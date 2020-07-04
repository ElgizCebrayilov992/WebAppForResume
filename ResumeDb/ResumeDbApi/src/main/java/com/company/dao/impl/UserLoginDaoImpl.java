/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserLoginDaoInter;
import com.company.entity.Countries;
import com.company.entity.Login;
import com.company.entity.User;
import com.company.entity.UserLogin;
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
public class UserLoginDaoImpl extends AbstractDAO implements UserLoginDaoInter {

    private UserLogin getUserLogin(ResultSet rs) throws Exception {

        int id = rs.getInt("id");

        String name = rs.getString("name");
        String surname = rs.getString("surname");
        int user_id = rs.getInt("user_id");
        User user = new User();
        user.setId(user_id);
        user.setName(name);
        user.setSurname(surname);

        int login_id = rs.getInt("login_id");
        Login login = new Login();
        login.setId(login_id);

        return new UserLogin(id, user, login);

    }

    @Override
    public List<UserLogin> getAll() {
        List<UserLogin> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "	ul.*,\n"
                + "	u.`name`,\n"
                + "	u.surname \n"
                + "FROM\n"
                + "	user_login ul\n"
                + "	LEFT JOIN `user` u ON u.id = ul.user_id\n"
                + "	LEFT JOIN login l ON l.id = ul.login_id";
        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                UserLogin u = getUserLogin(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public List<UserLogin> getById(int id) {
        List<UserLogin> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "	ul.*,\n"
                + "	u.`name`,\n"
                + "	u.surname \n"
                + "FROM\n"
                + "	user_login ul\n"
                + "	LEFT JOIN `user` u ON u.id = ul.user_id\n"
                + "	LEFT JOIN login l ON l.id = ul.login_id WHERE ul.id=" + id;
        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                UserLogin u = getUserLogin(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public boolean addUserLogin(UserLogin u) {
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO user_login ( user_id, login_id) VALUES( ?,? )");
            ps.setInt(1, u.getUserId().getId());
            ps.setInt(2, u.getLoginId().getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUserLogin(UserLogin u) {
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("update user_login set user_id=? ,login_id=?  where id=?");
            ps.setInt(1, u.getUserId().getId());
            ps.setInt(2, u.getLoginId().getId());
            ps.setInt(3, u.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean removeUserLogin(int id) {
        try (Connection connect = connection()) {
            Statement stm = connect.createStatement();

            stm.execute("DELETE FROM education WHERE user_id=" + id + ";");
            stm.execute("DELETE FROM image_url WHERE user_id=" + id + ";");
            stm.execute("DELETE FROM phone WHERE user_id=" + id + ";");
            stm.execute("DELETE FROM skill WHERE user_id=" + id + ";");
            stm.execute("DELETE FROM user_driver WHERE user_id=" + id + ";");
            stm.execute("DELETE FROM user_lang WHERE user_id=" + id + ";");
            stm.execute("DELETE FROM user_login WHERE user_id=" + id + ";");
            stm.execute("DELETE FROM website WHERE user_id=" + id + ";");
            stm.execute("DELETE FROM work WHERE user_id=" + id + ";");
            stm.execute("DELETE FROM user WHERE id=" + id + ";");
            ResultSet rs = stm.getResultSet();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;

    }

}
