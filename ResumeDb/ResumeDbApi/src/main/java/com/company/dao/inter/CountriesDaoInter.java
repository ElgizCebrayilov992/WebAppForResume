/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.Countries;
import com.company.entity.DriverCat;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface CountriesDaoInter {

    public List<Countries> getAll();

    public Countries getById(int id);

    public boolean addCountries(Countries u);

    public boolean updateCountries(Countries u);

    public boolean removeCountries(int id);

}
