package kg.backend.meniki.service.impl;

import kg.backend.meniki.model.Cart;

import kg.backend.meniki.model.CartItem;
import kg.backend.meniki.model.security.User;
import kg.backend.meniki.repo.CartItemRepository;
import kg.backend.meniki.repo.CartRepository;
import kg.backend.meniki.repo.UserRepository;
import kg.backend.meniki.service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartItemService {


    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;



    public Cart addItemToCart(Long userId, String productName, int quantity, double price, String description) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        // Получаем первую корзину пользователя или создаём новую
        Cart cart = user.getCarts().stream().findFirst().orElse(new Cart());
        cart.setUser(user);

        // Создаём новый товар и добавляем его в корзину
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProductName(productName);
        cartItem.setQuantity(quantity);
        cartItem.setPrice(price);
        cartItem.setDescription(description);

        cart.getCartItems().add(cartItem);  // Добавляем товар в корзину
        cartItemRepository.save(cartItem);  // Сохраняем товар
        return cartRepository.save(cart);   // Сохраняем обновлённую корзину
    }

    // Метод для получения корзины по id пользователя
    public Optional<Cart> getCartByUserId(Long userId) {
        return cartRepository.findAll().stream()
                .filter(cart -> cart.getUser().getId().equals(userId))
                .findFirst();
    }

    // Метод для удаления товара из корзины
    public void deleteItemFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

}

