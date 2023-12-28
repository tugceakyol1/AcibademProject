@meryem6a
Feature: Bireysel Contact Form Submission with Invalid Email Address with invalid Extension

  Scenario: User Receives Warning for Email Address with Invalid Extension
    Given the user goes to the homepage
    When the user clicks on the ILETISIM  button
    And the user verifies that they are on the ILETISIM FORMLARI page
    And  the user confirms that they are in the BIREYSEL section
    And the user enters "<Name>" into the Adiniz field
    And the user enters "<Surname>" into the Soyadiniz  field
    And an email with an invalid extension is entered into the 'E-Posta Adresiniz' field
    And the user clicks on the phone field
    Then the user verifies they receive a warning message "Lutfen gecerli bir e-mail adresi giriniz" and cannot proceed with the operation
