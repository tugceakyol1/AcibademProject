@meryem5d
Feature: Yatirimci Contact Form Submission with invalid Email Address that does not contain the Symbol '@'

  Scenario: User_Receives_Warning_for_Invalid_Email_Address
    Given the user goes to the homepage
    When the user clicks on the ILETISIM  button
    And the user verifies that they are on the ILETISIM FORMLARI page
    And  the user clicks on the 'YATIRIMCI' heading
    And the user enters "Name" into the Adiniz field two
    And the user enters "Surname" into the Soyadiniz  field two
    And an email address that does not contain @ is entered in the email box two
    And the user clicks on the phone field two
    Then the user verifies they receive a warning message "Lutfen gecerli bir e-mail adresi giriniz" and should not be able to proceed
