package ru.mariLague.domainPart.port.inPorts.orderLogic;

import ru.mariLague.domainPart.models.orderLogic.Order;

public interface SavingNewOrder {
    void savingNewOrder(Order order);
}
