package group7.jibberjabber.posts.posts;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
@Data
public class PostsModel {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(nullable = false)
    private String id;

    private String body;

    private String author;

    @CreationTimestamp
    LocalDateTime timeRecorded;

    @ElementCollection
    private List<String> likedBy;

    private String authorId;

    public PostsModel( String body, String author, String authorId) {
        this.body = body;
        this.author = author;
        this.authorId = authorId;
        likedBy = new ArrayList<>();
    }

    public PostsModel() {
        likedBy = new ArrayList<>();
    }
}
