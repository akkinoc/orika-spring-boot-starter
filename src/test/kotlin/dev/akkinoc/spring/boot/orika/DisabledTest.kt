package dev.akkinoc.spring.boot.orika

import io.kotest.matchers.nulls.shouldBeNull
import ma.glasnost.orika.MapperFacade
import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/**
 * Tests the case where auto-configuration is disabled.
 */
@SpringBootTest(properties = ["orika.enabled=false"])
class DisabledTest
@Autowired
constructor(
        private val orikaProperties: OrikaProperties?,
        private val orikaMapperFactoryBuilder: MapperFactoryBuilder<*, *>?,
        private val orikaMapperFactory: MapperFactory?,
        private val orikaMapperFacade: MapperFacade?,
) {

    @Test
    fun `Does not provide the configuration properties`() {
        orikaProperties.shouldBeNull()
    }

    @Test
    fun `Does not provide the MapperFactoryBuilder`() {
        orikaMapperFactoryBuilder.shouldBeNull()
    }

    @Test
    fun `Does not provide the MapperFactory`() {
        orikaMapperFactory.shouldBeNull()
    }

    @Test
    fun `Does not provide the MapperFacade`() {
        orikaMapperFacade.shouldBeNull()
    }

}
