/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.WorkDaoInter;
import com.company.entity.Countries;
import com.company.entity.User;
import com.company.entity.Website;
import com.company.entity.Work;
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
public class WorkDaoImpl extends AbstractDAO implements WorkDaoInter {

    private Work getWork(ResultSet rs) throws Exception {

        int id = rs.getInt("id");
        String job_title = rs.getString("job_title");
        String company = rs.getString("company");
        String about = rs.getString("about");

        Date begin = rs.getDate("begin");
        Date end = rs.getDate("end");

        int user_id = rs.getInt("user_id");
        User userId = new User();
        userId.setId(user_id);

        return new Work(id, job_title, company, about, begin, end, userId);

    }

    @Override
    public List<Work> getAll() {
        List<Work> list = new ArrayList<>();
        String sql = "SELECT * FROM work";
        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Work u = getWork(rs);
                list.add(u);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public List<Work> getListByUserId(int id) {
        List<Work> list = new ArrayList<>();
        String sql = "SELECT * FROM `work` WHERE user_id=" + id;
        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Work u = getWork(rs);
                list.add(u);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public boolean addWork(Work u) {

        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO work ( job_title, company, about, begin, end, user_id) VALUES( ?, ?, ?, ?,?, ? )");
            ps.setString(1, u.getJobTitle());
            ps.setString(2, u.getCompany());
            ps.setString(3, u.getAbout());
            ps.setDate(4, u.getBegin());
            ps.setDate(5, u.getEnd());
            ps.setInt(6, u.getUserId().getId());

            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean updateWork(Work u) {
        try (Connection c = connection()) {

            PreparedStatement ps = c.prepareStatement("update user set job_title=?, company=?, about=?, begin=?, end=?, user_id=? where id=?");
            ps.setString(1, u.getJobTitle());
            ps.setString(2, u.getCompany());
            ps.setString(3, u.getAbout());
            ps.setDate(4, u.getBegin());
            ps.setDate(5, u.getEnd());
            ps.setInt(6, u.getUserId().getId());
            ps.setInt(7, u.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean removeWork(int id) {
        try (Connection connect = connection()) {

            Statement stm = connect.createStatement();

            stm.execute("DELETE FROM work WHERE id=" + id + ";");

            ResultSet rs = stm.getResultSet();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;

    }

}
