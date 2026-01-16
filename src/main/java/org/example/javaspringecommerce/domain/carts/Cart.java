package org.example.javaspringecommerce.domain.carts;

import jakarta.persistence.*;
import org.example.javaspringecommerce.domain.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento 1:1 com a entidade User
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    private User user;

    @Enumerated(EnumType.STRING)
    private CartStatus status;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();


    @PrePersist public void prePersist() {

        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = CartStatus.ACTIVE;
        }
    }

    private LocalDateTime created;


    public List<CartItem> getItem() {
        return items;
    }
}
