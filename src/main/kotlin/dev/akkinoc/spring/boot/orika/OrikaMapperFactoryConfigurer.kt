package dev.akkinoc.spring.boot.orika

import ma.glasnost.orika.MapperFactory

/**
 * The interface to configure [MapperFactory].
 */
interface OrikaMapperFactoryConfigurer {

    /**
     * Configures the [MapperFactory].
     *
     * @param orikaMapperFactory The [MapperFactory].
     */
    fun configure(orikaMapperFactory: MapperFactory)

}
