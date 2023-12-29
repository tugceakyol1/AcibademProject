@US10_Passed_scenarios
Feature: Acibadem contact medical advice feature

  Background: The user is on the Medical Advice option on the Contact page

    Given a user is on the homepage
    When the user clicks on the Contact link
    And the user clicks on the Medical Advice button


  Scenario: TC_01_The user successfully fills out the form to make a suggestion

    And the user enters their firstname
    And the user enters their lastname
    And the user enters their email address
    And the user enters their phone number
    And the user selects a treatment unit
    And the user selects the Suggestion option
    And the user enters a message
    And the user clicks on the first radio button
    But the user does not click on the second radio button
    #And the user enters the security code
    #And the user clicks on the Submit button
    #Then the user should see a successful submission message

    Scenario: TC_02_The user successfully fills out the form to make a complain

      And the user enters their firstname
      And the user enters their lastname
      And the user enters their email address
      And the user enters their phone number
      And the user selects a treatment unit
      And the user selects the Complain option
      And the user enters a message
      And the user clicks on the first radio button
      But the user does not click on the second radio button
      #And the user enters the security code
      #And the user clicks on the Submit button
      #Then the user should see a successful submission message

      Scenario: TC_03_The user successfully fills out the form to get information

        And the user enters their firstname
        And the user enters their lastname
        And the user enters their email address
        And the user enters their phone number
        And the user selects a treatment unit
        And the user selects the Information option
        And the user enters a message
        And the user clicks on the first radio button
        But the user does not click on the second radio button
        #And the user enters the security code
        #And the user clicks on the Submit button
        #Then the user should see a successful submission message


