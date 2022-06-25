package com.kirks.wedding.infra.gateway;

import com.kirks.wedding.infra.entity.GuestGroupEntity;
import com.kirks.wedding.infra.repository.GuestGroupRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = GuestGroupGatewayImp.class)
@DisplayName("Test: Guest Group Infra Gateway")
class GuestGroupGatewayImpTest {

    @Autowired GuestGroupGatewayImp sut;
    @MockBean GuestGroupRepository repository;

    @Nested
    @DisplayName("Test: Check Name Exists Feature")
    class CheckNameExistsTest {

        @Test
        @DisplayName("When name exists then return true")
        void whenNameExists() {

            var name = "existing_name";
            when(repository.existsByName(anyString())).thenReturn(true);

            var result = sut.checkNameExists(name);

            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("When name not exist then return false")
        void whenNameNotExist() {

            var name = "any_new_name";
            when(repository.existsByName(anyString())).thenReturn(false);

            var result = sut.checkNameExists(name);

            assertThat(result).isFalse();
        }

    }

    @Nested
    @DisplayName("Test: Register Feature")
    class RegisterTest {

        @Test
        @DisplayName("When registered then don`t throw an exception")
        void whenRegistered() {

            var name = "any_new_name";

            assertThatCode(() -> sut.register(name)).doesNotThrowAnyException();

            verify(repository, times(1)).save(any(GuestGroupEntity.class));
        }
    }
}