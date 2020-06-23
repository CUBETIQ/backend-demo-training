package com.cubetiqs.demo.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/index", "", "/", "/index.php"})
    public String index(Model model) {
        model.addAttribute("myname", "Sambo");
        return "index";
    }

    @GetMapping(value = {"/admin/users"})
    public String user(Model model) {
        model.addAttribute("myname", "Sambo");
        return "admin/users/index";
    }
}
