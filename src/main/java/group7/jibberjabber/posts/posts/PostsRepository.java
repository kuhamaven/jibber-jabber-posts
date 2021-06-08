package group7.jibberjabber.posts.posts;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
@Repository
public interface PostsRepository extends PagingAndSortingRepository<PostsModel,Integer> {
    Optional<PostsModel> findById(String id);
    List<PostsModel> findAllByAuthor(String author);
    List<PostsModel> findAllByAuthorId(String authorId);
    List<PostsModel> findAllByLikedBy(String id);
    List<PostsModel> findAll();

}
