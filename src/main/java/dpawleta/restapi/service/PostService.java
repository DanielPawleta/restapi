package dpawleta.restapi.service;

import dpawleta.restapi.model.Comment;
import dpawleta.restapi.model.Post;
import dpawleta.restapi.repository.CommentRepository;
import dpawleta.restapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }

    public List<Post> getPosts(Sort.Direction direction) {
        List<Post> postList = postRepository.getPosts(Sort.by(direction, "created"));

        capitalizeSecondWord(postList);
        List<Long> ids = postList.stream()
                .map(post -> post.getId())
                .collect(Collectors.toList());

        List<Comment> comments = commentRepository.findAllByPostIdIn(ids);
        postList.forEach(post -> post.setCommentList(extractComments(comments, post.getId())));
        return postList;
    }

    private void capitalizeSecondWord(List<Post> postList) {
        postList.
                forEach(post -> post.setContent(capitalizeSecondWordInString(post.getContent())));
    }

    public String capitalizeSecondWordInString(String content) {
        String[] contentSplitToWords = content.split(" ");
        if (contentSplitToWords.length<2) return content;
        contentSplitToWords[1] = contentSplitToWords[1].substring(0,1).toUpperCase() +
                contentSplitToWords[1].substring(1);
        content = String.join(" ", contentSplitToWords);
        return content;
    }

    private List<Comment> extractComments(List<Comment> comments, long id) {
        return comments.stream()
                .filter(comment -> comment.getPostId() == id)
                .collect(Collectors.toList());
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Post editPost(Post post) {
        Post postEdited = postRepository.findById(post.getId()).orElseThrow();
        postEdited.setTitle(post.getTitle());
        postEdited.setContent(post.getContent());
        return postEdited;
    }

    @Transactional
    public void deletePost(long id) {
        List<Comment> comments = commentRepository.findAllByPostId(id);

        List<Long> ids = comments.stream()
                .map(Comment::getId)
                .collect(Collectors.toList());
        commentRepository.deleteCommentsWithIds(ids);
        postRepository.deleteById(id);
    }
}