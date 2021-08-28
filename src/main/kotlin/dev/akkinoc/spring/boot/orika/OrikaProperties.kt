package dev.akkinoc.spring.boot.orika

import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

/**
 * The configuration properties for Orika.
 *
 * @property enabled
 *  Whether to enable auto-configuration.
 * @property useBuiltinConverters
 *  Whether to use built-in converters.
 *  See also [MapperFactoryBuilder.useBuiltinConverters].
 *  By default, follows Orika's behavior.
 * @property useAutoMapping
 *  Whether to use auto-mapping.
 *  See also [MapperFactoryBuilder.useAutoMapping].
 *  By default, follows Orika's behavior.
 * @property mapNulls
 *  Whether to map nulls.
 *  See also [MapperFactoryBuilder.mapNulls].
 *  By default, follows Orika's behavior.
 * @property dumpStateOnException
 *  Whether to dump the current state of the mapping infrastructure objects
 *  upon occurrence of an exception while mapping.
 *  See also [MapperFactoryBuilder.dumpStateOnException].
 *  By default, follows Orika's behavior.
 * @property favorExtension
 *  Whether to favor extension by default in registered class-maps.
 *  See also [MapperFactoryBuilder.favorExtension].
 *  By default, follows Orika's behavior.
 * @property captureFieldContext
 *  Whether full field context should be captured.
 *  See also [MapperFactoryBuilder.captureFieldContext].
 *  By default, follows Orika's behavior.
 */
@ConfigurationProperties("orika")
@ConstructorBinding
data class OrikaProperties(
        val enabled: Boolean = true,
        val useBuiltinConverters: Boolean? = null,
        val useAutoMapping: Boolean? = null,
        val mapNulls: Boolean? = null,
        val dumpStateOnException: Boolean? = null,
        val favorExtension: Boolean? = null,
        val captureFieldContext: Boolean? = null,
)
