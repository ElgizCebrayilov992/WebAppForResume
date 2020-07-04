/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Countries;
import com.company.entity.Education;
import com.company.entity.Skill;
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
public class SkillDaoImpl  extends AbstractDAO implements SkillDaoInter{
    
    
    private Skill getSkill(ResultSet rs) throws Exception {

        int id = rs.getInt("id");
        String skill_name = rs.getString("skill_name");
        String add_info = rs.getString("add_info");
       
        
        int user_id = rs.getInt("user_id");
        User userId = new User();
        userId.setId(user_id);

        return new Skill(id, skill_name, add_info, userId);

    }

    @Override
    public List<Skill> getAll() {
      
     List<Skill> list = new ArrayList<>();

        String sql = "SELECT * FROM skill";

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Skill u = getSkill(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }
//"SELECT * FROM skill where user_id="+id
    
    
    @Override
    public List<Skill>  getListByUserId(int id) {
      List<Skill> list = new ArrayList<>();

        String sql ="SELECT * FROM skill where user_id="+id;

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Skill u = getSkill(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    
    }

    @Override
    public boolean addSkill(Skill u) {
    try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO skill ( skill_name, add_info, user_id) VALUES( ?, ?, ?)");
            ps.setString(1, u.getSkill_name());
            ps.setString(2, u.getAdd_info());
            ps.setInt(3, u.getUser_id().getId());

            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;  
    
    }

    @Override
    public boolean updateSkill(Skill u) {
    try (Connection c = connection()) {

            PreparedStatement ps = c.prepareStatement("update skill set skill_name=?,add_info=?,user_id=? where id=?");
            ps.setString(1, u.getSkill_name());
            ps.setString(2, u.getAdd_info());
            ps.setInt(3, u.getUser_id().getId());
            ps.setInt(4, u.getId());

            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;  
    
    }

    @Override
    public boolean removeSkill(int id) {
        try (Connection connect = connection()) {

            Statement stm = connect.createStatement();
            stm.execute("DELETE FROM skill WHERE id=" + id + ";");
            ResultSet rs = stm.getResultSet();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
}
