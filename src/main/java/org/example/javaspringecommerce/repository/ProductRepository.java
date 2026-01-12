package org.example.javaspringecommerce.repository;

import org.example.javaspringecommerce.domain.product.Product;
import org.example.javaspringecommerce.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
