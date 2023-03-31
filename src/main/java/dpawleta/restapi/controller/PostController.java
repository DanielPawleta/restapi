package dpawleta.restapi.controller;

import dpawleta.restapi.model.Post;
import dpawleta.restapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getPosts(){
        throw new IllegalArgumentException("Not implemented yet");
    }

    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable long id){
        throw new IllegalArgumentException("Not implemented yet");
    }
}