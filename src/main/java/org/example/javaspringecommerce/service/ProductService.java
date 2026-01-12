package org.example.javaspringecommerce.service;

import org.example.javaspringecommerce.domain.product.Product;
import org.example.javaspringecommerce.domain.user.User;
import org.example.javaspringecommerce.dto.product.ProductRequestDTO;
import org.example.javaspringecommerce.repository.ProductRepository;
import org.example.javaspringecommerce.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductService(ProductRepository productRepository,
                          UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public Product save(ProductRequestDTO dto) {

        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setAuthor(user);

        return productRepository.save(product);
    }
}
