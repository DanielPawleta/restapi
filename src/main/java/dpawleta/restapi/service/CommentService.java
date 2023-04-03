package dpawleta.restapi.service;

import dpawleta.restapi.exceptions.IllegalJsonBodyException;
import dpawleta.restapi.model.Comment;
import dpawleta.restapi.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment getSingleComment(long id) {
        return commentRepository.findById(id)
                .orElseThrow();
    }

    public List<Comment> getComments(Sort.Direction direction) {
        return commentRepository.findAll(Sort.by(direction, "created"));
    }

    public Comment addComment(Comment comment) {
        if (comment.getId() == 0L)  {
            return commentRepository.save(comment);
        } else {
            throw new IllegalJsonBodyException("Id specified in Json body");
        }
    }

    @Transactional
    public Comment editComment(Comment comment) {
        Comment commentEdited = commentRepository.findById(comment.getId()).orElseThrow();
        commentEdited.setContent(comment.getContent());
        return commentEdited;
    }

    @Transactional
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }
}