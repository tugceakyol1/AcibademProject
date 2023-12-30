@meryem3d
Feature Yatirimci Contact Form Submission with Blank Surname

  Scenario: User_Receives_Warning_for_Leaving email_address_Field_Blank_in_the_Yatirimci_Contact_Form

Given the user goes to the homepage
When the user clicks on the ILETISIM  button
And the user verifies that they are on the ILETISIM FORMLARI page
And  the user clicks on the 'YATIRIMCI' heading
    And the user enters "Name" into the Adiniz field two
    And the user enters "Surname" into the Soyadiniz  field two
    And the user enters "PhoneNumber" into the Telefon Numaraniz field two
    And the user enters "Message" into the Mesajiniz field two
    And the user clicks on the existing check-in buttons (optional) two
    And the user enters a five-digit SecurityCode into the Guvenlik Kodu field two
    And the user clicks on the Gonder button two
Then the user verifies that they receive a warning message "Lutfen e-mail adresinizi giriniz."