package dpawleta.restapi.controller;

import dpawleta.restapi.model.Post;
import dpawleta.restapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable long id){
        return postService.getSinglePost(id);
    }

    @GetMapping("/posts")
    public List<Post> getPosts(@RequestParam(required = false) Sort.Direction sort){
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return postService.getPosts(sortDirection);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post){
        return postService.addPost(post);
    }

    @PutMapping("/posts")
    public Post editPost(@RequestBody Post post){
        return postService.editPost(post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable long id){
        postService.deletePost(id);

    }
}