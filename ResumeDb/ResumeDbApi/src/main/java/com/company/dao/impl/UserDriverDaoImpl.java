/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDriverDaoInter;
import com.company.entity.DriverCat;
import com.company.entity.User;
import com.company.entity.UserDriver;
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
public class UserDriverDaoImpl extends AbstractDAO implements UserDriverDaoInter {

    private UserDriver getUserDriver(ResultSet rs) throws Exception {
        int id = rs.getInt("id");

        int user_id = rs.getInt("user_id");
        User userId = new User();
        userId.setId(user_id);

        int driver_cat_id = rs.getInt("driver_cat_id");
        String name = rs.getString("name");
        DriverCat dcId = new DriverCat(driver_cat_id, name);

        return new UserDriver(id, userId, dcId);
    }

    @Override
    public List<UserDriver> getAll() {
        List<UserDriver> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "\n"
                + "	dc.*,\n"
                + "	ud.user_id AS \"user_id\" ,\n"
                + "	ud.driver_id AS \"driver_cat_id\"\n"
                + "FROM\n"
                + "	user_driver ud\n"
                + "	LEFT JOIN driver_cat dc ON dc.id = ud.driver_id;";
        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                UserDriver u = getUserDriver(rs);
                list.add(u);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public UserDriver getById(int id) {

        UserDriver u = null;
        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT\n"
                    + "\n"
                    + "	dc.*,\n"
                    + "	ud.user_id AS \"user_id\" ,\n"
                    + "	ud.driver_id AS \"driver_cat_id\"\n"
                    + "FROM\n"
                    + "	user_driver ud\n"
                    + "	LEFT JOIN driver_cat dc ON dc.id = ud.driver_id WHERE user_id=" + id);
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                u = getUserDriver(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return u;

    }

    @Override
    public boolean addUserDriver(UserDriver u) {
    try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO user_driver ( user_id,driver_id ) VALUES( ?,? )");
            ps.setInt(1, u.getUserId().getId());
            ps.setInt(2, u.getDriverId().getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;    
    }

    @Override
    public boolean updateUserDriver(UserDriver u) {
    try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("update user_driver set user_id=?,driver_id=? where id=?");
            ps.setInt(1, u.getUserId().getId());
            ps.setInt(2, u.getDriverId().getId());
            ps.setInt(3, u.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;    
    
    }

    @Override
    public boolean removeUserDriver(int userId) {
     try (Connection connect = connection()) {
            Statement stm = connect.createStatement();
            stm.execute("DELETE FROM user_driver WHERE id=" + userId + ";");
            ResultSet rs = stm.getResultSet();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;  
    
    }

}
