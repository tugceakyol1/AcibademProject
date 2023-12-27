@meryem18a
Feature: Bireysel Contact Form Submission with Incorrect Security Code

  Scenario: User Submits Form with Incorrect Security Code
    Given the user goes to the homepage
    When the user clicks on the 'ILETISIM'  button
    And the user verifies that they are on the 'ILETISIM FORMLARI' page
    And  the user confirms that they are in the 'BIREYSEL' section
    And the user enters "<Name>" into the 'Adiniz' field
    And the user enters "<Surname>" into the 'Soyadiniz'  field
    And the user enters "<Email>" into the 'E-Posta Adresiniz' field
    And the user enters "<PhoneNumber>" into the 'Telefon Numaraniz' field
    And the user enters "<Message>" into the 'Mesajiniz' field
    And the user clicks on the existing check-in buttons (optional)
    And an incorrect code is entered into the 'Guvenlik Kodu' field
    Then the user verifies they cannot complete the operation
