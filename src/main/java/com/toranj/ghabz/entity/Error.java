package com.toranj.ghabz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_error")
public class Error {
    private static final long serialVersionUID = 174479855979285671L;

    @Id
    @Column(name = "id", length = 50, nullable = false)
    private String id;

    @Column(name = "errorCode", nullable = false)
    private String errorCode;

    @Column(name = "nationalId", nullable = false)
    private String nationalId;

    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    @Column(name = "userIp", length = 100)
    private String userIp;

    public Error() {
    }

    public Error(String id, String errorCode, String nationalId, Date creationDate, String userIp) {
        this.id = id;
        this.errorCode = errorCode;
        this.nationalId = nationalId;
        this.creationDate = creationDate;
        this.userIp = userIp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
}
