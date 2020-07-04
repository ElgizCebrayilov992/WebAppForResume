/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.dao.impl.CountriesDaoImpl;
import com.company.dao.impl.DriverCatDaoImpl;
import com.company.dao.impl.EducationDaoImpl;
import com.company.dao.impl.ImageUrlDaoImpl;
import com.company.dao.impl.LanguagesDaoImpl;
import com.company.dao.impl.LoginDaoImpl;
import com.company.dao.impl.PhoneDaoImpl;
import com.company.dao.impl.SkillDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.impl.UserDriverDaoImpl;
import com.company.dao.impl.UserLangDaoImpl;
import com.company.dao.impl.UserLoginDaoImpl;
import com.company.dao.impl.WebsiteDaoImpl;
import com.company.dao.impl.WorkDaoImpl;
import com.company.dao.inter.CountriesDaoInter;
import com.company.dao.inter.DriverCatDaoInter;
import com.company.dao.inter.EducationDaoInter;
import com.company.dao.inter.ImageUrlDaoInter;
import com.company.dao.inter.LanguagesDaoInter;
import com.company.dao.inter.LoginDaoInter;
import com.company.dao.inter.PhoneDaoInter;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserDriverDaoInter;
import com.company.dao.inter.UserLangDaoInter;
import com.company.dao.inter.UserLoginDaoInter;
import com.company.dao.inter.WebsiteDaoInter;
import com.company.dao.inter.WorkDaoInter;

/**
 *
 * @author virtu
 */
public class Contex {

    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }

    public static DriverCatDaoInter instanceDriverCatDao() {
        return new DriverCatDaoImpl();
    }

    public static EducationDaoInter instanceEducationDao() {
        return new EducationDaoImpl();
    }

    public static ImageUrlDaoInter instanceImageUrlDao() {
        return new ImageUrlDaoImpl();
    }

    public static CountriesDaoInter instanceCountriesDao() {
        return new CountriesDaoImpl();
    }

    public static LanguagesDaoInter instanceLanguagesDao() {
        return new LanguagesDaoImpl();
    }

    public static LoginDaoInter instanceLoginDao() {
        return new LoginDaoImpl();
    }

    public static PhoneDaoInter instancePhoneDao() {
        return new PhoneDaoImpl();
    }

    public static UserDriverDaoInter instanceUserDriverDao() {
        return new UserDriverDaoImpl();
    }

    public static SkillDaoInter instanceSkillDao() {
        return new SkillDaoImpl();
    }
    public static UserLangDaoInter instanceUserLangDao() {
        return new UserLangDaoImpl();
    }
    public static UserLoginDaoInter instanceUserLoginDao() {
        return new UserLoginDaoImpl();
    }
    public static WebsiteDaoInter instanceWebsiteDao() {
        return new WebsiteDaoImpl();
    }
    public static WorkDaoInter instanceWorkDao() {
        return new WorkDaoImpl();
    }
}
