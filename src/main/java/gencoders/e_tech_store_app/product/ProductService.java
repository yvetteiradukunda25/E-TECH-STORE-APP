package gencoders.e_tech_store_app.product;


import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    public List<Product> findAllProduct() {

        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, ProductDto productDto) {
       Product product = productRepository.findById(id).orElse(null);new RuntimeException("User not found");
        product.setProduct_Name(productDto.getProduct_Name());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setDiscount_price(productDto.getDiscount_price());
       product.setStock_quantity(productDto.getStock_quantity());
       product.setBrand(productDto.getBrand());
       product.setImage_Url(productDto.getImage_Url());
        return productRepository.save(product);
    }
//
//    public Product deleteProductById(long id) {
//        Product product = productRepository.findById(id).orElseThrow(null);new RuntimeException("User not found");
//        return productRepository.deleteProductById(id);
//    }
}
