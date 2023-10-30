package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Product;

public class ProductSteps {
    @Steps
    Product product;

    @Given("I set create product API endpoint")
    public void setValidCreateProduct() {
        product.setCreateProductEndpoint();
    }

    @When("I send POST HTTP request for create product with valid request body")
    public void successSendValidPostCreateProduct() {
        product.sendPostCreateProductValid();
    }

    @When("I send POST HTTP request for create product with invalid request body")
    public void successSendInvalidPostCreateProduct() {
        product.sendPostCreateProductWithInvalidFormat();
    }

    @Then("I receive HTTP response status code 400 Bad Request")
    public void validateStatus400BadRequest() {
        product.receiveResponseStatusCode400BadRequest();
    }

    @Given("I set get all products API endpoint")
    public void setValidGetAllProductsEndpoint() {
        product.setGetAllProductEndpoint();
    }

    @When("I send GET HTTP request for get all products")
    public void successSendGetAllProducts() {
        product.sendGetAllProductValid();
    }

    @Given("I set get product by ID API endpoint")
    public void setValidGetProductByID() {
        product.setGetProductByIdEndpoint();
    }

    @When("I send GET HTTP request for get product by ID")
    public void successSendGetProductByID() {
        product.sendGetProductById();
    }

    @Then("I receive HTTP response status code 404 Not Found")
    public void validateStatus404NotFound() {
        product.receiveStatusCode404NotFound();
    }

    @Given("I set get product by ID API endpoint with invalid ID")
    public void setInvalidGetProductByInvalidID() {
        product.setGetProductByInvalidId();
    }

    @When("I send GET HTTP request for get product by invalid ID")
    public void successSendGetProductByInvalidID() {
        product.sendGetProductByIdWithInvalidID();
    }

    @Given("I set delete product API endpoint")
    public void setValidDeleteProductEndpoint() {
        product.setDeleteProductEndpoint();
    }

    @When("I send DELETE HTTP request for delete product with valid product ID")
    public void successSendValidDeleteProduct() {
        product.sendDeleteProductValidId();
    }

    @Given("I set product rating API endpoint")
    public void setValidRatingEndpoint() {
        product.setRatingEndpoint();
    }

    @When("I send POST HTTP request for product rating with valid request body")
    public void successSendValidPostRating() {
        product.sendPostRating();
    }

    @Given("I set valid get product rating API endpoint")
    public void setValidGetProductRatingEndpoint() {
        product.setGetRatingValidID();
    }

    @When("I send GET HTTP request for get product rating")
    public void successSendGetProductRatingWithValidProductId() {
        product.sendGetProductRatingValidId();
    }


    @Given("I set create comment API endpoint")
    public void setValidCreateComment() {
        product.setCreateCommentEndpoint();
    }

    @When("I send POST HTTP request for create comment with valid request body")
    public void successSendPostCreateCommentValid() {
        product.sendPostCreateCommentValid();
    }

    @Given("I set get comment API endpoint")
    public void setValidGetCommentEndpoint() {
        product.setGetCommentEndpoint();
    }

    @When("I send GET HTTP request for get comment with valid product ID")
    public void successSendGetCommentWithValidProductID() {
        product.sendGetCommentWithValidID();
    }

}