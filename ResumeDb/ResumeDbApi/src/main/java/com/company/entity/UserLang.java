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
public class UserLang {
    private int id;
    private User userId;
    private Languages langId;
    private String underListen;
    private String underRead;
    private String underSpeak;
    private String certificate;

    public UserLang() {
    }

    public UserLang(int id, User userId, Languages langId, String underListen, String underRead, String underSpeak, String certificate) {
        this.id = id;
        this.userId = userId;
        this.langId = langId;
        this.underListen = underListen;
        this.underRead = underRead;
        this.underSpeak = underSpeak;
        this.certificate = certificate;
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

    public Languages getLangId() {
        return langId;
    }

    public void setLangId(Languages langId) {
        this.langId = langId;
    }

    public String getUnderListen() {
        return underListen;
    }

    public void setUnderListen(String underListen) {
        this.underListen = underListen;
    }

    public String getUnderRead() {
        return underRead;
    }

    public void setUnderRead(String underRead) {
        this.underRead = underRead;
    }

    public String getUnderSpeak() {
        return underSpeak;
    }

    public void setUnderSpeak(String underSpeak) {
        this.underSpeak = underSpeak;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.userId);
        hash = 37 * hash + Objects.hashCode(this.langId);
        hash = 37 * hash + Objects.hashCode(this.underListen);
        hash = 37 * hash + Objects.hashCode(this.underRead);
        hash = 37 * hash + Objects.hashCode(this.underSpeak);
        hash = 37 * hash + Objects.hashCode(this.certificate);
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
        final UserLang other = (UserLang) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.underListen, other.underListen)) {
            return false;
        }
        if (!Objects.equals(this.underRead, other.underRead)) {
            return false;
        }
        if (!Objects.equals(this.underSpeak, other.underSpeak)) {
            return false;
        }
        if (!Objects.equals(this.certificate, other.certificate)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.langId, other.langId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserLang{" + "id=" + id + ", userId=" + userId + ", langId=" + langId + ", underListen=" + underListen + ", underRead=" + underRead + ", underSpeak=" + underSpeak + ", certificate=" + certificate + '}';
    }
    
    
    
}
