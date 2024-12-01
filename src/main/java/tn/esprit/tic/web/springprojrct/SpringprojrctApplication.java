package tn.esprit.tic.web.springprojrct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringprojrctApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringprojrctApplication.class, args);
    }

}
