/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.Education;
import com.company.entity.ImageUrl;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface ImageUrlDaoInter {
    
    public List<ImageUrl> getAll();
    
    public ImageUrl getById(int id);
    
    public boolean addImageUrl(ImageUrl u);
    
    public boolean updateImageUrl(ImageUrl u);
    
    public boolean removeImageUrl(int id);
    
}
