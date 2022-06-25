package com.kirks.wedding.api.controller;

import com.kirks.wedding.api.request.GuestGroupRequest;
import com.kirks.wedding.core.usecase.GuestGroupRegister;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = GuestGroupController.class)
@DisplayName("Test: Person Group Api Controller")
class GuestGroupControllerTest {

    @Autowired GuestGroupController sut;
    @MockBean GuestGroupRegister guestGroupRegister;

    @BeforeEach
    void init() {
        RestAssuredMockMvc.standaloneSetup(sut);
    }

    @Nested
    @DisplayName("Test Create Group Feature")
    class CreateGroupTest {

        @Test
        @DisplayName("When the group was created then return http status ok")
        void whenGroupCreated() {

            var requestBody = new GuestGroupRequest("Friends");

            given()
                .contentType(ContentType.JSON)
                .body(requestBody)
            .when()
                .post("/guests/groups")
            .then()
                .status(HttpStatus.OK);

            verify(guestGroupRegister, times(1)).execute(anyString());
        }
    }
}
