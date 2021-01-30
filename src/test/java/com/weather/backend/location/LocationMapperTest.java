package com.weather.backend.location;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LocationMapperTest {
    private LocationMapper locationMapper = new LocationMapper();

    @Test
    void asLocationDTO_returnsLocationDTO() {
        // given
        Location location = new Location("Gdansk", "Pomorskie", "Polska", 50f, 40f);

        // when
        LocationDTO locationDTO = locationMapper.asLocationDTO(location);

        // then
        assertThat(locationDTO.getCity()).isEqualTo("Gdansk");
        assertThat(locationDTO.getRegion()).isEqualTo("Pomorskie");
        assertThat(locationDTO.getCountry()).isEqualTo("Polska");
        assertThat(locationDTO.getLongitude()).isEqualTo(50f);
        assertThat(locationDTO.getLatitude()).isEqualTo(40f);
    }
}
