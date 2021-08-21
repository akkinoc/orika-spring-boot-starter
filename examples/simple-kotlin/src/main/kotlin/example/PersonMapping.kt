package example

import dev.akkinoc.spring.boot.orika.OrikaMapperFactoryConfigurer
import ma.glasnost.orika.MapperFactory
import org.springframework.stereotype.Component

@Component
class PersonMapping : OrikaMapperFactoryConfigurer {

    override fun configure(orikaMapperFactory: MapperFactory) {
        orikaMapperFactory.classMap(PersonSource::class.java, PersonDestination::class.java)
                .field("firstName", "givenName")
                .field("lastName", "sirName")
                .byDefault()
                .register()
    }

}
