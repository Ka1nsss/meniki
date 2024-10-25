package kg.backend.meniki.service;

import kg.backend.meniki.model.Cart;
import kg.backend.meniki.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface CartItemService {
    Cart addItemToCart(Long userId, String productName, int quantity, double price, String description);
    void deleteItemFromCart(Long cartItemId);
    Optional<Cart> getCartByUserId(Long userId);

}
