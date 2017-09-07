
package com.moha.controller;


import com.moha.domain.Demo;
import com.moha.domain.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldControl {

    @Autowired
    private DemoRepository demoRepository;

    @RequestMapping("/hello")
    @Cacheable(value="user-key")
    public List<Demo> helloword(){
        return demoRepository.findAll();
    }

    @RequestMapping("/savehello")
    public Demo insterthelloword(){
        Demo demo = new Demo();
        demo.setName("mao1");
        return demoRepository.save(demo);
    }

}
