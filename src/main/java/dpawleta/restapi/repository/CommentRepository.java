package dpawleta.restapi.repository;

import dpawleta.restapi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostIdIn(List<Long> ids);
    List<Comment> findAllByPostId(Long id);

    @Modifying
    @Query("delete from Comment c where c.id in ?1")
    void deleteCommentsWithIds(List<Long> ids);
}
