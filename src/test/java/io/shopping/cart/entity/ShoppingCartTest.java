package io.shopping.cart.entity;

import com.akkaserverless.javasdk.testkit.ValueEntityResult;
import com.akkaserverless.javasdk.valueentity.ValueEntity;
import com.google.protobuf.Empty;
import io.shopping.cart.CartApi;
import org.junit.Test;

import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class ShoppingCartTest {

  @Test
  public void exampleTest() {
    ShoppingCartTestKit testKit = ShoppingCartTestKit.of(ShoppingCart::new);
    // use the testkit to execute a command
    // of events emitted, or a final updated state:
    // ValueEntityResult<SomeResponse> result = testKit.someOperation(SomeRequest);
    // verify the response
    // SomeResponse actualResponse = result.getReply();
    // assertEquals(expectedResponse, actualResponse);
    // verify the final state after the command
    // assertEquals(expectedState, testKit.getState());
  }

  @Test
  public void addItemTest() {
    ShoppingCartTestKit testKit = ShoppingCartTestKit.of(ShoppingCart::new);
    // ValueEntityResult<Empty> result = testKit.addItem(AddLineItem.newBuilder()...build());
  }


  @Test
  public void changeItemTest() {
    ShoppingCartTestKit testKit = ShoppingCartTestKit.of(ShoppingCart::new);
    // ValueEntityResult<Empty> result = testKit.changeItem(ChangeLineItem.newBuilder()...build());
  }


  @Test
  public void removeItemTest() {
    ShoppingCartTestKit testKit = ShoppingCartTestKit.of(ShoppingCart::new);
    // ValueEntityResult<Empty> result = testKit.removeItem(RemoveLineItem.newBuilder()...build());
  }


  @Test
  public void checkoutCartTest() {
    ShoppingCartTestKit testKit = ShoppingCartTestKit.of(ShoppingCart::new);
    // ValueEntityResult<Empty> result = testKit.checkoutCart(CheckoutShoppingCart.newBuilder()...build());
  }


  @Test
  public void shippedCartTest() {
    ShoppingCartTestKit testKit = ShoppingCartTestKit.of(ShoppingCart::new);
    // ValueEntityResult<Empty> result = testKit.shippedCart(ShippedShoppingCart.newBuilder()...build());
  }


  @Test
  public void deliveredCartTest() {
    ShoppingCartTestKit testKit = ShoppingCartTestKit.of(ShoppingCart::new);
    // ValueEntityResult<Empty> result = testKit.deliveredCart(DeliveredShoppingCart.newBuilder()...build());
  }


  @Test
  public void deleteCartTest() {
    ShoppingCartTestKit testKit = ShoppingCartTestKit.of(ShoppingCart::new);
    // ValueEntityResult<Empty> result = testKit.deleteCart(DeleteShoppingCart.newBuilder()...build());
  }


  @Test
  public void getCartTest() {
    ShoppingCartTestKit testKit = ShoppingCartTestKit.of(ShoppingCart::new);
    // ValueEntityResult<ShoppingCart> result = testKit.getCart(GetShoppingCart.newBuilder()...build());
  }

}
