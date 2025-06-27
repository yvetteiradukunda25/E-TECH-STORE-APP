package gencoders.e_tech_store_app.product;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductDto Dto) {
   Product product = new Product();
        product.setProduct_Name(Dto.getProduct_Name());
        product.setProduct_Type(Dto.getProduct_Type());
        product.setPrice(Dto.getPrice());
        product.setDiscount_price(Dto.getDiscount_price());
        product.setStock_quantity(Dto.getStock_quantity());
        product.setDescription(Dto.getDescription());
        product.setBrand(Dto.getBrand());
        product.setImage_Url(Dto.getImage_Url());
        return productRepository.save(product);
    }

    public List<Product> findAllProduct() {

        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, ProductDto productDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order ID " + id + " not found"));

        product.setProduct_Name(productDto.getProduct_Name());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setDiscount_price(productDto.getDiscount_price());
       product.setStock_quantity(productDto.getStock_quantity());
       product.setBrand(productDto.getBrand());
       product.setImage_Url(productDto.getImage_Url());
        return productRepository.save(product);
    }


    public void deleteProductById(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product ID " + id + " not found"));

        productRepository.delete(product);
    }
}
