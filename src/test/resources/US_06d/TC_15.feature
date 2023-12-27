@meryem15d
Feature: Yatirimci Contact Form Submission with Blank Security Code

  Scenario: User Submits Form with Blank Security Code
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
    And the Security Code field is left blank
    And the user clicks on the 'Gonder' button
    Then the user verifies they receive the message "Lutfen guvenlik kodunu giriniz" and cannot proceed