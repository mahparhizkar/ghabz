package com.toranj.ghabz.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_privilege")
public class Privilege implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;

    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    public Privilege() {
    }

    public Privilege(String name, List<Role> roles) {
        this.name = name;
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
