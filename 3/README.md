# TESTY SELENIUM
Przygotowane zostały dwa testy selenium dla dwóch różnych stron internetowych używając w jednym scenariuszu przeglądarki Firefox a  wdrugim Google Chrome.
Aby skrypty zadziałały należy zainstalować paczkę "selenium" oraz podać odpowiednie ścieżki do Webdriverów dla odpowiednich przeglądarek.

## Scenariusz 1 - przypinki.pl

Dodanie produktu do koszyka na stronie przypinki.pl

1. Wchodzimy na stronę przypinki.pl
2. Akceptujemy ciasteczka
3. Klikamy w kategorię "Studniówka"
4. Przechodzimy na drugą stronę listy produktów
5. Klikamy na pierwszą przypinkę na górze listy
6. Dodajemy do koszyka 1 sztukę
7. Sprawdzamy czy w koszyku faktycznie znajduje się jedna sztuka produktu

## Scenariusz 2 - wikipedia.pl

Próba błędnego zalogowania się na stronę wikipedia.pl

1. Wchodzimy na stronę wikipedia.pl
2. Klikamy zaloguj się - przechodzimy do formularza logowania
3. Wprowadzamy dane użytkownika, login i hasło
4. Klikamy przycisk zaloguj się
5. Szukamy boxa z informacją o powodzeniu logowania
6. Sprawdzamy czy tekst informujący powodzeniu logowania jest prawidłowy