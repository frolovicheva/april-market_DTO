package ru.geekbrains.april.market.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.april.market.dtos.CartDto;
import ru.geekbrains.april.market.dtos.ProductDto;
import ru.geekbrains.april.market.utils.Cart;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {
    private final Cart cart;

    @GetMapping
    public CartDto getCartDto(Cart cart){
        return new CartDto(cart);
    }
    @GetMapping("/add/{id}")
    public void addToCart(@RequestParam Long id) {
      cart.addProductDto (id);
    }

    @GetMapping("/remove/{id}")
    public void removeFromCart(@RequestParam Long id) {
        cart.removeProductDto (id);
    }

    @GetMapping("/clear")
    public void clearCart() {
        cart.clearAllProductDtos ();
    }
}
