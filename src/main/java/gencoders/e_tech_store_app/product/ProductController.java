package gencoders.e_tech_store_app.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Api/Product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public Product create(@RequestBody ProductDto Dto) {
        return productService.createProduct(Dto);
    }


    @GetMapping
    public List<Product> findAllProduct() {
        return productService.findAllProduct();
    }

    @GetMapping("/api/{id}")
    public Product findProductById(@PathVariable long id) {
        return productService.findProductById(id);

    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable Long id, @RequestBody ProductDto dto) {
        return productService.updateProduct(id, dto);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable long id) {
        productService.deleteProductById(id);
    }
}
