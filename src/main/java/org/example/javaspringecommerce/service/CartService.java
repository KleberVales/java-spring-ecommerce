package org.example.javaspringecommerce.service;

import org.example.javaspringecommerce.domain.carts.CartItem;
import org.example.javaspringecommerce.domain.carts.Cart;
import org.example.javaspringecommerce.domain.product.Product;
import org.example.javaspringecommerce.dto.cart.CartRequestDTO;
import org.example.javaspringecommerce.repository.CartRepository;
import org.example.javaspringecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private CartRepository cartRepository;
    private ProductRepository productRepository;

    public CartService(CartRepository cartRepository,  ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    //             Save Operation
    public CartItem create(CartRequestDTO dto) {
        CartItem cartItem = new CartItem();

        Product product = productRepository.findById(dto.getProduct_id())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Cart cart = new Cart();

        cartItem.setProduct(product);
        cartItem.setQuantity(dto.getQuantity());
        cartItem.setCart(cart);

        cart.getItem().add(cartItem);

        cartRepository.save(cart);

        return cartItem;
    }




}
