package com.hingebridgeltd.serviceImpl;

import com.hingebridgeltd.daomodel.Person;
import java.util.List;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import com.hingebridgeltd.service.Person_Service;

@Repository
public class Person_ServiceImpl implements Person_Service
{
    private final Configuration cfg;
    private static SessionFactory sf;
    
    public Person_ServiceImpl()
    {
        cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        sf=cfg.buildSessionFactory(ssrb.build());
    }
    
    @Override
    public void saveUser(String username, String email, String pswd, String otp, String gender, String rgdate)
    {
        Session ses=null;
        Transaction tx=null;
        try
        {
            ses=sf.openSession();
            tx=ses.beginTransaction();
            Person p=new Person(username, email, "empty.jpg", "NO", "NO", pswd, otp, gender, rgdate);
            ses.save(p);
            //Integer intg=(Integer)ses.save(p);
            tx.commit();
        }
        catch(HibernateError err)
        {
            if(tx!=null)
            {
                tx.rollback();
            }
        }
        finally
        {
            if(ses!=null)
            {
                ses.close();
            }
        }
        
    }

    @Override
    public List<String> getUsers()
    {
        Session ses=null;
        Transaction tx=null;
        List<String> users=null;
        try
        {
            ses=sf.openSession();
            tx=ses.beginTransaction();
            users=ses.createQuery("SELECT p.username FROM Person p").list();
            tx.commit();
        }
        catch(HibernateError err)
        {
            if(tx!=null)
            {
                tx.rollback();
            }
        }
        finally
        {
            if(ses!=null)
            {
                ses.close();
            }
        }
        return users;
    }
    
    @Override
    public List<String> getEmail()
    {
        Session ses=null;
        Transaction tx=null;
        List<String> email=null;
        try
        {
            ses=sf.openSession();
            tx=ses.beginTransaction();
            email=ses.createQuery("SELECT p.email FROM Person p").list();
            tx.commit();
        }
        catch(HibernateError err)
        {
            if(tx!=null)
            {
                tx.rollback();
            }
        }
        finally
        {
            if(ses!=null)
            {
                ses.close();
            }
        }
        return email;
    }

    /*@Override
    public List<String> getPswd()
    {
        Session ses=null;
        Transaction tx=null;
        List<String> pswd=null;
        try
        {
            ses=sf.openSession();
            tx=ses.beginTransaction();
            pswd=ses.createQuery("SELECT p.password FROM Person p").list();
            tx.commit();
        }
        catch(HibernateError err)
        {
            if(tx!=null)
            {
                tx.rollback();
            }
        }
        finally
        {
            if(ses!=null)
            {
                ses.close();
            }
        }
        return pswd;
    }*/

    @Override
    public boolean data_Test(String user, String pswd_Input)
    {
        Session ses=null;
        Transaction tx=null;
        boolean login=false;
        
        try
        {
            ses=sf.openSession();
            tx=ses.beginTransaction();
            List<String> pswd_List=ses.createQuery("SELECT p.password FROM Person p WHERE p.username='"+user+"'").list();
            tx.commit();
            String pswd_DB=pswd_List.get(0);
            if(pswd_Input.equals(pswd_DB))
            {
                login=true;
            }
        }
        catch(HibernateError err)
        {
            if(tx!=null)
            {
                tx.rollback();
            }
        }
        finally
        {
            if(ses!=null)
            {
                ses.close();
            }
        }
        return login;
    }

    @Override
    public boolean block_Test(String user)
    {
        Session ses=null;
        Transaction tx=null;
        boolean bool_block=false;
        try
        {
            ses=sf.openSession();
            tx=ses.beginTransaction();
            List<String> user_List=ses.createQuery("SELECT p.blocked FROM Person p WHERE p.username='"+user+"'").list();
            tx.commit();
            String block=user_List.get(0);
            if(block.equals("NO"))
            {
                bool_block=true;
            }
        }
        catch(HibernateError err)
        {
            if(tx!=null)
            {
                tx.rollback();
            }
        }
        finally
        {
            if(ses!=null)
            {
                ses.close();
            }
        }
        return bool_block;
    }

    @Override
    public boolean ban_Test(String user)
    {
        Session ses=null;
        Transaction tx=null;
        boolean ban_block=false;
        try
        {
            ses=sf.openSession();
            tx=ses.beginTransaction();
            List<String> user_List=ses.createQuery("SELECT p.banned FROM Person p WHERE p.username='"+user+"'").list();
            tx.commit();
            String block=user_List.get(0);
            if(block.equals("NO"))
            {
                ban_block=true;
            }
        }
        catch(HibernateError err)
        {
            if(tx!=null)
            {
                tx.rollback();
            }
        }
        finally
        {
            if(ses!=null)
            {
                ses.close();
            }
        }
        return ban_block;
    }
    
    
}