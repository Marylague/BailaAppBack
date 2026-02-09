package ru.appBaila.domainPart.models.CartLogic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
    Long ProductId;
    Integer Quantity = 0;

    public CartItem(Long productId) {
        ProductId = productId;
    }

    public CartItem(Long productId, Integer quantity) {
        ProductId = productId;
        Quantity = quantity;
    }

    public void addOneMore() {
        Quantity++;
    }
}
