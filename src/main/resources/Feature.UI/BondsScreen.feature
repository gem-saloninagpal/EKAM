Feature: Bonds screen

Scenario Outline: Validate the state of invest now button according to allotment and maturity date
When Click the button "login"
Then Validate credentials box appears
And Enter email "<email>" and password "<password>"
And Click the login button
And View bond details
Then Validate the state of invest now according to allotment and maturity

Examples:
|email                            |password|
|saloni.nagpal@geminisolutions.com|Friday@1234|

  @check
Scenario Outline: Validate add to watchlist
When Click the button "login"
Then Validate credentials box appears
And Enter email "<email>" and password "<password>"
And Click the login button
And Click the watchlist icon
Then Validate the popup message

Examples:
|email                            |password   |
|saloni.nagpal@geminisolutions.com|Friday@1234|

Scenario Outline: Validate search filter
When Click the button "login"
Then Validate credentials box appears
And Enter email "<email>" and password "<password>"
And Click the login button
And Enter text to search "<bondName>"
Then Verify records get filtered on the basis of searched bond "<bondName>"

Examples:
|email                            |password   |bondName |
|saloni.nagpal@geminisolutions.com|Friday@1234|Allotment|

Scenario Outline: Validate rating filter
When Click the button "login"
Then Validate credentials box appears
And Enter email "<email>" and password "<password>"
And Click the login button
When Expand "Rating" dropdown
And Select option "AAA"
Then Validate records on the basis of rating "AAA"

Examples:
|email                            |password   |
|saloni.nagpal@geminisolutions.com|Friday@1234|
