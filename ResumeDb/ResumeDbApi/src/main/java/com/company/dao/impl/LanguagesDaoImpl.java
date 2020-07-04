/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.LanguagesDaoInter;
import com.company.entity.Languages;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author virtu
 */
public class LanguagesDaoImpl extends AbstractDAO implements LanguagesDaoInter{

   private Languages getLanguages(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        return new Languages(id, name);
    }

    @Override
    public List<Languages> getAll() {
        List<Languages> list = new ArrayList<>();
        String sql = "SELECT * FROM languages";
        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Languages u = getLanguages(rs);
                list.add(u);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public Languages getById(int id) {
        Languages u = null;
        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT * FROM languages where id=" + id);
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                u = getLanguages(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return u;
    }

    @Override
    public boolean addLanguages(Languages u) {
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO languages ( name ) VALUES( ? )");
            ps.setString(1, u.getName());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean updateLanguages(Languages u) {
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("update languages set name=? where id=?");
            ps.setString(1, u.getName());
            ps.setInt(2, u.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean removeLanguages(int id) {
        try (Connection connect = connection()) {
            Statement stm = connect.createStatement();
            stm.execute("DELETE FROM languages WHERE id=" + id + ";");
            ResultSet rs = stm.getResultSet();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;

    }  
}
