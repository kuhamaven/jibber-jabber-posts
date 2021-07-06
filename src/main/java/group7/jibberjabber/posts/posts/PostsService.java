package group7.jibberjabber.posts.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<PostDto> findAll(){
        List<PostDto> list = postsRepository.findAll().stream().map(PostDto::toDto).collect(Collectors.toList());
        return list;
    }

    public List<PostsModel> findAllByAuthor(String author){
        return this.postsRepository.findAllByAuthor(author);
    }

    public PostsModel savePost(PostsModel postsModel){
        return this.postsRepository.save(postsModel);
    }


    public List<PostDto> getAllLiked(String id) {
        List<PostDto> list = postsRepository.findAllByLikedBy(id).stream().map(PostDto::toDto).collect(Collectors.toList());
        list.sort(Comparator.comparing(PostDto::getTimeRecorded).reversed());
        return list;
    }

    public List<PostDto> getAuthorPosts(String id) {
        List<PostDto> list = postsRepository.findAllByAuthorId(id).stream().map(PostDto::toDto).collect(Collectors.toList());
        list.sort(Comparator.comparing(PostDto::getTimeRecorded).reversed());
        return list;
    }

    public String deletePost(String id) {
        Optional<PostsModel> post = postsRepository.findById(id);
        if (post.isEmpty()) return null;
        postsRepository.delete(post.get());
        return id;
    }

    public PostDto like(PostLike postLike) {
        Optional<PostsModel> post = postsRepository.findById(postLike.getPostId());
        if(post.isEmpty()) return null;
        List<String> likedBy = post.get().getLikedBy();
        if (likedBy.contains(postLike.getUserId())) {
            likedBy.remove(postLike.getUserId());
        } else likedBy.add(postLike.getUserId());
        post.get().setLikedBy(likedBy);
        return PostDto.toDto(postsRepository.save(post.get()));
    }

    public List<PostDto> timeline(FollowedDto followedDto) {
        List<PostsModel> timeline = new ArrayList<>();
        for (int i = 0; i <followedDto.getFollowed().size() ; i++) {
            timeline.addAll(postsRepository.findAllByAuthorId(followedDto.getFollowed().get(i)));
        }
        timeline.sort(Comparator.comparing(PostsModel::getTimeRecorded).reversed());
        return timeline.stream().map(PostDto::toDto).collect(Collectors.toList());
    }
}
