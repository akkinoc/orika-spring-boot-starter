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
class MapperFactoryBuilderConfigurationTest {

    @Test
    fun `Configures the MapperFactoryBuilder`(
            @Autowired orikaMapperFactoryBuilder: MapperFactoryBuilder<*, *>,
            @Autowired mockOrikaMapperFactoryBuilderConfigurer1: MockOrikaMapperFactoryBuilderConfigurer,
            @Autowired mockOrikaMapperFactoryBuilderConfigurer2: MockOrikaMapperFactoryBuilderConfigurer,
    ) {
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
