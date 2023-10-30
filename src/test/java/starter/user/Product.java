package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Product {
    protected String url = "https://altashop-api.fly.dev/api";

    //    Scenario: POST - As a user i have be able to create new product
    @Step("I set create product API endpoint")
    public String setCreateProductEndpoint(){
        return url + "/products";
    }

    @Step("I send POST HTTP request for create product with valid request body")
    public void sendPostCreateProductValid(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Samsung A14");
        requestBody.put("description", "Handphone samsung");
        requestBody.put("price", 2000);

        JSONArray categories = new JSONArray();
        categories.put(1);

        requestBody.put("categories", categories);


        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setCreateProductEndpoint());
    }

    //    Scenario: POST - As a user i should be failed to create new product with empty name
    @Step("I send POST HTTP request for create product with invalid request body")
    public void sendPostCreateProductWithInvalidFormat(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("description", "Handphone samsung");
        requestBody.put("price", 299);
        requestBody.put("categories", 1);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setCreateProductEndpoint());
    }

    @Step("I receive HTTP response status code 400 Bad Request")
    public void receiveResponseStatusCode400BadRequest(){
        restAssuredThat(response -> response.statusCode(400));
    }

    //    Scenario: GET - As a user i have be able to get all products
    @Step("I set get all products API endpoint")
    public String setGetAllProductEndpoint(){
        return url + "/products";
    }

    @Step("I send GET HTTP request for get all products")
    public void sendGetAllProductValid(){
        SerenityRest.given().get(setGetAllProductEndpoint());
    }



    //    Scenario: GET - As a user i have be able to get product by ID with valid product ID
    @Step("I set get product by ID API endpoint")
    public String setGetProductByIdEndpoint(){
        return url + "/products/87324";
    }

    @Step("I send GET HTTP request for get product by ID")
    public void sendGetProductById(){
        SerenityRest.given().get(setGetProductByIdEndpoint());
    }


    //    Scenario: GET - As a user i should be failed to get product by ID with invalid ID
    @Step("I set get product by ID API endpoint with invalid ID")
    public String setGetProductByInvalidId(){
        return url + "/products/123456789";
    }

    @Step("I send GET HTTP request for get product by invalid ID")
    public void sendGetProductByIdWithInvalidID(){
        SerenityRest.given().get(setGetProductByInvalidId());
    }

    @Step("I receive HTTP response status code 404 Not Found")
    public void receiveStatusCode404NotFound(){
        restAssuredThat(response -> response.statusCode(404));
    }


    //    Scenario: DELETE - As a user i have be able to delete product with valid product ID
    @Step("I set delete product API endpoint")
    public String setDeleteProductEndpoint(){
        return  url + "/products/25";
    }

    @Step("I send DELETE HTTP request for delete product with valid product ID")
    public void sendDeleteProductValidId(){
        SerenityRest.when().delete(setDeleteProductEndpoint());
    }


    //    Scenario: POST - As a user i have be able to give product ratings
    @Step("I set product rating API endpoint")
    public String setRatingEndpoint(){
        return url + "/products/87324/ratings";
    }

    @Step("I send POST HTTP request for product rating with valid request body")
    public void sendPostRating(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("count", 4);

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .post(setRatingEndpoint());
    }


    //    Scenario: GET - As a user i have be able to get product ratings with valid product ID
    @Step("I set valid get product rating API endpoint")
    public String setGetRatingValidID(){
        return url + "/products/87324/ratings";
    }

    @Step("I send GET HTTP request for get product rating")
    public void sendGetProductRatingValidId(){
        SerenityRest.when().get(setGetRatingValidID());
    }


    //    Scenario: POST - As a user i have be able to create comment with valid product ID
    @Step("I set create comment API endpoint")
    public String setCreateCommentEndpoint(){
        return url + "/products/225/comments";
    }

    @Step("I send POST HTTP request for create comment with valid request body")
    public void sendPostCreateCommentValid(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("content", "Comment");

        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .body(requestBody.toString())
                .post(setCreateCommentEndpoint());
    }

    //    Scenario: GET - As a user i have be able to get comment with valid product ID
    @Step("I set get comment API endpoint")
    public String setGetCommentEndpoint(){
        return url + "/products/2/comments";
    }

    @Step("I send GET HTTP request for get comment with valid product ID")
    public void sendGetCommentWithValidID(){
        SerenityRest.when().get(setGetCommentEndpoint());
    }


}
