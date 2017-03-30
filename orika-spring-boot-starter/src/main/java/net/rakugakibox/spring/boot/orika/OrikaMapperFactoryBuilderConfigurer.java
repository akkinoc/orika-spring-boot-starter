package net.rakugakibox.spring.boot.orika;

import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder;

/**
 * The interface to configure {@link MapperFactoryBuilder}.
 */
public interface OrikaMapperFactoryBuilderConfigurer {

    /**
     * Configures the {@link MapperFactoryBuilder}.
     *
     * @param orikaMapperFactoryBuilder the {@link MapperFactoryBuilder}.
     */
    void configure(MapperFactoryBuilder<?, ?> orikaMapperFactoryBuilder);

}
