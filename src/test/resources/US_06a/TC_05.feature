@meryem5a
  Feature: Bireysel Contact Form Submission with invalid Email Address that does not contain the Symbol '@'

    Scenario: User_Receives_Warning_for_Invalid_Email_Address
      Given the user goes to the homepage
      When the user clicks on the 'ILETISIM'  button
      And the user verifies that they are on the 'ILETISIM FORMLARI' page
      And  the user confirms that they are in the 'BIREYSEL' section
      And the user enters "<Name>" into the 'Adiniz' field
      And the user enters "<Surname>" into the 'Soyadiniz'  field
      And an email address containing space characters is entered in the 'E-Posta Adresiniz' field <InvalidEmail>
      And the user clicks on the phone field
      Then the user verifies they receive a warning message "Lutfen gecerli bir e-mail adresi giriniz" and should not be able to proceed
