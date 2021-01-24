package com.weather;

import java.util.Scanner;

public class WeatherApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Witaj w stacji pogodynka.pl\n");
            System.out.println("1. Dodaj lokalizacje do bazy danych");
            System.out.println("2. Wyswietl wszystkie lokalizacje z bazy danych");
            System.out.println("3. Zamknąć aplikację");

            int response = scanner.nextInt();

            switch (response) {
                case 1:
                    addNewLocation();
                    break;
                case 2:
                    readLocations();
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void readLocations() {
        System.out.println("Dostepne nastepujace lokalizacje: \n");

    }

    private static void addNewLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj miasto: ");
        String city = scanner.nextLine();
        System.out.println("Podaj szerokosc geograficzna: ");
        String latitude = scanner.nextLine();
        System.out.println("Podaj dlugosc geograficzna: ");
        String longitude = scanner.nextLine();
        System.out.println("Podaj Region: ");
        String region = scanner.nextLine();
        System.out.println("Podaj Kraj: ");
        String country = scanner.nextLine();

        System.out.println("Nowa lokalizacja dodana: \n");
    }
}
