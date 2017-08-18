
package com.moha.controller;


import com.moha.domain.Demo;
import com.moha.domain.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControl {

    @Autowired
    private DemoRepository demoRepository;

    @RequestMapping("/hello")
    public Demo helloword(@RequestParam Integer id){
       /* Demo demo = new Demo();
        demo.setId(1);
        demo.setName("mao1");
        demoRepository.save(demo);*/

        return demoRepository.findById(id);
    }
}
