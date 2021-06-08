package group7.jibberjabber.posts.posts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostLike {
    private String postId;
    private String userId;
}
