@meryem4a
  Feature: Bireysel Contact Form Submission with Blank Email Address feild

    Scenario: User_Receives_Warning_for_Leaving email_address_Field_Blank_in Bireysel_Contact_Form

      Given the user goes to the homepage
      When the user clicks on the ILETISIM  button
      And the user verifies that they are on the ILETISIM FORMLARI page
      And  the user confirms that they are in the BIREYSEL section
      And the user enters "Name" into the Adiniz field
      And the user enters "Surname" into the Soyadiniz  field
     # And the 'E-Posta Adresiniz'  field is left blank
      And the user enters "PhoneNumber" into the Telefon Numaraniz field
      And the user enters "Message" into the Mesajiniz field
      And the user clicks on the existing check-in buttons (optional)
      And the user enters a five-digit SecurityCode into the Guvenlik Kodu field
      And the user clicks on the Gonder button
      Then the user verifies that they receive a warning message "Lutfen e-mail adresinizi giriniz."