package com.kirks.wedding.core.gateway;

import com.kirks.wedding.core.domain.GuestGroup;

import java.util.Optional;

public interface GuestGroupGateway {

    boolean checkNameExists(String name);

    void register(String name);

    Optional<GuestGroup> load(String id);

    void update(GuestGroup group);

}
