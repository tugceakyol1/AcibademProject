@meryem9a
Feature: Bireysel Contact Form Submission with Blank Phone Number

  Scenario: User_Receives_Warning_for_Blank_Phone_Number
    Given the user goes to the homepage
    When the user clicks on the 'ILETISIM'  button
    And the user verifies that they are on the 'ILETISIM FORMLARI' page
    And  the user confirms that they are in the 'BIREYSEL' section
    And the user enters "<Name>" into the 'Adiniz' field
    And the user enters "<Surname>" into the 'Soyadiniz'  field
    And the user enters "<Email>" into the 'E-Posta Adresiniz' field
    And the 'Telefon Numaraniz' field is left blank
    And the user enters "<Message>" into the 'Mesajiniz' field
    And the user clicks on the existing check-in buttons (optional)
    And the user enters a 5-digit '<SecurityCode>' into the 'Guvenlik Kodu' field
    And the user clicks on the 'Gonder' button
    Then the user verifies they receive a warning message "Lutfen telefon numaranizi giriniz"


