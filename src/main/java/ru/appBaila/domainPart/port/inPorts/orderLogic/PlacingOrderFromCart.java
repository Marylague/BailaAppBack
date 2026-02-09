package ru.appBaila.domainPart.port.inPorts.orderLogic;

import ru.appBaila.domainPart.models.CartLogic.Cart;

public interface PlacingOrderFromCart {
    void placeOrder(Cart cart);
}
