package com.optum.myfirstspringapp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    @RequestMapping("/page1")
    public String myMethod1() {
        return "index1";
    }

    @RequestMapping("/page2")
    public String myMethod2(){
        return "index2";
    }
}
