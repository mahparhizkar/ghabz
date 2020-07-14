package com.toranj.ghabz.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_user", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"}), @UniqueConstraint(columnNames = {"user_name"})})
public class User implements Serializable {

    private static final long serialVersionUID = -2054654325979281969L;

    @Id
    @Column(name = "id", length = 50, nullable = false)
    private String id;
    @Column(name="shenase",length= 50,nullable=false)
    protected String shenase;
    @Column(name = "fk_person", length = 50, nullable = false)
    private String fkPerson;
    @Column(name = "user_name", length = 50, nullable = false)
    private String userName;
    @Transient
    private String mobileNumber;
    @Column(name = "password", length = 255, nullable = false)
    private String password;
    @Transient
    private String confirmPassword;
    @Column(name = "status", length = 50, nullable = false)
    private String status;
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;
    @Column(name = "valid_from")
    private Date validFrom;
    @Column(name = "valid_until")
    private Date validUntil;
    @Transient
    private String otp;

    @Transient
    private String captcha;

    @Column(name = "fk_user_role", length = 50, nullable = false)
    private String fkUserRole;

    public User() {
    }

    public User(String id, String shenase, String fkPerson, String userName, String mobileNumber, String password, String confirmPassword, String status, Date creationDate, Date validFrom, Date validUntil, String otp, String captcha, String fkUserRole) {
        this.id = id;
        this.shenase=shenase;
        this.fkPerson = fkPerson;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.status = status;
        this.creationDate = creationDate;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
        this.otp = otp;
        this.captcha = captcha;
        this.fkUserRole = fkUserRole;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShenase(){return shenase;}

    public void setShenase(String shenase){this.shenase=shenase;}

    public String getFkPerson() {
        return fkPerson;
    }

    public void setFkPerson(String fkPerson) {
        this.fkPerson = fkPerson;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }


    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }


    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getFkUserRole() {
        return fkUserRole;
    }

    public void setFkUserRole(String fkUserRole) {
        this.fkUserRole = fkUserRole;
    }
}