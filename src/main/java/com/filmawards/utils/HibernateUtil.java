package com.filmawards.utils;


import com.filmawards.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class HibernateUtil {
    private static SessionFactory sessionFactory=null;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            try{
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(FilmCategory.class);
                configuration.addAnnotatedClass(Award.class);
                configuration.addAnnotatedClass(Film.class);
                configuration.addAnnotatedClass(Actor.class);
                configuration.addAnnotatedClass(Director.class);




                sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
