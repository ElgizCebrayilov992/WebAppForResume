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
public class Login {

    private int id;
    private String username;
    private String password;
    private String email;
    private int status_read;
    private int status_edit;

    public Login() {
    }

    public Login(int id, String username, String password, String email, int status_read, int status_edit) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.status_read = status_read;
        this.status_edit = status_edit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus_read() {
        return status_read;
    }

    public void setStatus_read(int status_read) {
        this.status_read = status_read;
    }

    public int getStatus_edit() {
        return status_edit;
    }

    public void setStatus_edit(int status_edit) {
        this.status_edit = status_edit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.username);
        hash = 47 * hash + Objects.hashCode(this.password);
        hash = 47 * hash + Objects.hashCode(this.email);
        hash = 47 * hash + this.status_read;
        hash = 47 * hash + this.status_edit;
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
        final Login other = (Login) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.status_read != other.status_read) {
            return false;
        }
        if (this.status_edit != other.status_edit) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Login{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", status_read=" + status_read + ", status_edit=" + status_edit + '}';
    }

    
}
