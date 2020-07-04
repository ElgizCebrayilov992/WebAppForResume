/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.DriverCat;
import com.company.entity.UserDriver;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface UserDriverDaoInter {

    public List<UserDriver> getAll();

    public UserDriver getById(int id);

    public boolean addUserDriver(UserDriver u);

    public boolean updateUserDriver(UserDriver u);

    public boolean removeUserDriver(int id);
}
