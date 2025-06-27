package gencoders.e_tech_store_app.blogPost;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostDto {

    private String title;
    private String content;
    private String imageUrl;
//    private Long authorId;
}
