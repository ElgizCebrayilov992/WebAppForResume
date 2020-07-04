/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.Education;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface EducationDaoInter {

    public List<Education> getAll();

    public List<Education> getListByUserId(int id);

    public boolean addEducation(Education u);

    public boolean updateEducation(Education u);

    public boolean removeEducation(int id);
}
