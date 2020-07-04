/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.CountriesDaoInter;
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
public class CountriesDaoImpl extends AbstractDAO implements CountriesDaoInter{
    
      private Countries getCountries(ResultSet rs) throws Exception{
        
        int id = rs.getInt("id");
        String country = rs.getString("country");
        String nationality = rs.getString("nationality");
        
        
        return new Countries(id, country, nationality);
        
    
    
    }

    @Override
    public List<Countries> getAll() {
    List<Countries> list = new ArrayList<>();
        String sql = "SELECT * FROM countries";
        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Countries u = getCountries(rs);
                list.add(u);
                
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;  
    
    }

    @Override
    public Countries getById(int id) {
    Countries u = null;
        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT * FROM countries where id=" + id);
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                u = getCountries(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return u;  
    }

    @Override
    public boolean addCountries(Countries u) {
         try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO countries ( country, nationality) VALUES( ?,? )");
            ps.setString(1, u.getCountry());
            ps.setString(1, u.getNationality());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    
    }

    @Override
    public boolean updateCountries(Countries u) {
         try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("update countries set country=? ,nationality=?  where id=?");
            ps.setString(1, u.getCountry());
            ps.setString(2, u.getNationality());
            ps.setInt(3, u.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean removeCountries(int id) {
     try (Connection connect = connection()) {
            Statement stm = connect.createStatement();
            stm.execute("DELETE FROM countries WHERE id=" + id + ";");
            ResultSet rs = stm.getResultSet();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;    
    
    }
    
}
