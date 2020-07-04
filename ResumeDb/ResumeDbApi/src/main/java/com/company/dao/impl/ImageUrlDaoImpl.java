/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.entity.ImageUrl;
import com.company.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.company.dao.inter.ImageUrlDaoInter;

/**
 *
 * @author virtu
 */
public class ImageUrlDaoImpl extends AbstractDAO implements ImageUrlDaoInter{

    private ImageUrl getImageUrl(ResultSet rs) throws Exception{
        
        int id = rs.getInt("id");
        String name = rs.getString("image_url_name");
        
        int user_id = rs.getInt("user_id");
        User userId=new User();
        userId.setId(user_id);
        
        
        return new ImageUrl(id, name, userId);
        
    
    
    }
    
    
    
    @Override
    public List<ImageUrl> getAll() {
      List<ImageUrl> list=new ArrayList<>();
        
        String sql="SELECT * FROM image_url";
      
        try(Connection con=connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
             while (rs.next()) {
                ImageUrl u = getImageUrl(rs);
                list.add(u);

            }
        } catch (Exception e) {
           e.getMessage();
        }
           return list;       
    
    }

    @Override
    public ImageUrl getById(int id) {
       ImageUrl u=null;
        try(Connection c=connection()) {
             Statement stm = c.createStatement();
             stm.execute("SELECT * FROM image_url where user_id="+id);
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                u = getImageUrl(rs);

            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return u;    
    
    }

    @Override
    public boolean addImageUrl(ImageUrl u) {
        try(Connection c=connection()) {
            PreparedStatement ps=c.prepareStatement("INSERT INTO image_url ( image_url_name, user_id) VALUES( ?, ?)");
             ps.setString(1, u.getImageUrlName());        
             ps.setInt(2, u.getUserId().getId());
           
            
             ps.execute();
        } catch (Exception e) {
            System.out.println( e.getMessage());
            return false;
        }
        return true;
    
    }

    @Override
    public boolean updateImageUrl(ImageUrl u) {
      try (Connection c = connection()) {

            PreparedStatement ps = c.prepareStatement("update image_url set image_url_name=?,user_id=? where id=?");
              ps.setString(1, u.getImageUrlName());        
              ps.setInt(2, u.getUserId().getId());          
              ps.setInt(3, u.getId());
              ps.execute();
        } catch (Exception e) {
            System.out.println( e.getMessage());
            return false;
        }
return true;      
    
    }

    @Override
    public boolean removeImageUrl(int id) {

         try (Connection connect = connection()) {

             Statement stm = connect.createStatement();
             stm.execute("DELETE FROM image_url WHERE user_id="+id+";");         
          ResultSet rs = stm.getResultSet();                            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;        
    }
    
}
