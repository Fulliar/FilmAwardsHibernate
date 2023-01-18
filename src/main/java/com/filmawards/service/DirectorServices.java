package com.filmawards.service;

import com.filmawards.entity.*;
import com.filmawards.repository.DirectorDao;

import java.util.Arrays;

public class DirectorServices {
    static DirectorDao directorDao = new DirectorDao();
    public static void main(String[] args) {
        //save();
        getAll();
        //delete(4);
        //update();
    }

    public static void save(){
        try {
            Award award1 = new Award("Best Award LAB LAB");
            Film film1 = new Film("Jojo Rabbit");
            Director director1 = new Director("Taika Waititi",Arrays.asList(film1),award1);
            directorDao.save(director1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void getAll(){
        try { //getAll'lar fikslenecek eğer ödülü varsa göster sorgusu
            directorDao.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void delete(int id){
        try {
            directorDao.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void update(){
        try {
            Award award1 = new Award("Best Award LAB LAB");
            Film film1 = new Film("ET");
            Director director1 = new Director(3,"Spielberg",Arrays.asList(film1),award1);
            directorDao.update(director1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
