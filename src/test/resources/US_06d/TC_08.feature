@meryem8d
Feature: Yatirimci Contact Form Submission with Invalid Email Address

  Scenario: User_Receives_Warning_for_Email_Address_with_Space_Characters

    Given the user goes to the homepage
    When the user clicks on the ILETISIM  button
    And the user verifies that they are on the ILETISIM FORMLARI page
    And  the user clicks on the 'YATIRIMCI' heading
    And the user enters "Name" into the Adiniz field two
    And the user enters "Surname" into the Soyadiniz  field two
    And an email address containing space characters is entered in the 'E-Posta Adresiniz' field two
    And the user clicks on the phone field two
    Then the user verifies they receive a warning message "Lutfen gecerli bir e-mail adresi giriniz" and should not be able to proceed
