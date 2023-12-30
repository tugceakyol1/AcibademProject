@meryem18d
Feature: Yatirimcil Contact Form Submission with Incorrect Security Code

  Scenario: User Submits Form with Incorrect Security Code
    Given the user goes to the homepage
    When the user clicks on the ILETISIM  button
    And the user verifies that they are on the ILETISIM FORMLARI page
    And  the user clicks on the 'YATIRIMCI' heading
    And the user enters "Name" into the Adiniz field two
    And the user enters "Surname" into the Soyadiniz  field two
    And the user enters "Email" into the E-Posta Adresiniz field two
    And the user enters "PhoneNumber" into the Telefon Numaraniz field two
    And the user enters "Message" into the Mesajiniz field two
    And the user clicks on the existing check-in buttons (optional) two
    And an incorrect code is entered into the 'Guvenlik Kodu' field
    Then the user verifies they cannot complete the operation
