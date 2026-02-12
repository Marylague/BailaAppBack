package ru.appBaila.models.dto;

import ru.appBaila.models.entitys.OrderItem;
import ru.appBaila.models.entitys.Outfit;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {

    private Long id;

    private Outfit outfit;

    private Integer quantity;

    private Double price;

    public OrderItemDto(OrderItem entity) {
        this.id = entity.getId();
        this.outfit = entity.getOutfit();
        this.quantity = entity.getQuantity();
        this.price = entity.getPrice();
    }
}
