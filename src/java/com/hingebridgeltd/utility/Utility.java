package com.hingebridgeltd.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utility
{
    public String getDate()
    {
        Date d=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
        String date=sdf.format(d);
        return date;
    }
    
    public String getOtp()
    {
        Random random=new Random();
        String otpgen="";
        String shuffleOTP=""; 
        
        char[] capitalLetters={'A','B','C','D','E','F','G','H','I','J', 'K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] smallLetters={'a','b','c','d','e','f','g','h','i','j', 'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] numbers={'1','2','3','4','5','6','7','8','9'};       
        
        for(int i=0; i<2; i++) //selects two random characters from capital letters
        {
            String xter= String.valueOf(capitalLetters[random.nextInt(capitalLetters.length)]);            
            while(otpgen.contains(xter))
            {
                xter = String.valueOf(capitalLetters[random.nextInt(capitalLetters.length)]);
            }
            otpgen += xter;
        }
        for(int i=0; i<3; i++) //selects three random characters from small letters
        {
            String xter= String.valueOf(smallLetters[random.nextInt(smallLetters.length)]);            
            while(otpgen.contains(xter))
            {
                xter = String.valueOf(smallLetters[random.nextInt(smallLetters.length)]);
            }
            otpgen += xter;
        }
        for(int i=0; i<3; i++) //selects three random characters from numbers/digits
        {
            String xter= String.valueOf(numbers[random.nextInt(numbers.length)]);
            
            while(otpgen.contains(xter))
            {
                xter = String.valueOf(numbers[random.nextInt(numbers.length)]);
            }
            otpgen += xter;
        }        
        for(int i=0; i<otpgen.length(); i++) //rearranges/shuffles the generated OTP
        {
            String xter = String.valueOf(otpgen.charAt(random.nextInt(otpgen.length())));            
            while(shuffleOTP.contains(xter))
            {
                xter = String.valueOf(otpgen.charAt(random.nextInt(otpgen.length())));
            }            
            shuffleOTP += xter;
        }        
        return shuffleOTP; 
    }
}