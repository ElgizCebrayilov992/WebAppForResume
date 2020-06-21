/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Countries;
import com.company.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author virtu
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter{

    private User getUser(ResultSet rs) throws Exception{
        
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String address = rs.getString("street_address");
        String postalCode = rs.getString("postal_code");
        String city = rs.getString("city");
        
        int countryId=rs.getInt("country_id");
        String countryName=rs.getString("country");
        Countries country=new Countries(countryId, countryName, null);
        
        int nationalityId=rs.getInt("nationality_id");
        String nationalityName=rs.getString("nationality");
        Countries nationality=new Countries(nationalityId, null, nationalityName);
        
        String sex = rs.getString("sex");
        Date dateBirth = rs.getDate("date_birth");
        
        
        return new User(id, name, surname,
                address, postalCode, city,
                country, email, sex, dateBirth,
                nationality);
        
    
    
    }
    
    @Override
    public List<User> getAll() {
        List<User> list=new ArrayList<>();
        
        String sql="SELECT\n" +
"	u.*,\n" +
"	c.country,\n" +
"	n.nationality \n" +
"FROM\n" +
"	`user` u\n" +
"	LEFT JOIN countries c ON c.id = u.country_id\n" +
"	LEFT JOIN countries n ON n.id = u.nationality_id";
      
        try(Connection con=connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
             while (rs.next()) {
                User u = getUser(rs);
                list.add(u);

            }
        } catch (Exception e) {
           e.getMessage();
        }
           return list;
     }

    @Override
    public List<User> getSearchUser(String fullName) {
        System.out.println("Name"+fullName);

        List<User> list=new ArrayList<>();
       
        try(Connection con=connection()) {
           //String sql="";
            if (fullName!=null&&!fullName.trim().isEmpty()){
//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
              Statement stm = connection().createStatement();
              stm.execute("SELECT u.*,c.country,n.nationality FROM `user` "
                    + "u LEFT JOIN countries c ON c.id = u.country_id "
                    + "LEFT JOIN countries n ON n.id = u.nationality_id WHERE fullname LIKE '%"+fullName.trim()+"%' ");
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
               User result = getUser(rs);
               list.add(result);
            }
                   }
      
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public User getById(int id) {
            User u=null;
        try(Connection c=connection()) {
             Statement stm = c.createStatement();
             stm.execute("SELECT u.*,c.country,n.nationality FROM `user` "
                    + "u LEFT JOIN countries c ON c.id = u.country_id "
                    + "LEFT JOIN countries n ON n.id = u.nationality_id where u.id="+id);
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                u = getUser(rs);

            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return u;
     }

    @Override
    public boolean addUser(User u) {
        try(Connection c=connection()) {
            PreparedStatement ps=c.prepareStatement("INSERT INTO USER ( name, surname, street_address, postal_code, city, country_id, email, sex, date_birth, nationality_id, fullname) VALUES( ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ? )");
             ps.setString(1, u.getName());
            ps.setString(2, u.getSurname());
            ps.setString(3, u.getStreetAdrdress());
            ps.setString(4, u.getPostalCode());
            ps.setString(5, u.getCity());
            ps.setInt(6, u.getCountryId().getId());
            ps.setString(7, u.getEmail());
            ps.setString(8, u.getSex());
            ps.setDate(9, u.getDateBirth());
            ps.setInt(10, u.getCountryId().getId());
            ps.setString(11, u.getFullName());
            
             ps.execute();
        } catch (Exception e) {
            System.out.println( e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connection()) {

            PreparedStatement ps = c.prepareStatement("update user set name=?,surname=?,street_address=?,postal_code=?,city=?,country_id=?,email=?,sex=?,date_birth=?,nationality_id=?,fullname=? where id=?");
            ps.setString(1, u.getName());
            ps.setString(2, u.getSurname());
                   ps.setString(3, u.getStreetAdrdress());
            ps.setString(4, u.getPostalCode());
            ps.setString(5, u.getCity());
            ps.setInt(6, u.getCountryId().getId());
            ps.setString(7, u.getEmail());
            ps.setString(8, u.getSex());
            ps.setDate(9, u.getDateBirth());
            ps.setInt(10, u.getCountryId().getId());
            ps.setString(11, u.getFullName());
            ps.setInt(12, u.getId());
             ps.execute();
        } catch (Exception e) {
            System.out.println( e.getMessage());
            return false;
        }
return true;
    }

    @Override
    public boolean removeUser(int id) {
       try (Connection connect = connection()) {

             Statement stm = connect.createStatement();
             stm.execute("DELETE FROM education WHERE user_id="+id+";");
             stm.execute("DELETE FROM image_url WHERE user_id="+id+";");
             stm.execute("DELETE FROM phone WHERE user_id="+id+";");
             stm.execute("DELETE FROM user_driver WHERE user_id="+id+";");
             stm.execute("DELETE FROM user_lang WHERE user_id="+id+";");
             stm.execute("DELETE FROM user_login WHERE user_id="+id+";");
             stm.execute("DELETE FROM user_skill WHERE user_id="+id+";");
             stm.execute("DELETE FROM website WHERE user_id="+id+";");
             stm.execute("DELETE FROM work WHERE user_id="+id+";");
             stm.execute("DELETE FROM user WHERE id="+id+";");
             
          ResultSet rs = stm.getResultSet();
         
         
          
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    
    
}
