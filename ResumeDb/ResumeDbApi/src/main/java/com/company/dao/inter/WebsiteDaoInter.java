/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.UserLang;
import com.company.entity.Website;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface WebsiteDaoInter {

    public List<Website> getAll();

    public List<Website> getListByUserId(int id);

    public boolean addWebsite(Website u);

    public boolean updateWebsite(Website u);

    public boolean removeWebsite(int id);
}
