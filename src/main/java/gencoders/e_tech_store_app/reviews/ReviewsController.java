package gencoders.e_tech_store_app.reviews;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewsController {
    private final ReviewsService reviewsService;


    @PostMapping("/create")
    public Reviews create(@RequestBody ReviewsDto dto) {
        return reviewsService.createReviews(dto);
    }

    @GetMapping
    public List<Reviews> getAll() {
        return reviewsService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Reviews getById(@PathVariable Long id) {
        return reviewsService.getReviewsById(id);
    }

    @PutMapping("/update/{id}")
    public Reviews update(@PathVariable Long id, @RequestBody ReviewsDto dto) {
        return reviewsService.updateReviews(id, dto);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        reviewsService.deleteReviews(id);
    }
}
