package dev.akkinoc.spring.boot.orika.test

import dev.akkinoc.spring.boot.orika.OrikaMapperFactoryConfigurer
import ma.glasnost.orika.MapperFactory

/**
 * The mock configurer for [MapperFactory].
 */
class MockOrikaMapperFactoryConfigurer : OrikaMapperFactoryConfigurer {

    /**
     * The configured [MapperFactory].
     */
    var configured: MapperFactory? = null

    override fun configure(orikaMapperFactory: MapperFactory) {
        check(configured == null) { "configured=$configured" }
        configured = orikaMapperFactory
    }

}
