package dpawleta.restapi.controller;

import dpawleta.restapi.model.Comment;
import dpawleta.restapi.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comments/{id}")
    public Comment getSingleComment(@PathVariable long id){
        return commentService.getSingleComment(id);
    }

    @GetMapping("/comments")
    public List<Comment> getComments(@RequestParam(required = false) Sort.Direction sort){
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return commentService.getComments(sortDirection);
    }

    @PostMapping("/comments")
    public Comment addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @PutMapping("/comments")
    public Comment editComment(@RequestBody Comment comment){
        return commentService.editComment(comment);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable long id){
        commentService.deleteComment(id);
    }
}