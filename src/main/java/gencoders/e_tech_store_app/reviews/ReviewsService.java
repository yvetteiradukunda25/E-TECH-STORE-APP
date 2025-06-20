package gencoders.e_tech_store_app.reviews;

import gencoders.e_tech_store_app.product.ProductRepository;
import gencoders.e_tech_store_app.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ReviewsService {
    private final ReviewsRepository reviewsRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

}
