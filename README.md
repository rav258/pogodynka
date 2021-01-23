# pogodynka

OPIS SYSTEMU
W ramach projektu należy utworzyć system umożliwiający zbieranie danych z min. jednego, a najlepiej dwóch/trzech dowolnych serwisów pogodowych i udostępnić uśrednione (rezultatem powinna być dana wartość pogodowa obliczona jako średnia arytmetyczna z rezultatów zwróconych przez każdy serwis) wartości obliczone na podstawie zwróconych odpowiedzi. FUNKCJE SYSTEMU
• zarządzanie lokalizacjami, których dotyczy prognoza pogody
• pobieranie danych pogodowych z odpowiednich serwisów pogodowych
• pobrane dane pogodowe powinny być zapisywane do bazy danych TECHNOLOGIE
• aplikacja konsolowa
• połączenie z bazą danych – JDBC / Hibernate
• klient HTTP – HttpClient
• architektura warstwowa – warstwa prezentacji, logiki biznesowej, dostępu do bazy danych
• narzędzie do serializacji/deserializacji danych formatu JSON – Jackson
• narzędzia do testowania jednostkowego i integracyjnego
• wariant Spring:
• brak aplikacji konsolowej
• klient HTTP – RestTemplate FUNKCJONALNOŚCI INTERFEJS UŻYTKOWNIKA
Użytkownik w ramach widoku konsolowego/graficznego powinien mieć możliwość wybrania jednej z poniższych opcji:
• dodawania konkretnych lokalizacji do bazy danych
• wyświetlanie aktualnie dodanych lokalizacji
• pobierania wartości pogodowych DODAWANIE LOKALIZACJI
Użytkownik powinien móc dodawać lokalizację do bazy danych wprowadzając poniższe wartości:
• nazwę miasta
• długość i szerokość geograficzną
• region
• nazwę kraju
Dodatkowo w ramach zadania użytkownik powinien zadbać o odpowiednią walidację:
• długość i szerokość geograficzna zgodnie z wartościami geograficznymi
(szerokość: -90 -> S, 90 -> N, długość: -180 -> W, 180 -> E)
• nazwa miasta – nie może być pusta
• nazwa kraju – nie może być pusta
• region – opcjonalny
W przypadku wprowadzenia niepoprawnych danych, użytkownik powinien zostać powiadomiony za pośrednictwem odpowiedniego komunikatu.
Michał Paukszto
WYŚWIETLANIE DOSTĘPNYCH LOKALIZACJI
Użytkownik wybierając opcję w menu powinien móc zobaczyć wszystkie lokalizacje wprowadzone do bazy danych. POBIERANIE DANYCH POGODOWYCH
Pobieranie danych pogodowych z zewnętrznych serwisów - w ramach tej opcji użytkownik powinien móc pobierać dane z np. poniższych systemów:
• https://openweathermap.org/api
• https://developer.accuweather.com/apis
• https://weatherstack.com/documentation
Wspierane parametry - użytkownik powinien móc pobierać następujące wartości:
• temperatura
• ciśnienie
• wilgotność
• kierunek i prędkość wiatru
Wartości pobrane z zewnętrznych serwisów przed zwróceniem użytkownikowi powinny zostać uśrednione i zapisane dodatkowo do bazy.
Dostępne konfiguracje pobierania - użytkownik za pośrednictwem aplikacji może wskazać następujące wartości:
• DATA – w ramach żądania może zostać wskazana data, kiedy ma zostać sprawdzona pogoda. Jeśli użytkownik nie poda daty w ustalonym formacie powinna zostać sprawdzona pogoda na dzień jutrzejszy.
• LOKALIZACJA – w ramach żądania musi zostać wskazana lokalizacja, dla której powinny zostać zwrócone wartości. Lokalizacja powinna być wcześniej dodana do bazy danych. FUNKCJONALNOŚCI OPCJONALNE
• Edycja lokalizacji - w ramach nowej opcji w menu użytkownik powinien móc edytować aktualnie dodane lokalizacje. W ramach edycji powinna być również uwzględniana walidacja.
• Wyszukiwanie lokalizacji - użytkownik powinien móc wyświetlać informację o konkretnej lokalizacji wyszukując ją, np. po nazwie.
• Dane statystyczne - użytkownik powinien móc wyświetlać dane statystyczne na temat wybranych wartości pogodowych z określonego przedziału czasu, np. miesiąc, rok. Dane w tym celu powinny być pobierane bezpośrednio z bazy danych.
• Zapis/odczyt danych - użytkownik powinien móc zapisać aktualnie zgromadzone dane do pliku w dowolnym formacie, a następnie odtworzyć je zapisując bezpośrednio do bazy danych.
• Testy - implementowane funkcjonalności powinny zostać pokryte testami jednostkowymi i integracyjnymi zgodnie z powszechnie stosowanymi metodologiami i praktykami.
Zadanie celowo jest sformułowane bardzo ogólnie.
