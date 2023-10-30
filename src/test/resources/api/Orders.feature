Feature: Order

  @CreateOrder
  Scenario: POST - As a user i have be able to create order with valid product ID and quantity
    Given I set create order API endpoint
    When I send POST HTTP request for create order with valid product id and quantity
    Then I receive HTTP response status code 200 OK

  @GetOrder
  Scenario: GET - As a user i have be able to get all orders
    Given I set get all orders API endpoint
    When I send GET HTTP request for get all orders
    Then I receive HTTP response status code 200 OK

  @GetOrderByID
  Scenario: GET - As a user i have be able to get order by ID
    Given I set get orders by ID API endpoint
    When I send GET HTTP request for get orders by ID
    Then I receive HTTP response status code 200 OK

  @GetOrderByID
  Scenario: GET - As a user i should be failed to get order by ID with invalid ID
    Given I set get orders by ID API endpoint with invalid ID
    When I send GET HTTP request for get orders by ID with invalid ID
    Then I receive HTTP response status code 404 Not Found