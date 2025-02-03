Feature:Bond trading-users controller

  #uncomment 3 tcs once issue gets resolved
  Scenario Outline: Login User
    Given Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>" for login
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint | Method|SampleName |StatusCode|
      | login    | post  |credentials|200       |

#  Scenario Outline: Delete user
#    Given Set endpoint "login" method "post" and SampleName "credentials" for login
#    Given Set endpoint "<Endpoint>" and Method "<Method>"
#    Then Verify Status code <StatusCode>
#    Examples:
#      | Endpoint  | Method|SampleName|StatusCode|
#      | deleteUser| post  |deleteUser|200       |

  Scenario Outline: Create user
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    Given Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>" for login
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint  | Method|SampleName             |StatusCode|
      | createUser| post  |existingUserCredentials|409       |
  #    | createUser| post  |newUserCredentials     |200       |

#   Scenario Outline: Get user --static endpoint
#     Given Set endpoint "login" method "post" and SampleName "credentials" for login
#     And Set endpoint "<Endpoint>" and Method "<Method>"
#     Then Verify Status code <StatusCode>
#     Examples:
#       | Endpoint| Method|StatusCode|
#       | getUser | get   |200       |

 # @discuss- post request does not execute w/o login
   Scenario Outline: Forgot password
     Given Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>" for login
     Then Verify Status code <StatusCode>
     Examples:
       | Endpoint      | Method|SampleName             |StatusCode|
       | forgotPassword| post  |existingUserCredentials|200       |

  Scenario Outline: Change password
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    Given Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint      | Method|SampleName     |StatusCode|
      | changePassword| post  |nonExistingUser|409       |
   #   | changePassword| post  |changePassword |200       |

















