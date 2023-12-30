@meryem17d

Feature: Yatirimci Contact Form Submission with Long Security Code

  Scenario: User Submits Form with Security Code that contains more digits than required
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
    And six characters are entered into the Security Code field
    And the user clicks on the Gonder button two
    Then the user verifies they receive the warning message "Guvenlik kodu 5 haneli olmalidir" and cannot proceed