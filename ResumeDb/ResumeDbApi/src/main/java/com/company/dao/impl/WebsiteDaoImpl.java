/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.WebsiteDaoInter;
import com.company.entity.Languages;
import com.company.entity.User;
import com.company.entity.UserLang;
import com.company.entity.Website;
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
public class WebsiteDaoImpl extends AbstractDAO implements WebsiteDaoInter {

    private Website getWebsite(ResultSet rs) throws Exception {

        int id = rs.getInt("id");
        String name = rs.getString("name");

        int user_id = rs.getInt("user_id");
        User userId = new User();
        userId.setId(user_id);

        return new Website(id, name, userId);
    }

    @Override
    public List<Website> getAll() {
        List<Website> list = new ArrayList<>();
        String sql = "SELECT * FROM website";
        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Website u = getWebsite(rs);
                list.add(u);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public List<Website> getListByUserId(int id) {

        List<Website> list = new ArrayList<>();
        String sql = "SELECT * FROM website WHERE user_id=" + id;
        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Website u = getWebsite(rs);
                list.add(u);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public boolean addWebsite(Website u) {
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO website (name, user_id ) VALUES( ?,?)");
            ps.setString(1, u.getName());
            ps.setInt(2, u.getUserId().getId());

            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean updateWebsite(Website u) {

        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("update website set name=?,user_id=? where id=?");
            ps.setString(1, u.getName());
            ps.setInt(2, u.getUserId().getId());
            ps.setInt(3, u.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean removeWebsite(int id) {

        try (Connection connect = connection()) {
            Statement stm = connect.createStatement();
            stm.execute("DELETE FROM website WHERE id=" + id + ";");
            ResultSet rs = stm.getResultSet();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;

    }

}
