package ru.appBaila.domainPart.port.inPorts.cartLogic;

import ru.appBaila.domainPart.models.CartLogic.CartItem;

public interface SavingNewItemInCart {
    CartItem addNewItem(Long productId);
}
