Feature: POST API DEMO

  Background: 
    * url baseUrl
    * def expectedOutput = read('response.json')
  
  Scenario: Create a user
    Given url 'https://reqres.in/api/users'
    When method POST
    And request { "name": "C. Ronaldo", "job": "Footballer"}
    Then status 201
    And print response
    And match $.createdAt != null

  Scenario: Create a user(match response from file)
    Given path '/api/users'
    When method POST
    And request { "name": "C. Ronaldo", "job": "Footballer"}
    Then status 201
    And print response
    And match response == expectedOutput