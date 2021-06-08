package group7.jibberjabber.posts.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostsService {
    private final PostsRepository postsRepository;
    @Autowired
    public PostsService(PostsRepository postsRepository){
        this.postsRepository=postsRepository;
    }

    public PostsModel findById(int id){
        return this.postsRepository.findById(id).orElseThrow(()->new RuntimeException("POST NOT FOUND"));
    }

    public List<PostsModel> findAll(){
        return this.postsRepository.findAll();
    }

    public List<PostsModel> findAllByAuthor(String author){
        return this.postsRepository.findAllByAuthor(author);
    }

    public PostsModel savePost(PostsModel postsModel){
        return this.postsRepository.save(postsModel);
    }


    public List<PostsModel> getAllLiked(String id) {
        return postsRepository.findAllByLikedBy(id);
    }

    public List<PostsModel> getAuthorPosts(String id) {
        return postsRepository.findAllByAuthorId(id);
    }

    public String deletePost(String id) {
        Optional<PostsModel> post = postsRepository.findById(id);
        if (post.isEmpty()) return null;
        postsRepository.delete(post.get());
        return id;
    }

    public PostsModel like(PostLike postLike) {
        Optional<PostsModel> post = postsRepository.findById(postLike.getPostId());
        if(post.isEmpty()) return null;
        List<String> likedBy = post.get().getLikedBy();
        likedBy.add(postLike.getUserId());
        post.get().setLikedBy(likedBy);
        return postsRepository.save(post.get());
    }
}
