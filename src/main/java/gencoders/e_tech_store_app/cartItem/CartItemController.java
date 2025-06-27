package gencoders.e_tech_store_app.cartItem;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cartItem")
public class CartItemController {
    private final CartItemService cartItemService;

    @PostMapping("/create")
    public CartItem create(@RequestBody CartItemDto dto) {
        return cartItemService.createCartItem(dto);
    }

    @GetMapping
    public List<CartItem> getAll() {
        return cartItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public CartItem getById(@PathVariable Long id) {
        return cartItemService.getItemById(id);
    }

    @PutMapping("/update/{id}")
    public CartItem update(@PathVariable Long id, @RequestBody CartItemDto dto) {
        return cartItemService.updateItem(id, dto);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        cartItemService.deleteItem(id);
    }
}
