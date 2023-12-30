@meryem11d
Feature: Yatirimci Contact Form Submission with One Digit Phone Number

  Scenario: User_should_Receive_a_Warning _for_One_Digit_Phone_Number

    Given the user goes to the homepage
    When the user clicks on the ILETISIM  button
    And the user verifies that they are on the ILETISIM FORMLARI page
    And  the user clicks on the 'YATIRIMCI' heading
    And the user enters "Name" into the Adiniz field two
    And the user enters "Surname" into the Soyadiniz  field two
    And the user enters "Email" into the E-Posta Adresiniz field two
    And only one digit is entered into the 'Your Phone Number' field two
    And the user enters "Message" into the Mesajiniz field two
    And the user clicks on the existing check-in buttons (optional) two
    And the user enters a five-digit SecurityCode into the Guvenlik Kodu field two
    And the user clicks on the Gonder button two
    Then the user should verify they recieve a warning message and should not be able to proceed
