package spring.boot.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

@SpringBootApplication
public class SpringBootConfig{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfig.class, args);
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(new MongoClient("localhost:27017"), "student_db");
	}
}
