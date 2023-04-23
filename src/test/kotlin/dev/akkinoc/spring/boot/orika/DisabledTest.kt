package dev.akkinoc.spring.boot.orika

import io.kotest.matchers.nulls.shouldBeNull
import ma.glasnost.orika.MapperFacade
import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/**
 * Tests the case where autoconfiguration is disabled.
 */
@SpringBootTest(properties = ["orika.enabled=false"])
class DisabledTest {

    @Test
    fun `Does not provide the configuration properties for Orika`(@Autowired orikaProperties: OrikaProperties?) {
        orikaProperties.shouldBeNull()
    }

    @Test
    fun `Does not provide the MapperFactoryBuilder`(@Autowired orikaMapperFactoryBuilder: MapperFactoryBuilder<*, *>?) {
        orikaMapperFactoryBuilder.shouldBeNull()
    }

    @Test
    fun `Does not provide the MapperFactory`(@Autowired orikaMapperFactory: MapperFactory?) {
        orikaMapperFactory.shouldBeNull()
    }

    @Test
    fun `Does not provide the MapperFacade`(@Autowired orikaMapperFacade: MapperFacade?) {
        orikaMapperFacade.shouldBeNull()
    }

}
