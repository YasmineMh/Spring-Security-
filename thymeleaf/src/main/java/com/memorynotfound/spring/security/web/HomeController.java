package com.memorynotfound.spring.security.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//import com.booky.entities.User;

@Controller
public class HomeController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/user")
    public String userIndex() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth!=null)
    		if(auth.getPrincipal()!=null)
    	System.out.println("username="+auth.getPrincipal().toString());
        return "user/index";
    }

    @GetMapping("/login")
    public String login() {
    	System.out.println("login controller !");
        return "login";
    }
    

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

}
