package de.ckraus.commons.parser.type;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by gandalf on 15.03.14.
 */
public interface INumericTypeParser<E extends Number>
    extends ITypeParser<E> {

    /**
     * parse
     * @param sNumber the number string
     * @param defaultValue default value used, when sNumber is null or cannot be parsed
     * @param sPattern a non-localized pattern string.
     * @return the unformatted Number-String as Number otherwise the default value
     */
    E parse(
            String sNumber,
            E defaultValue,
            String sPattern
    );

    /**
     * parse
     * @param sNumber the number string
     * @param defaultValue default value used, when sNumber is null or cannot be parsed
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @return the unformatted Number-String as Number otherwise the default value
     */
    E parse(
            String sNumber,
            E defaultValue,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    );

    /**
     * unformat
     * @param sNumber the number string
     * @return the unformatted Number-String as Number otherwise the default value
     */
    E unformat ( String sNumber );

    /**
     * unformat
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @return the unformatted Number-String as Number otherwise the default value
     */
    E unformat(
            String sNumber,
            Locale locale
    );

    /**
     * unformat
     * @param sNumber the number string
     * @param sPattern a non-localized pattern string.
     * @return the unformatted Number-String as Number otherwise the default value
     */
    E unformat(
            String sNumber,
            String sPattern
    );

    /**
     * unformat
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @return the unformatted Number-String as Number otherwise the default value
     */
    E unformat(
            String sNumber,
            Locale locale,
            String sPattern
    );

    /**
     * unformat
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @return the unformatted Number-String as Number otherwise the default value
     */
    E unformat(
            String sNumber,
            Locale locale,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    );

    /**
     * unformat
     * @param sNumber the number string
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @return the unformatted Number-String as Number otherwise the default value
     */
    E unformat(
            String sNumber,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    );

    /**
     * unformat
     * @param sNumber the number string
     * @param defaultValue default value used, when sNumber is null or cannot be parsed
     * @return the unformatted Number-String as Number otherwise the default value
     */
    E unformat (
            String sNumber,
            E defaultValue
    );

    /**
     * unformat
     * @param sNumber the number string
     * @param defaultValue default value used, when sNumber is null or cannot be parsed
     * @param locale the locale to use for the format.
     * @return the unformatted Number-String as Number otherwise the default value
     */
    E unformat (
            String sNumber,
            E defaultValue,
            Locale locale
    );

    /**
     * unformat
     * @param sNumber the number string
     * @param defaultValue default value used, when sNumber is null or cannot be parsed
     * @param sPattern a non-localized pattern string.
     * @return the unformatted Number-String as Number otherwise the default value
     */
    E unformat(
            String sNumber,
            E defaultValue,
            String sPattern
    );

    /**
     * unformat
     * @param sNumber the number string
     * @param defaultValue default value used, when sNumber is null or cannot be parsed
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @return the unformatted Number-String as Number otherwise the default value
     */
    E unformat(
            String sNumber,
            E defaultValue,
            Locale locale,
            String sPattern
    );

    /**
     * unformat
     * @param sNumber the number string
     * @param defaultValue default value used, when sNumber is null or cannot be parsed
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @return the unformatted Number-String as Number otherwise the default value
     */
    E unformat(
            String sNumber,
            E defaultValue,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    );

    /**
     * unformat
     * @param sNumber the number string
     * @param defaultValue default value used, when sNumber is null or cannot be parsed
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @return the unformatted Number-String as Number otherwise the default value
     */
    E unformat(
            String sNumber,
            E defaultValue,
            Locale locale,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    );

}
