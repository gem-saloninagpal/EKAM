Feature: Order Controller

  Scenario Outline: Create order
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" with subject, method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint   | Method|SampleName|StatusCode|
      | createOrder| post  |bondInfo  |201       |

    Scenario Outline: Get order by id
      Given Set endpoint "login" method "post" and SampleName "credentials" for login
      And Set endpoint "<Endpoint>" with subject and method "<Method>"
      Then Verify Status code <StatusCode>
      Examples:
        | Endpoint | Method|StatusCode|
        | getOrder | get   |200       |

  Scenario Outline: Get order by user id
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" with subject and method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint         | Method|StatusCode|
      | getOrderByUserId | get   |200       |
