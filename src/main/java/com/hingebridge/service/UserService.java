package com.hingebridge.service;

import com.hingebridge.model.Users;
import com.hingebridge.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService
{
    @Autowired
    UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException
    {
        Users users=(Users)usersRepo.findByUsername(string);
        
        if(users == null)
        {
            throw new UsernameNotFoundException("Username does not exist");
        }
        
        return new UserDet(users);
    }    
}