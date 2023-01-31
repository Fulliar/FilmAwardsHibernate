package com.filmawards.service;

import com.filmawards.entity.*;
import com.filmawards.repository.ActorDao;
import com.filmawards.repository.FilmDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActorServices {
    static ActorDao actorDao = new ActorDao();
    public static void main(String[] args) {

        //save();
        getAll();
        //delete(3);
        //update();



    }

    public static void save(){
        try{
            Film film10 = new Film("ASDAD");
            Award award10 = new Award("Best choice award");

            Actor actor1 = new Actor("Johny Depp", Arrays.asList(film10),Arrays.asList(award10));
            actorDao.save(actor1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void getAll(){
        try{ //getAll'lar fikslenecek eğer ödülü varsa göster sorgusu
            actorDao.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void delete(int id){
        try {
            actorDao.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void update(){
        try {
            Director director11 = new Director("Director11");
            Award award11 = new Award("Award12");
            Film film11 = new Film("11.FİLM");
            Actor actor11 = new Actor(4,"Banana Apple",Arrays.asList(film11),Arrays.asList(award11));
            actorDao.update(actor11);
            //   ActorDao.update(film3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
