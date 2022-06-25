package com.kirks.wedding.core.usecase;

import com.kirks.wedding.core.domain.Person;
import com.kirks.wedding.core.gateway.GuestGroupGateway;
import org.springframework.stereotype.Service;

@Service
public class GuestRegister {

    private final GuestGroupGateway groupGateway;

    public GuestRegister(final GuestGroupGateway groupGateway) {
        this.groupGateway = groupGateway;
    }

    public void execute(final Person person, final String groupId) {
       groupGateway.load(groupId).orElseThrow(() -> new IllegalArgumentException("Guest group not found!"));
    }

}
