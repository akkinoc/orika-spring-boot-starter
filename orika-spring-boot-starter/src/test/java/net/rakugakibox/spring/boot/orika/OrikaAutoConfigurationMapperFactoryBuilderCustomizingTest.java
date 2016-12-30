package net.rakugakibox.spring.boot.orika;

import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The {@link OrikaAutoConfiguration}'s test cases when customize {@link MapperFactoryBuilder}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrikaAutoConfigurationMapperFactoryBuilderCustomizingTest {

    /**
     * The {@link MapperFactoryBuilder}.
     */
    @Autowired
    protected MapperFactoryBuilder<?, ?> orikaMapperFactoryBuilder;

    /**
     * The {@link MapperFactoryBuilder}'s configuration 1.
     */
    @Autowired
    @Qualifier("orikaMapperFactoryBuilderConfiguration1")
    protected OrikaMapperFactoryBuilderConfiguration orikaMapperFactoryBuilderConfiguration1;

    /**
     * The {@link MapperFactoryBuilder}'s configuration 2.
     */
    @Autowired
    @Qualifier("orikaMapperFactoryBuilderConfiguration2")
    protected OrikaMapperFactoryBuilderConfiguration orikaMapperFactoryBuilderConfiguration2;

    /**
     * Tests the {@link OrikaAutoConfiguration#orikaMapperFactoryBuilder()}.
     */
    @Test
    public void orikaMapperFactoryBuilder_configurerShouldBeCalled() {
        assertThat(orikaMapperFactoryBuilderConfiguration1.mapperFactoryBuilder).isSameAs(orikaMapperFactoryBuilder);
        assertThat(orikaMapperFactoryBuilderConfiguration2.mapperFactoryBuilder).isSameAs(orikaMapperFactoryBuilder);
    }

    /**
     * The context configuration.
     */
    @Configuration
    @EnableAutoConfiguration
    public static class ContextConfiguration {

        /**
         * Creates a {@link MapperFactoryBuilder}'s configuration 1.
         *
         * @return a {@link MapperFactoryBuilder}'s configuration 1.
         */
        @Bean
        public OrikaMapperFactoryBuilderConfiguration orikaMapperFactoryBuilderConfiguration1() {
            return new OrikaMapperFactoryBuilderConfiguration();
        }

        /**
         * Creates a {@link MapperFactoryBuilder}'s configuration 2.
         *
         * @return a {@link MapperFactoryBuilder}'s configuration 2.
         */
        @Bean
        public OrikaMapperFactoryBuilderConfiguration orikaMapperFactoryBuilderConfiguration2() {
            return new OrikaMapperFactoryBuilderConfiguration();
        }

    }

    /**
     * The {@link MapperFactoryBuilder}'s configuration.
     */
    public static class OrikaMapperFactoryBuilderConfiguration implements OrikaMapperFactoryBuilderConfigurer {

        /**
         * The {@link MapperFactoryBuilder}.
         */
        private MapperFactoryBuilder<?, ?> mapperFactoryBuilder;

        /** {@inheritDoc} */
        @Override
        public void configure(MapperFactoryBuilder<?, ?> mapperFactoryBuilder) {
            this.mapperFactoryBuilder = mapperFactoryBuilder;
        }

    }

}
