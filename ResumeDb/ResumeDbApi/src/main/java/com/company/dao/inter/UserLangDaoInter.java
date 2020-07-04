/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.Languages;
import com.company.entity.Skill;
import com.company.entity.UserLang;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface UserLangDaoInter {

    public List<UserLang> getAll();

    public List<UserLang> getListByUserId(int id);

    public boolean addUserLang(UserLang u);

    public boolean updateUserLang(UserLang u);

    public boolean removeUserLang(int id);
}
