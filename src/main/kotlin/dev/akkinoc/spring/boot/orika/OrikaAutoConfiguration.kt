package dev.akkinoc.spring.boot.orika

import ma.glasnost.orika.MapperFacade
import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.impl.DefaultMapperFactory
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * The auto-configuration for Orika.
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(prefix = "orika", name = ["enabled"], havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(OrikaProperties::class)
class OrikaAutoConfiguration {

    /**
     * Provides the [MapperFactoryBuilder].
     *
     * @param orikaProperties The configuration properties for Orika.
     * @param orikaMapperFactoryBuilderConfigurers The configurers for [MapperFactoryBuilder].
     * @return The [MapperFactoryBuilder].
     */
    @Bean
    @ConditionalOnMissingBean
    fun orikaMapperFactoryBuilder(
            orikaProperties: OrikaProperties,
            orikaMapperFactoryBuilderConfigurers: List<OrikaMapperFactoryBuilderConfigurer>,
    ): MapperFactoryBuilder<*, *> {
        val orikaMapperFactoryBuilder = DefaultMapperFactory.Builder()
        orikaProperties.useBuiltinConverters?.also { orikaMapperFactoryBuilder.useBuiltinConverters(it) }
        orikaProperties.useAutoMapping?.also { orikaMapperFactoryBuilder.useAutoMapping(it) }
        orikaProperties.mapNulls?.also { orikaMapperFactoryBuilder.mapNulls(it) }
        orikaProperties.dumpStateOnException?.also { orikaMapperFactoryBuilder.dumpStateOnException(it) }
        orikaProperties.favorExtension?.also { orikaMapperFactoryBuilder.favorExtension(it) }
        orikaProperties.captureFieldContext?.also { orikaMapperFactoryBuilder.captureFieldContext(it) }
        orikaMapperFactoryBuilderConfigurers.forEach { it.configure(orikaMapperFactoryBuilder) }
        log.debug("Providing the {}: {}", MapperFactoryBuilder::class.simpleName, orikaMapperFactoryBuilder)
        return orikaMapperFactoryBuilder
    }

    /**
     * Provides the [MapperFactory].
     *
     * @param orikaMapperFactoryBuilder The [MapperFactoryBuilder].
     * @param orikaMapperFactoryConfigurers The configurers for [MapperFactory].
     * @return The [MapperFactory].
     */
    @Bean
    @ConditionalOnMissingBean
    fun orikaMapperFactory(
            orikaMapperFactoryBuilder: MapperFactoryBuilder<*, *>,
            orikaMapperFactoryConfigurers: List<OrikaMapperFactoryConfigurer>,
    ): MapperFactory {
        val orikaMapperFactory = orikaMapperFactoryBuilder.build()
        orikaMapperFactoryConfigurers.forEach { it.configure(orikaMapperFactory) }
        log.debug("Providing the {}: {}", MapperFactory::class.simpleName, orikaMapperFactory)
        return orikaMapperFactory
    }

    /**
     * Provides the [MapperFacade].
     *
     * @param orikaMapperFactory The [MapperFactory].
     * @return The [MapperFacade].
     */
    @Bean
    @ConditionalOnMissingBean
    fun orikaMapperFacade(orikaMapperFactory: MapperFactory): MapperFacade {
        val orikaMapperFacade = orikaMapperFactory.mapperFacade
        log.debug("Providing the {}: {}", MapperFacade::class.simpleName, orikaMapperFacade)
        return orikaMapperFacade
    }

    companion object {

        /**
         * The logger.
         */
        private val log: Logger = getLogger(OrikaAutoConfiguration::class.java)

    }

}
