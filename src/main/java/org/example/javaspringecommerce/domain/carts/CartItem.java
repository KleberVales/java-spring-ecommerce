package org.example.javaspringecommerce.domain.carts;

import jakarta.persistence.*;
import org.example.javaspringecommerce.domain.product.Product;

@Entity
@Table(name="cart_items")
public class CartItem { // Removido o "_" para seguir o padrão CamelCase do Java

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart; // O JPA mapeia o objeto, não apenas o ID

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private Long quantity;

    public void setCart(Cart cart) {
        this.cart = cart;

    }


    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
