package gencoders.e_tech_store_app.blogPost;


import gencoders.e_tech_store_app.reviews.Reviews;
import gencoders.e_tech_store_app.reviews.ReviewsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blogPost")
public class BlogPostController {
    private final BlogPostService blogPostService;

    @PostMapping("/create")
    public BlogPost create(@RequestBody BlogPostDto dto) {
        return blogPostService.createBlogPost(dto);
    }

    @GetMapping
    public List<BlogPost> getAll() {
        return blogPostService.getAllPosts();
    }


    @GetMapping("/{id}")
    public BlogPost getById(@PathVariable Long id) {
        return blogPostService.getPostById(id);
    }

    @PutMapping("/update/{id}")
    public BlogPost update(@PathVariable Long id, @RequestBody BlogPostDto dto) {
        return blogPostService.updatePost(id, dto);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        blogPostService.deletePost(id);
    }
}
