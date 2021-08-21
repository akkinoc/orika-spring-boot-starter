package dev.akkinoc.spring.boot.orika

import dev.akkinoc.spring.boot.orika.test.MockOrikaMapperFactoryBuilderConfigurer
import dev.akkinoc.spring.boot.orika.test.MockOrikaMapperFactoryConfigurer
import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile

/**
 * The test context configuration.
 */
@SpringBootConfiguration(proxyBeanMethods = false)
@EnableAutoConfiguration
class OrikaTestConfiguration {

    /**
     * Provides the mock configurer for [MapperFactoryBuilder].
     *
     * @return The mock configurer for [MapperFactoryBuilder].
     */
    @Bean
    @Profile("test-mapper-factory-builder-configuration")
    fun mockOrikaMapperFactoryBuilderConfigurer1(): MockOrikaMapperFactoryBuilderConfigurer {
        return MockOrikaMapperFactoryBuilderConfigurer()
    }

    /**
     * Provides the mock configurer for [MapperFactoryBuilder].
     *
     * @return The mock configurer for [MapperFactoryBuilder].
     */
    @Bean
    @Profile("test-mapper-factory-builder-configuration")
    fun mockOrikaMapperFactoryBuilderConfigurer2(): MockOrikaMapperFactoryBuilderConfigurer {
        return MockOrikaMapperFactoryBuilderConfigurer()
    }

    /**
     * Provides the mock configurer for [MapperFactory].
     *
     * @return The mock configurer for [MapperFactory].
     */
    @Bean
    @Profile("test-mapper-factory-configuration")
    fun mockOrikaMapperFactoryConfigurer1(): MockOrikaMapperFactoryConfigurer {
        return MockOrikaMapperFactoryConfigurer()
    }

    /**
     * Provides the mock configurer for [MapperFactory].
     *
     * @return The mock configurer for [MapperFactory].
     */
    @Bean
    @Profile("test-mapper-factory-configuration")
    fun mockOrikaMapperFactoryConfigurer2(): MockOrikaMapperFactoryConfigurer {
        return MockOrikaMapperFactoryConfigurer()
    }

}
