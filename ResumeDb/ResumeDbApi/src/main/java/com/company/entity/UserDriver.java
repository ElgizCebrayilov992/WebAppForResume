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
public class UserDriver {
    private int id;
    private User userId;
    private DriverCat driverId;

    public UserDriver() {
    }

    public UserDriver(int id, User userId, DriverCat driverId) {
        this.id = id;
        this.userId = userId;
        this.driverId = driverId;
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

    public DriverCat getDriverId() {
        return driverId;
    }

    public void setDriverId(DriverCat driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "UserDriver{" + "id=" + id + ", userId=" + userId + ", driverId=" + driverId + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.userId);
        hash = 37 * hash + Objects.hashCode(this.driverId);
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
        final UserDriver other = (UserDriver) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.driverId, other.driverId)) {
            return false;
        }
        return true;
    }
    
    
}
