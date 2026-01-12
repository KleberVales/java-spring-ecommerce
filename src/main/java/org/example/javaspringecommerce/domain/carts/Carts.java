package org.example.javaspringecommerce.domain.carts;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="carts")
public class Carts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user_id;

    private CartStatus status;

    private LocalDateTime created;


}
