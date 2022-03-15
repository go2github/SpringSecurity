package SpringSecuritySpringData;

import SpringSecuritySpringData.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringSecuritySpringDataApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringSecuritySpringDataApplication.class, args);
    }
    @GetMapping("/welcome")
    private String welcome(){
        return "Api is running";
    }


}
