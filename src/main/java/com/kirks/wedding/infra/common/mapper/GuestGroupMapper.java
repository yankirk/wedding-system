package com.kirks.wedding.infra.common.mapper;

import com.kirks.wedding.infra.entity.GuestGroupEntity;

public class GuestGroupMapper {

    private GuestGroupMapper() {}

    public static GuestGroupEntity mapToEntity(final String name) {
        return new GuestGroupEntity(name);
    }
}
