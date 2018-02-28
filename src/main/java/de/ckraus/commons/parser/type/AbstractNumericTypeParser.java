package de.ckraus.commons.parser.type;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by gandalf on 16.03.14.
 */
public abstract class AbstractNumericTypeParser<E extends Number>
    extends AbstractTypeParser<E>
    implements INumericTypeParser<E> {

    private final static String CLASS   = AbstractNumericTypeParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger( AbstractNumericTypeParser.class );


    /**
     * Constructor
     */
    public AbstractNumericTypeParser() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public AbstractNumericTypeParser(E defaultValue) {
        super( defaultValue );
    }


    /* ### Formatter Methods ############ */


    /**
     * getDecimalFormat
     * @return a DecimalFormat using the current locale
     */
    protected DecimalFormat getDecimalFormat () {
        return this.getDecimalFormat( (Locale) null );
    }

    /**
     * getDecimalFormat
     * @param locale the locale to use for the format
     * @return a DecimalFormat using the given locale
     */
    protected DecimalFormat getDecimalFormat (Locale locale) {
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
    protected DecimalFormat getDecimalFormat (
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
    protected DecimalFormat getDecimalFormat ( String sPattern ) {
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
    protected DecimalFormat getDecimalFormat (
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
    protected DecimalFormat getDecimalFormat (
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

        if ( null != StringUtils.trimToNull( sPattern ) ) {
            decimalFormat.applyPattern(sPattern);
        }

        if ( null != decimalFormatSymbols ) {
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        }
        return decimalFormat;
    }


    /* ### parse Methods ############ */


    /**
     * @see ITypeParser#parse(String, Object)
     */
    public E parse(
            String s,
            E defaultValue
    ) {
        return this.parse(
                s,
                defaultValue,
                null
        );
    }

    /**
     * @see INumericTypeParser#parse(String, Number, String)
     */
    public E parse(
            String s,
            E defaultValue,
            String sPattern
    ) {
        return this.parse(
                s,
                defaultValue,
                sPattern,
                null
        );
    }

    /**
     * @see INumericTypeParser#parse(String, Number, String, DecimalFormatSymbols)
     * <p>This default implementation only return the defaultValue param.</p>
     */
    public E parse(
            String s,
            E defaultValue,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        return defaultValue;
    }


    /* ### unformat Methods ############ */


    /**
     * @see INumericTypeParser#unformat
     */
    public E unformat ( String sNumber ) {
        return this.unformat(
                sNumber,
                this.getDefaultValue()
        );
    }

    /**
     * @see INumericTypeParser#unformat
     */
    public E unformat(
            String sNumber,
            Locale locale
    ) {
        return this.unformat(
                sNumber,
                locale,
                null
        );
    }

    /**
     * @see INumericTypeParser#unformat
     */
    public E unformat(
            String sNumber,
            String sPattern
    ) {
        return this.unformat(
                sNumber,
                (Locale) null,
                sPattern
        );
    }

    /**
     * @see INumericTypeParser#unformat
     */
    public E unformat(
            String sNumber,
            Locale locale,
            String sPattern
    ) {
        return this.unformat(
                sNumber,
                locale,
                sPattern,
                null
        );
    }

    /**
     * @see INumericTypeParser#unformat
     */
    public E unformat(
            String sNumber,
            Locale locale,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        return this.unformat(
                sNumber,
                this.getDefaultValue(),
                locale,
                sPattern,
                decimalFormatSymbols
        );
    }

    /**
     * @see INumericTypeParser#unformat
     */
    public E unformat(
            String sNumber,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        return this.unformat(
                sNumber,
                (Locale) null,
                sPattern,
                decimalFormatSymbols
        );
    }

    /**
     * @see INumericTypeParser#unformat
     */
    public E unformat (
            String sNumber,
            E defaultValue
    ) {
        return this.unformat(
                sNumber,
                defaultValue,
                (Locale) null
        );
    }

    /**
     * @see INumericTypeParser#unformat
     */
    public E unformat (
            String sNumber,
            E defaultValue,
            Locale locale
    ) {
        return this.unformat(
                sNumber,
                defaultValue,
                locale,
                null
        );
    }

    /**
     * @see INumericTypeParser#unformat
     */
    public E unformat(
            String sNumber,
            E defaultValue,
            String sPattern
    ) {
        return this.unformat(
                sNumber,
                defaultValue,
                sPattern,
                null
        );
    }

    /**
     * @see INumericTypeParser#unformat
     */
    public E unformat(
            String sNumber,
            E defaultValue,
            Locale locale,
            String sPattern
    ) {
        return this.unformat(
                sNumber,
                defaultValue,
                locale,
                sPattern,
                null
        );
    }

    /**
     * @see INumericTypeParser#unformat
     */
    public E unformat(
            String sNumber,
            E defaultValue,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        return this.unformat(
                sNumber,
                defaultValue,
                null,
                sPattern,
                decimalFormatSymbols
        );
    }

    /**
     * @see INumericTypeParser#unformat
     */
    public E unformat(
            String sNumber,
            E defaultValue,
            Locale locale,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        return defaultValue;
    }

}
