package org.example.javaspringecommerce.repository;

import org.example.javaspringecommerce.domain.carts.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
