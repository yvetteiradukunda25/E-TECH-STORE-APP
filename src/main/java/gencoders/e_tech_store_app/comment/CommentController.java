package gencoders.e_tech_store_app.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/create")
    public Comment create(@RequestBody CommentDto dto) {
        return commentService.createComment(dto);
    }

    @GetMapping
    public List<Comment> getAll() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @PutMapping("/update/{id}")
    public Comment update(@PathVariable Long id, @RequestBody CommentDto dto) {
        return commentService.updateComment(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

}
