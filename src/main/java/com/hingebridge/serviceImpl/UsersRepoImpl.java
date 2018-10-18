package com.hingebridge.serviceImpl;

import com.hingebridge.model.Users;
import com.hingebridge.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class UsersRepoImpl 
{
    @Autowired
    UsersRepo usersRepo;
    
    @PreAuthorize("#entername.equals('chidex') and hasRole('ADMIN')")           //@PreAuthorize uses SpringEl unlike the old @Secured
    public String getPassword(String entername)                                 //The parameter variable (entername) must match the SpringEl
    {                                                                           //that is used in @PreAuthorize("#entername.equals('chidex') and hasRole('ADMIN')")
        Users users=(Users) usersRepo.findByUsername(entername);                //for it to work properly. This is why @PreAuthorize, @PostAuthorize,
        return users.getPassword();                                             //@PreFilter and @PostFilter beats @Secured
    }
}