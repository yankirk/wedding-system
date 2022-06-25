package com.kirks.wedding.core.usecase;

import com.kirks.wedding.core.gateway.GuestGroupGateway;
import org.springframework.stereotype.Service;

@Service
public class GuestGroupRegister {

    private final GuestGroupGateway gateway;

    public GuestGroupRegister(final GuestGroupGateway gateway) {
        this.gateway = gateway;
    }

    public void execute(final String name) {
        if(gateway.checkNameExists(name)) {
            throw new IllegalArgumentException("Person group name already exists!");
        }

        gateway.register(name);
    }

}
