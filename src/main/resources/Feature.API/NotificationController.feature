Feature: Notification controller

  Scenario Outline: Delete notification preferences
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" with subject and method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint                     | Method |StatusCode|
      | deleteNotificationPreference | delete |200       |

  Scenario Outline: Create notification preferences
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint          | Method|SampleName             |StatusCode|
      | createNotification| post  |notificationPreferences|201       |

  Scenario Outline: Retrieve notification preference
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" with subject and method "<Method>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint                  | Method|StatusCode|
      | getNotificationPreference | get   |200       |

  Scenario Outline: Send notification for new bonds
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint        | Method|SampleName      |StatusCode|
      | sendNotification| post  |sendNotification|200       |

  Scenario Outline: Update notification preference
    Given Set endpoint "login" method "post" and SampleName "credentials" for login
    And Set endpoint "<Endpoint>" with subject, method "<Method>" and SampleName "<SampleName>"
    Then Verify Status code <StatusCode>
    Examples:
      | Endpoint                 | Method|SampleName                  |StatusCode|
      | getNotificationPreference| put  |updateNotificationPreferences|200       |



