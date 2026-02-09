package ru.appBaila.domainPart.port.outPorts.orderLogic;

import ru.appBaila.domainPart.models.orderLogic.Order;

public interface orderRepository {
    void createOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(Order order);
}
