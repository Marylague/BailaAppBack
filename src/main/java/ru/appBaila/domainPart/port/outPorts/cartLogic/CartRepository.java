package ru.appBaila.domainPart.port.outPorts.cartLogic;

import ru.appBaila.domainPart.models.CartLogic.Cart;
import ru.appBaila.domainPart.models.CartLogic.CartItem;

public interface CartRepository {
    void saveNewItem(CartItem cartItem);
    Cart viewCartItems(Long userId);
    void deleteItemInCart(CartItem cartItem);
}
