Feature: Portfolio Controller

  Scenario Outline: Get Portfolio details of User
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" with subject and method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint            | Method|StatusCode|
      | getPortfolioDetails | get   |200       |
