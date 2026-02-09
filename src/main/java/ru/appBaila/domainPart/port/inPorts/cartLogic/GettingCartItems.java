package ru.appBaila.domainPart.port.inPorts.cartLogic;

import ru.appBaila.domainPart.models.CartLogic.Cart;

public interface GettingCartItems {
    Cart viewCartItems(Long userId);
}
