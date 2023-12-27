@meryem2d
Feature: YATIRIMCI Contact Form Submission with Blank name field

  Scenario: Unsuccessful_Submission_with_Blank_'Adiniz'_Field

    Given the user goes to the homepage
    When the user clicks on the 'ILETISIM' button
    And the user verifies that they are on the 'ILETISIM FORMLARI' page
    And  the user clicks on the 'YATIRIMCI' heading
    And the 'Adiniz' field is left blank
    And the user enters "<Surname>" into the 'Soyadiniz' field
    And the user enters "<Email>" into the 'E-Posta Adresiniz' field
    And the user enters "<PhoneNumber>" into the 'Telefon Numaraniz' field
    And the user enters "<Message>" into the 'Mesajiniz' field
    And the user clicks on the existing check-in buttons (optional)
    And the user enters a 5-digit '<SecurityCode>' into the 'Guvenlik Kodu' field
    And the user clicks on the 'Gonder' button
    Then the user verifies that they receive a warning message "Lutfen Adinizi giriniz" under the 'Adiniz' field