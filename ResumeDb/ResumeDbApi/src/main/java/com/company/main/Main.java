/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.dao.inter.CountriesDaoInter;
import com.company.dao.inter.EducationDaoInter;
import com.company.dao.inter.LanguagesDaoInter;
import com.company.dao.inter.LoginDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.WorkDaoInter;
import com.company.entity.Countries;
import com.company.entity.Languages;
import com.company.entity.Login;
import com.company.entity.User;
import com.company.entity.Work;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author virtu
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, ParseException {
    UserDaoInter dao = Contex.instanceUserDao();
    
//
//        //    System.out.println(dao.getById(6));
////            List<User> lsit=dao.getSearchUser("Cebrayilov");
////            for (User user : lsit) {
////                System.out.println(user);
////            
////        }
////        try {
////            
////            Countries c=new Countries(45, "", "");
////            Countries n=new Countries(78, "", "");
////            
////            String name="Aygun";
////            String surname="Qurbanova";
////            String street="Cavadli";
////            String postal="45s8";
////            String city="Ganja";
////            String sex="famle";
////            String fullanme=name+" "+surname;
////            String email="Ehmedli@gmail.com";
////            
////            SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );
////            java.util.Date myDate = format.parse("2009-06-06");
////            long l=myDate.getTime();
////            java.sql.Date birthDate = new java.sql.Date(l);
////            
////            User u=new User(10, name, surname, street, postal, city, c, email, sex, birthDate, n);
////            // boolean b=dao.addUser(u);
////            System.out.println(dao.updateUser(u));
////            System.out.println("****************");
////        } catch (ParseException ex) {
////            System.out.println(ex.getMessage());
////        }
//        EducationDaoInter edu = Contex.instanceEducationDao();
////       User u=dao.getById(6);
////       Countries c=new Countries(45, null, null);
////        Education ed=new Education(0, "salam", "salam", "Baku", c, "Master", "salam",u );
////        edu.addEducation(ed);
//
//        //  System.out.println(edu.getById(6));
//        CountriesDaoInter cdi = Contex.instanceCountriesDao();
////        List<Countries> liste=cdi.getAll();
////        for (Countries countries : liste) {
////            System.out.println(countries);
////           // Thread.sleep(1000);
////            
////        }
//
//        LanguagesDaoInter ldi = Contex.instanceLanguagesDao();
////        for (Languages lan : ldi.getAll()) {
////            System.out.println(lan);
////            
////        }
//
//        WorkDaoInter wki = Contex.instanceWorkDao();
//
//        String jab = "salam";
//        String comp = "baku";
//        String about = "about";
//
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        java.util.Date wBegin = format.parse("2009-06-06");
//        long lBegin = wBegin.getTime();
//        java.sql.Date begin = new java.sql.Date(lBegin);
//
//        java.util.Date wEnd = format.parse("2009-06-06");
//        long lEnd = wEnd.getTime();
//        java.sql.Date end = new java.sql.Date(lBegin);
//        
//        User user=dao.getById(5);
//
//        Work u = new Work(0, jab, comp, about, begin, end, user);
//         
//        wki.addWork(u);

        LoginDaoInter lgi=Contex.instanceLoginDao();
        System.out.println(lgi.getByUsernameAndPassword("admin", "admin"));
    }
}
