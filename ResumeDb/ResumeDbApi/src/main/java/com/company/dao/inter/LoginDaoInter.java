/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.Education;
import com.company.entity.Login;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface LoginDaoInter {

    public List<Login> getAll();

    public Login getById(int id);
    public Login getByUsernameAndPassword(String username,String password);

    public boolean addLogin(Login u);

    public boolean updateLogin(Login u);

    public boolean removeLogin(int id);

}
