Feature: Book Creation

  Scenario: Create a book with valid data
    Given url baseUrl
    And request {"title": "NewBook", "price": 55.50}
    When method POST
    Then status 201

  Scenario: Create a book with blank title
    Given url baseUrl
    And request {"title": " ", "price": 55.50}
    When method POST
    Then status 400