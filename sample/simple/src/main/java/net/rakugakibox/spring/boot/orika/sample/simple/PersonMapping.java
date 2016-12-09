package net.rakugakibox.spring.boot.orika.sample.simple;

import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

/**
 * The configuration of {@link PersonSource} and {@link PersonDestination} mapping.
 * {@link }OrikaMapperFactoryConfigurer}'s components are auto-detected
 * and the {@link OrikaMapperFactoryConfigurer#configure(MapperFactory)} method is called.
 */
@Component
public class PersonMapping implements OrikaMapperFactoryConfigurer {

    /** {@inheritDoc} */
    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(PersonSource.class, PersonDestination.class)
                .field("firstName", "givenName")
                .field("lastName", "sirName")
                .byDefault()
                .register();
    }

}
