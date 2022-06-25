package com.kirks.wedding.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Test: Guest Group Domain")
class GuestGroupTest {

    @Test
    @DisplayName("When guest added then has list with guest")
    void whenGuestAdded() {

        var sut = new GuestGroup("any_group_id");
        var person = new Person("Luís Amilton");

        sut.addGuest(person);

        assertThat(sut.guests()).isEqualTo(List.of(person));
    }
}