package in.sp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ThinkHumbleTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThinkHumbleTaskApplication.class, args);
	}

}
