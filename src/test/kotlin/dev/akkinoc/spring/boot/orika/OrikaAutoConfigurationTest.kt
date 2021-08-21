package dev.akkinoc.spring.boot.orika

import dev.akkinoc.spring.boot.orika.test.MockOrikaMapperFactoryBuilderConfigurer
import dev.akkinoc.spring.boot.orika.test.MockOrikaMapperFactoryConfigurer
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs
import ma.glasnost.orika.MapperFacade
import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.util.ReflectionTestUtils.getField

/**
 * Tests [OrikaAutoConfiguration].
 */
class OrikaAutoConfigurationTest {

    /**
     * Tests [OrikaAutoConfiguration] for the cases with the default configuration.
     */
    @Nested
    @SpringBootTest
    @ActiveProfiles("test")
    inner class DefaultConfigurationCase
    @Autowired
    constructor(
            private val orikaProperties: OrikaProperties?,
            private val orikaMapperFactoryBuilder: MapperFactoryBuilder<*, *>?,
            private val orikaMapperFactory: MapperFactory?,
            private val orikaMapperFacade: MapperFacade?,
    ) {

        @Test
        fun `orikaProperties - Provides the configuration properties`() {
            orikaProperties.shouldNotBeNull()
            orikaProperties.enabled.shouldBe(true)
            orikaProperties.useBuiltinConverters.shouldBeNull()
            orikaProperties.useAutoMapping.shouldBeNull()
            orikaProperties.mapNulls.shouldBeNull()
            orikaProperties.dumpStateOnException.shouldBeNull()
            orikaProperties.favorExtension.shouldBeNull()
            orikaProperties.captureFieldContext.shouldBeNull()
        }

        @Test
        fun `orikaMapperFactoryBuilder - Provides the MapperFactoryBuilder`() {
            orikaMapperFactoryBuilder.shouldNotBeNull()
            getField(orikaMapperFactoryBuilder, "useBuiltinConverters").shouldBe(true)
            getField(orikaMapperFactoryBuilder, "useAutoMapping").shouldBe(true)
            getField(orikaMapperFactoryBuilder, "mapNulls").shouldBe(true)
            getField(orikaMapperFactoryBuilder, "dumpStateOnException").shouldBe(false)
            getField(orikaMapperFactoryBuilder, "favorExtension").shouldBe(false)
            getField(orikaMapperFactoryBuilder, "captureFieldContext").shouldBe(false)
        }

        @Test
        fun `orikaMapperFactory - Provides the MapperFactory`() {
            orikaMapperFactory.shouldNotBeNull()
        }

        @Test
        fun `orikaMapperFacade - Provides the MapperFacade`() {
            orikaMapperFacade.shouldNotBeNull()
        }

    }

    /**
     * Tests [OrikaAutoConfiguration] for the cases that configures the configuration properties.
     */
    @Nested
    @SpringBootTest
    @ActiveProfiles("test", "test-properties-configuration")
    inner class PropertiesConfigurationCase
    @Autowired
    constructor(
            private val orikaProperties: OrikaProperties,
            private val orikaMapperFactoryBuilder: MapperFactoryBuilder<*, *>,
    ) {

        @Test
        fun `orikaProperties - Configures the configuration properties`() {
            orikaProperties.enabled.shouldBe(true)
            orikaProperties.useBuiltinConverters.shouldBe(false)
            orikaProperties.useAutoMapping.shouldBe(false)
            orikaProperties.mapNulls.shouldBe(false)
            orikaProperties.dumpStateOnException.shouldBe(true)
            orikaProperties.favorExtension.shouldBe(true)
            orikaProperties.captureFieldContext.shouldBe(true)
        }

        @Test
        fun `orikaMapperFactoryBuilder - Configures the MapperFactoryBuilder`() {
            getField(orikaMapperFactoryBuilder, "useBuiltinConverters").shouldBe(false)
            getField(orikaMapperFactoryBuilder, "useAutoMapping").shouldBe(false)
            getField(orikaMapperFactoryBuilder, "mapNulls").shouldBe(false)
            getField(orikaMapperFactoryBuilder, "dumpStateOnException").shouldBe(true)
            getField(orikaMapperFactoryBuilder, "favorExtension").shouldBe(true)
            getField(orikaMapperFactoryBuilder, "captureFieldContext").shouldBe(true)
        }

    }

    /**
     * Tests [OrikaAutoConfiguration] for the cases that configures the [MapperFactoryBuilder].
     */
    @Nested
    @SpringBootTest
    @ActiveProfiles("test", "test-mapper-factory-builder-configuration")
    inner class MapperFactoryBuilderConfigurationCase
    @Autowired
    constructor(
            private val orikaMapperFactoryBuilder: MapperFactoryBuilder<*, *>,
            @Qualifier("mockOrikaMapperFactoryBuilderConfigurer1")
            private val mockOrikaMapperFactoryBuilderConfigurer1: MockOrikaMapperFactoryBuilderConfigurer,
            @Qualifier("mockOrikaMapperFactoryBuilderConfigurer2")
            private val mockOrikaMapperFactoryBuilderConfigurer2: MockOrikaMapperFactoryBuilderConfigurer,
    ) {

        @Test
        fun `orikaMapperFactoryBuilder - Configures the MapperFactoryBuilder`() {
            mockOrikaMapperFactoryBuilderConfigurer1.configured.shouldBeSameInstanceAs(orikaMapperFactoryBuilder)
            mockOrikaMapperFactoryBuilderConfigurer2.configured.shouldBeSameInstanceAs(orikaMapperFactoryBuilder)
        }

    }

    /**
     * Tests [OrikaAutoConfiguration] for the cases that configures the [MapperFactory].
     */
    @Nested
    @SpringBootTest
    @ActiveProfiles("test", "test-mapper-factory-configuration")
    inner class MapperFactoryConfigurationCase
    @Autowired
    constructor(
            private val orikaMapperFactory: MapperFactory,
            @Qualifier("mockOrikaMapperFactoryConfigurer1")
            private val mockOrikaMapperFactoryConfigurer1: MockOrikaMapperFactoryConfigurer,
            @Qualifier("mockOrikaMapperFactoryConfigurer2")
            private val mockOrikaMapperFactoryConfigurer2: MockOrikaMapperFactoryConfigurer,
    ) {

        @Test
        fun `orikaMapperFactory - Configures the MapperFactory`() {
            mockOrikaMapperFactoryConfigurer1.configured.shouldBeSameInstanceAs(orikaMapperFactory)
            mockOrikaMapperFactoryConfigurer2.configured.shouldBeSameInstanceAs(orikaMapperFactory)
        }

    }

    /**
     * Tests [OrikaAutoConfiguration] for the cases that disables auto-configuration.
     */
    @Nested
    @SpringBootTest
    @ActiveProfiles("test", "test-disabling")
    inner class DisablingCase
    @Autowired
    constructor(
            private val orikaProperties: OrikaProperties?,
            private val orikaMapperFactoryBuilder: MapperFactoryBuilder<*, *>?,
            private val orikaMapperFactory: MapperFactory?,
            private val orikaMapperFacade: MapperFacade?,
    ) {

        @Test
        fun `orikaProperties - Does not provide the configuration properties`() {
            orikaProperties.shouldBeNull()
        }

        @Test
        fun `orikaMapperFactoryBuilder - Does not provide the MapperFactoryBuilder`() {
            orikaMapperFactoryBuilder.shouldBeNull()
        }

        @Test
        fun `orikaMapperFactory - Does not provide the MapperFactory`() {
            orikaMapperFactory.shouldBeNull()
        }

        @Test
        fun `orikaMapperFacade - Does not provide the MapperFacade`() {
            orikaMapperFacade.shouldBeNull()
        }

    }

}
