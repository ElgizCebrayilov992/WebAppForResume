/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EducationDaoInter;
import com.company.entity.Countries;
import com.company.entity.Education;
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
public class EducationDaoImpl extends AbstractDAO implements EducationDaoInter {

    private Education getEducation(ResultSet rs) throws Exception {

        int id = rs.getInt("id");
        String qualification = rs.getString("qualification");
        String organisation = rs.getString("organisation");
        String city = rs.getString("city");
        String degree = rs.getString("degree");

        String add_info = rs.getString("add_info");

        int countryId = rs.getInt("country_id");
        String countryName = rs.getString("country");
        Countries country = new Countries(countryId, countryName, null);

        int user_id = rs.getInt("user_id");
        User userId = new User();
        userId.setId(user_id);

        return new Education(id, qualification, organisation, city, country, degree, add_info, userId);

    }

    @Override
    public List<Education> getAll() {
        List<Education> list = new ArrayList<>();

        String sql = "SELECT * FROM education";

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Education u = getEducation(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    
    
    @Override
    public List<Education> getListByUserId(int userId){
         List<Education> list = new ArrayList<>();

        String sql = "SELECT\n"
                    + "	e.*,\n"
                    + "	c.country \n"
                    + "FROM\n"
                    + "	education e\n"
                    + "	LEFT JOIN countries c ON c.id = e.country_id\n"
                    + "	\n"
                    + "WHERE\n"
                    + "	e.user_id =" + userId;

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Education u = getEducation(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public boolean addEducation(Education u) {
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO education ( qualification, organisation, city, country_id, degree, add_info, user_id) VALUES( ?, ?, ?, ?,?, ?, ? )");
            ps.setString(1, u.getQualification());
            ps.setString(2, u.getOrgansiation());
            ps.setString(3, u.getCity());
            ps.setInt(4, u.getCountryId().getId());
            ps.setString(5, u.getDegree());
            ps.setString(6, u.getAddInfo());
            ps.setInt(7, u.getUserId().getId());

            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean updateEducation(Education u) {
        try (Connection c = connection()) {

            PreparedStatement ps = c.prepareStatement("update education set qualification=?,organisation=?,city=?,country_id=?,degree=?,add_info=? user_id=? where id=?");
            ps.setString(1, u.getQualification());
            ps.setString(2, u.getOrgansiation());
            ps.setString(3, u.getCity());
            ps.setInt(4, u.getCountryId().getId());
            ps.setString(5, u.getDegree());
            ps.setString(6, u.getAddInfo());
            ps.setInt(7, u.getUserId().getId());
            ps.setInt(8, u.getId());

            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean removeEducation(int id) {

        try (Connection connect = connection()) {

            Statement stm = connect.createStatement();
            stm.execute("DELETE FROM education WHERE id=" + id + ";");
            ResultSet rs = stm.getResultSet();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

}
