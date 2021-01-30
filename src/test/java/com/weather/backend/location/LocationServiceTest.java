package com.weather.backend.location;

import com.weather.exception.BadRequestException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class LocationServiceTest {

    private static LocationService locationService;
    private static LocationRepositoryMock locationRepository;

    @BeforeAll
    static void setUp() {
        locationRepository = new LocationRepositoryMock();
        locationService = new LocationService(locationRepository);
    }

    @AfterEach
    void tearDown() {
        locationRepository.clear();
    }

    @Test
    void createNewLocation_createsLocation() {
        // when
        Location result = locationService.createLocation("Gdansk", "Pomorze", "Polska", "40.5", "50.5");

        // then
        assertThat(result).isNotNull();
        assertThat(result.getCity()).isEqualTo("Gdansk");
        assertThat(result.getRegion()).hasValue("Pomorze");
        assertThat(result.getCountry()).isEqualTo("Polska");
        assertThat(result.getLongitude()).isEqualTo(40.5f);
        assertThat(result.getLatitude()).isEqualTo(50.5f);
    }

    @Test
    void createNewLocation_whenRegionIsBlank_createsLocation() {
        // when
        Location result = locationService.createLocation("Gdansk", " ", "Polska", "40.5", "50.5");

        // then
        assertThat(result).isNotNull();
        assertThat(result.getCity()).isEqualTo("Gdansk");
        assertThat(result.getRegion()).isEmpty();
        assertThat(result.getCountry()).isEqualTo("Polska");
        assertThat(result.getLongitude()).isEqualTo(40.5f);
        assertThat(result.getLatitude()).isEqualTo(50.5f);
    }

    @Test
    void createNewLocation_whenCityIsBlank_throwsException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.createLocation(" ", "Pomorskie", "Polska", "40.5", "50.5"));

        // then
        assertThat(throwable).isInstanceOf(BadRequestException.class);
    }

    @Test
    void createNewLocation_whenCountryIsBlank_throwsException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.createLocation("Gdansk", "Pomorskie", " ", "40.5", "50.5"));

        // then
        assertThat(throwable).isInstanceOf(BadRequestException.class);
    }

    @Test
    void createNewLocation_whenLongitudeIsBlank_throwsException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.createLocation("Gdansk", "Pomorskie", "Polska", "", "50.5"));

        // then
        assertThat(throwable).isInstanceOf(BadRequestException.class);
    }

    @Test
    void createNewLocation_whenLatitudeIsBlank_throwsException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.createLocation("Gdansk", "Pomorskie", "Polska", "40.5", ""));

        // then
        assertThat(throwable).isInstanceOf(BadRequestException.class);
    }

    @Test
    void createNewLocation_whenLongitudeIsMoreThan90_throwsException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.createLocation("Gdansk", "Pomorskie", "Polska", "91.0", "50.5"));

        // then
        assertThat(throwable).isInstanceOf(BadRequestException.class);
    }

    @Test
    void createNewLocation_whenLongitudeIsLessThan90Negative_throwsException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.createLocation("Gdansk", "Pomorskie", "Polska", "-91.0", "50.5"));

        // then
        assertThat(throwable).isInstanceOf(BadRequestException.class);
    }

    @Test
    void createNewLocation_whenLatitudeIsMoreThan180_throwsException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.createLocation("Gdansk", "Pomorskie", "Polska", "40.5", "181"));

        // then
        assertThat(throwable).isInstanceOf(BadRequestException.class);
    }

    @Test
    void createNewLocation_whenLatitudeIsLessThan180Negative_throwsException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.createLocation("Gdansk", "Pomorskie", "Polska", "40.5", "-181"));

        // then
        assertThat(throwable).isInstanceOf(BadRequestException.class);
    }

    @Test
    void getLocations_returnsLocations() {
        // given
        locationRepository.save(new Location("Gdansk", "Pomorskie", "Polska", 40.5f, 50.5f));
        locationRepository.save(new Location("Warszawa", "Mazowieckie", "Polska", 40.5f, 50.5f));

        // when
        List<Location> result = locationRepository.findAll();

        // then
        Assertions.assertThat(result).hasSize(2);
    }
}
