package gencoders.e_tech_store_app.comment;

import gencoders.e_tech_store_app.blogPost.BlogPost;
import gencoders.e_tech_store_app.blogPost.BlogPostRepository;
import gencoders.e_tech_store_app.user.User;
import gencoders.e_tech_store_app.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CommentService {
    private final CommentRepository commentRepository;
    private final BlogPostRepository blogPostRepository;
    private final UserRepository userRepository;


    public Comment createComment(CommentDto dto) {
        BlogPost post = blogPostRepository.findById(dto.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setUser(user);
        comment.setContent(dto.getContent());
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comments not found"));
    }

    public Comment updateComment(Long id, CommentDto dto) {
        BlogPost post = blogPostRepository.findById(dto.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reviews not found"));
       comment.setPost(post);
        comment.setUser(user);
        comment.setContent(dto.getContent());
        return commentRepository.save(comment);
    }


    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
