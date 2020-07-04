/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.Education;
import com.company.entity.Skill;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface SkillDaoInter {

    public List<Skill> getAll();

    public List<Skill> getListByUserId(int id);

    public boolean addSkill(Skill u);

    public boolean updateSkill(Skill u);

    public boolean removeSkill(int id);

}
