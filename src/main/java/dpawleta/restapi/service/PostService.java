package dpawleta.restapi.service;

import dpawleta.restapi.model.Post;
import dpawleta.restapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {


    private final PostRepository postRepository;

    public List<Post> getPosts(){
        return postRepository.findAll();
    }

}