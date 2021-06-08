package group7.jibberjabber.posts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan("group7.jibberjabber.posts.posts")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
