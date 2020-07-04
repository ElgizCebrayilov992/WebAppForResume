/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.Website;
import com.company.entity.Work;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface WorkDaoInter {

    public List<Work> getAll();

    public List<Work> getListByUserId(int id);

    public boolean addWork(Work u);

    public boolean updateWork(Work u);

    public boolean removeWork(int id);
}
