package ru.mariLague.domainPart.port.inPorts.orderLogic;

import ru.mariLague.domainPart.models.orderLogic.Order;

public interface DeletingOrder {
    void deleteOrder(Order order);
}
