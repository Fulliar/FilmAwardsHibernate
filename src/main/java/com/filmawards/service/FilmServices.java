package com.filmawards.service;

import com.filmawards.entity.*;
import com.filmawards.repository.FilmDao;
import com.filmawards.utils.HibernateUtil;


import java.util.*;


public class FilmServices {
    static FilmDao filmDao = new FilmDao();
    public static void main(String[] args) {
      //HibernateUtil.getSessionFactory();
      //save();
      getAll();
      //askAwardByName("Film1");
      //delete(1);
      //update();

    }

    public static void save(){
        try {
            Director director1 = new Director("Director1");
            Actor actor1 = new Actor("Johny Depp");
            FilmCategory filmCategory1 = new FilmCategory("FilmCategory1");
            Award award1 = new Award("Award1");
            Film film1 = new Film("ASDAD", director1, Arrays.asList(actor1), Arrays.asList(filmCategory1), Arrays.asList(award1));
            filmDao.save(film1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void getAll(){
        try { //getAll'lar fikslenecek eğer ödülü varsa göster sorgusu
            filmDao.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void askAwardByName(String filmName){
        try{
            FilmDao.askAwardByName(filmName);

        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public static void delete(int id){
        try {
            filmDao.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void update(){
        try {
            Director director1 = new Director("Director1");
            Actor actor2 = new Actor("Actor2");
            FilmCategory filmCategory3 = new FilmCategory("FilmCategory3");
            Award award4 = new Award("Award4");
            Film film3 = new Film(1,"Film2", director1, Arrays.asList(actor2), Arrays.asList(filmCategory3), Arrays.asList(award4));
            filmDao.update(film3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
