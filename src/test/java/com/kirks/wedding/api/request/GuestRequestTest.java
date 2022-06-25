package com.kirks.wedding.api.request;

import com.kirks.wedding.core.domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Test: Guest Api Request Body")
class GuestRequestTest {

    @Test
    @DisplayName("When mapped to person then return person")
    void whenMappedToPerson() {

        var name = "any_guest_name";
        var groupId = "any_group_id";
        var expected = new Person(name);
        var sut = new GuestRequest(name, groupId);

        var result = sut.toGuest();

        assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }
}