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
public class Work {
    private int id;
    private String jobTitle;
    private String company;
    private String about;
    private Date begin;
    private Date end;
    private User userId;

    public Work() {
    }

    public Work(int id, String jobTitle, String company, String about, Date begin, Date end, User userId) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.company = company;
        this.about = about;
        this.begin = begin;
        this.end = end;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.jobTitle);
        hash = 47 * hash + Objects.hashCode(this.company);
        hash = 47 * hash + Objects.hashCode(this.about);
        hash = 47 * hash + Objects.hashCode(this.begin);
        hash = 47 * hash + Objects.hashCode(this.end);
        hash = 47 * hash + Objects.hashCode(this.userId);
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
        final Work other = (Work) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.jobTitle, other.jobTitle)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (!Objects.equals(this.about, other.about)) {
            return false;
        }
        if (!Objects.equals(this.begin, other.begin)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Work{" + "id=" + id + ", jobTitle=" + jobTitle + ", company=" + company + ", about=" + about + ", begin=" + begin + ", end=" + end + ", userId=" + userId + '}';
    }
    
    
}
