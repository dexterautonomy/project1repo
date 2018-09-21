package com.hingebridgeltd.serviceImpl;

import com.hingebridgeltd.daomodel.Picture;
import com.hingebridgeltd.service.Picture_Service;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class Picture_ServiceImpl implements Picture_Service
{
    private final Configuration cfg;
    private static SessionFactory sf;
    
    public Picture_ServiceImpl()
    {
        cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        sf=cfg.buildSessionFactory(ssrb.build());
    }
    
    @Override
    public void save_pic(String approve, String uploader, String img, String date)
    {
        Session ses=null;
        Transaction tx=null;
        try
        {
            ses=sf.openSession();
            tx=ses.beginTransaction();
            Picture p=new Picture(approve, uploader, img, date);
            ses.save(p);
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
}