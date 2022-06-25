package com.kirks.wedding.infra.common.mapper;

import com.kirks.wedding.infra.entity.GuestGroupEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Test: Person Group Infra Mapper")
class GuestGroupMapperTest {

    @Test
    @DisplayName("When mapped from name then return entity")
    void whenMappedFromName() {

        var name = "any_guest_group_name";
        var expected = new GuestGroupEntity(name);

        var result = GuestGroupMapper.mapToEntity(name);

        assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }
}