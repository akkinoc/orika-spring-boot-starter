package dev.akkinoc.spring.boot.orika

import dev.akkinoc.spring.boot.orika.test.MockOrikaMapperFactoryBuilderConfigurer
import io.kotest.matchers.types.shouldBeSameInstanceAs
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

/**
 * Tests the case where the [MapperFactoryBuilder] is configured.
 */
@SpringBootTest
class MapperFactoryBuilderConfigurationTest
@Autowired
constructor(
        private val orikaMapperFactoryBuilder: MapperFactoryBuilder<*, *>,
        private val mockOrikaMapperFactoryBuilderConfigurer1: MockOrikaMapperFactoryBuilderConfigurer,
        private val mockOrikaMapperFactoryBuilderConfigurer2: MockOrikaMapperFactoryBuilderConfigurer,
) {

    @Test
    fun `Configures the MapperFactoryBuilder`() {
        mockOrikaMapperFactoryBuilderConfigurer1.configured.shouldBeSameInstanceAs(orikaMapperFactoryBuilder)
        mockOrikaMapperFactoryBuilderConfigurer2.configured.shouldBeSameInstanceAs(orikaMapperFactoryBuilder)
    }

    @TestConfiguration(proxyBeanMethods = false)
    class MapperFactoryBuilderConfiguration {

        @Bean
        fun mockOrikaMapperFactoryBuilderConfigurer1(): MockOrikaMapperFactoryBuilderConfigurer {
            return MockOrikaMapperFactoryBuilderConfigurer()
        }

        @Bean
        fun mockOrikaMapperFactoryBuilderConfigurer2(): MockOrikaMapperFactoryBuilderConfigurer {
            return MockOrikaMapperFactoryBuilderConfigurer()
        }

    }

}
