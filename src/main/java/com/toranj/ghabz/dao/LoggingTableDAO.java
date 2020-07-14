package com.toranj.ghabz.dao;

import com.toranj.ghabz.entity.LoggingTable;

public interface LoggingTableDAO {
    void save(LoggingTable loggingTable);
    LoggingTable findByID(String id);
}
