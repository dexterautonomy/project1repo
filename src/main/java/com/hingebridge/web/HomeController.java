package com.hingebridge.web;

import com.hingebridge.model.Roles;
import com.hingebridge.model.Users;
import com.hingebridge.repository.UsersRepo;
import com.hingebridge.serviceImpl.UsersRepoImpl;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController
{
    @Autowired
    UsersRepo usersrepo;
    
    @Autowired
    UsersRepoImpl urim;
    
    @GetMapping("/")
    public String getHome()
    {
        /*Roles r1=new Roles();
        r1.setRolename("ADMIN");
        
        Roles r2=new Roles();
        r2.setRolename("USER");
        
        Set<Roles> sr1=new HashSet<>();
        Set<Roles> sr2=new HashSet<>();
        Set<Roles> sr3=new HashSet<>();
        
        sr1.add(r1);    //ADMIN role
        sr2.add(r2);    //USER role
        
        sr3.add(r1);    //Both role
        sr3.add(r2);
        
        Users us1=new Users();  //Admin
        us1.setUsername("dexter");
        us1.setPassword("1111");
        us1.setFirstname("Dexter");
        us1.setRoles(sr1);
        us1.setEnabled(1);
        usersrepo.save(us1);
        
        Users us2=new Users();  //User
        us2.setUsername("chidex");
        us2.setPassword("2222");
        us2.setFirstname("Chinedu");
        us2.setRoles(sr2);
        us2.setEnabled(1);
        usersrepo.save(us2);
        
        Users us3=new Users();  //User
        us3.setUsername("ezechi");
        us3.setPassword("3333");
        us3.setFirstname("Ezeigbo");
        us3.setRoles(sr3);
        us3.setEnabled(1);
        usersrepo.save(us3);*/
        
        return "pages/home";
    }
    
    @GetMapping("/login")
    public String secured(@RequestParam(value="error", required=false)String err, ModelMap model)
    {
        if(err!=null)
        {
            model.addAttribute("fake", "Bad credentials");
        }
        return "pages/loginpage";
    }
    
    @GetMapping("/getpassword")
    public String secured3(ModelMap model)  //This method right here uses a service layer method that is secured, so authentication will
    {                                       //be provided whenever this URL @GetMapping("/getpassword") is called
        model.addAttribute("pswd", urim.getPassword("chidex"));
        return "pages/home";
    }
}