package net.rakugakibox.spring.boot.orika;

import java.util.Optional;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The {@link OrikaAutoConfiguration}'s beans test cases.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrikaAutoConfigurationBeansTest {

    /**
     * The auto-configuration properties for Orika.
     */
    @Autowired
    protected Optional<OrikaProperties> orikaProperties;

    /**
     * The {@link MapperFactoryBuilder}.
     */
    @Autowired
    protected Optional<MapperFactoryBuilder<?, ?>> orikaMapperFactoryBuilder;

    /**
     * The {@link MapperFactory}.
     */
    @Autowired
    protected Optional<MapperFactory> orikaMapperFactory;

    /**
     * The {@link MapperFacade}.
     */
    @Autowired
    protected Optional<MapperFacade> orikaMapperFacade;

    /**
     * Tests the {@link OrikaAutoConfiguration}'s configuration properties.
     */
    @Test
    public void orikaProperties_shouldBeCreated() {
        assertThat(orikaProperties).isPresent();
    }

    /**
     * Tests the {@link OrikaAutoConfiguration#orikaMapperFactoryBuilder()}.
     */
    @Test
    public void orikaMapperFactoryBuilder_shouldBeCreated() {
        assertThat(orikaMapperFactoryBuilder).isPresent();
    }

    /**
     * Tests the {@link OrikaAutoConfiguration#orikaMapperFactory(MapperFactoryBuilder)}.
     */
    @Test
    public void orikaMapperFactory_shouldBeCreated() {
        assertThat(orikaMapperFactory).isPresent();
    }

    /**
     * Tests the {@link OrikaAutoConfiguration#orikaMapperFacade(MapperFactory)}.
     */
    @Test
    public void orikaMapperFacade_shouldBeCreated() {
        assertThat(orikaMapperFacade).isPresent();
    }

    /**
     * The context configuration.
     */
    @Configuration
    @EnableAutoConfiguration
    public static class ContextConfiguration {
    }

}
