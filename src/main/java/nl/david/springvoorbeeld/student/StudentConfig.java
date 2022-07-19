package nl.david.springvoorbeeld.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student miriam = new Student(
                    1L,
                    "miriam",
                    "mail",
                    LocalDate.now(),
                    21
            );

            Student alex = new Student(
                    "alex",
                    "mail",
                    LocalDate.now(),
                    21
            );

            repository.saveAll(List.of(miriam, alex));
        };
    }
}
