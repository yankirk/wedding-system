package com.kirks.wedding.infra.repository;

import com.kirks.wedding.infra.entity.GuestGroupEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestGroupRepository extends MongoRepository<GuestGroupEntity, String> {

    boolean existsByName(final String name);
}
