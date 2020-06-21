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
public class ImageUrl {
    private int id;
    private String imageUrlName;
    private User userId;

    public ImageUrl() {
    }

    public ImageUrl(int id, String imageUrlName, User userId) {
        this.id = id;
        this.imageUrlName = imageUrlName;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrlName() {
        return imageUrlName;
    }

    public void setImageUrlName(String imageUrlName) {
        this.imageUrlName = imageUrlName;
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
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.imageUrlName);
        hash = 73 * hash + Objects.hashCode(this.userId);
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
        final ImageUrl other = (ImageUrl) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.imageUrlName, other.imageUrlName)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ImageUrl{" + "id=" + id + ", imageUrlName=" + imageUrlName + ", userId=" + userId + '}';
    }
    
}
