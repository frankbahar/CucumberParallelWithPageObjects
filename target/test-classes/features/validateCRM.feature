Feature: Login to Zoho and validate CRM

  Scenario Outline: Navigate to Zoho.com and click CRM
    Given launch browser "<browserName>"
    When user navigates to the URL "https://www.zoho.com"
    Then user click on login
    Then user click on CRM

    Examples: 
      | browserName |
      | chrome      |
      | firefox     |
