package org.example.javaspringecommerce.controller;

import org.example.javaspringecommerce.domain.carts.CartItem;
import org.example.javaspringecommerce.dto.cart.CartRequestDTO;
import org.example.javaspringecommerce.dto.cart.CartResponseDTO;
import org.example.javaspringecommerce.service.CartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public CartResponseDTO createCart(@RequestBody CartRequestDTO dto) {

        CartItem cartItem = cartService.create(dto);

        CartResponseDTO cartResponseDTO = new CartResponseDTO();

        cartResponseDTO.setId(cartItem.getId());
        cartResponseDTO.setQuantity(cartItem.getQuantity());

        return cartResponseDTO;
    }
}
