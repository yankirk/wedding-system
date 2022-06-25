package com.kirks.wedding.core.domain;

import java.util.ArrayList;
import java.util.List;

public record GuestGroup(String id, List<Person> guests) {

    public GuestGroup(String id) {
        this(id, new ArrayList<>());
    }

    public void addGuest(final Person person) {
        guests.add(person);
    }

}
