@meryem3a
Feature: The user should be able to successfully submit the form.

  Scenario: TC01_The_user_can_successfully_submit_the_BIREYSEL_form

    Given the user goes to the homepage
    When the user clicks on the ILETISIM  button
    And the user verifies that they are on the ILETISIM FORMLARI page
    And  the user confirms that they are in the BIREYSEL section
    And the user enters "Name" into the Adiniz field
    And the 'Surname' field is left blank
    And the user enters "Email" into the E-Posta Adresiniz field
    And the user enters "PhoneNumber" into the Telefon Numaraniz field
    And the user enters "Message" into the Mesajiniz field
    And the user clicks on the existing check-in buttons (optional)
    And the user enters a five-digit SecurityCode into the Guvenlik Kodu field
    And the user clicks on the Gonder button
    Then the user verifies that they receive a warning message "Lutfen soyadinizi giriniz"  under the 'Soyadiniz' field
