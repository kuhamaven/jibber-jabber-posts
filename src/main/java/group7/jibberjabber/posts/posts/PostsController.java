package group7.jibberjabber.posts.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<PostDto> getPostsModel(){
        return this.postsService.findAll();
    }

    @PostMapping()
    public PostsModel createPost(@RequestBody PostsModel postsModel){
        return this.postsService.savePost(postsModel);
    }

    @GetMapping("/liked/{id}")
    public List<PostDto> getLikedPosts(@PathVariable String id){
        return this.postsService.getAllLiked(id);
    }

    @GetMapping("/author/{id}")
    public List<PostDto> getAuthorPosts(@PathVariable String id){
        return this.postsService.getAuthorPosts(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePosts(@PathVariable String id){
        return this.postsService.deletePost(id);
    }

    @PutMapping("/like")
    public PostDto likePost(@RequestBody PostLike postLike){
        return this.postsService.like(postLike);
    }

    @GetMapping("/timeline")
    public List<PostDto> timeline(@RequestBody FollowedDto followedDto){
        return this.postsService.timeline(followedDto);
    }
}
