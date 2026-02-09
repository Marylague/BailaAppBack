package ru.appBaila.domainPart.port.inPorts.orderLogic;

import ru.appBaila.domainPart.models.orderLogic.Order;

public interface DeletingOrder {
    void deleteOrder(Order order);
}
