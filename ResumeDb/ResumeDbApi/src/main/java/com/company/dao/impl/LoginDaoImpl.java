/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.LoginDaoInter;
import com.company.entity.Login;
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
public class LoginDaoImpl extends AbstractDAO implements LoginDaoInter {

    private Login getLogin(ResultSet rs) throws Exception {

        int id = rs.getInt("id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String email = rs.getString("email");
        int status_read = rs.getInt("status_read");
        int status_edit = rs.getInt("status_edit");

        return new Login(id, username, password, email, status_read, status_edit);

    }

    @Override
    public List<Login> getAll() {
        List<Login> list = new ArrayList<>();

        String sql = "SELECT * FROM login";

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Login u = getLogin(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public Login getById(int id) {
        Login u = null;
        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT * FROM login where id=" + id);
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                u = getLogin(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return u;
    }

    @Override
    public boolean addLogin(Login u) {
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO login ( username,password,email,status_read,status_edit ) VALUES( ?,?,?,?,?)");
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getEmail());
            ps.setInt(4, u.getStatus_edit());
            ps.setInt(5, u.getStatus_read());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean updateLogin(Login u) {
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("update login set username=?, password=?,email=?,status_read=?,status_edit=?  where id=?");
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getEmail());
              ps.setInt(4, u.getStatus_edit());
            ps.setInt(5, u.getStatus_read());
            ps.setInt(6, u.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean removeLogin(int id) {
        try (Connection connect = connection()) {
            Statement stm = connect.createStatement();
            stm.execute("DELETE FROM login WHERE id=" + id + ";");
            ResultSet rs = stm.getResultSet();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Login getByUsernameAndPassword(String username, String password) {
   
        Login u = null;
        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT * FROM login WHERE username='"+username+"'"+ "AND `password`='"+password+"'");
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                u = getLogin(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return u;
        
        
        
        
        
        
        
    }

}
