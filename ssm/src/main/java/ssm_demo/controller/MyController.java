package ssm_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm_demo.domain.User;
import ssm_demo.service.MyService;

import java.util.List;

@Controller
@RequestMapping("/ssm_demo")
public class MyController {
    @Autowired
    private MyService service;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return service.findAll();
    }

}
