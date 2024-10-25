package kg.backend.meniki.controller;

import kg.backend.meniki.model.Cart;
import kg.backend.meniki.service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@AllArgsConstructor
@RequestMapping("/carts")
public class CartController {

    private final CartItemService cartItemService;

    @PostMapping("/addItemCart")
    public Cart addItemToCart(@PathVariable Long userId, @RequestParam String productName,
                              @RequestParam int quantity, @RequestParam double price,
                              @RequestParam String description) {
        return cartItemService.addItemToCart(userId, productName,
                quantity, price, description );
    }

    // Получение корзины пользователя
    @GetMapping("/user/{userId}")
    public Optional<Cart> getCartByUserId(@PathVariable Long userId) {
        return cartItemService.getCartByUserId(userId);
    }

    // Удаление товара из корзины
    @DeleteMapping("/delete/{cartItemId}")
    public void removeItemFromCart(@PathVariable Long cartItemId) {
        cartItemService.deleteItemFromCart(cartItemId);
    }
}




