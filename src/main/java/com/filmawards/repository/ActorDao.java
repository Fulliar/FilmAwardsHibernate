package com.filmawards.repository;

import com.filmawards.entity.Actor;
import com.filmawards.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class ActorDao {

    private Session session = null;
    public void save(Actor actor){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(actor);
            session.getTransaction().commit();
            System.out.println("Actor başarılı bir şekilde kaydedildi.");
        }catch (Exception e){
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
    public void getAll(){
        List<Object[]> list = null;
        try{
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select ac.actorName, f.filmName, aw.awardName  from actor_award as aa\n" +
                    "inner join actor as ac\n" +
                    "on aa.Actor_id = ac.id\n" +
                    "inner join award as aw\n" +
                    "on aa.awards_id = aw.id\n" +
                    "inner join actor_film af\n" +
                    "on aa.Actor_id = af.Actor_id \n" +
                    "inner join film f\n" +
                    "on af.films_id = f.id";
            list = entityManager.createNativeQuery(query).getResultList();
            for(Object[] item:list){
                System.out.println(
                        "Actor Name: " + item[0] + ", " +
                                "Film Name: " + item[1] + ", " +
                                "Award Name: " + item[2]
                );
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

    public void deleteById(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Actor actor = session.load(Actor.class,id);
            session.delete(actor);
            session.getTransaction().commit();
        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
    }

    public void update(Actor actor){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(actor);
            session.getTransaction().commit();
        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
    }

}
