package com.kirks.wedding.infra.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface GuestGroupRepository {

    boolean existsByName(final String name);
}
