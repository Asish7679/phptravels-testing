Feature: User Registration

  Scenario Outline: Register with valid details
    When user navigates to Sign Up page
    And user enters registration details "<fname>" "<lname>" "<country>" "<phone>" "<email>" "<password>"
    And clicks on Sign Up button
    Then account should be created successfully

    Examples:
      | fname | lname | country | phone       | email                | password |
      | John  | Doe   | India   | 9876543210  | john<time>@test.com  | Test@123 |
