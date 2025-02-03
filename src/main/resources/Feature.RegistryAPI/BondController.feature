Feature: Admin- Bond Controller

  @executingThrice
  Scenario Outline: Retrieve bond details based on ISIN
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint2>" method "<Method2>" and SampleName "<SampleName>"
    And Set endpoint "<Endpoint>" with isin and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint       | Method|StatusCode|Endpoint2|Method2|SampleName|
      | getBondDetails | get   |200       |createBond|post  |createBond|

  Scenario Outline: Update bond details based on ISIN
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" with key "<Key>" from filepath "<Filepath>", method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint      | Method|SampleName |StatusCode|Filepath    |Key      |
      | getBondDetails| put   |bondDetails|      200 | bondDetails| bondIsin|

  Scenario Outline: Retrieve unlisted bonds details based on ISIN
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint            | Method|StatusCode|
      | unlistedBondDetails | get   |200       |

  Scenario Outline: Update unlisted bond details based on ISIN
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" with key "<Key>" from filepath "<Filepath>", method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint    | Method|SampleName         |StatusCode|Filepath    |Key      |
      | unlistedBond| put   |unlistedBondDetails|      200 | bondDetails| bondIsin|

    @sameIssue
  Scenario Outline: Retrieve bonds text data details based on ISIN
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint2>" method "<Method2>" and SampleName "<SampleName>"
    And Set endpoint "<Endpoint>" with isin and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint            | Method|StatusCode|Endpoint2|Method2|SampleName|
      | bondTextDataDetails | get   |200       |createBond|post  |createBond|

  Scenario Outline: Update bond text data details based on ISIN
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" with key "<Key>" from filepath "<Filepath>", method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint           | Method|SampleName         |StatusCode|Filepath            |Key      |
      | bondTextDataDetails| put   |bondTextDataDetails|      200 | bondTextDataDetails| bondIsin|

    #new
  @toBeUpdated
  Scenario Outline: Retrieve market data details based on ISIN
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint             | Method|StatusCode|
      | bondMarketDataDetails| get   |200       |

  Scenario Outline: Retrieve all bonds
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint        | Method|StatusCode|
      | retrieveAllBonds| get   |200       |

  Scenario Outline: Create new bonds
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint  | Method|SampleName|StatusCode|
      | createBond| post  |createBond|201       |

  Scenario Outline: Retrieve filtered bonds
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint        | Method|SampleName      |StatusCode|
      | getFilteredBonds| post  |createListedBond|200       |

    @ToBeDone
#  Scenario Outline: Upload the file to S3
#    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
#    And Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>"
#    Then Verify Status code <StatusCode>
#    Examples:
#      | Endpoint      | Method|SampleName      |StatusCode|
#      | uploadFileToS3| post  |createListedBond|201       |

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

  Scenario Outline: Retrieve bond listing dropdowns
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint                    | Method|StatusCode|
      | retrieveBondListingDropdowns| get   |200       |

    @BEnotIntegrated
  Scenario Outline: Retrieve presigned url for S3
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint            | Method|StatusCode|
      | retrievePresignedUrl| get   |200       |

  Scenario Outline: Retrieve bond details based on ISIN
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint                 | Method|StatusCode|
      | retrieveBondDetailsOnIsin| get   |200       |

  Scenario Outline: Retrieve bond count
    Given Set endpoint "adminLogin" method "post" and SampleName "adminCredentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint          | Method|StatusCode|
      | registryBondCount |  get  | 200      |



