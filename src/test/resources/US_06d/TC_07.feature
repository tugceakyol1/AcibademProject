@meryem7d

Feature: Yatirimci Contact Form Submission with Invalid Email Address

  Scenario: User_Receives_Warning_for_Email_Address_with_Inappropriate_Characters

    Given the user goes to the homepage
    When the user clicks on the 'ILETISIM'  button
    And the user verifies that they are on the 'ILETISIM FORMLARI' page
    And  the user clicks on the 'YATIRIMCI' heading
    And the user enters "<Name>" into the 'Adiniz' field
    And the user enters "<Surname>" into the 'Soyadiniz'  field
    And an email address containing inappropriate characters is entered in the 'E-Posta Adresiniz' field
    And the user clicks on the phone field
    Then the user verifies they receive a warning message "Lutfen gecerli bir e-mail adresi giriniz"and should not be able to proceed