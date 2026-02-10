package ru.appBaila.domainPart.port.inPorts.orderLogic;

import ru.appBaila.domainPart.models.CartLogic.Cart;
import ru.appBaila.domainPart.models.orderLogic.Order;

public interface UsingOrderCases {
    void deleteOrder(Order order);
    void placeOrder(Cart cart);
    void saveNewOrder(Order order);
    void updateOrder(Order order);
}
