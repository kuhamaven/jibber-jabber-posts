package group7.jibberjabber.posts.posts;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PostsRepository extends PagingAndSortingRepository<PostsModel,Integer> {
    Optional<PostsModel> findById(int id);
    Iterable<PostsModel> findAllByAuthor(String author);
    Iterable<PostsModel> findAll();

}
