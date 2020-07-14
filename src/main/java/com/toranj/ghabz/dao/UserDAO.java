package com.toranj.ghabz.dao;

import com.toranj.ghabz.entity.User;

import java.util.Date;
import java.util.List;

public interface UserDAO {
    void save(User user);
    User findByUsername(String username);
    List<User> getUsers();
    void updateUser(User user);
    List<User> getUsersForAdmin();
    List<User> getUsersForPowerUser();
    List<User> getUsersForSupportUser();
    String getUserNewShenase();
     List getUserReport(Date startCreationDate, Date endCreationDate, Date startBirthDate, Date endBirthDate,
                        String shenase, String nationalId, String fk_user_role, String family, String name, String mobile_number);
}
