/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.Phone;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface PhoneDaoInter {

    public List<Phone> getAll();

    public List<Phone> getListByUserId(int id);

    public boolean addPhone(Phone u);

    public boolean updatePhone(Phone u);

    public boolean removePhone(int id);
}
