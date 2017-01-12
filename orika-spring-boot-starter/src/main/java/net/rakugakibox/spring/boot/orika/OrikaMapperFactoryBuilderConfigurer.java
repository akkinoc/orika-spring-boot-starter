package net.rakugakibox.spring.boot.orika;

import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * The configurer of {@link DefaultMapperFactory.MapperFactoryBuilder}.
 */
public interface OrikaMapperFactoryBuilderConfigurer {

    /**
     * Configures the {@link DefaultMapperFactory.MapperFactoryBuilder}.
     *
     * @param mapperFactoryBuilder the {@link DefaultMapperFactory.MapperFactoryBuilder} to be configured.
     */
    void configure(DefaultMapperFactory.MapperFactoryBuilder<?, ?> mapperFactoryBuilder);

}
