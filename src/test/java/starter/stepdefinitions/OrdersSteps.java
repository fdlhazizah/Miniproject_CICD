package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Orders;

public class OrdersSteps {
    @Steps
    Orders order;

    @Given("I set create order API endpoint")
    public void setValidCreateOrderEndpoint(){
        order.setCreateOrderEndpoint();
    }

    @When("I send POST HTTP request for create order with valid product id and quantity")
    public void successSendPostCreateOrder(){
        order.sendPostToValidCreateOrder();
    }

    @Given("I set get all orders API endpoint")
    public void setValidGetAllEndpoint(){
        order.setGetAllOrdersEndpoint();
    }

    @When("I send GET HTTP request for get all orders")
    public void successSendGetAllOrders(){
        order.sendGetAllOrders();
    }

    @Given("I set get orders by ID API endpoint")
    public void setValidOrderByIdEndpoint(){
        order.setGetOrderByIdEndpoint();
    }

    @When("I send GET HTTP request for get orders by ID")
    public void successSendGetOrderByID(){
        order.sendGetOrderByID();
    }

    @Given("I set get orders by ID API endpoint with invalid ID")
    public void setInvalidEndpointOfGetOrdersInvalidID(){
        order.setGetOrdersWithInvalidID();
    }

    @When("I send GET HTTP request for get orders by ID with invalid ID")
    public void successSendGetOrdersWithInvalidID(){
        order.sendGetOrderByInvalidID();
    }

}
