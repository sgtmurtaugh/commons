package de.ckraus.commons.mapper;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;
import java.util.Map;

@SuppressWarnings({"javadoc", "unused"})
public interface INumericTypeMapper<E extends Number>
    extends ITypeMapper<E> {

    /**
     * getDecimalFormat
     * @return a DecimalFormat using the current locale
     */
    default DecimalFormat getDecimalFormat() {
        return this.getDecimalFormat( (Locale) null );
    }

    /**
     * getDecimalFormat
     * @param locale the locale to use for the format
     * @return a DecimalFormat using the given locale
     */
    default DecimalFormat getDecimalFormat (Locale locale) {
        return this.getDecimalFormat(
                locale,
                null
        );
    }

    /**
     * getDecimalFormat
     * @param locale the locale to use for the format
     * @param sPattern a non-localized pattern string.
     * @return a DecimalFormat using the given locale and pattern string.
     */
    default DecimalFormat getDecimalFormat (
            Locale locale,
            String sPattern
    ) {
        return this.getDecimalFormat(
                locale,
                sPattern,
                null
        );
    }

    /**
     * getDecimalFormat
     * @param sPattern a non-localized pattern string.
     * @return a DecimalFormat using the current locale and the given pattern string.
     */
    default DecimalFormat getDecimalFormat ( String sPattern ) {
        return this.getDecimalFormat(
                null,
                sPattern,
                null
        );
    }

    /**
     * getDecimalFormat
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @return a DecimalFormat using the current locale and the given pattern string and DecimalFormatSymbols.
     */
    default DecimalFormat getDecimalFormat (
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        return this.getDecimalFormat(
                null,
                sPattern,
                decimalFormatSymbols
        );
    }

    /**
     * getDecimalFormat
     * @param locale the locale to use for the format
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @return a DecimalFormat using the given params
     */
    default DecimalFormat getDecimalFormat (
            Locale locale,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        DecimalFormat decimalFormat;

        if ( null == locale ) {
            decimalFormat = (DecimalFormat) DecimalFormat.getInstance();
        }
        else {
            decimalFormat = (DecimalFormat) DecimalFormat.getInstance(locale);
        }

        if (StringUtils.isNotEmpty(sPattern)) {
            decimalFormat.applyPattern(sPattern);
        }

        if ( null != decimalFormatSymbols ) {
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        }
        return decimalFormat;
    }

    /**
     * map
     * @param map parameter map
     * @param key map access key
     * @param locale the locale to use for the format.
     * @return
     */
    default E map(
            Map<String, ?> map,
            String key,
            Locale locale
    ) {
        return this.map(
                map,
                key,
                locale,
                (String) null
        );
    }

    /**
     * map
     * @param map parameter map
     * @param key map access key
     * @param sPattern a non-localized pattern string.
     * @return
     */
    default E map(
            Map<String, ?> map,
            String key,
            String sPattern
    ) {
        return this.map(
                map,
                key,
                null,
                sPattern
        );
    }

    /**
     * map
     * @param map parameter map
     * @param key map access key
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @return
     */
    default E map(
            Map<String, ?> map,
            String key,
            Locale locale,
            String sPattern
    ) {
        return this.map(
                map,
                key,
                locale,
                sPattern,
                (DecimalFormatSymbols) null
        );
    }

    /**
     * map
     * @param map parameter map
     * @param key map access key
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @return
     */
    default E map(
            Map<String, ?> map,
            String key,
            Locale locale,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        return this.map(
                map,
                key,
                locale,
                sPattern,
                decimalFormatSymbols,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param map parameter map
     * @param key map access key
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @return
     */
    default E map(
            Map<String, ?> map,
            String key,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        return this.map(
                map,
                key,
                null,
                sPattern,
                decimalFormatSymbols
        );
    }

    /**
     * map
     * @param map parameter map
     * @param key map access key
     * @param defaultValue default value used, when the given map is null, the key cannot be found in map, or the map
     *                    value cannot be mapped to Number type
     * @return
     */
    default E map(
            Map<String, ?> map,
            String key,
            E defaultValue
    ) {
        return this.map(
                map,
                key,
                (Locale) null,
                defaultValue
        );
    }

    /**
     * map
     * @param map parameter map
     * @param key map access key
     * @param locale the locale to use for the format.
     * @param defaultValue default value used, when the given map is null, the key cannot be found in map, or the map
     *                    value cannot be mapped to Number type
     * @return
     */
    default E map(
            Map<String, ?> map,
            String key,
            Locale locale,
            E defaultValue
    ) {
        return this.map(
                map,
                key,
                locale,
                null,
                defaultValue
        );
    }

    /**
     * map
     * @param map parameter map
     * @param key map access key
     * @param sPattern a non-localized pattern string.
     * @param defaultValue default value used, when the given map is null, the key cannot be found in map, or the map
     *                    value cannot be mapped to Number type
     * @return
     */
    default E map(
            Map<String, ?> map,
            String key,
            String sPattern,
            E defaultValue
    ) {
        return this.map(
                map,
                key,
                null,
                sPattern,
                defaultValue
        );
    }

    /**
     * map
     * @param map parameter map
     * @param key map access key
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @param defaultValue default value used, when the given map is null, the key cannot be found in map, or the map
     *                    value cannot be mapped to Number type
     * @return
     */
    default E map(
            Map<String, ?> map,
            String key,
            Locale locale,
            String sPattern,
            E defaultValue
    ) {
        return this.map(
                map,
                key,
                locale,
                sPattern,
                null,
                defaultValue
        );
    }

    /**
     * map
     * @param map parameter map
     * @param key map access key
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @param defaultValue default value used, when the given map is null, the key cannot be found in map, or the map
     *                    value cannot be mapped to Number type
     * @return
     */
    default E map(
            Map<String, ?> map,
            String key,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols,
            E defaultValue
    ) {
        return this.map(
                map,
                key,
                null,
                sPattern,
                decimalFormatSymbols,
                defaultValue
        );
    }

    /**
     * map
     * @param map parameter map
     * @param key map access key
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @param defaultValue default value used, when the given map is null, the key cannot be found in map, or the map
     *                    value cannot be mapped to Number type
     * @return
     */
    default E map(
            Map<String, ?> map,
            String key,
            Locale locale,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols,
            E defaultValue
    ) {
        E retVal = defaultValue;

        if ( null != map ) {
            if ( null != key ) {
                if ( map.containsKey(key) ) {
                    retVal = this.map(
                            map.get(key).toString(),
                            locale,
                            sPattern,
                            decimalFormatSymbols,
                            defaultValue
                    );
                }
            }
        }
        return retVal;
    }

    /**
     * map
     * @param sNumber the number string
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E map( String sNumber ) {
        return this.map(
                sNumber,
                (Locale) null
        );
    }

    /**
     * map
     * @param s - string to map
     * @param bTrim - default flag for string handling
     * @param bEmptyIsNull - default flag for empty string handling
     * @param defaultValue - The default value
     * @return
     * <p>Overrides {@link ITypeMapper#map(String, boolean, boolean, Object)}. This implementation ignores the boolean
     * flags and delegates to {@link #map(String, Number)}.
     */
    @Override
    default E map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull,
            E defaultValue
    ) {
        return this.map(
                s,
                defaultValue
        );
    }

    /**
     * map
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E map(
            String sNumber,
            Locale locale
    ) {
        return this.map(
                sNumber,
                locale,
                (String) null
        );
    }

    /**
     * map
     * @param sNumber the number string
     * @param sPattern a non-localized pattern string.
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E map(
            String sNumber,
            String sPattern
    ) {
        return this.map(
                sNumber,
                null,
                sPattern
        );
    }

    /**
     * map
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E map(
            String sNumber,
            Locale locale,
            String sPattern
    ) {
        return this.map(
                sNumber,
                locale,
                sPattern,
                (DecimalFormatSymbols) null
        );
    }

    /**
     * map
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E map(
            String sNumber,
            Locale locale,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        return this.map(
                sNumber,
                locale,
                sPattern,
                decimalFormatSymbols,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param sNumber the number string
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E map(
            String sNumber,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        return this.map(
                sNumber,
                null,
                sPattern,
                decimalFormatSymbols
        );
    }

    /**
     * map
     * @param sNumber the number string
     * @param defaultValue default value used, when sNumber is null or cannot be mapped
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E map(
            String sNumber,
            E defaultValue
    ) {
        return this.map(
                sNumber,
                (Locale) null,
                defaultValue
        );
    }

    /**
     * map
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param defaultValue default value used, when sNumber is null or cannot be mapped
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E map(
            String sNumber,
            Locale locale,
            E defaultValue
    ) {
        return this.map(
                sNumber,
                locale,
                null,
                defaultValue
        );
    }

    /**
     * map
     * @param sNumber the number string
     * @param sPattern a non-localized pattern string.
     * @param defaultValue default value used, when sNumber is null or cannot be mapped
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E map(
            String sNumber,
            String sPattern,
            E defaultValue
    ) {
        return this.map(
                sNumber,
                null,
                sPattern,
                defaultValue
        );
    }

    /**
     * map
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @param defaultValue default value used, when sNumber is null or cannot be mapped
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E map(
            String sNumber,
            Locale locale,
            String sPattern,
            E defaultValue
    ) {
        return this.map(
                sNumber,
                locale,
                sPattern,
                null,
                defaultValue
        );
    }

    /**
     * map
     * @param sNumber the number string
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @param defaultValue default value used, when sNumber is null or cannot be mapped
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E map(
            String sNumber,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols,
            E defaultValue
    ) {
        return this.map(
                sNumber,
                null,
                sPattern,
                decimalFormatSymbols,
                defaultValue
        );
    }

    /**
     * map
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @param defaultValue default value used, when sNumber is null or cannot be mapped
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E map(
            String sNumber,
            Locale locale,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols,
            E defaultValue
    ) {
        return this.unformat(
                sNumber,
                locale,
                sPattern,
                decimalFormatSymbols,
                defaultValue
        );
    }

    /**
     * unformat
     * @param sNumber the number string
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E unformat ( String sNumber ) {
        return this.unformat(
                sNumber,
                (Locale) null
        );
    }

    /**
     * unformat
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E unformat(
            String sNumber,
            Locale locale
    ) {
        return this.unformat(
                sNumber,
                locale,
                (String) null
        );
    }

    /**
     * unformat
     * @param sNumber the number string
     * @param sPattern a non-localized pattern string.
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E unformat(
            String sNumber,
            String sPattern
    ) {
        return this.unformat(
                sNumber,
                null,
                sPattern
        );
    }

    /**
     * unformat
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E unformat(
            String sNumber,
            Locale locale,
            String sPattern
    ) {
        return this.unformat(
                sNumber,
                locale,
                sPattern,
                (DecimalFormatSymbols) null
        );
    }

    /**
     * unformat
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E unformat(
            String sNumber,
            Locale locale,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        return this.unformat(
                sNumber,
                locale,
                sPattern,
                decimalFormatSymbols,
                this.getDefaultValue()
        );
    }

    /**
     * unformat
     * @param sNumber the number string
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E unformat(
            String sNumber,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        return this.unformat(
                sNumber,
                null,
                sPattern,
                decimalFormatSymbols
        );
    }

    /**
     * unformat
     * @param sNumber the number string
     * @param defaultValue default value used, when sNumber is null or cannot be mapped
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E unformat (
            String sNumber,
            E defaultValue
    ) {
        return this.unformat(
                sNumber,
                (Locale) null,
                defaultValue
        );
    }

    /**
     * unformat
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param defaultValue default value used, when sNumber is null or cannot be mapped
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E unformat (
            String sNumber,
            Locale locale,
            E defaultValue
    ) {
        return this.unformat(
                sNumber,
                locale,
                null,
                defaultValue
        );
    }

    /**
     * unformat
     * @param sNumber the number string
     * @param sPattern a non-localized pattern string.
     * @param defaultValue default value used, when sNumber is null or cannot be mapped
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E unformat(
            String sNumber,
            String sPattern,
            E defaultValue
    ) {
        return this.unformat(
                sNumber,
                null,
                sPattern,
                defaultValue
        );
    }

    /**
     * unformat
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @param defaultValue default value used, when sNumber is null or cannot be mapped
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E unformat(
            String sNumber,
            Locale locale,
            String sPattern,
            E defaultValue
    ) {
        return this.unformat(
                sNumber,
                locale,
                sPattern,
                null,
                defaultValue
        );
    }

    /**
     * unformat
     * @param sNumber the number string
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @param defaultValue default value used, when sNumber is null or cannot be mapped
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default E unformat(
            String sNumber,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols,
            E defaultValue
    ) {
        return this.unformat(
                sNumber,
                null,
                sPattern,
                decimalFormatSymbols,
                defaultValue
        );
    }

    /**
     * unformat
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @param defaultValue default value used, when sNumber is null or cannot be mapped
     * @return the unformatted Number-String as Number otherwise the default value
     * <p>This method should be overwritten individually.
     */
    E unformat(
            String sNumber,
            Locale locale,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols,
            E defaultValue
    );

    /**
     * unformatToNumber
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @param defaultValue default value used, when sNumber is null or cannot be mapped
     * @return the unformatted Number-String as Number otherwise the default value
     */
    default Number unformatToNumber(
            String sNumber,
            Locale locale,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols,
            Number defaultValue
    ) {
        Number returnValue = defaultValue;

        if (StringUtils.isNotEmpty(sNumber)) {
            DecimalFormat decimalFormat = this.getDecimalFormat(
                    locale,
                    sPattern,
                    decimalFormatSymbols
            );

            try {
                returnValue = decimalFormat.parse(sNumber);
            }
            catch ( ParseException pe ) {
                // pe.printStackTrace();
            }
        }
        return returnValue;
    }

}
