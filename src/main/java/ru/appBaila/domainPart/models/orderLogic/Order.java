package ru.appBaila.domainPart.models.orderLogic;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Order {
    Long userId;
    OrderStatus status;

    public Order(Long userId) {
        this.userId = userId;
        this.status = OrderStatus.CREATED;
    }
}
