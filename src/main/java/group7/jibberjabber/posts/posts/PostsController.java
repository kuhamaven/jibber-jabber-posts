package group7.jibberjabber.posts.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/posts")
public class PostsController {
    private final PostsService postsService;
    @Autowired
    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostsModel> getPostsModel(@PathVariable Integer id){
        return new ResponseEntity<PostsModel>(this.postsService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity getPostsModel(){
        ArrayList<PostsModel> arrayList=new ArrayList<>();
        this.postsService.findAll().forEach(arrayList::add);
        return new ResponseEntity(arrayList,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity createPost(@RequestBody PostsModel postsModel){
        return new ResponseEntity(this.postsService.savePost(postsModel),HttpStatus.OK);
    }

    @GetMapping("/liked/{id}")
    public ResponseEntity getLikedPosts(@PathVariable String id){
        return new ResponseEntity(this.postsService.getAllLiked(id),HttpStatus.OK);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity getAuthorPosts(@PathVariable String id){
        return new ResponseEntity(this.postsService.getAuthorPosts(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePosts(@PathVariable String id){
        return new ResponseEntity(this.postsService.deletePost(id), HttpStatus.OK);
    }

    @PutMapping("/like")
    public ResponseEntity likePost(@RequestBody PostLike postLike){
        return new ResponseEntity(this.postsService.like(postLike),HttpStatus.OK);
    }

}
