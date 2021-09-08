package dev.akkinoc.spring.boot.orika

import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import ma.glasnost.orika.MapperFacade
import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.impl.DefaultMapperFactory
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.util.ReflectionTestUtils.getField

/**
 * Tests the case where the default configuration is used.
 */
@SpringBootTest
class DefaultConfigurationTest
@Autowired
constructor(
        private val orikaProperties: OrikaProperties?,
        private val orikaMapperFactoryBuilder: DefaultMapperFactory.MapperFactoryBuilder<*, *>?,
        private val orikaMapperFactory: MapperFactory?,
        private val orikaMapperFacade: MapperFacade?,
) {

    @Test
    fun `Provides the configuration properties`() {
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
    fun `Provides the MapperFactoryBuilder`() {
        orikaMapperFactoryBuilder.shouldNotBeNull()
        getField(orikaMapperFactoryBuilder, "useBuiltinConverters").shouldBe(true)
        getField(orikaMapperFactoryBuilder, "useAutoMapping").shouldBe(true)
        getField(orikaMapperFactoryBuilder, "mapNulls").shouldBe(true)
        getField(orikaMapperFactoryBuilder, "dumpStateOnException").shouldBe(false)
        getField(orikaMapperFactoryBuilder, "favorExtension").shouldBe(false)
        getField(orikaMapperFactoryBuilder, "captureFieldContext").shouldBe(false)
    }

    @Test
    fun `Provides the MapperFactory`() {
        orikaMapperFactory.shouldNotBeNull()
    }

    @Test
    fun `Provides the MapperFacade`() {
        orikaMapperFacade.shouldNotBeNull()
    }

}
