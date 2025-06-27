package gencoders.e_tech_store_app.cartItem;

import gencoders.e_tech_store_app.product.Product;
import gencoders.e_tech_store_app.product.ProductRepository;
import gencoders.e_tech_store_app.shoppingCart.ShoppingCart;
import gencoders.e_tech_store_app.shoppingCart.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    public CartItem createCartItem(CartItemDto dto) {
        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ShoppingCart shoppingCart = shoppingCartRepository.findById(dto.getShoppingCartId())
                .orElseThrow(() -> new RuntimeException("Shopping Cart not found"));

        CartItem cartItem = new CartItem();
        cartItem.setShoppingCart(shoppingCart);
        cartItem.setProduct(product);
        cartItem.setQuantity(dto.getQuantity());
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> getAllItems() {
        return cartItemRepository.findAll();
    }

    public CartItem getItemById(Long id) {
        return cartItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    public CartItem updateItem(Long id, CartItemDto dto) {
        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ShoppingCart shoppingCart = shoppingCartRepository.findById(dto.getShoppingCartId())
                .orElseThrow(() -> new RuntimeException("Shopping Cart not found"));

       CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
         cartItem.setProduct(product);
         cartItem.setShoppingCart(shoppingCart);
         cartItem.setQuantity(dto.getQuantity());
         return cartItemRepository.save(cartItem);

    }

    public void deleteItem(Long id) {
        cartItemRepository.deleteById(id);
    }

}
