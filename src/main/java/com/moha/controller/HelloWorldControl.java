
package com.moha.controller;


import com.moha.domain.Demo;
import com.moha.domain.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

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

    @RequestMapping("/page")
    Page<Demo> findAll(Pageable pageable){
        return demoRepository.findAll(pageable);
    }

    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

}
