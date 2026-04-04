package org.hades.order.infrastructure;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_items")
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    Long productId;
    @Column(nullable = false)
    Long price;
    @Column(nullable = false)
    Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    OrderEntity order;
}
