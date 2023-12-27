Feature:  US08

Scenario:International patients should be able to register
  Given User goes to homepage
  Given Click on menu
  Then Click on for international patiens
  And Accept cookies
  And Enter name,lastname,e-mail and phone
  And Select country
  And Select Treatment Units
  And Write message
  And Click on checkbox
  And Click on Send button
  And Verify that thanks appears on the screen
