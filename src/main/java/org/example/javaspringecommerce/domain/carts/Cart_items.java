package org.example.javaspringecommerce.domain.carts;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="cart_items")
public class Cart_items {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long cart_id;

    private Long product_id;

    private Long quantity;

    private BigDecimal unit_price;
}
