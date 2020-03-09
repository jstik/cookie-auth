package com.example.authpage.endpoint;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginEndpoint {

    @GetMapping("/login")
    public String login(@RequestParam(required = true) String action, Model model) {
        if (action != null) {
            model.addAttribute("action", action);
        }
        return "login";
    }
}
