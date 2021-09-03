Feature: Api enables successful retrieval of Books


  @book
  Scenario: Sent GET request to list all Books API
    Given url baseUrl
    When method GET
    Then status 200
    And match response != null
    And print response