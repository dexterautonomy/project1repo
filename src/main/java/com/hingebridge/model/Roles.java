package com.hingebridge.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "rolename")
    private String rolename;
    
    public Roles(){}
    
    public void setRolename(String rolename)
    {
        this.rolename=rolename;
    }
    
    public String getRolename()
    {
        return rolename;
    }
}