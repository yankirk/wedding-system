package com.kirks.wedding.infra.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "guest-groups")
public class GuestGroupEntity {

    private final String name;

    public GuestGroupEntity(final String name) {
        this.name = name;
    }

}
