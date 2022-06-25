package com.kirks.wedding.core.usecase;

import com.kirks.wedding.core.domain.GuestGroup;
import com.kirks.wedding.core.domain.Person;
import com.kirks.wedding.core.gateway.GuestGroupGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = GuestRegister.class)
@DisplayName("Test: Guest Register Core Use Case")
class GuestRegisterTest {

    @Autowired GuestRegister sut;
    @MockBean GuestGroupGateway groupGateway;

    @Test
    @DisplayName("When group id is invalid then throw illegal argument exception")
    void whenGroupIdInvalid() {

        var person = new Person("Jorjão da Massa");
        var groupId = "invalid_group_id";
        when(groupGateway.load(anyString())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> sut.execute(person, groupId)).isInstanceOf(IllegalArgumentException.class);

        verify(groupGateway, times(1)).load(anyString());
        verify(groupGateway, never()).update(any(GuestGroup.class));
    }

    @Test
    @DisplayName("When group updated with guest then don`t throw an exception")
    void whenGroupUpdatedWithGuest() {

        var person = new Person("Jorjão da Massa");
        var groupId = "any_group_id";
        var group = new GuestGroup(groupId);
        when(groupGateway.load(anyString())).thenReturn(Optional.of(group));

        assertThatCode(() -> sut.execute(person, groupId)).doesNotThrowAnyException();

        assertThat(group.guests()).contains(person);
        verify(groupGateway, times(1)).load(anyString());
        verify(groupGateway, times(1)).update(any(GuestGroup.class));
    }
}