package com.optum.myfirstspringapp;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoodbyeController {
    @GetMapping("/goodbye")
    public String goodbye(@RequestParam(name="name", required=false, defaultValue="No face") String name, Model model){
        model.addAttribute("name", name);
        return "goodbye";
    }
}
