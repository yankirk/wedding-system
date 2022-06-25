package com.kirks.wedding.core.usecase;

import com.kirks.wedding.core.gateway.GuestGroupGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = GuestGroupRegister.class)
@DisplayName("Test: Person Group Register Core Use Case")
class GuestGroupRegisterTest {

    @Autowired GuestGroupRegister sut;
    @MockBean GuestGroupGateway gateway;

    @Test
    @DisplayName("When name exists then throw illegal argument exception")
    void whenNameExists() {

        var name = "existing_name";
        when(gateway.checkNameExists(anyString())).thenReturn(true);

        assertThatThrownBy(() -> sut.execute(name)).isInstanceOf(IllegalArgumentException.class);

        verify(gateway, times(1)).checkNameExists(anyString());
        verify(gateway, never()).register(anyString());
    }

    @Test
    @DisplayName("When registered then don`t throw an exception")
    void whenRegistered() {

        var name = "any_guest_group_name";
        when(gateway.checkNameExists(anyString())).thenReturn(false);

        assertThatCode(() -> sut.execute(name)).doesNotThrowAnyException();

        verify(gateway, times(1)).checkNameExists(anyString());
        verify(gateway, times(1)).register(anyString());
    }
}