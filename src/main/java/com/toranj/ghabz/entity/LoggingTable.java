package com.toranj.ghabz.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_logging")
public class LoggingTable {
    @Id
    @Column(name = "id", length = 50, nullable = false)
    private String id;

    @Column(name = "debug_Message", length = 100)
    private String debugMessage;

    @Column(name = "error_Message", length = 100)
    private String errorMessage;

    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    @Column(name = "userName", length = 50)
    private String userName;

    @Column(name = "methodArgument", length = 100)
    private String methodArgument;

    @Column(name = "userIp", length = 100)
    private String userIp;


    public LoggingTable() {
    }

    public LoggingTable(String id, String debugMessage, String errorMessage, Date creationDate, String userName, String methodArgument, String userIp) {
        this.id = id;
        this.debugMessage = debugMessage;
        this.errorMessage = errorMessage;
        this.creationDate = creationDate;
        this.userName = userName;
        this.methodArgument = methodArgument;
        this.userIp = userIp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMethodArgument() {
        return methodArgument;
    }

    public void setMethodArgument(String methodArgument) {
        this.methodArgument = methodArgument;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
}
