Feature: Sample Api Test

  Scenario: Test a simple Get API
    Given url "https://reqres.in/api/users?page=2"
    When method GET
    Then status 200