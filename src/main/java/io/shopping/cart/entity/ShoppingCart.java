package io.shopping.cart.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.akkaserverless.javasdk.valueentity.ValueEntityContext;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;

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
    if (state.getCheckedOut()) {
      return Optional.of(effects().error("Shopping cart is already checked out"));
    }
    if (state.getDeleted()) {
      return Optional.of(effects().error("Shopping cart is deleted"));
    }
    if (command.getCustomerId().isEmpty()) {
      return Optional.of(effects().error("Customer ID is required"));
    }
    if (command.getProductId().isEmpty()) {
      return Optional.of(effects().error("Product ID is required"));
    }
    if (command.getProductName().isEmpty()) {
      return Optional.of(effects().error("Product name is required"));
    }
    if (command.getQuantity() <= 0) {
      return Optional.of(effects().error("Quantity must be greater than 0"));
    }
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
    if (state.getCartId().isEmpty()) {
      return Optional.of(effects().error("Shopping cart is empty"));
    }
    return Optional.empty();
  }

  private Effect<Empty> handle(CartState state, CartApi.AddLineItem command) {
    return effects()
        .updateState(updateState(state, command))
        .thenReply(Empty.getDefaultInstance());
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
    return effects().reply(toApi(state));
  }

  private CartState updateState(CartState state, CartApi.AddLineItem command) {
    var lineItems = CartItems
        .fromLineItems(state.getLineItemsList())
        .update(command)
        .toLineItems();
    return state
        .toBuilder()
        .setCartId(command.getCartId())
        .setCustomerId(command.getCustomerId())
        .clearLineItems()
        .addAllLineItems(lineItems)
        .build();
  }

  private io.shopping.cart.CartApi.ShoppingCart toApi(CartState state) {
    return CartApi.ShoppingCart
        .newBuilder()
        .setCartId(state.getCartId())
        .setCustomerId(state.getCustomerId())
        .setCheckedOut(state.getCheckedOut())
        .setCheckedOutUtc(toUtc(state.getCheckedOutUtc()))
        .setShippedUtc(toUtc(state.getShippedUtc()))
        .setDeliveredUtc(toUtc(state.getDeliveredUtc()))
        .setDeleted(state.getDeleted())
        .addAllLineItems(toApi(state.getLineItemsList()))
        .build();
  }

  private List<CartApi.LineItem> toApi(List<CartEntity.LineItem> lineItems) {
    return lineItems.stream().map(
        lineItem -> CartApi.LineItem
            .newBuilder()
            .setProductId(lineItem.getProductId())
            .setProductName(lineItem.getProductName())
            .setQuantity(lineItem.getQuantity())
            .build())
        .collect(Collectors.toList());
  }

  private String toUtc(Timestamp timestamp) {
    if (timestamp.getSeconds() == 0) {
      return "";
    }
    var daeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    return daeFormat.format(new Date(timestamp.getSeconds() * 1000 + timestamp.getNanos() / 1000000));
  }

  static class CartItems {
    Map<String, CartEntity.LineItem> items = new LinkedHashMap<String, CartEntity.LineItem>();

    CartItems(List<io.shopping.cart.entity.CartEntity.LineItem> lineItems) {
      lineItems.forEach(lineItem -> items.put(lineItem.getProductId(), lineItem));
    }

    static CartItems fromLineItems(List<CartEntity.LineItem> lineItems) {
      return new CartItems(lineItems);
    }

    List<CartEntity.LineItem> toLineItems() {
      return new ArrayList<>(items.values());
    }

    CartItems update(CartApi.AddLineItem command) {
      items.computeIfPresent(command.getProductId(),
          (productId, lineItem) -> lineItem
              .toBuilder()
              .setQuantity(lineItem.getQuantity() + command.getQuantity())
              .build());
      items.computeIfAbsent(command.getProductId(),
          productId -> CartEntity.LineItem
              .newBuilder()
              .setProductId(command.getProductId())
              .setProductName(command.getProductName())
              .setQuantity(command.getQuantity())
              .build());
      return this;
    }

    CartItems update(CartApi.ChangeLineItem command) {
      items.computeIfPresent(command.getProductId(),
          (productId, lineItem) -> lineItem
              .toBuilder()
              .setQuantity(command.getQuantity())
              .build());
      return this;
    }

    CartItems update(CartApi.RemoveLineItem command) {
      items.remove(command.getProductId());
      return this;
    }
  }
}
