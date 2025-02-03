Feature: Create bond form

  Scenario Outline: Draft a bond and verify
    Given Navigate to admin portal
    And Enter email "<email>" and password "<password>"
    And Click the login button
    When Click the button "Add New Bond"
    And Hover over Save & Draft and verify tooltip
    And Enter issuer name "testBond" and isin
    And Click the button "Save & Draft"
    And Click the button "Drafted Bonds"
    Then Verify the drafted bond

    Examples:
      |email               |password      |
      |super.admin@test.com|admin_password|


    Scenario Outline: Publish a bond and verify
      Given Navigate to admin portal
      And Enter email "<email>" and password "<password>"
      And Click the login button
      When Click the button "Add New Bond"
      And Enter issuer name "testBond" and isin
      And Enter mandatory details in bond form
      And Click the button "Publish Bond"
      Then Verify bond is published

      Examples:
        |email               |password      |
        |super.admin@test.com|admin_password|




