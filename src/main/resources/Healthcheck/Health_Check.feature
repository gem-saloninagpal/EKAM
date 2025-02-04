@healthcheck
Feature: Healthcheck

  Scenario Outline: Create new bonds
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint  | Method|SampleName|StatusCode|
      | createBond| post  |createBond|201       |

  Scenario Outline: Update bond details based on ISIN
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" with key "<Key>" from filepath "<Filepath>", method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint      | Method|SampleName |StatusCode|Filepath    |Key      |
      | getBondDetails| put   |bondDetails|      200 | bondDetails| bondIsin|

  Scenario Outline: Update bond text data details based on ISIN
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" with key "<Key>" from filepath "<Filepath>", method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint           | Method|SampleName         |StatusCode|Filepath            |Key      |
      | bondTextDataDetails| put   |bondTextDataDetails|      200 | bondTextDataDetails| bondIsin|

  Scenario Outline: Retrieve all bonds
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint        | Method|StatusCode|
      | retrieveAllBonds| get   |200       |

  Scenario Outline: Retrieve filtered bonds
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint        | Method|SampleName      |StatusCode|
      | getFilteredBonds| post  |createListedBond|200       |

  Scenario Outline: Retrieve bond listing dropdowns
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint                    | Method|StatusCode|
      | retrieveBondListingDropdowns| get   |200       |

#    @toBeChecked
#  Scenario Outline: Retrieve unlisted bonds details based on ISIN
#    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
#    And Set endpoint "<Endpoint2>" method "<Method2>" and SampleName "<SampleName>"
#    Given Set endpoint "login" method "post" and SampleName "credentials" for login
#    And Set endpoint "<Endpoint>" with isin and Method "<Method>"
#    Then Verify Status code <StatusCode>
#    Examples:
#    | Endpoint                  | Method|StatusCode|Endpoint2|Method2|SampleName|
#    | unlistedBondDetailsOnISIN | get   |200       |createBond|post  |createBond|

  Scenario Outline: Update bond details based on ISIN
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" with key "<Key>" from filepath "<Filepath>", method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint      | Method|SampleName |StatusCode|Filepath    |Key      |
      | getBondDetails| put   |bondDetails|      200 | bondDetails| bondIsin|

  Scenario Outline: Retrieve cashflow
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint        | Method|SampleName      |StatusCode|
      | retrieveCashflow| post  |retrieveCashflow|200       |

  Scenario Outline: Retrieve bond details based on name
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint          | Method|StatusCode|
      | retrieveBondOnName| get   |200       |

  Scenario Outline: Retrieve bond filters
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint    | Method|StatusCode|
      | bondFilters | get   |200       |

  Scenario Outline: Send notification for new bonds
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint        | Method|SampleName      |StatusCode|
      | sendNotification| post  |sendNotification|200       |

  Scenario Outline: Retrieve notification preference
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" with subject and method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint                  | Method|StatusCode|
      | getNotificationPreference | get   |200       |

  Scenario Outline: Get order by user id
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" with subject and method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint         | Method|StatusCode|
      | getOrderByUserId | get   |200       |

  Scenario Outline: Create order
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint2>" method "<Method2>" and SampleName "<SampleName2>"
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" with subject, method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint   | Method|SampleName|StatusCode|Endpoint2|Method2|SampleName2|
      | createOrder| post  |bondInfo  |201       |createBond|post  |createBond|

  Scenario Outline: Retrieve all bonds - user portal
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint    | Method|StatusCode|
      | getAllBonds |  get  | 200      |

  Scenario Outline: Retrieving top 3 bonds to show on Landing Page
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint          | Method|StatusCode|
      | retrieveTop3Bonds |  get  | 200      |

  Scenario Outline: Get Portfolio details of User
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" with subject and method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint            | Method|StatusCode|
      | getPortfolioDetails | get   |200       |

  Scenario Outline: Create existing user
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    Given Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>" for login
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint  | Method|SampleName             |StatusCode|
      | createUser| post  |existingUserCredentials|409       |

  Scenario Outline: Retrieve user watchlist
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint         | Method|StatusCode|
      | getUserWatchlist | get   |200       |