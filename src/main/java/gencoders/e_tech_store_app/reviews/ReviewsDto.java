package gencoders.e_tech_store_app.reviews;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsDto {

    private Long userId;
    private Long productId;
    private Integer rating;
    private String comment;
}
