package com.kirks.wedding.core.gateway;

public interface GuestGroupGateway {
    boolean checkNameExists(String name);
    void register(String name);
}
