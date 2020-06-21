/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.Countries;
import com.company.entity.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author virtu
 */
public class Main {
    
    public static void main(String[] args)  {
            UserDaoInter dao=Contex.instanceUserDao();
            
            System.out.println(dao.getById(6));
            
//            List<User> lsit=dao.getSearchUser("Cebrayilov");
//            for (User user : lsit) {
//                System.out.println(user);
//            
//        }
            
//        try {
//            
//            Countries c=new Countries(45, "", "");
//            Countries n=new Countries(78, "", "");
//            
//            String name="Aygun";
//            String surname="Qurbanova";
//            String street="Cavadli";
//            String postal="45s8";
//            String city="Ganja";
//            String sex="famle";
//            String fullanme=name+" "+surname;
//            String email="Ehmedli@gmail.com";
//            
//            SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );
//            java.util.Date myDate = format.parse("2009-06-06");
//            long l=myDate.getTime();
//            java.sql.Date birthDate = new java.sql.Date(l);
//            
//            User u=new User(10, name, surname, street, postal, city, c, email, sex, birthDate, n);
//            // boolean b=dao.addUser(u);
//            System.out.println(dao.updateUser(u));
//            System.out.println("****************");
//        } catch (ParseException ex) {
//            System.out.println(ex.getMessage());
//        }


    
             
    }
}
