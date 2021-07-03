package group7.jibberjabber.posts.posts;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private String id;
    private String body;
    private String author;
    LocalDateTime timeRecorded;
    private String authorId;
    private int likes;

    public static PostDto toDto(PostsModel model){
        return new PostDto(model.getId(), model.getBody(), model.getAuthor(), model.getTimeRecorded(), model.getAuthorId(), model.getLikedBy().size());
    }
}
