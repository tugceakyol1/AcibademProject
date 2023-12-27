@meryem16a
Feature: Bireysel Contact Form Submission with Short Security Code

  Scenario: User Submits Form with incomplete Security Code
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
    And only four characters are entered into the Security Code field
    And the user clicks on the 'Gonder' button
    Then the user verifies they receive the warning message "Guvenlik kodu 5 haneli olmalidir" and cannot proceed