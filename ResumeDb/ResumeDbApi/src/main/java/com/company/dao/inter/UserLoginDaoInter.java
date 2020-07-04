/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.UserLogin;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface UserLoginDaoInter {

    public List<UserLogin> getAll();

    public List<UserLogin> getById(int id);

    public boolean addUserLogin(UserLogin u);

    public boolean updateUserLogin(UserLogin u);

    public boolean removeUserLogin(int id);

}
