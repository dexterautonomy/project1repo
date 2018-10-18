package com.hingebridge.service;

import com.hingebridge.model.Roles;
import com.hingebridge.model.Users;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDet implements UserDetails
{
    private final Users users;
    
    public UserDet(Users users)
    {
        this.users=users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        List<SimpleGrantedAuthority> gaList=new LinkedList<>();
        for(Roles r:users.getRoles())
        {
            gaList.add(new SimpleGrantedAuthority("ROLE_"+r.getRolename()));
        }
        return gaList;
        /*return users.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRolename())).collect(Collectors.toList());*/
    }

    @Override
    public String getPassword()
    {
        return users.getPassword();
    }

    @Override
    public String getUsername()
    {
        return users.getUsername();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}