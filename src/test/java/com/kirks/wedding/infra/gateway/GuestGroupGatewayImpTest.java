package com.kirks.wedding.infra.gateway;

import com.kirks.wedding.infra.repository.GuestGroupRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = GuestGroupGatewayImp.class)
@DisplayName("Test: Guest Group Infra Gateway")
class GuestGroupGatewayImpTest {

    @Autowired GuestGroupGatewayImp sut;
    @MockBean GuestGroupRepository repository;

    @Test
    @DisplayName("When name exists then return true")
    void whenNameExists() {

        var name = "existing_name";
        when(repository.existsByName(anyString())).thenReturn(true);

        var result = sut.checkNameExists(name);

        assertThat(result).isTrue();
    }
}