package com.weather.frontend;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.backend.location.*;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private final LocationController locationController;

    {
        LocationRepository locationRepository = new LocationRepositoryImpl();
        LocationService locationService = new LocationService(locationRepository);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        LocationMapper locationMapper = new LocationMapper();
        locationController = new LocationController(objectMapper, locationService, locationMapper);
    }

    public void runApplication() {
        System.out.println("Witaj w aplikacji pogodowej\n");

        while (true) {
            System.out.println("Możlliwe opcje:");
            System.out.println("1. Dodać nową lokalizację");
            System.out.println("2. Wyświetlić dodane lokalizacje");
            System.out.println("3. Wyświetlić informacje o pogodzie dla lokalizacji");
            System.out.println("4. Zamknąć aplikację");
            System.out.print("\nWybierz co chcesz zrobić: ");

            int userInput = getInteger();

            switch (userInput) {
                case 1:
                    createLocation();
                    break;
                case 2:
                    getLocation();
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    System.out.print("\nWybrałeś niewłaściwą opcję. ");
            }
        }
    }

    private void getLocation() {
        String result = locationController.getLocations();
        result = result
                .replaceAll("\\{", "\n\\{")
                .replaceAll("}]", "}\n]");

        System.out.println("Dostępne lokalizacje: " + result + "\n");
    }

    private void createLocation() {
        System.out.print("Podaj nazwe miasta: ");
        String city = scanner.nextLine();
        System.out.print("Podaj nazwe regionu (opcjonalne): ");
        String region = scanner.nextLine();
        System.out.print("Podaj nazwe kraju: ");
        String country = scanner.nextLine();
        System.out.print("Podaj szerokość geograficzną: ");
        String longitude = scanner.nextLine();
        System.out.print("Podaj długość geograficzną: ");
        String latitude = scanner.nextLine();
        String response = locationController.createLocation(city, region, country, longitude, latitude);
        System.out.println("Zapisano nową lokalizację: " + response + "\n");
    }

    private int getInteger() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.print("\nPodana wartość musi być cyfrą. Wpisz cyfrę: ");
            }
        }
    }
}
