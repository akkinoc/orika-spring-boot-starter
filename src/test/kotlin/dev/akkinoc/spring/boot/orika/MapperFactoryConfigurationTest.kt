package dev.akkinoc.spring.boot.orika

import dev.akkinoc.spring.boot.orika.test.mock.MockOrikaMapperFactoryConfigurer
import io.kotest.matchers.types.shouldBeSameInstanceAs
import ma.glasnost.orika.MapperFactory
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

/**
 * Tests the case where the [MapperFactory] is configured.
 */
@SpringBootTest
class MapperFactoryConfigurationTest {

    @Test
    fun `Configures the MapperFactory`(
            @Autowired orikaMapperFactory: MapperFactory,
            @Autowired mockOrikaMapperFactoryConfigurer1: MockOrikaMapperFactoryConfigurer,
            @Autowired mockOrikaMapperFactoryConfigurer2: MockOrikaMapperFactoryConfigurer,
    ) {
        mockOrikaMapperFactoryConfigurer1.configured.shouldBeSameInstanceAs(orikaMapperFactory)
        mockOrikaMapperFactoryConfigurer2.configured.shouldBeSameInstanceAs(orikaMapperFactory)
    }

    @TestConfiguration(proxyBeanMethods = false)
    class MapperFactoryConfiguration {

        @Bean
        fun mockOrikaMapperFactoryConfigurer1(): MockOrikaMapperFactoryConfigurer {
            return MockOrikaMapperFactoryConfigurer()
        }

        @Bean
        fun mockOrikaMapperFactoryConfigurer2(): MockOrikaMapperFactoryConfigurer {
            return MockOrikaMapperFactoryConfigurer()
        }

    }

}
