package net.rakugakibox.spring.boot.orika;

import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * The {@link DefaultMapperFactory.Builder}'s configurer.
 */
public interface OrikaMapperFactoryBuilderConfigurer {

    /**
     * Configures the {@link DefaultMapperFactory.Builder}.
     *
     * @param mapperFactory the {@link DefaultMapperFactory.Builder} to be configured.
     */
    void configure(DefaultMapperFactory.Builder mapperFactory);

}
