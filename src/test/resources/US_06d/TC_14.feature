@meryem14d
Feature: Yatirimci Contact Form Submission with Unchecked Check-in Buttons

  Scenario: User_Submits_Form_with_Unchecked_(Check-in )_Buttons
    Given the user goes to the homepage
    When the user clicks on the ILETISIM  button
    And the user verifies that they are on the ILETISIM FORMLARI page
    And  the user clicks on the 'YATIRIMCI' heading
    And the user enters "Name" into the Adiniz field two
    And the user enters "Surname" into the Soyadiniz  field two
    And the user enters "Email" into the E-Posta Adresiniz field two
    And the user enters "PhoneNumber" into the Telefon Numaraniz field two
    And the user enters "Message" into the Mesajiniz field two
    And the existing check-in buttons are left unchecked
    And the user enters a five-digit SecurityCode into the Guvenlik Kodu field two
    And the user clicks on the Gonder button two
    Then the user confirms that the sent message is received