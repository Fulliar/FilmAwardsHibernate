package com.filmawards.repository;
import com.filmawards.entity.Film;
import com.filmawards.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class FilmDao {
    private Session session = null;
    public void save(Film film){
         try{
             session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
             session.save(film);
             session.getTransaction().commit();
             System.out.println("Film başarılı bir şekilde kaydedildi.");
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
            String query = "select aw.awardName, fi.filmName, fc.filmCategoryName,d.directorName,at.actorName from film_award as fa\n" +
                    "inner join award as aw\n" +
                    "on fa.awards_id = aw.id\n" +
                    "inner join film as fi\n" +
                    "on fi.id = fa.Film_id\n" +
                    "inner join film_filmcategory as ff\n" +
                    "on ff.Film_id = fa.Film_id\n" +
                    "inner join filmcategory as fc\n" +
                    "on ff.filmCategory_id = fc.id\n" +
                    "inner join director as d\n" +
                    "on d.id = fi.director_id\n" +
                    "inner join film_actor as fy\n" +
                    "on fi.id = fy.Film_id\n" +
                    "inner join actor as at\n" +
                    "on at.id = fy.actors_id\n" +
                    "where fi.director_id is not null";
            list = entityManager.createNativeQuery(query).getResultList();
            for(Object[] item:list) {
                System.out.println(
                        "Award name: " + item[0] + ", " +
                                "Film name: " + item[1] + ", " +
                                "Film Category name: " + item[2] + ", " +
                                "Director name: " + item[3] + ", " +
                                "Actor name: " + item[4]
                );
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

    public static void askAwardByName(String filmName){
        List<Object> list = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            String qs = "select ac.actorName  from film as f\n" +
                    "inner join film_actor as fa\n" +
                    "on f.id = fa.Film_id\n" +
                    "inner join actor as ac\n" +
                    "on fa.actors_id = ac.id " +
                    "where f.filmName = :bili";
            Query query = session.createNativeQuery(qs);
            query.setParameter("bili", filmName);
            list = query.getResultList();
            if(list.isEmpty()){
                System.out.println("There is no awarded actor with this movie");
            } else{
                for(Object item:list) {
                    System.out.println(
                            "Awarded actor name: " + item
                    );
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

    public void deleteById(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Film film = session.load(Film.class,id);
            session.delete(film);
            session.getTransaction().commit();
        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
    }

    public void update(Film film){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(film);
            session.getTransaction().commit();
        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
    }
}
