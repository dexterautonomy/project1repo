/*package com.hingebridge.errorcontrollers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Error1 implements ErrorController
{
    @Override
    public String getErrorPath()
    {
        return "/error";
    }
    
    @RequestMapping("/error")
    public String errorPage(HttpServletRequest req)
    {
        Object status = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String page=null;
        if(status != null)
        {
            Integer statusCode = Integer.valueOf(status.toString());
            
            if(statusCode == HttpStatus.FORBIDDEN.value())
            {
                page = "errorpages/errorpage1";
            }            
            else if(statusCode == HttpStatus.NOT_FOUND.value())
            {
                page = "errorpages/errorpage2";
            }
        }
        return page;
    }
}*/