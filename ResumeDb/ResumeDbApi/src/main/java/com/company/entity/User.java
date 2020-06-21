/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author virtu
 */
public class User {

    private int id;
    private String name;
    private String surname;
    private String streetAdrdress;
    private String postalCode;
    private String city;
    private Countries countryId;
    private String email;
    private String sex;
    private Date dateBirth;
    private Countries nationalityId;
    private String fullName;
    public User() {
    }

    public User(int id, String name, String surname, String streetAdrdress, String postalCode, String city, Countries countryId, String email, String sex, Date dateBirth, Countries nationalityId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.streetAdrdress = streetAdrdress;
        this.postalCode = postalCode;
        this.city = city;
        this.countryId = countryId;
        this.email = email;
        this.sex = sex;
        this.dateBirth = dateBirth;
        this.nationalityId = nationalityId;
        this.fullName=name+" "+surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreetAdrdress() {
        return streetAdrdress;
    }

    public void setStreetAdrdress(String streetAdrdress) {
        this.streetAdrdress = streetAdrdress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Countries getCountryId() {
        return countryId;
    }

    public void setCountryId(Countries countryId) {
        this.countryId = countryId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Countries getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Countries nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getFullName() {
        return name+" "+surname;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.surname);
        hash = 29 * hash + Objects.hashCode(this.streetAdrdress);
        hash = 29 * hash + Objects.hashCode(this.postalCode);
        hash = 29 * hash + Objects.hashCode(this.city);
        hash = 29 * hash + Objects.hashCode(this.countryId);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.sex);
        hash = 29 * hash + Objects.hashCode(this.dateBirth);
        hash = 29 * hash + Objects.hashCode(this.nationalityId);
        hash = 29 * hash + Objects.hashCode(this.fullName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.streetAdrdress, other.streetAdrdress)) {
            return false;
        }
        if (!Objects.equals(this.postalCode, other.postalCode)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.sex, other.sex)) {
            return false;
        }
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.countryId, other.countryId)) {
            return false;
        }
        if (!Objects.equals(this.dateBirth, other.dateBirth)) {
            return false;
        }
        if (!Objects.equals(this.nationalityId, other.nationalityId)) {
            return false;
        }
        return true;
    }

  

  
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", streetAdrdress=" + streetAdrdress + ", postalCode=" + postalCode + ", city=" + city + ", countryId=" + countryId + ", email=" + email + ", sex=" + sex + ", dateBirth=" + dateBirth + ", nationalityId=" + nationalityId + '}';
    }
    
    
   
}
