package ru.appBaila.models.dto;

import ru.appBaila.models.entitys.Order;

import java.time.LocalDateTime;
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
public class OrderDto {
    private Long id;

    private Long userId;

    private String status;

    private String deliveryAddress;

    private String comment;

    private LocalDateTime createdAt;

    private List<OrderItemDto> orderItems = new ArrayList<>();

    public OrderDto(Order entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        if (entity.getStatus() != null) this.status = String.valueOf(entity.getStatus());
        this.deliveryAddress = entity.getDeliveryAddress();
        this.comment = entity.getComment();
        this.createdAt = entity.getCreatedAt();
        if (entity.getOrderItems() != null) {
            this.orderItems = entity.getOrderItems().stream()
                    .map(OrderItemDto::new)
                    .collect(Collectors.toList());
        } else {
            this.orderItems = Collections.emptyList();
        }
    }
}
