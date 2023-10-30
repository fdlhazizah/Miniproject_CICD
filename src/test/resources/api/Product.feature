Feature: Product

  @GetAllProduct
  Scenario: GET - As a user i have be able to get all products
    Given I set get all products API endpoint
    When I send GET HTTP request for get all products
    Then I receive HTTP response status code 200 OK

  @CreateProduct
  Scenario: POST - As a user i have be able to create new product
    Given I set create product API endpoint
    When I send POST HTTP request for create product with valid request body
    Then I receive HTTP response status code 200 OK

  @CreateProduct
  Scenario: POST - As a user i should be failed to create new product with invalid request body
    Given I set create product API endpoint
    When I send POST HTTP request for create product with invalid request body
    Then I receive HTTP response status code 400 Bad Request

  @GetProductByID
  Scenario: GET - As a user i have be able to get product by ID with valid product ID
    Given I set get product by ID API endpoint
    When I send GET HTTP request for get product by ID
    Then I receive HTTP response status code 200 OK

  @GetProductByID
  Scenario: GET - As a user i should be failed to get product by ID with invalid ID
    Given I set get product by ID API endpoint with invalid ID
    When I send GET HTTP request for get product by invalid ID
    Then I receive HTTP response status code 404 Not Found

  @DeleteProduct
  Scenario: DELETE - As a user i have be able to delete product with valid product ID
    Given I set delete product API endpoint
    When I send DELETE HTTP request for delete product with valid product ID
    Then I receive HTTP response status code 200 OK

  @CreateProductRatings
  Scenario: POST - As a user i have be able to give product ratings
    Given I set product rating API endpoint
    When I send POST HTTP request for product rating with valid request body
    Then I receive HTTP response status code 200 OK

  @GetProductRating
  Scenario: GET - As a user i have be able to get product ratings
    Given I set valid get product rating API endpoint
    When I send GET HTTP request for get product rating
    Then I receive HTTP response status code 200 OK

  @CreateComment
  Scenario: POST - As a user i have be able to create comment
    Given I set create comment API endpoint
    When I send POST HTTP request for create comment with valid request body
    Then I receive HTTP response status code 200 OK

  @GetComment
  Scenario: GET - As a user i have be able to get comment
    Given I set get comment API endpoint
    When I send GET HTTP request for get comment with valid product ID
    Then I receive HTTP response status code 200 OK