package com.selfWebapp.selfWebappArtifact.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping("/saveUser")
    public String saveUser(HttpServletRequest httpServletRequest ){
        return "";
    }

}
