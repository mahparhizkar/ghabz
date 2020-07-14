package com.toranj.ghabz.dao;

import com.toranj.ghabz.entity.Error;

public interface ErrorDAO {
    void save(Error error);
    Error findBylId(String id);
}
