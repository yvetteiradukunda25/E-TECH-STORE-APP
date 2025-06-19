package gencoders.e_tech_store_app.product;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Api/Product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/Api/create")
    public Product createProduct(@RequestBody ProductDto productDto) {
        Product product = new Product();
     product.setProduct_Name(productDto.getProduct_Name());
     product.setProduct_Type(productDto.getProduct_Type());
     product.setPrice(productDto.getPrice());
     product.setDiscount_price(productDto.getDiscount_price());
     product.setStock_quantity(productDto.getStock_quantity());
     product.setDescription(productDto.getDescription());
     product.setBrand(productDto.getBrand());
     product.setImage_Url(productDto.getImage_Url());
        return productService.createProduct(product);
    }


    @GetMapping
    public List<Product> findAllProduct() {
        return productService.findAllProduct();
    }

    @GetMapping("/api/{id}")
    public Product findProductById(@PathVariable long id) {
        return productService.findProductById(id);

    }

    public Product updateProduct(@PathVariable long id, @RequestBody ProductDto productDto) {
        Product product = productService.findProductById(id);
        product.setProduct_Name(productDto.getProduct_Name());
        product.setProduct_Type(productDto.getProduct_Type());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setDiscount_price(productDto.getDiscount_price());
        product.setStock_quantity(productDto.getStock_quantity());
        product.setDescription(productDto.getDescription());
        product.setImage_Url(productDto.getImage_Url());

        return productService.updateProduct(id, productDto);
    }

//   @DeleteMapping("/Api/{id}")
// public Product deleteProductById(@PathVariable long id) {
//       return productService.deleteProductById(id);
//   }
}
