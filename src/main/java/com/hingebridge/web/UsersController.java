package com.hingebridge.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@PreAuthorize("hasRole('USER')")
@Controller
@RequestMapping("/user")
public class UsersController
{
    @GetMapping("/test")
    public String secured1()
    {
        return "pages/userpage";
    }
}