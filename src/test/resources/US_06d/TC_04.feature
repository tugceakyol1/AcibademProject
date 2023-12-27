@meryem3d
Feature Yatirimci Contact Form Submission with Blank Surname

  Scenario: User_Receives_Warning_for_Leaving_Surname_Field Blank_in_Bireysel_Contact_Form

    Given the user goes to the homepage
    When the user clicks on the 'YATIRIMCI'  button
    And the user verifies that they are on the 'ILETISIM FORMLARI' page
    And  the user clicks on the 'YATIRIMCI' heading
    And the user enters "<Name>" into the 'Adiniz' field
    And the 'Soyadiniz' field is left blank
    And the user enters "<Email>" into the 'E-Posta Adresiniz' field
    And the user enters "<PhoneNumber>" into the 'Telefon Numaraniz' field
    And the user enters "<Message>" into the 'Mesajiniz' field
    And the user clicks on the existing check-in buttons (optional)
    And the user enters a 5-digit '<SecurityCode>' into the 'Guvenlik Kodu' field
    And the user clicks on the 'Gonder' button
    Then the user verifies that they receive a warning message "Lutfen soyadinizi giriniz"  under the 'Soyadiniz' field
