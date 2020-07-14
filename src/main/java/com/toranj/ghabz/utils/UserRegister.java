package com.toranj.ghabz.utils;

import com.toranj.ghabz.entity.NaturalPerson;

public class UserRegister {
    private NaturalPerson naturalPerson;

    public UserRegister() {
    }

    public UserRegister(NaturalPerson naturalPerson) {
        this.naturalPerson = naturalPerson;
    }

    public NaturalPerson getNaturalPerson() { return naturalPerson; }

    public void setNaturalPerson(NaturalPerson naturalPerson) { this.naturalPerson = naturalPerson; }
}
