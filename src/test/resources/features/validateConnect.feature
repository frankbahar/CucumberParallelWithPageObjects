Feature: Login to Zoho and Validate Connect

  Scenario: Navigate to Zoho.com in chrome and validate Connect
    Given launch browser "chrome"
    When user navigates to the URL "https://www.zoho.com"
    Then user click on login
    Then user click on Connect