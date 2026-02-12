package ru.appBaila.models.dto;

import ru.appBaila.models.entitys.Cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    Long Id;

    private Long userId;

    private List<CartItemDto> cartItems = new ArrayList<>();

    public CartDto(Cart entity) {
        this.Id = entity.getId();
        this.userId = entity.getUser().getId();
        if (entity.getCartItems() != null) {
            this.cartItems = entity.getCartItems().stream()
                    .map(CartItemDto::new)
                    .collect(Collectors.toList());
        } else {
            this.cartItems = Collections.emptyList();
        }
    }

}
