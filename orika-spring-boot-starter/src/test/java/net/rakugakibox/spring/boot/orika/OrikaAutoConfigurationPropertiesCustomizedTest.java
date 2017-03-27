package net.rakugakibox.spring.boot.orika;

import ma.glasnost.orika.OrikaSystemProperties;
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * The test of {@link OrikaAutoConfiguration} when properties are customized.
 */
@RunWith(SpringRunner.class)
@SpringBootTest({
        "orika.useBuiltinConverters=false",
        "orika.useAutoMapping=false",
        "orika.mapNulls=false",
        "orika.dumpStateOnException=true",
        "orika.favorExtension=true",
        "orika.captureFieldContext=true"
})
public class OrikaAutoConfigurationPropertiesCustomizedTest {

    /**
     * The {@link MapperFactoryBuilder}.
     */
    @Autowired
    protected MapperFactoryBuilder<?, ?> orikaMapperFactoryBuilder;

    /**
     * Initializes Orika's default properties.
     */
    @BeforeClass
    public static void initializeOrikaDefaultProperties() {
        System.setProperty(OrikaSystemProperties.USE_BUILTIN_CONVERTERS, "true");
        System.setProperty(OrikaSystemProperties.USE_AUTO_MAPPING, "true");
        System.setProperty(OrikaSystemProperties.MAP_NULLS, "true");
        System.setProperty(OrikaSystemProperties.DUMP_STATE_ON_EXCEPTION, "false");
        System.setProperty(OrikaSystemProperties.FAVOR_EXTENSION, "false");
        System.setProperty(OrikaSystemProperties.CAPTURE_FIELD_CONTEXT, "false");
    }

    /**
     * Clears Orika's default properties.
     */
    @AfterClass
    public static void clearOrikaDefaultProperties() {
        System.clearProperty(OrikaSystemProperties.USE_BUILTIN_CONVERTERS);
        System.clearProperty(OrikaSystemProperties.USE_AUTO_MAPPING);
        System.clearProperty(OrikaSystemProperties.MAP_NULLS);
        System.clearProperty(OrikaSystemProperties.DUMP_STATE_ON_EXCEPTION);
        System.clearProperty(OrikaSystemProperties.FAVOR_EXTENSION);
        System.clearProperty(OrikaSystemProperties.CAPTURE_FIELD_CONTEXT);
    }

    /**
     * Tests the {@link MapperFactoryBuilder}.
     */
    @Test
    public void orikaMapperFactoryBuilder() {
        assertThat(orikaMapperFactoryBuilder)
                .hasFieldOrPropertyWithValue("useBuiltinConverters", false)
                .hasFieldOrPropertyWithValue("useAutoMapping", false)
                .hasFieldOrPropertyWithValue("mapNulls", false)
                .hasFieldOrPropertyWithValue("dumpStateOnException", true)
                .hasFieldOrPropertyWithValue("favorExtension", true)
                .hasFieldOrPropertyWithValue("captureFieldContext", true);
    }

    /**
     * The context configuration.
     */
    @Configuration
    @EnableAutoConfiguration
    public static class ContextConfiguration {
    }

}
