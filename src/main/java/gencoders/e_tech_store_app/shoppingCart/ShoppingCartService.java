package gencoders.e_tech_store_app.shoppingCart;

import gencoders.e_tech_store_app.cartItem.CartItem;
import gencoders.e_tech_store_app.cartItem.CartItemRepository;
import gencoders.e_tech_store_app.user.User;
import gencoders.e_tech_store_app.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;

    public ShoppingCart createShoppingCart(ShoppingCartDto dto) {
        CartItem cartItem = cartItemRepository.findById(dto.getCartItemId())
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
    return shoppingCartRepository.save(shoppingCart);
    }
}
