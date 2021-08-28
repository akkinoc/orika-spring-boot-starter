package example;

import dev.akkinoc.spring.boot.orika.OrikaMapperFactoryConfigurer;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class PersonMapping implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory orikaMapperFactory) {
        orikaMapperFactory.classMap(PersonSource.class, PersonDestination.class)
                .field("firstName", "givenName")
                .field("lastName", "sirName")
                .byDefault()
                .register();
    }

}
