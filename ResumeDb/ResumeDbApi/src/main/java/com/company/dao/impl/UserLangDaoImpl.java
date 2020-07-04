/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserLangDaoInter;
import com.company.entity.Languages;
import com.company.entity.User;
import com.company.entity.UserLang;
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
public class UserLangDaoImpl extends AbstractDAO implements UserLangDaoInter {

    private UserLang getUserLang(ResultSet rs) throws Exception {

        int id = rs.getInt("id");
        String under_listen = rs.getString("under_listen");
        String under_read = rs.getString("under_read");
        String under_speak = rs.getString("under_speak");
        String certificate = rs.getString("certificate");

        String name = rs.getString("name");
        int lang_id = rs.getInt("lang_id");
        Languages lang = new Languages(lang_id, name);

        int user_id = rs.getInt("user_id");
        User userId = new User();
        userId.setId(user_id);

        return new UserLang(id, userId, lang, under_listen, under_read, under_speak, certificate);
    }

    @Override
    public List<UserLang> getAll() {
        List<UserLang> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "	ul.*,\n"
                + "	l.`name` \n"
                + "FROM\n"
                + "	user_lang ul\n"
                + "	LEFT JOIN languages l ON l.id = ul.lang_id";
        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                UserLang u = getUserLang(rs);
                list.add(u);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public List<UserLang> getListByUserId(int id) {
        List<UserLang> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "	ul.*,\n"
                + "	l.`name` \n"
                + "FROM\n"
                + "	user_lang ul\n"
                + "	LEFT JOIN languages l ON l.id = ul.lang_id WHERE user_id=" + id;
        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                UserLang u = getUserLang(rs);
                list.add(u);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public boolean addUserLang(UserLang u) {
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO user_lang ( user_id,lang_id,under_listen,under_read,under_speak,certificate ) VALUES( ?,?,?,?,?,? )");
            ps.setInt(1, u.getUserId().getId());
            ps.setInt(2, u.getLangId().getId());
            ps.setString(3, u.getUnderListen());
            ps.setString(4, u.getUnderRead());
            ps.setString(5, u.getUnderSpeak());
            ps.setString(6, u.getCertificate());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean updateUserLang(UserLang u) {

        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("update user_lang set user_id=?,lang_id=?,under_listen=?,under_read=?,under_speak=?,certificate=? where id=?");
            ps.setInt(1, u.getUserId().getId());
            ps.setInt(2, u.getLangId().getId());
            ps.setString(3, u.getUnderListen());
            ps.setString(4, u.getUnderRead());
            ps.setString(5, u.getUnderSpeak());
            ps.setString(6, u.getCertificate());
            ps.setInt(7, u.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean removeUserLang(int id) {

        try (Connection connect = connection()) {
            Statement stm = connect.createStatement();
            stm.execute("DELETE FROM user_lang WHERE id=" + id + ";");
            ResultSet rs = stm.getResultSet();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

}
