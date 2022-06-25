package com.kirks.wedding.api.controller;

import com.kirks.wedding.api.request.GuestGroupRequest;
import com.kirks.wedding.core.usecase.GuestGroupRegister;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests/groups")
public class GuestGroupController {

    private final GuestGroupRegister groupRegister;

    public GuestGroupController(final GuestGroupRegister groupRegister) {
        this.groupRegister = groupRegister;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGroup(@RequestBody GuestGroupRequest requestBody) {
        groupRegister.execute(requestBody.name());
        return ResponseEntity.ok().build();
    }

}
