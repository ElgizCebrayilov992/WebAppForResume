/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.DriverCat;
import com.company.entity.User;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface DriverCatDaoInter {
    
     public List<DriverCat> getAll();
    
    public DriverCat getById(int id);
    
    public boolean addDriverCat(DriverCat u);
    
    public boolean updateDriverCat(DriverCat u);
    
    public boolean removeDriverCat(int id);
    
}
