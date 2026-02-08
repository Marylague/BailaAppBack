package ru.mariLague.domainPart.port.inPorts.orderLogic;

import ru.mariLague.domainPart.models.CartLogic.Cart;
import ru.mariLague.domainPart.models.orderLogic.Order;

public interface PlacingOrderFromCart {
    void placeOrder(Cart cart);
}
