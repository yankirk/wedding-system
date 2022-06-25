package com.kirks.wedding.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kirks.wedding.core.domain.Person;

public record GuestRequest(String name, @JsonProperty("group_id") String groupId) {

    public Person toGuest() {
        return new Person(name);
    }

}
