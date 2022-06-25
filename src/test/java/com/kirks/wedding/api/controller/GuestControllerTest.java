package com.kirks.wedding.api.controller;

import com.kirks.wedding.api.request.GuestRequest;
import com.kirks.wedding.core.domain.Guest;
import com.kirks.wedding.core.usecase.GuestRegister;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = GuestController.class)
@DisplayName("Test: Guest Api Controller")
class GuestControllerTest {

    @Autowired GuestController sut;
    @MockBean GuestRegister guestRegister;

    @BeforeEach
    void init() {
        RestAssuredMockMvc.standaloneSetup(sut);
    }

    @Nested
    @DisplayName("Test: Add Guest Feature")
    class AddGuestTest {

        @Test
        @DisplayName("When guest was added then return http status ok")
        void whenGuestAdded() {

            var requestBody = new GuestRequest("any_guest_name", "group_id");

            given()
                .contentType(ContentType.JSON)
                .body(requestBody)
            .when()
                .post("/guests")
            .then()
                .status(HttpStatus.OK);

            verify(guestRegister, times(1)).execute(any(Guest.class));
        }
    }
}
