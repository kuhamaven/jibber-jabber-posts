package group7.jibberjabber.posts.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public Iterable<PostsModel> findAll(){
        return this.postsRepository.findAll();
    }

    public Iterable<PostsModel> findAllByAuthor(String author){
        return this.postsRepository.findAllByAuthor(author);
    }

    public PostsModel savePost(PostsModel postsModel){
        return this.postsRepository.save(postsModel);
    }


}
