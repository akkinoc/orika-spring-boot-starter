package dev.akkinoc.spring.boot.orika.test.mock

import dev.akkinoc.spring.boot.orika.OrikaMapperFactoryBuilderConfigurer
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder

/**
 * The mock configurer for [MapperFactoryBuilder].
 */
class MockOrikaMapperFactoryBuilderConfigurer : OrikaMapperFactoryBuilderConfigurer {

    /**
     * The configured [MapperFactoryBuilder].
     */
    var configured: MapperFactoryBuilder<*, *>? = null
        private set

    override fun configure(orikaMapperFactoryBuilder: MapperFactoryBuilder<*, *>) {
        check(configured == null) { "The MockOrikaMapperFactoryBuilderConfigurer is already configured: $this" }
        configured = orikaMapperFactoryBuilder
    }

}
