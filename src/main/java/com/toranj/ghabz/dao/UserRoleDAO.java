package com.toranj.ghabz.dao;

import com.toranj.ghabz.entity.Role;

import java.util.List;

public interface UserRoleDAO {
    void save();

    Role findById(int id);

    Role findByName(String name);

    List<Role> roleList();
}
