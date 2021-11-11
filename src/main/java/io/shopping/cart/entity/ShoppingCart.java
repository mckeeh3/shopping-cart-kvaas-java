package io.shopping.cart.entity;

import java.util.Optional;

import com.akkaserverless.javasdk.valueentity.ValueEntityContext;
import com.google.protobuf.Empty;
import io.shopping.cart.CartApi;
import io.shopping.cart.entity.CartEntity.CartState;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

/** A value entity. */
public class ShoppingCart extends AbstractShoppingCart {
  @SuppressWarnings("unused")
  private final String entityId;

  public ShoppingCart(ValueEntityContext context) {
    this.entityId = context.entityId();
  }

  @Override
  public CartEntity.CartState emptyState() {
    return CartState.getDefaultInstance();
  }

  @Override
  public Effect<Empty> addItem(CartEntity.CartState state, CartApi.AddLineItem command) {
    return reject(state, command).orElse(handle(state, command));
  }

  @Override
  public Effect<Empty> changeItem(CartEntity.CartState state, CartApi.ChangeLineItem command) {
    return reject(state, command).orElse(handle(state, command));
  }

  @Override
  public Effect<Empty> removeItem(CartEntity.CartState state, CartApi.RemoveLineItem command) {
    return reject(state, command).orElse(handle(state, command));
  }

  @Override
  public Effect<Empty> checkoutCart(CartEntity.CartState state, CartApi.CheckoutShoppingCart command) {
    return reject(state, command).orElse(handle(state, command));
  }

  @Override
  public Effect<Empty> shippedCart(CartEntity.CartState state, CartApi.ShippedShoppingCart command) {
    return reject(state, command).orElse(handle(state, command));
  }

  @Override
  public Effect<Empty> deliveredCart(CartEntity.CartState state, CartApi.DeliveredShoppingCart command) {
    return reject(state, command).orElse(handle(state, command));
  }

  @Override
  public Effect<Empty> deleteCart(CartEntity.CartState state, CartApi.DeleteShoppingCart command) {
    return reject(state, command).orElse(handle(state, command));
  }

  @Override
  public Effect<CartApi.ShoppingCart> getCart(CartEntity.CartState state, CartApi.GetShoppingCart command) {
    return reject(state, command).orElse(handle(state, command));
  }

  private Optional<Effect<Empty>> reject(CartState state, CartApi.AddLineItem command) {
    return Optional.empty();
  }

  private Optional<Effect<Empty>> reject(CartState state, CartApi.ChangeLineItem command) {
    return Optional.empty();
  }

  private Optional<Effect<Empty>> reject(CartState state, CartApi.RemoveLineItem command) {
    return Optional.empty();
  }

  private Optional<Effect<Empty>> reject(CartState state, CartApi.CheckoutShoppingCart command) {
    return Optional.empty();
  }

  private Optional<Effect<Empty>> reject(CartState state, CartApi.ShippedShoppingCart command) {
    return Optional.empty();
  }

  private Optional<Effect<Empty>> reject(CartState state, CartApi.DeliveredShoppingCart command) {
    return Optional.empty();
  }

  private Optional<Effect<Empty>> reject(CartState state, CartApi.DeleteShoppingCart command) {
    return Optional.empty();
  }

  private Optional<Effect<CartApi.ShoppingCart>> reject(CartState state, CartApi.GetShoppingCart command) {
    return Optional.empty();
  }

  private Effect<Empty> handle(CartState state, CartApi.AddLineItem command) {
    return effects().error("The command handler for `AddItem` is not implemented, yet");
  }

  private Effect<Empty> handle(CartState state, CartApi.ChangeLineItem command) {
    return effects().error("The command handler for `ChangeItem` is not implemented, yet");
  }

  private Effect<Empty> handle(CartState state, CartApi.RemoveLineItem command) {
    return effects().error("The command handler for `RemoveItem` is not implemented, yet");
  }

  private Effect<Empty> handle(CartState state, CartApi.CheckoutShoppingCart command) {
    return effects().error("The command handler for `CheckoutCart` is not implemented, yet");
  }

  private Effect<Empty> handle(CartState state, CartApi.ShippedShoppingCart command) {
    return effects().error("The command handler for `ShippedCart` is not implemented, yet");
  }

  private Effect<Empty> handle(CartState state, CartApi.DeliveredShoppingCart command) {
    return effects().error("The command handler for `DeliveredCart` is not implemented, yet");
  }

  private Effect<Empty> handle(CartState state, CartApi.DeleteShoppingCart command) {
    return effects().error("The command handler for `DeleteCart` is not implemented, yet");
  }

  private Effect<CartApi.ShoppingCart> handle(CartState state, CartApi.GetShoppingCart command) {
    return effects().error("The command handler for `GetCart` is not implemented, yet");
  }
}
