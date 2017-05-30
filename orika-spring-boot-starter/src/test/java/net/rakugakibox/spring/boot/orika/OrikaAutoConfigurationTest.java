package net.rakugakibox.spring.boot.orika;

import java.util.Optional;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * The test of {@link OrikaAutoConfiguration}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrikaAutoConfigurationTest {

    /**
     * The configuration properties for Orika.
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
     * Tests the configuration properties for Orika.
     */
    @Test
    public void orikaProperties() {
        assertThat(orikaProperties).isPresent();
    }

    /**
     * Tests the {@link MapperFactoryBuilder}.
     */
    @Test
    public void orikaMapperFactoryBuilder() {
        assertThat(orikaMapperFactoryBuilder)
                .isPresent()
                .hasValueSatisfying(value ->
                    assertThat(value)
                            .hasFieldOrPropertyWithValue("useBuiltinConverters", true)
                            .hasFieldOrPropertyWithValue("useAutoMapping", true)
                            .hasFieldOrPropertyWithValue("mapNulls", true)
                            .hasFieldOrPropertyWithValue("dumpStateOnException", false)
                            .hasFieldOrPropertyWithValue("favorExtension", false)
                            .hasFieldOrPropertyWithValue("captureFieldContext", false)
                );
    }

    /**
     * Tests the {@link MapperFactory}.
     */
    @Test
    public void orikaMapperFactory() {
        assertThat(orikaMapperFactory).isPresent();
    }

    /**
     * Tests the {@link MapperFacade}.
     */
    @Test
    public void orikaMapperFacade() {
        assertThat(orikaMapperFacade).isPresent();
    }

    /**
     * The context configuration.
     */
    @EnableAutoConfiguration
    @Configuration
    public static class ContextConfiguration {
    }

}
