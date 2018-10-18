package com.hingebridge.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "users")
public class Users implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;    
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "enabled")
    private int enabled;
    
    @ManyToMany(targetEntity = Roles.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = {@JoinColumn(name = "users_id")}, inverseJoinColumns = {@JoinColumn(name = "roles_id")})
    Set<Roles> roles;
    
    public Users(){}
    
    public void setUsername(String username)
    {
        this.username=username;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setPassword(String password)
    {
        BCryptPasswordEncoder b=new BCryptPasswordEncoder();
        this.password=b.encode(password);
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setFirstname(String firstname)
    {
        this.firstname=firstname;
    }
    
    public String getFirstname()
    {
        return firstname;
    }
    
    public void setEnabled(int enabled)
    {
        this.enabled=enabled;
    }
    
    public int getEnabled()
    {
        return enabled;
    }
    
    public void setRoles(Set<Roles> roles)
    {
        this.roles=roles;
    }
    
    public Set<Roles> getRoles()
    {
        return roles;
    }
}