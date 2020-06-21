/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import java.util.Objects;

/**
 *
 * @author virtu
 */
public class Education {
    private int id;
    private String qualification;
    private String organsiation;
    private String city;
    private Countries countryId;
    private String degree;
    private String AddInfo;
    private User userId;

    public Education() {
    }

    public Education(int id, String qualification, String organsiation, String city, Countries countryId, String degree, String AddInfo, User userId) {
        this.id = id;
        this.qualification = qualification;
        this.organsiation = organsiation;
        this.city = city;
        this.countryId = countryId;
        this.degree = degree;
        this.AddInfo = AddInfo;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getOrgansiation() {
        return organsiation;
    }

    public void setOrgansiation(String organsiation) {
        this.organsiation = organsiation;
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getAddInfo() {
        return AddInfo;
    }

    public void setAddInfo(String AddInfo) {
        this.AddInfo = AddInfo;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.qualification);
        hash = 53 * hash + Objects.hashCode(this.organsiation);
        hash = 53 * hash + Objects.hashCode(this.city);
        hash = 53 * hash + Objects.hashCode(this.countryId);
        hash = 53 * hash + Objects.hashCode(this.degree);
        hash = 53 * hash + Objects.hashCode(this.AddInfo);
        hash = 53 * hash + Objects.hashCode(this.userId);
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
        final Education other = (Education) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.qualification, other.qualification)) {
            return false;
        }
        if (!Objects.equals(this.organsiation, other.organsiation)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.degree, other.degree)) {
            return false;
        }
        if (!Objects.equals(this.AddInfo, other.AddInfo)) {
            return false;
        }
        if (!Objects.equals(this.countryId, other.countryId)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Education{" + "id=" + id + ", qualification=" + qualification + ", organsiation=" + organsiation + ", city=" + city + ", countryId=" + countryId + ", degree=" + degree + ", AddInfo=" + AddInfo + ", userId=" + userId + '}';
    }
    
    
    
}
