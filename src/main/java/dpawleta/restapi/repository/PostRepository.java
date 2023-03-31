package dpawleta.restapi.repository;

import dpawleta.restapi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByTitle(String title);

    @Query(value = "select * from post left join" +
            " comment on post.id = comment.post_id",
            nativeQuery = true)
    List<Post> findAllPosts();
}
