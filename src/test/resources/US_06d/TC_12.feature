@meryem12d
Feature: Yatirimci Contact Form Submission with Too Many Digits in Phone Number

  Scenario: User should receive a Warning for Too Many Digits in Phone Number
    Given the user goes to the homepage
    When the user clicks on the 'ILETISIM'  button
    And the user verifies that they are on the 'ILETISIM FORMLARI' page
    And  the user clicks on the 'YATIRIMCI' heading
    And the user enters "<Name>" into the 'Adiniz' field
    And the user enters "<Surname>" into the 'Soyadiniz'  field
    And the user enters "<Email>" into the 'E-Posta Adresiniz' field
    And too many digits are entered into the 'Your Phone Number' field
    And the user enters "<Message>" into the 'Mesajiniz' field
    And the user clicks on the existing check-in buttons (optional)
    And the user enters a 5-digit '<SecurityCode>' into the 'Guvenlik Kodu' field
    And the user clicks on the 'Gonder' button
    Then the user should verify they recieve a warning message and should not be able to proceed