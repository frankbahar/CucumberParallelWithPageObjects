Feature: Login to Zoho and Validate SalesIQ

  Scenario: Navigate to Zoho.com in chrome and validate SalesIQ
    Given launch browser "chrome"
    When user navigates to the URL "https://www.zoho.com"
    Then user click on login
    Then user click on SalesIQ
