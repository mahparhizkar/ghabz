package com.toranj.ghabz.dao;

import com.toranj.ghabz.entity.NaturalPerson;

public interface NaturalPersonDAO {

    void save(NaturalPerson naturalPerson);

    void saveOrUpdate(NaturalPerson naturalPerson);

    NaturalPerson findByNationalId(String nationalId);

    void UpdateInfo(NaturalPerson naturalPerson);

    NaturalPerson findByMobile(String mobile);

    NaturalPerson findById(String id);
}
