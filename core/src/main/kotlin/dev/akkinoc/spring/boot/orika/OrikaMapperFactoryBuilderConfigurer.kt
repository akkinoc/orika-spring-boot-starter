package dev.akkinoc.spring.boot.orika

import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder

/**
 * The interface to configure [MapperFactoryBuilder].
 */
interface OrikaMapperFactoryBuilderConfigurer {

    /**
     * Configures the [MapperFactoryBuilder].
     *
     * @param orikaMapperFactoryBuilder The [MapperFactoryBuilder].
     */
    fun configure(orikaMapperFactoryBuilder: MapperFactoryBuilder<*, *>)

}
