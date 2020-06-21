/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author virtu
 */
public class UserSkill {
    private int id;
    private User userId;
    private Skill skillId;
    private String addInfo;

    public UserSkill() {
    }

    public UserSkill(int id, User userId, Skill skillId, String addInfo) {
        this.id = id;
        this.userId = userId;
        this.skillId = skillId;
        this.addInfo = addInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Skill getSkillId() {
        return skillId;
    }

    public void setSkillId(Skill skillId) {
        this.skillId = skillId;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.userId);
        hash = 83 * hash + Objects.hashCode(this.skillId);
        hash = 83 * hash + Objects.hashCode(this.addInfo);
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
        final UserSkill other = (UserSkill) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.addInfo, other.addInfo)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.skillId, other.skillId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserSkill{" + "id=" + id + ", userId=" + userId + ", skillId=" + skillId + ", addInfo=" + addInfo + '}';
    }
    
    
}
