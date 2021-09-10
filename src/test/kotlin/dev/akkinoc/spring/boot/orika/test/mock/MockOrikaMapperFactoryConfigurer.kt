package dev.akkinoc.spring.boot.orika.test.mock

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
        private set

    override fun configure(orikaMapperFactory: MapperFactory) {
        check(configured == null) { "MockOrikaMapperFactoryConfigurer is already configured: $this" }
        configured = orikaMapperFactory
    }

}
