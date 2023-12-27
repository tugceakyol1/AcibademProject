@meryem10d
Feature: Yatirimci Contact Form Submission with Phone Number Starting with '0'

  Scenario: User_Receives_Warning_for_Phone_Number_Starting_with_'0'
    Given the user goes to the homepage
    When the user clicks on the 'ILETISIM'  button
    And the user verifies that they are on the 'ILETISIM FORMLARI' page
    And  the user clicks on the 'YATIRIMCI' heading
    And the user enters "<Name>" into the 'Adiniz' field
    And the user enters "<Surname>" into the 'Soyadiniz'  field
    And the user enters "<Email>" into the 'E-Posta Adresiniz' field
    And a number that starts with '0' is entered in the 'Telefon Numaraniz' field
    And the user clicks on the message field
    Then the user verifies they receive a warning message '"0" ile başlamayan geçerli bir numara girilmeli'