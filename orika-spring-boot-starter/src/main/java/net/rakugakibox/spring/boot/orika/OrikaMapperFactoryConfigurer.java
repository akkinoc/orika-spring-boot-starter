package net.rakugakibox.spring.boot.orika;

import ma.glasnost.orika.MapperFactory;

/**
 * The {@link MapperFactory}'s configurer.
 */
public interface OrikaMapperFactoryConfigurer {

    /**
     * Configures the {@link MapperFactory}.
     *
     * @param mapperFactory the {@link MapperFactory} to be configured.
     */
    void configure(MapperFactory mapperFactory);

}
