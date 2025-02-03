Feature: Signup and Login flow


Scenario Outline: Validate login and logout flow (positive and negative)
  When Click the button "login"
  Then Validate credentials box appears
  And Click the login button
  Then Validate error messages on email and password "<emailMessage>", "<passwordMessage>"
  And Enter email "<email>" and password "<password>"
  And Click the login button
  Then Validate user logs in on entering valid email and password
  And Click the Profile icon
  And Select the option "LogOut"
  Then Verify confirmation dialog
  And Click the logout button in confirmation dialog
  Then Validate user logs out of the portal

  Examples:
  |emailMessage     |passwordMessage     |email                            |password   |
  |Email is required|Password is required|saloni.nagpal@geminisolutions.com|Friday@1234|















