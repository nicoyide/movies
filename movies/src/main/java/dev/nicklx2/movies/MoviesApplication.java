package dev.nicklx2.movies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(UserRepo userDao){
		return args -> {
			String email = "test2@uuu.com";
			//Create a user
			User user = new User(email, "test2", "test2", 0123457, 1);
			//check if email is reapeat in DB
			userDao.findUserByEmail(email)
					.ifPresentOrElse(users -> {
						//print it if have
						System.out.println("already exists");
						System.out.println(users);
					}, () -> {
						//if not create new
						userDao.insert(user);
						System.out.println("add user");
					});
		};

	}


}
