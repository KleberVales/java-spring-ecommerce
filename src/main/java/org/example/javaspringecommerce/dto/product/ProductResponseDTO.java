package org.example.javaspringecommerce.dto.product;

import org.example.javaspringecommerce.domain.product.Product;
import org.example.javaspringecommerce.domain.user.User;

import java.time.LocalDateTime;

public class ProductResponseDTO {

    private String id;
    private String name;
    private Double price;
    private User author;
    private LocalDateTime createdAt;

    private Product product;

    public ProductResponseDTO() {}

    public ProductResponseDTO(Product product) {
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
