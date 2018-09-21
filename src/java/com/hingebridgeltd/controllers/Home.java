package com.hingebridgeltd.controllers;

import com.hingebridgeltd.utility.Utility;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hingebridgeltd.service.Person_Service;
import com.hingebridgeltd.service.Picture_Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Home
{
    @Resource(name="person_ServiceImpl")
    private Person_Service ps;
    
    @Resource(name="picture_ServiceImpl")
    private Picture_Service p_s;
    
    //First door to app
    @RequestMapping("/")
    public String home(HttpSession session, HttpServletRequest req, ModelMap model)
    {
        session=req.getSession();
        String username=(String)session.getAttribute("username");
        if(username==null)
        {
            //model.addAttribute("user", "");
            //model.addAttribute("disp2", "none");
            model.addAttribute("home_active1", "active");
            model.addAttribute("home_active2", "");
        }
        else
        {
            //model.addAttribute("user", username);
            //model.addAttribute("disp2", "inline");
        }
        model.addAttribute("_x", "none");
        return "homepage";
    }
    
    //To bring up login panel
    @RequestMapping("l_g")
    public String login(HttpSession session, HttpServletRequest req, ModelMap model)
    {
        session=req.getSession();
        String username=(String)session.getAttribute("username");
        model.addAttribute("_x", "inline");
        model.addAttribute("home_active1", "");
        model.addAttribute("home_active2", "active");
        
        /*if(username==null)
        {
            model.addAttribute("user", "");
            model.addAttribute("disp2", "none");
        }
        else
        {
            model.addAttribute("user", username);
            model.addAttribute("disp2", "inline");
        }*/
        return "homepage";
    }
    
    //Main login
    @RequestMapping(value="l_", method = RequestMethod.POST)
    public String login(@RequestParam("user_login")String user, @RequestParam("pswd_login")String pswd, HttpSession session, 
    HttpServletRequest req, ModelMap model)
    {
        List<String> getUsers=ps.getUsers();
        String u_ser=user.toLowerCase();
        
        for(String u:getUsers)
        {
            if(u.equals(u_ser))
            {
                if(ps.data_Test(u_ser, pswd))
                {
                    if(ps.ban_Test(u_ser))
                    {
                        session=req.getSession();
                        session.setAttribute("username", u_ser);
                        session.setAttribute("pswd", pswd);
                    
                        //model.addAttribute("user", user);
                        //model.addAttribute("disp2", "inline");
                        return "memberpage";
                    }
                    else
                    {
                        model.addAttribute("login_err", "Try again later");
                        model.addAttribute("login_user_val", u_ser);
                        return "homepage";
                    }
                }
                else
                {
                    model.addAttribute("login_user_val", u_ser);
                    model.addAttribute("login_err", "Password is incorrect");
                    return "homepage";
                }
            }
        }
        model.addAttribute("login_user_val", u_ser);
        model.addAttribute("login_err", "Username is not registered");
        return "homepage";
    }
    
    //To bring signup page
    @RequestMapping("p_")
    public String signup()
    {
        return "signuppage";
    }
    
    //Ajax test of username
    @RequestMapping("user_Test")
    @ResponseBody
    public String ajax_User(@RequestParam("sent")String username)
    {
        List<String> getUsers=ps.getUsers();
        ListIterator<String> uIter=getUsers.listIterator();
        
        while(uIter.hasNext())
        {
            if(uIter.next().equals(username.toLowerCase()))
            {
                return "exists";
            }
        }
        return "";
    }
    
    //Ajax test of email
    @RequestMapping("email_Test")
    @ResponseBody
    public String ajax_Email(@RequestParam("sent")String email)
    {
        List<String> getEmail=ps.getEmail();
        ListIterator<String> uIter=getEmail.listIterator();
        
        while(uIter.hasNext())
        {
            if(uIter.next().equals(email))
            {
                return "exists";
            }
        }
        return "";
    }
    
    //Ajax test of password
    @RequestMapping("pswd_Test")
    @ResponseBody
    public String ajax_Pswd(@RequestParam("sent")String pswd)
    {
        if(pswd.length()<8)
        {
            return "less";
        }
        return "";
    }
    
    //Signup and OTP: stage 1
    @RequestMapping(value="sp_", method = RequestMethod.POST)
    public String signup_Otp(@RequestParam("user")String username, @RequestParam("email")String email, @RequestParam("pswd")String pswd,
    @RequestParam("gender")String gender, HttpSession session, HttpServletRequest req, ModelMap model)
    {
        List<String> getUsers=ps.getUsers();
        List<String> getEmail=ps.getEmail();
        ListIterator<String> uIter=getUsers.listIterator();
        ListIterator<String> eIter=getEmail.listIterator();
        
        while(uIter.hasNext())
        {
            if(uIter.next().equals(username.toLowerCase()))
            {
                model.addAttribute("user_val", username);
                model.addAttribute("email_val", email);
                model.addAttribute("user_otp", "Username already taken");
                return "signuppage";
            }
        }
        
        while(eIter.hasNext())
        {
            if(eIter.next().equals(email))
            {
                model.addAttribute("user_val", username);
                model.addAttribute("email_val", email);
                model.addAttribute("email_otp", "E-mail already taken");
                return "signuppage";
            }
        }
        
        if(pswd.length()<8)
        {
            model.addAttribute("user_val", username);
            model.addAttribute("email_val", email);
            model.addAttribute("pswd_otp", "Password must be at least 7 characters long");
            return "signuppage";
        }
        
        session=req.getSession();
        String otp=new Utility().getOtp();
        session.setAttribute("username", username);//KEY
        session.setAttribute("pswd", pswd);//KEY
        session.setAttribute("email", email);
        session.setAttribute("gender", gender);
        session.setAttribute("otp", otp);
        
        model.addAttribute("otp", otp);//This line is for test purpose (to be handled by mail server or infobip)
        return "otpconfpage";
    }
    
    //Otp confirmed: stage 2
    @RequestMapping(value = "s_", method = RequestMethod.POST)
    public String signup2DB(@RequestParam("otp")String otp, HttpSession session, HttpServletRequest req, ModelMap model)
    {
        session=req.getSession();
        String username=(String)session.getAttribute("username");
        String email=(String)session.getAttribute("email");
        String pswd=(String)session.getAttribute("pswd");
        String gender=(String)session.getAttribute("gender");
        String ses_otp=(String)session.getAttribute("otp");
        
        if(username!=null && !username.equals("") && email!=null && !email.equals("") && pswd!=null && !pswd.equals("")
        && gender!=null && !gender.equals("") && ses_otp!=null && !ses_otp.equals(""))
        {
            if(ses_otp.equals(otp))
            {
                ps.saveUser(username.toLowerCase(), email, pswd, otp, gender, new Utility().getDate());
                session.removeAttribute("email");
                session.removeAttribute("gender");
                session.removeAttribute("otp");
            
                return "redirect:u_x";
            }
            else
            {
                model.addAttribute("err_otp", "OTP did not match!");
                return "otpconfpage";
            }
        }
        model.addAttribute("err_otp", "Expired, try again!");
        return "otpconfpage";
    }
    
    //Direct login from sign-up: stage 3 and final
    @RequestMapping("u_x")
    public String user_Reg_Login(HttpSession session, HttpServletRequest req, ModelMap model)
    {
        session=req.getSession();
        String username=(String)session.getAttribute("username");
        String pswd=(String)session.getAttribute("pswd");
        
        if(username!=null && !username.equals("") && pswd!=null && !pswd.equals(""))
        {
            if(ps.data_Test(username, pswd))
            {
                //model.addAttribute("user", user);
                //model.addAttribute("disp2", "inline");
                return "memberpage";
            }
        }
        model.addAttribute("login_err", "Please login");
        session.removeAttribute("username");
        session.removeAttribute("pswd");
        return "homepage";
    }
    
    @RequestMapping(value="post_meme", method = RequestMethod.POST)
    public String post_Meme(HttpSession session, HttpServletRequest req, @RequestParam("file_img")MultipartFile meme_File)
    {
        session=req.getSession();
        String username=(String)session.getAttribute("username");
        
        if(ps.ban_Test(username)) //if you are not banned
        {
            if(ps.block_Test(username))
            {
                //save the meme
                p_s.save_pic("NO", username, meme_File.getOriginalFilename(), new Utility().getDate());
                //File path=new File(parent, child);
            }
            else
            {
                //You have been blocked
            }
        }
        else
        {
            session.invalidate();
        }
        
        return "homepage";
    }
}