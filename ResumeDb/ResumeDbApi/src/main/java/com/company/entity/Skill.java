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
public class Skill {
    private int id;
    private String skill_name;
    private String add_info;
    private User user_id;

    public Skill() {
    }

    public Skill(int id, String skill_name, String add_info, User user_id) {
        this.id = id;
        this.skill_name = skill_name;
        this.add_info = add_info;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getAdd_info() {
        return add_info;
    }

    public void setAdd_info(String add_info) {
        this.add_info = add_info;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.skill_name);
        hash = 73 * hash + Objects.hashCode(this.add_info);
        hash = 73 * hash + Objects.hashCode(this.user_id);
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
        final Skill other = (Skill) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.skill_name, other.skill_name)) {
            return false;
        }
        if (!Objects.equals(this.add_info, other.add_info)) {
            return false;
        }
        if (!Objects.equals(this.user_id, other.user_id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Skill{" + "id=" + id + ", skill_name=" + skill_name + ", add_info=" + add_info + ", user_id=" + user_id + '}';
    }

}
