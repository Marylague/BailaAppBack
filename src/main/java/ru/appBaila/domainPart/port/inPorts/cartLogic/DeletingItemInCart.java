package ru.appBaila.domainPart.port.inPorts.cartLogic;

import ru.appBaila.domainPart.models.CartLogic.CartItem;

public interface DeletingItemInCart {
    void deleteItemInCart(CartItem cartItem);
}
