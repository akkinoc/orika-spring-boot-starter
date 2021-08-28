package example;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class App implements ApplicationRunner {

    private final MapperFacade orikaMapperFacade;

    @Override
    public void run(ApplicationArguments args) {

        // Maps from PersonSource to PersonDestination
        PersonSource src = new PersonSource("John", "Smith", 23);
        System.out.println(src);   // => "PersonSource(firstName=John, lastName=Smith, age=23)"
        PersonDestination dest = orikaMapperFacade.map(src, PersonDestination.class);
        System.out.println(dest);  // => "PersonDestination(givenName=John, sirName=Smith, age=23)"

    }

    public static void main(String... args) {
        SpringApplication.run(App.class, args);
    }

}
