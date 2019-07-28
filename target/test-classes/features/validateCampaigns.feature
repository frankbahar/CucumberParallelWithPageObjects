Feature: Login to Zoho and Validate Campaigns

  Scenario: Navigate to Zoho.com in chrome and validate Campaigns
    Given launch browser "chrome"
    When user navigates to the URL "https://www.zoho.com"
    Then user click on login
    Then user click on Campaigns