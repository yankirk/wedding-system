package com.kirks.wedding.infra.gateway;

import com.kirks.wedding.core.gateway.GuestGroupGateway;
import com.kirks.wedding.infra.common.mapper.GuestGroupMapper;
import com.kirks.wedding.infra.repository.GuestGroupRepository;
import org.springframework.stereotype.Component;

@Component
public class GuestGroupGatewayImp implements GuestGroupGateway {

    private final GuestGroupRepository repository;

    public GuestGroupGatewayImp(final GuestGroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean checkNameExists(final String name) {
        return repository.existsByName(name);
    }

    @Override
    public void register(final String name) {
        repository.save(GuestGroupMapper.mapToEntity(name));
    }

}
