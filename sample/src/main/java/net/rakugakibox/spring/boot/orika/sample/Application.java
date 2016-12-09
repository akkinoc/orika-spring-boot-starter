package net.rakugakibox.spring.boot.orika.sample;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The sample application.
 * Maps {@link PersonSource} to {@link PersonDestination}.
 */
@SpringBootApplication
@RequiredArgsConstructor
public class Application implements ApplicationRunner {

    /**
     * The Orika's mapper interface.
     * This object is managed by the Spring container.
     */
    private final MapperFacade mapperFacade;

    /** {@inheritDoc} */
    @Override
    public void run(ApplicationArguments args) {

        PersonSource source = new PersonSource();
        source.setFirstName("John");
        source.setLastName("Smith");
        source.setAge(23);

        PersonDestination destination = mapperFacade.map(source, PersonDestination.class);
        System.out.println(destination);  // => "PersonDestination(givenName=John, sirName=Smith, age=23)"

    }

    /**
     * The entry point of application.
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
