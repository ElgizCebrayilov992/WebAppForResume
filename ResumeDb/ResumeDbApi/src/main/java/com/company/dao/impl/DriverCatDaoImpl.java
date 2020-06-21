/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.DriverCatDaoInter;
import com.company.entity.Countries;
import com.company.entity.DriverCat;
import com.company.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author virtu
 */
public class DriverCatDaoImpl extends AbstractDAO implements DriverCatDaoInter{

     private DriverCat getDriverCat(ResultSet rs) throws Exception{      
        int id = rs.getInt("id");
        String name = rs.getString("name");     
        return new DriverCat(id, name);
     }
    
    @Override
    public List<DriverCat> getAll() {
    List<DriverCat> list=new ArrayList<>();
        String sql="SELECT * FROM driver_cat";     
        try(Connection con=connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
             while (rs.next()) {
                DriverCat u = getDriverCat(rs);
                list.add(u);
            }
        } catch (Exception e) {
           e.getMessage();
        }
           return list;    
    }

    @Override
    public DriverCat getById(int id) {   
        DriverCat u=null;
        try(Connection c=connection()) {
             Statement stm = c.createStatement();
             stm.execute("SELECT * FROM driver_cat where id="+id);
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                u = getDriverCat(rs);
            }            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return u;  
    }

    @Override
    public boolean addDriverCat(DriverCat u) {
      try(Connection c=connection()) {
            PreparedStatement ps=c.prepareStatement("INSERT INTO driver_cat ( name ) VALUES( ? )");
             ps.setString(1, u.getName());          
             ps.execute();
        } catch (Exception e) {
            System.out.println( e.getMessage());
            return false;
        }
        return true;}

    @Override
    public boolean updateDriverCat(DriverCat u) {
       try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("update driver_cat set name=? where id=?");
            ps.setString(1, u.getName());    
            ps.setInt(2, u.getId());
             ps.execute();
        } catch (Exception e) {
            System.out.println( e.getMessage());
            return false;
        }
return true;  
    }

    @Override
    public boolean removeDriverCat(int id) {
    try (Connection connect = connection()) {
             Statement stm = connect.createStatement();           
             stm.execute("DELETE FROM driver_cat WHERE id="+id+";");           
          ResultSet rs = stm.getResultSet();
       
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;    
    
    }
    
}
