package ru.appBaila.models.dto;

import ru.appBaila.models.entitys.CartItem;
import ru.appBaila.models.entitys.Outfit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {

    private Long Id;

    private Outfit outfit;

    private Integer quantity;

    public CartItemDto(CartItem entity) {
        this.Id = entity.getId();
        this.outfit = entity.getOutfit();
        this.quantity = entity.getQuantity();
    }
}
