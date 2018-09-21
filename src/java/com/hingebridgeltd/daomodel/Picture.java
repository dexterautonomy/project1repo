package com.hingebridgeltd.daomodel;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="picture")
public class Picture implements Serializable
{
    @Id @GeneratedValue
    @Column(name="id")
    private int id;
    
    @Column(name="approve")
    private String approve;
    
    @Column(name="username")
    private String username;
    
    @Column(name="img_name")
    private String img_name;
    
    @Column(name="img_date")
    private String img_date;
    
    @Column(name="likes")
    private int likes;
    
    @Column(name="views")
    private int views;
    
    public Picture(){}
    
    public Picture(String approve, String username, String img_name, String img_date)
    {
        this.approve=approve;
        this.username=username;
        this.img_name=img_name;
        this.img_date=img_date;
        //this.likes=likes;
        //this.views=views;
    }
    
    public void setApprove(String approve)
    {
        this.approve=approve;
    }
    
    public void setUsername(String username)
    {
        this.username=username;
    }
    
    public void setImg_Name(String img_name)
    {
        this.img_name=img_name;
    }
    
    public void setImg_Date(String img_date)
    {
        this.img_date=img_date;
    }
    
    public void setLikes(int likes)
    {
        this.likes=likes;
    }
    
    public void setViews(int views)
    {
        this.views=views;
    }
    
    public String getApprove()
    {
        return approve;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getImg_Name()
    {
        return img_name;
    }
    
    public String getImg_Date()
    {
        return img_date;
    }
    
    public int getLikes()
    {
        return likes;
    }
    
    public int getViews()
    {
        return views;
    }
}