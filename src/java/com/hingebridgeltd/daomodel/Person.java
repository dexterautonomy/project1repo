package com.hingebridgeltd.daomodel;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person implements Serializable
{
    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "otp")
    private String otp;
    @Column(name = "pic")
    private String pic;
    @Column(name = "blocked")
    private String blocked;
    @Column(name = "banned")
    private String banned;
    @Column(name = "gender")
    private String gender;
    @Column(name = "regdate")
    private String regdate;
    @Column(name = "likes")
    private int likes;
    @Column(name = "adcredit")
    private int adcredit;
    @Column(name = "cpm")
    private int cpm;
    @Column(name = "cpc")
    private int cpc;

    public Person(){}
    
    public Person(String username, String email, String pic, String block, String ban, String pswd, String otp, String gender, String rgdate)
    {
        this.username=username;
        this.email=email;
        this.pic=pic;
        this.blocked=block;
        this.banned=ban;
        this.password=pswd;
        this.otp=otp;
        this.gender=gender;
        this.regdate=rgdate;
    }
    
    public void setUsername(String username)
    {
        this.username=username;
    }
    
    public void setPassword(String password)
    {
        this.password=password;
    }
    
    public void setEmail(String email)
    {
        this.email=email;
    }
    
    public void setOtp(String otp)
    {
        this.otp=otp;
    }
    
    public void setPic(String pic)
    {
        this.pic=pic;
    }
    
    public void setBlocked(String blocked)
    {
        this.blocked=blocked;
    }
    
    public void setBanned(String banned)
    {
        this.banned=banned;
    }
    
    public void setGender(String gender)
    {
        this.gender=gender;
    }
    
    public void setRegdate(String regdate)
    {
        this.regdate=regdate;
    }
    
    public void setLikes(int likes)
    {
        this.likes=likes;
    }
    
    public void setAdcredit(int adcredit)
    {
        this.adcredit=adcredit;
    }
    
    public void setCpm(int cpm)
    {
        this.cpm=cpm;
    }
    
    public void setCpc(int cpc)
    {
        this.cpc=cpc;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public String getOtp()
    {
        return otp;
    }
    
    public String getPic()
    {
        return pic;
    }
    
    public String getBlocked()
    {
        return blocked;
    }
    
    public String getBanned()
    {
        return banned;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public String getRegdate()
    {
        return regdate;
    }
    
    public int getLikes()
    {
        return likes;
    }
    
    public int getAdcredit()
    {
        return adcredit;
    }
    
    public int getCpm()
    {
        return cpm;
    }
    
    public int getCpc()
    {
        return cpc;
    }
}