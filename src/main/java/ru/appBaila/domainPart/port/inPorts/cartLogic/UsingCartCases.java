package ru.appBaila.domainPart.port.inPorts.cartLogic;

import ru.appBaila.domainPart.models.CartLogic.Cart;
import ru.appBaila.domainPart.models.CartLogic.CartItem;

public interface UsingCartCases {
    void deleteItemInCart(CartItem cartItem);
    Cart viewCartItems(Long userId);
    CartItem addNewItem(Long productId);
}
