package ru.mariLague.domainPart.models.CartLogic;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cart {
    Long UserId;
    List<CartItem> CartItems;

    public Cart(Long userId) {
        UserId = userId;
        CartItems = new ArrayList<>();
    }

    public void addNewItem(CartItem cartItem) {
        // добавить ллогику, что если такой же товар есть, то добавлять + 1
        if (CartItems.contains(cartItem)) {
            int index = CartItems.indexOf(cartItem);
            CartItem cI = CartItems.get(index);
            cI.addOneMore();
            return;
        }
        CartItems.add(cartItem);
    }

    public void addNewItem(Long productId) {
        CartItems.add(new CartItem(productId));
    }

    public void removeItem(CartItem cartItem) {
        CartItems.remove(cartItem);
    }
}
