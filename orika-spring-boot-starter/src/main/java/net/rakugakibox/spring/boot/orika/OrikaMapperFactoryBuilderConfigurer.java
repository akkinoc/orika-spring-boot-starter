package net.rakugakibox.spring.boot.orika;

import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder;

/**
 * The {@link MapperFactoryBuilder}'s configurer.
 */
public interface OrikaMapperFactoryBuilderConfigurer {

    /**
     * Configures the {@link MapperFactoryBuilder}.
     *
     * @param mapperFactoryBuilder the {@link MapperFactoryBuilder} to be configured.
     */
    void configure(MapperFactoryBuilder<?, ?> mapperFactoryBuilder);

}
