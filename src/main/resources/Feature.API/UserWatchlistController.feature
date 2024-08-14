Feature: User watchlist controller

  Scenario Outline: Retrieve user watchlist
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint         | Method|StatusCode|
      | getUserWatchlist | get   |200       |

    #post new cred in sample data
   Scenario Outline: Create watchlist
     Given Set endpoint "login" method "post" and SampleName "credentials" for login
     And Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>"
     Then Verify Status code <StatusCode>
     Examples:
       | Endpoint        | Method|SampleName     |StatusCode|
       | createWatchlist | post  | watchlistCred |400       |

  Scenario Outline: Delete watchlist
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint        | Method|SampleName     |StatusCode|
      | createWatchlist | post  | watchlistCred |400       |
