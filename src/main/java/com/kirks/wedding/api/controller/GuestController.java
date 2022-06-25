package com.kirks.wedding.api.controller;

import com.kirks.wedding.api.request.GuestRequest;
import com.kirks.wedding.core.usecase.GuestRegister;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestRegister guestRegister;

    public GuestController(final GuestRegister guestRegister) {
        this.guestRegister = guestRegister;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addGuest(@RequestBody GuestRequest requestBody) {
        guestRegister.execute(requestBody.toGuest(), requestBody.groupId());
        return ResponseEntity.ok().build();
    }
}
