/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.Languages;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface LanguagesDaoInter {
    public List<Languages> getAll();

    public Languages getById(int id);

    public boolean addLanguages(Languages u);

    public boolean updateLanguages(Languages u);

    public boolean removeLanguages(int id);

    
}
