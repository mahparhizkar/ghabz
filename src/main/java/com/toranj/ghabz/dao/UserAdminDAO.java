package com.toranj.ghabz.dao;

public interface UserAdminDAO {
    void saveUser(String nationalId, String mobileNumber, String shenase, String pass, String role);
}
