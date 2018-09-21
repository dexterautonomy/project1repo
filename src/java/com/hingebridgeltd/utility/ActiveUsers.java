package com.hingebridgeltd.utility;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.springframework.stereotype.Service;

@Service
public class ActiveUsers implements HttpSessionListener
{
    private static int count=0;

    @Override
    public void sessionCreated(HttpSessionEvent se)
    {
        count++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se)
    {
        count--;
    }
    
    public static int getActiveUsers()
    {
        return count;
    }
}
