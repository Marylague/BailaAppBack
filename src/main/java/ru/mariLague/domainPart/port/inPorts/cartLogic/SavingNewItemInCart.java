package ru.mariLague.domainPart.port.inPorts.cartLogic;

import ru.mariLague.domainPart.models.CartLogic.CartItem;

public interface SavingNewItemInCart {
    CartItem addNewItem(Long productId);
}
