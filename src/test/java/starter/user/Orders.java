package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;

public class Orders {
    protected String url = "https://altashop-api.fly.dev/api";

    //    Scenario: POST - As a user i have be able to create order with valid product ID and quantity
    @Step("I set create order API endpoint")
    public String setCreateOrderEndpoint() {
        return url + "/orders";
    }

    @Step("I send POST HTTP request for create order with valid product id and quantity")
    public void sendPostToValidCreateOrder() {
        JSONArray orderItems = new JSONArray();
        JSONObject orderItem = new JSONObject();
        orderItem.put("product_id", 5);
        orderItem.put("quantity", 1);
        orderItems.put(orderItem);

        JSONArray requestBody = new JSONArray();
        JSONObject orderCreate = new JSONObject();
        orderCreate.put("order_items", orderItems);
        requestBody.put(orderCreate);

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setCreateOrderEndpoint());
    }

    //    Scenario: GET - As a user i have be able to get all orders
    @Step("I set get all orders API endpoint")
    public String setGetAllOrdersEndpoint() {
        return url + "/orders";
    }

    @Step("I send GET HTTP request for get all orders")
    public void sendGetAllOrders() {
        SerenityRest.when().get(setGetAllOrdersEndpoint());
    }


    //    Scenario: GET - As a user i have be able to get order by ID
    @Step("I set get orders by ID API endpoint")
    public String setGetOrderByIdEndpoint() {
        return url + "/orders/12575";
    }

    @Step("I send GET HTTP request for get orders by ID")
    public void sendGetOrderByID() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .get(setGetOrderByIdEndpoint());
    }

    //    Scenario: GET - As a user i should be failed to get order by ID with invalid ID
    @Step("I set get orders by ID API endpoint with invalid ID")
    public String setGetOrdersWithInvalidID() {
        return url + "/orders/123456789";
    }

    @Step("I send GET HTTP request for get orders by ID with invalid ID")
    public void sendGetOrderByInvalidID() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .get(setGetOrdersWithInvalidID());
    }

}