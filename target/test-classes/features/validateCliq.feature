Feature: Login to Zoho and Validate Cliq

  Scenario: Navigate to Zoho.com in chrome and validate Cliq
    Given launch browser "chrome"
    When user navigates to the URL "https://www.zoho.com"
    Then user click on login
    Then user click on Cliq