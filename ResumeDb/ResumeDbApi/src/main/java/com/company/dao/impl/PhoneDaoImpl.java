/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.PhoneDaoInter;
import com.company.entity.Phone;
import com.company.entity.User;
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
public class PhoneDaoImpl extends AbstractDAO implements PhoneDaoInter {

    private Phone getPhone(ResultSet rs) throws Exception {

        int id = rs.getInt("id");
        String type = rs.getString("type");
        String phone_number = rs.getString("phone_number");

        String name = rs.getString("name");
        String surname = rs.getString("surname");
        int user_id = rs.getInt("user_id");
        User userId = new User();
        userId.setId(id);
        userId.setName(name);
        userId.setSurname(surname);

        return new Phone(id, type, phone_number, userId);

    }

    @Override
    public List<Phone> getAll() {

        List<Phone> list = new ArrayList<>();

        String sql = "SELECT\n"
                + "	p.*,\n"
                + "	u.`name`,\n"
                + "	u.surname \n"
                + "FROM\n"
                + "	phone p LEFT JOIN `user` u ON  u.id=p.user_id";

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Phone u = getPhone(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }
/*
    "SELECT\n"
                    + "	p.*,\n"
                    + "	u.`name`,\n"
                    + "	u.surname \n"
                    + "FROM\n"
                    + "	phone p LEFT JOIN `user` u ON  u.id=p.user_id WHERE user_id=" + id
    */
    @Override
    public List<Phone> getListByUserId(int id){
        List<Phone> list = new ArrayList<>();

        String sql = "SELECT\n"
                    + "	p.*,\n"
                    + "	u.`name`,\n"
                    + "	u.surname \n"
                    + "FROM\n"
                    + "	phone p LEFT JOIN `user` u ON  u.id=p.user_id WHERE user_id=" + id;

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Phone u = getPhone(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public boolean addPhone(Phone u) {
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO phone ( type, phone_number, user_id) VALUES( ?, ?, ?)");
            ps.setString(1, u.getType());
            ps.setString(2, u.getPhone_number());
            ps.setInt(3, u.getUserId().getId());

            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean updatePhone(Phone u) {
      try (Connection c = connection()) {

            PreparedStatement ps = c.prepareStatement("update phone set type=?,phone_number=?,user_id=? where id=?");
            ps.setString(1, u.getType());
            ps.setString(2, u.getPhone_number());
            ps.setInt(3, u.getUserId().getId());
            ps.setInt(4, u.getId());

            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    
    }

    @Override
    public boolean removePhone(int id) {
       
     try (Connection connect = connection()) {

            Statement stm = connect.createStatement();
            stm.execute("DELETE FROM phone WHERE id=" + id + ";");
            ResultSet rs = stm.getResultSet();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

}
