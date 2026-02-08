package ru.mariLague.domainPart.port.outPorts.cartLogic;

import ru.mariLague.domainPart.models.CartLogic.Cart;
import ru.mariLague.domainPart.models.CartLogic.CartItem;

public interface CartRepository {
    void saveNewItem(CartItem cartItem);
    Cart viewCartItems(Long userId);
    void deleteItemInCart(CartItem cartItem);
}
