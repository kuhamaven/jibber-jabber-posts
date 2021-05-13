package group7.jibberjabber.posts.posts;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
public class PostsModel {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    @Getter
    @Setter
    private String body;
    @Column
    @Getter
    @Setter
    private String author;

    public PostsModel( String body, String author) {
        this.body = body;
        this.author = author;
    }

    public PostsModel() {

    }
}
