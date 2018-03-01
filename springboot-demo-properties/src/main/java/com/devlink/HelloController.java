package com.devlink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${my.name}")
    private String myName;

    @Value("${my.gender:f}")
    private String gender;

    @Autowired
    private MyConfig myConfig;

    @Autowired
    private Environment env;

    @RequestMapping(value = "/value")
    public String hello(@RequestParam(name = "name")String name){
        return "您好，" + name + "，我叫" + myName + ", 性别：" + gender;
    }


    @RequestMapping(value = "/config")
    public String hello2(@RequestParam(name = "name")String name){
        return "您好，" + name + "，我叫" + myConfig.getName();
    }

    @RequestMapping(value = "/env")
    public String hello3(@RequestParam(name = "name")String name){
        return "您好，" + name + "，我叫" + env.getProperty("my.name");
    }

}
