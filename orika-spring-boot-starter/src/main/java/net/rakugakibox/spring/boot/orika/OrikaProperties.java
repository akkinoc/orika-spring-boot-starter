package net.rakugakibox.spring.boot.orika;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The configuration properties for Orika.
 */
@Data
@ConfigurationProperties("orika")
public class OrikaProperties {

    /**
     * Whether to enable auto-configuration.
     */
    private boolean enabled = true;

    /**
     * Whether to use built-in converters (MapperFactoryBuilder#useBuiltinConverters(boolean)).
     * Follows Orika's behavior by default.
     */
    private Boolean useBuiltinConverters;

    /**
     * Whether to use auto-mapping (MapperFactoryBuilder#useAutoMapping(boolean)).
     * Follows Orika's behavior by default.
     */
    private Boolean useAutoMapping;

    /**
     * Whether to map null values (MapperFactoryBuilder#mapNulls(boolean)).
     * Follows Orika's behavior by default.
     */
    private Boolean mapNulls;

    /**
     * Whether to dump the current state of the mapping infrastructure objects
     * upon occurrence of an exception while mapping (MapperFactoryBuilder#dumpStateOnException(boolean)).
     * Follows Orika's behavior by default.
     */
    private Boolean dumpStateOnException;

    /**
     * Whether the class-map should be considered 'abstract' (MapperFactoryBuilder#favorExtension(boolean)).
     * Follows Orika's behavior by default.
     */
    private Boolean favorExtension;

    /**
     * Whether full field context should be captured (MapperFactoryBuilder#captureFieldContext(boolean)).
     * Follows Orika's behavior by default.
     */
    private Boolean captureFieldContext;

}
