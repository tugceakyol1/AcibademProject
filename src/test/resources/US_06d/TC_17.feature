@meryem17d

Feature: Yatirimci Contact Form Submission with Long Security Code

  Scenario: User Submits Form with Security Code that contains more digits than required
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
    And six characters are entered into the Security Code field
    And the user clicks on the 'Gonder' button
    Then the user verifies they receive the warning message "Guvenlik kodu 5 haneli olmalidir" and cannot proceed