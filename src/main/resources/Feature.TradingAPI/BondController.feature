Feature: Bond Controller

  Scenario Outline: Retrieve bond filters
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint    | Method|StatusCode|
      | bondFilters | get   |200       |

  Scenario Outline: Retrieving bonds based on filters
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint         | Method|SampleName           |StatusCode|
      | getBondsOnFilters| post  |retrieveFilteredBonds|200       |

  Scenario Outline: Retrieve all bonds
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint    | Method|StatusCode|
      | getAllBonds |  get  | 200      |

  Scenario Outline: Retrieve bond based on ISIN
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint   | Method|StatusCode|
      | bondOnISIN |  get  | 200      |

  Scenario Outline: Retrieve unlisted bonds details based on ISIN
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint                  | Method|StatusCode|
      | unlistedBondDetailsOnISIN |  get  | 200      |

  Scenario Outline: Retrieving bond text data details based on it's ISIN
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint        | Method|StatusCode|
      | textDataDetails |  get  | 200      |

  Scenario Outline: Retrieving top 3 bonds to show on Landing Page
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint          | Method|StatusCode|
      | retrieveTop3Bonds |  get  | 200      |

#  Scenario Outline: Retrieve listed bonds details based on ISIN
#    Given Set endpoint "login" method "post" and SampleName "credentials" for login
#    And Set endpoint "<Endpoint>" and Method "<Method>"
#    Then Verify Status code <StatusCode>
#    Examples:
#      | Endpoint                | Method|StatusCode|
#      | listedBondDetailsOnISIN |  get  | 200      |

  Scenario Outline: Retrieve bond details based on its ISIN
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint          | Method|StatusCode|
      | bondDetailsOnISIN |  get  | 200      |

  Scenario Outline: Retrieve bond count
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" and Method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint  | Method|StatusCode|
      | bondCount |  get  | 200      |

