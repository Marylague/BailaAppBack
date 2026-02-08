package ru.mariLague.domainPart.port.inPorts.cartLogic;

import ru.mariLague.domainPart.models.CartLogic.Cart;

public interface ViewingCartItems {
    Cart viewCartItems(Long userId);
}
