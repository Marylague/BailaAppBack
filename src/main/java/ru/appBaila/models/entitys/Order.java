package ru.appBaila.models.entitys;

import ru.appBaila.models.dto.OrderDto;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    private String comment;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(User user) {
        this.user = user;
        this.status = OrderStatus.CREATED;
    }

    public Order(OrderDto dto, User user) {
        this.id = dto.getId();
        this.user = user;
        if (dto.getStatus() != null) this.status = OrderStatus.valueOf(dto.getStatus());
        this.deliveryAddress = dto.getDeliveryAddress();
        this.comment = dto.getComment();
        this.createdAt = dto.getCreatedAt();
        if (dto.getOrderItems() != null) {
            this.orderItems = dto.getOrderItems().stream()
                    .map(OrderItem::new)
                    .collect(Collectors.toList());
        } else {
            this.orderItems = Collections.emptyList();
        }
    }
}
