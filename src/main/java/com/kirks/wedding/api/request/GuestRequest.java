package com.kirks.wedding.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kirks.wedding.core.domain.Guest;

public record GuestRequest(String name, @JsonProperty("group_id") String groupId) {

    public Guest toGuest() {
        return new Guest();
    }

}
