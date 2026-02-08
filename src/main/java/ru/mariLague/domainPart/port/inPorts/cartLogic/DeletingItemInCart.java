package ru.mariLague.domainPart.port.inPorts.cartLogic;

import ru.mariLague.domainPart.models.CartLogic.CartItem;

public interface DeletingItemInCart {
    void deleteItemInCart(CartItem cartItem);
}
