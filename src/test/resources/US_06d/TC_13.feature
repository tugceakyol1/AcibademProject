@meryem13d
Feature: Yatitimci Contact Form Submission with Blank Message Field

  Scenario: User Receives Warning for Blank Message Field

    Given the user goes to the homepage
    When the user clicks on the ILETISIM  button
    And the user verifies that they are on the ILETISIM FORMLARI page
    And  the user clicks on the 'YATIRIMCI' heading
    And the user enters "Name" into the Adiniz field two
    And the user enters "Surname" into the Soyadiniz  field two
    And the user enters "Email" into the E-Posta Adresiniz field two
    And the user enters "PhoneNumber" into the Telefon Numaraniz field two
    And the message section is left blank
    And the user clicks on the existing check-in buttons (optional)
    And the user enters a five-digit SecurityCode into the Guvenlik Kodu field two
    And the user clicks on the Gonder button two
    Then the user verifies that they receive the warning message "Lutfen mesajinizi giriniz"