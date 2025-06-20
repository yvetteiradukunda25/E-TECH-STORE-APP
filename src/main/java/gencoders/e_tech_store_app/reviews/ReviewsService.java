package gencoders.e_tech_store_app.reviews;

import gencoders.e_tech_store_app.product.Product;
import gencoders.e_tech_store_app.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewsService {
    private final ReviewsRepository reviewsRepository;
    private final ProductRepository productRepository;
//    private final UserRepository userRepository;

    public Reviews createReviews(ReviewsDto dto) {
        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Reviews reviews = new Reviews();
        reviews.setProduct(product);
        reviews.setComment(dto.getComment());
        reviews.setRating(dto.getRating());
        return reviewsRepository.save(reviews);
    }

    public List<Reviews> getAllReviews() {
        return reviewsRepository.findAll();
    }

    public Reviews getReviewsById(Long id) {
        return reviewsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reviews not found"));
    }

    public Reviews updateReviews(Long id, ReviewsDto dto) {
        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Reviews reviews = reviewsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reviews not found"));

        reviews.setProduct(product);
        reviews.setComment(dto.getComment());
        reviews.setRating(dto.getRating());
        return reviewsRepository.save(reviews);
    }

    public void deleteReviews(Long id) {
        reviewsRepository.deleteById(id);
    }
}
