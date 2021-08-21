package dev.akkinoc.spring.boot.orika.test

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

    override fun configure(orikaMapperFactoryBuilder: MapperFactoryBuilder<*, *>) {
        check(configured == null) { "configured=$configured" }
        configured = orikaMapperFactoryBuilder
    }

}
