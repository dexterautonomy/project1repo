package com.hingebridgeltd.service;

import java.util.List;

public interface Person_Service
{
    void saveUser(String username, String email, String pswd, String otp, String gender, String rgdate);
    List<String> getUsers();
    List<String> getEmail();
    //List<String> getPswd();
    boolean data_Test(String user, String pswd_Input);
    boolean block_Test(String user);
    boolean ban_Test(String user);
}