package ru.appBaila.domainPart.port.inPorts.orderLogic;

import ru.appBaila.domainPart.models.orderLogic.Order;

public interface SavingOrder {
    void saveNewOrder(Order order);
    void updateOrder(Order order);
}
