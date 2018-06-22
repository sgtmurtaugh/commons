package de.ckraus.commons.mapper;

import org.apache.commons.lang3.StringUtils;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;
import java.util.Locale;

@SuppressWarnings({ "javadoc", "unused" })
public interface ITemporalTypeMapper<E extends Temporal>
    extends ITypeMapper<E> {

    /**
     * map
     * @param s
     * @param formatter
     * @return
     */
    default E map(
            String s,
            DateTimeFormatter formatter
    ) {
        return this.map(
                s,
                formatter,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param s
     * @param formatter
     * @param defaultValue
     * @return
     */
    E map(
            String s,
            DateTimeFormatter formatter,
            E defaultValue
    );

    /**
     * map
     * @param s
     * @param formatStyle
     * @return
     */
    default E map(
            String s,
            FormatStyle formatStyle
    ) {
        return this.map(
                s,
                formatStyle,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param s
     * @param formatStyle
     * @param defaultValue
     * @return
     */
    E map(
            String s,
            FormatStyle formatStyle,
            E defaultValue
    );

    /**
     * map
     * @param s
     * @param sPattern
     * @return
     */
    default E map(
            String s,
            String sPattern
    ) {
        return this.map(
                s,
                sPattern,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param s
     * @param sPattern
     * @param defaultValue
     * @return
     */
    default E map(
            String s,
            String sPattern,
            E defaultValue
    ) {
        return this.map(
                s,
                sPattern,
                null,
                defaultValue
        );
    }

    /**
     * map
     * @param s
     * @param sPattern
     * @param locale
     * @return
     */
    default E map(
            String s,
            String sPattern,
            Locale locale
    ) {
        return this.map(
                s,
                sPattern,
                locale,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param s
     * @param sPattern
     * @param locale
     * @param defaultValue
     * @return
     */
    default E map(
            String s,
            String sPattern,
            Locale locale,
            E defaultValue
    ) {
        DateTimeFormatter formatter = null;

        if (StringUtils.isNotEmpty(sPattern)) {
            try {
                if (null == locale) {
                    formatter = DateTimeFormatter.ofPattern(sPattern);
                }
                else {
                    formatter = DateTimeFormatter.ofPattern(
                            sPattern,
                            locale
                    );
                }
            }
            catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        return this.map(
                s,
                formatter,
                defaultValue
        );
    }

}
