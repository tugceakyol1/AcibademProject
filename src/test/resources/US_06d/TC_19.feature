@meryem19d
Feature: Yatirimci Contact Form Submission with Numbers and Symbols in Name and Surname fields

  Scenario: User Submits Form with Numbers and Symbols in Name and Surname fields
    Given the user goes to the homepage
    When the user clicks on the 'ILETISIM'  button
    And the user verifies that they are on the 'ILETISIM FORMLARI' page
    And  the user clicks on the 'YATIRIMCI' heading
    And the user enters "<Name>" into the 'Adiniz' field
    And the user enters "<Surname>" into the 'Soyadiniz'  field
    And the user enters "<Email>" into the 'E-Posta Adresiniz' field
    And the user enters "<PhoneNumber>" into the 'Telefon Numaraniz' field
    And the user enters "<Message>" into the 'Mesajiniz' field
    And the user clicks on the existing check-in buttons (optional)
    And the user enters a 5-digit '<SecurityCode>' into the 'Guvenlik Kodu' field
    And the user clicks on the 'Gonder' button
    Then the user should verify they recieve a warning message and should not be able to proceed
