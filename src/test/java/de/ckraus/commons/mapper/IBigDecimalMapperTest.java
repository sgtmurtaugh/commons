package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.*;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static de.ckraus.commons.mapper.TestHelper.*;

@SuppressWarnings({ "javadoc", "Duplicates" })
class IBigDecimalMapperTest {

    private final static Locale locale = Locale.GERMAN;
    private final static String FORMAT_PATTERN = "#,##0.00;(#,##0.00)";

    private final static BigDecimal ANOTHER_DEFAULT_VALUE   = new BigDecimal(5113);

    // create mapper instance
    private IBigDecimalMapper mapper = new IBigDecimalMapper() {};


    /**
     * getDefaultBigDecimal
     * @return
     */
    private BigDecimal getDefaultBigDecimal() {
        return (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
    }

    /**
     * getDefaultBigDecimal
     * @param locale
     * @return
     */
    private BigDecimal getDefaultBigDecimal(Locale locale) {
        BigDecimal retValue = null;
        DecimalFormat format;

        if (null != locale) {
            format = (DecimalFormat) DecimalFormat.getInstance(locale);
        }
        else {
            format = (DecimalFormat) DecimalFormat.getInstance();
        }

        try {
            retValue = new BigDecimal(
                    format.parse(getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString()).toString()
            );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
        return retValue;
    }

    /**
     * getDefaultBigInteger
     * @return
     */
    private BigDecimal getDefaultBigInteger() {
        return new BigDecimal(
                getParameters().get(PARAMS_KEY__BIG_INTEGER).toString()
        );
    }

    /**
     * getDefaultBigInteger
     * @param locale
     * @return
     */
    private BigDecimal getDefaultBigInteger(Locale locale) {
        BigDecimal retValue = null;
        DecimalFormat format;

        if (null != locale) {
            format = (DecimalFormat) DecimalFormat.getInstance(locale);
        }
        else {
            format = (DecimalFormat) DecimalFormat.getInstance();
        }

        try {
            retValue = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
        return retValue;
    }

    /**
     * getDefaultByte
     * @return
     */
    private BigDecimal getDefaultByte() {
        return new BigDecimal(
                getParameters().get(PARAMS_KEY__BYTE).toString()
        );
    }

    /**
     * getDefaultByte
     * @param locale
     * @return
     */
    private BigDecimal getDefaultByte(Locale locale) {
        BigDecimal retValue = null;
        DecimalFormat format;

        if (null != locale) {
            format = (DecimalFormat) DecimalFormat.getInstance(locale);
        }
        else {
            format = (DecimalFormat) DecimalFormat.getInstance();
        }

        try {
            retValue = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
        return retValue;
    }

    /**
     * getDefaultDouble
     * @return
     */
    private BigDecimal getDefaultDouble() {
        return new BigDecimal(
                getParameters().get(PARAMS_KEY__DOUBLE).toString()
        );
    }

    /**
     * getDefaultDouble
     * @param locale
     * @return
     */
    private BigDecimal getDefaultDouble(Locale locale) {
        BigDecimal retValue = null;
        DecimalFormat format;

        if (null != locale) {
            format = (DecimalFormat) DecimalFormat.getInstance(locale);
        }
        else {
            format = (DecimalFormat) DecimalFormat.getInstance();
        }

        try {
            retValue = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
        return retValue;
    }

    /**
     * getDefaultFloat
     * @return
     */
    private BigDecimal getDefaultFloat() {
        return new BigDecimal(
                getParameters().get(PARAMS_KEY__FLOAT).toString()
        );
    }

    /**
     * getDefaultFloat
     * @param locale
     * @return
     */
    private BigDecimal getDefaultFloat(Locale locale) {
        BigDecimal retValue = null;
        DecimalFormat format;

        if (null != locale) {
            format = (DecimalFormat) DecimalFormat.getInstance(locale);
        }
        else {
            format = (DecimalFormat) DecimalFormat.getInstance();
        }

        try {
            retValue = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
        return retValue;
    }

    /**
     * getDefaultInteger
     * @return
     */
    private BigDecimal getDefaultInteger() {
        return new BigDecimal(
                getParameters().get(PARAMS_KEY__INTEGER).toString()
        );
    }

    /**
     * getDefaultInteger
     * @param locale
     * @return
     */
    private BigDecimal getDefaultInteger(Locale locale) {
        BigDecimal retValue = null;
        DecimalFormat format;

        if (null != locale) {
            format = (DecimalFormat) DecimalFormat.getInstance(locale);
        }
        else {
            format = (DecimalFormat) DecimalFormat.getInstance();
        }

        try {
            retValue = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
        return retValue;
    }

    /**
     * getDefaultLong
     * @return
     */
    private BigDecimal getDefaultLong() {
        return new BigDecimal(
                getParameters().get(PARAMS_KEY__LONG).toString()
        );
    }

    /**
     * getDefaultLong
     * @param locale
     * @return
     */
    private BigDecimal getDefaultLong(Locale locale) {
        BigDecimal retValue = null;
        DecimalFormat format;

        if (null != locale) {
            format = (DecimalFormat) DecimalFormat.getInstance(locale);
        }
        else {
            format = (DecimalFormat) DecimalFormat.getInstance();
        }

        try {
            retValue = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
        return retValue;
    }

    /**
     * getDefaultShort
     * @return
     */
    private BigDecimal getDefaultShort() {
        return new BigDecimal(
                getParameters().get(PARAMS_KEY__SHORT).toString()
        );
    }

    /**
     * getDefaultShort
     * @param locale
     * @return
     */
    private BigDecimal getDefaultShort(Locale locale) {
        BigDecimal retValue = null;
        DecimalFormat format;

        if (null != locale) {
            format = (DecimalFormat) DecimalFormat.getInstance(locale);
        }
        else {
            format = (DecimalFormat) DecimalFormat.getInstance();
        }

        try {
            retValue = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
        return retValue;
    }


    /**
     * test for {@link IBigDecimalMapper#map(Map, String)}
     */
    @Test
    void map() {
        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(null);
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(null);
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultByteString        = this.getDefaultByte(null);
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultDoubleString      = this.getDefaultDouble(null);
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultFloatString       = this.getDefaultFloat(null);
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultIntegerString     = this.getDefaultInteger(null);
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultLongString        = this.getDefaultLong(null);
        BigDecimal defaultShort             = this.getDefaultShort();
        BigDecimal defaultShortString       = this.getDefaultShort(null);

        assertEquals( defaultBigDecimal, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL ) );
        assertEquals( defaultBigDecimalString, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING ) );
        assertEquals( defaultBigInteger, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER ) );
        assertEquals( defaultBigIntegerString, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING ) );
        assertEquals( defaultByte, mapper.map( getParameters(), PARAMS_KEY__BYTE ) );
        assertEquals( defaultByteString, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING ) );
        assertEquals( defaultDouble, mapper.map( getParameters(), PARAMS_KEY__DOUBLE ) );
        assertEquals( defaultDoubleString, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING ) );
        assertEquals( defaultFloat, mapper.map( getParameters(), PARAMS_KEY__FLOAT ) );
        assertEquals( defaultFloatString, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING ) );
        assertEquals( defaultInteger, mapper.map( getParameters(), PARAMS_KEY__INTEGER ) );
        assertEquals( defaultIntegerString, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING ) );
        assertEquals( defaultLong, mapper.map( getParameters(), PARAMS_KEY__LONG ) );
        assertEquals( defaultLongString, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING ) );
        assertEquals( defaultShort, mapper.map( getParameters(), PARAMS_KEY__SHORT ) );
        assertEquals( defaultShortString, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, Locale)}
     */
    @Test
    void map1() {
        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(locale);
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(locale);
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultByteString        = this.getDefaultByte(locale);
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultDoubleString      = this.getDefaultDouble(locale);
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultFloatString       = this.getDefaultFloat(locale);
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultIntegerString     = this.getDefaultInteger(locale);
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultLongString        = this.getDefaultLong(locale);
        BigDecimal defaultShort             = this.getDefaultShort();
        BigDecimal defaultShortString       = this.getDefaultShort(locale);

        assertEquals( defaultBigDecimal, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, locale ) );
        assertEquals( defaultBigDecimalString, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, locale ) );
        assertEquals( defaultBigInteger, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, locale ) );
        assertEquals( defaultBigIntegerString, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, locale ) );
        assertEquals( defaultByte, mapper.map( getParameters(), PARAMS_KEY__BYTE, locale ) );
        assertEquals( defaultByteString, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, locale ) );
        assertEquals( defaultDouble, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, locale ) );
        assertEquals( defaultDoubleString, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, locale ) );
        assertEquals( defaultFloat, mapper.map( getParameters(), PARAMS_KEY__FLOAT, locale ) );
        assertEquals( defaultFloatString, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, locale ) );
        assertEquals( defaultInteger, mapper.map( getParameters(), PARAMS_KEY__INTEGER, locale ) );
        assertEquals( defaultIntegerString, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, locale ) );
        assertEquals( defaultLong, mapper.map( getParameters(), PARAMS_KEY__LONG, locale ) );
        assertEquals( defaultLongString, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, locale ) );
        assertEquals( defaultShort, mapper.map( getParameters(), PARAMS_KEY__SHORT, locale ) );
        assertEquals( defaultShortString, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, locale ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, locale ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, String)}
     */
    @Test
    void map2() {
        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(null);
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(null);
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultByteString        = this.getDefaultByte(null);
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultDoubleString      = this.getDefaultDouble(null);
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultFloatString       = this.getDefaultFloat(null);
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultIntegerString     = this.getDefaultInteger(null);
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultLongString        = this.getDefaultLong(null);
        BigDecimal defaultShort             = this.getDefaultShort();
        BigDecimal defaultShortString       = this.getDefaultShort(null);

        assertEquals( defaultBigDecimal, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, FORMAT_PATTERN ) );
        assertEquals( defaultBigDecimalString, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, FORMAT_PATTERN ) );
        assertEquals( defaultBigInteger, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, FORMAT_PATTERN ) );
        assertEquals( defaultBigIntegerString, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, FORMAT_PATTERN ) );
        assertEquals( defaultByte, mapper.map( getParameters(), PARAMS_KEY__BYTE, FORMAT_PATTERN ) );
        assertEquals( defaultByteString, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, FORMAT_PATTERN ) );
        assertEquals( defaultDouble, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, FORMAT_PATTERN ) );
        assertEquals( defaultDoubleString, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, FORMAT_PATTERN ) );
        assertEquals( defaultFloat, mapper.map( getParameters(), PARAMS_KEY__FLOAT, FORMAT_PATTERN ) );
        assertEquals( defaultFloatString, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, FORMAT_PATTERN ) );
        assertEquals( defaultInteger, mapper.map( getParameters(), PARAMS_KEY__INTEGER, FORMAT_PATTERN ) );
        assertEquals( defaultIntegerString, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, FORMAT_PATTERN ) );
        assertEquals( defaultLong, mapper.map( getParameters(), PARAMS_KEY__LONG, FORMAT_PATTERN ) );
        assertEquals( defaultLongString, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, FORMAT_PATTERN ) );
        assertEquals( defaultShort, mapper.map( getParameters(), PARAMS_KEY__SHORT, FORMAT_PATTERN ) );
        assertEquals( defaultShortString, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, FORMAT_PATTERN ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, FORMAT_PATTERN  ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, Locale, String)}
     */
    @Test
    void map3() {
        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(locale);
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(locale);
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultByteString        = this.getDefaultByte(locale);
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultDoubleString      = this.getDefaultDouble(locale);
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultFloatString       = this.getDefaultFloat(locale);
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultIntegerString     = this.getDefaultInteger(locale);
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultLongString        = this.getDefaultLong(locale);
        BigDecimal defaultShort             = this.getDefaultShort();
        BigDecimal defaultShortString       = this.getDefaultShort(locale);

        assertEquals( defaultBigDecimal, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, locale, FORMAT_PATTERN ) );
        assertEquals( defaultBigDecimalString, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, locale, FORMAT_PATTERN ) );
        assertEquals( defaultBigInteger, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, locale, FORMAT_PATTERN ) );
        assertEquals( defaultBigIntegerString, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, locale, FORMAT_PATTERN ) );
        assertEquals( defaultByte, mapper.map( getParameters(), PARAMS_KEY__BYTE, locale, FORMAT_PATTERN ) );
        assertEquals( defaultByteString, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, locale, FORMAT_PATTERN ) );
        assertEquals( defaultDouble, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, locale, FORMAT_PATTERN ) );
        assertEquals( defaultDoubleString, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, locale, FORMAT_PATTERN ) );
        assertEquals( defaultFloat, mapper.map( getParameters(), PARAMS_KEY__FLOAT, locale, FORMAT_PATTERN ) );
        assertEquals( defaultFloatString, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, locale, FORMAT_PATTERN ) );
        assertEquals( defaultInteger, mapper.map( getParameters(), PARAMS_KEY__INTEGER, locale, FORMAT_PATTERN ) );
        assertEquals( defaultIntegerString, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, locale, FORMAT_PATTERN ) );
        assertEquals( defaultLong, mapper.map( getParameters(), PARAMS_KEY__LONG, locale, FORMAT_PATTERN ) );
        assertEquals( defaultLongString, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, locale, FORMAT_PATTERN ) );
        assertEquals( defaultShort, mapper.map( getParameters(), PARAMS_KEY__SHORT, locale, FORMAT_PATTERN ) );
        assertEquals( defaultShortString, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, locale, FORMAT_PATTERN ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, locale, FORMAT_PATTERN ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, Locale, String, DecimalFormatSymbols)}
     */
    @Test
    void map4() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(locale);
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(locale);
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultByteString        = this.getDefaultByte(locale);
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultDoubleString      = this.getDefaultDouble(locale);
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultFloatString       = this.getDefaultFloat(locale);
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultIntegerString     = this.getDefaultInteger(locale);
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultLongString        = this.getDefaultLong(locale);
        BigDecimal defaultShort             = this.getDefaultShort();
        BigDecimal defaultShortString       = this.getDefaultShort(locale);

        assertEquals( defaultBigDecimal, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultBigDecimalString, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultBigInteger, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultBigIntegerString, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultByte, mapper.map( getParameters(), PARAMS_KEY__BYTE, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultByteString, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultDouble, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultDoubleString, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultFloat, mapper.map( getParameters(), PARAMS_KEY__FLOAT, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultFloatString, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultInteger, mapper.map( getParameters(), PARAMS_KEY__INTEGER, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultIntegerString, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultLong, mapper.map( getParameters(), PARAMS_KEY__LONG, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultLongString, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultShort, mapper.map( getParameters(), PARAMS_KEY__SHORT, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultShortString, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, locale, FORMAT_PATTERN, symbols ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, locale, FORMAT_PATTERN, symbols ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, String, DecimalFormatSymbols)}
     */
    @Test
    void map5() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(null);
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(null);
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultByteString        = this.getDefaultByte(null);
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultDoubleString      = this.getDefaultDouble(null);
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultFloatString       = this.getDefaultFloat(null);
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultIntegerString     = this.getDefaultInteger(null);
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultLongString        = this.getDefaultLong(null);
        BigDecimal defaultShort             = this.getDefaultShort();
        BigDecimal defaultShortString       = this.getDefaultShort(null);

        assertEquals( defaultBigDecimal, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultBigDecimalString, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultBigInteger, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultBigIntegerString, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultByte, mapper.map( getParameters(), PARAMS_KEY__BYTE, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultByteString, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultDouble, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultDoubleString, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultFloat, mapper.map( getParameters(), PARAMS_KEY__FLOAT, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultFloatString, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultInteger, mapper.map( getParameters(), PARAMS_KEY__INTEGER, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultIntegerString, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultLong, mapper.map( getParameters(), PARAMS_KEY__LONG, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultLongString, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultShort, mapper.map( getParameters(), PARAMS_KEY__SHORT, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultShortString, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, FORMAT_PATTERN, symbols ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, FORMAT_PATTERN, symbols ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, Number)}
     */
    @Test
    void map6() {
        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(null);
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(null);
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultByteString        = this.getDefaultByte(null);
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultDoubleString      = this.getDefaultDouble(null);
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultFloatString       = this.getDefaultFloat(null);
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultIntegerString     = this.getDefaultInteger(null);
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultLongString        = this.getDefaultLong(null);
        BigDecimal defaultShort             = this.getDefaultShort();
        BigDecimal defaultShortString       = this.getDefaultShort(null);

        assertEquals( defaultBigDecimal, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigDecimalString, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigInteger, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigIntegerString, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByte, mapper.map( getParameters(), PARAMS_KEY__BYTE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByteString, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDouble, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDoubleString, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloat, mapper.map( getParameters(), PARAMS_KEY__FLOAT, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloatString, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultInteger, mapper.map( getParameters(), PARAMS_KEY__INTEGER, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultIntegerString, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLong, mapper.map( getParameters(), PARAMS_KEY__LONG, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLongString, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShort, mapper.map( getParameters(), PARAMS_KEY__SHORT, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShortString, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__NO_KEY, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__OBJECT, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, Locale, Number)}
     */
    @Test
    void map7() {
        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(locale);
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(locale);
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultByteString        = this.getDefaultByte(locale);
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultDoubleString      = this.getDefaultDouble(locale);
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultFloatString       = this.getDefaultFloat(locale);
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultIntegerString     = this.getDefaultInteger(locale);
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultLongString        = this.getDefaultLong(locale);
        BigDecimal defaultShort             = this.getDefaultShort();
        BigDecimal defaultShortString       = this.getDefaultShort(locale);

        assertEquals( defaultBigDecimal, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigDecimalString, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigInteger, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigIntegerString, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByte, mapper.map( getParameters(), PARAMS_KEY__BYTE, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByteString, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDouble, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDoubleString, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloat, mapper.map( getParameters(), PARAMS_KEY__FLOAT, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloatString, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultInteger, mapper.map( getParameters(), PARAMS_KEY__INTEGER, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultIntegerString, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLong, mapper.map( getParameters(), PARAMS_KEY__LONG, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLongString, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShort, mapper.map( getParameters(), PARAMS_KEY__SHORT, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShortString, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, locale, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__NO_KEY, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__OBJECT, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, locale, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, String, Number)}
     */
    @Test
    void map8() {
        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(null);
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(null);
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultByteString        = this.getDefaultByte(null);
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultDoubleString      = this.getDefaultDouble(null);
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultFloatString       = this.getDefaultFloat(null);
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultIntegerString     = this.getDefaultInteger(null);
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultLongString        = this.getDefaultLong(null);
        BigDecimal defaultShort             = this.getDefaultShort();
        BigDecimal defaultShortString       = this.getDefaultShort(null);

        assertEquals( defaultBigDecimal, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigDecimalString, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigInteger, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigIntegerString, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByte, mapper.map( getParameters(), PARAMS_KEY__BYTE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByteString, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDouble, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDoubleString, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloat, mapper.map( getParameters(), PARAMS_KEY__FLOAT, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloatString, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultInteger, mapper.map( getParameters(), PARAMS_KEY__INTEGER, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultIntegerString, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLong, mapper.map( getParameters(), PARAMS_KEY__LONG, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLongString, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShort, mapper.map( getParameters(), PARAMS_KEY__SHORT, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShortString, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__NO_KEY, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__OBJECT, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, Locale, String, Number)}
     */
    @Test
    void map9() {
        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(locale);
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(locale);
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultByteString        = this.getDefaultByte(locale);
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultDoubleString      = this.getDefaultDouble(locale);
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultFloatString       = this.getDefaultFloat(locale);
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultIntegerString     = this.getDefaultInteger(locale);
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultLongString        = this.getDefaultLong(locale);
        BigDecimal defaultShort             = this.getDefaultShort();
        BigDecimal defaultShortString       = this.getDefaultShort(locale);

        assertEquals( defaultBigDecimal,
                mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigDecimalString,
                mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigInteger,
                mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigIntegerString,
                mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByte,
                mapper.map( getParameters(), PARAMS_KEY__BYTE, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByteString,
                mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDouble,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDoubleString,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloat,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloatString,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultInteger,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultIntegerString,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLong,
                mapper.map( getParameters(), PARAMS_KEY__LONG, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLongString,
                mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShort,
                mapper.map( getParameters(), PARAMS_KEY__SHORT, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShortString,
                mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void map10() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(null);
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(null);
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultByteString        = this.getDefaultByte(null);
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultDoubleString      = this.getDefaultDouble(null);
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultFloatString       = this.getDefaultFloat(null);
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultIntegerString     = this.getDefaultInteger(null);
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultLongString        = this.getDefaultLong(null);
        BigDecimal defaultShort             = this.getDefaultShort();
        BigDecimal defaultShortString       = this.getDefaultShort(null);

        assertEquals( defaultBigDecimal,
                mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigDecimalString,
                mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigInteger,
                mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigIntegerString,
                mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByte,
                mapper.map( getParameters(), PARAMS_KEY__BYTE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByteString,
                mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDouble,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDoubleString,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloat,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloatString,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultInteger,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultIntegerString,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLong,
                mapper.map( getParameters(), PARAMS_KEY__LONG, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLongString,
                mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShort,
                mapper.map( getParameters(), PARAMS_KEY__SHORT, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShortString,
                mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, Locale, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void map11() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(locale);
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(locale);
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultByteString        = this.getDefaultByte(locale);
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultDoubleString      = this.getDefaultDouble(locale);
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultFloatString       = this.getDefaultFloat(locale);
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultIntegerString     = this.getDefaultInteger(locale);
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultLongString        = this.getDefaultLong(locale);
        BigDecimal defaultShort             = this.getDefaultShort();
        BigDecimal defaultShortString       = this.getDefaultShort(locale);

        assertEquals( defaultBigDecimal,
                mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigDecimalString,
                mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigInteger,
                mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigIntegerString,
                mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByte,
                mapper.map( getParameters(), PARAMS_KEY__BYTE, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByteString,
                mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDouble,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDoubleString,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloat,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloatString,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultInteger,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultIntegerString,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLong,
                mapper.map( getParameters(), PARAMS_KEY__LONG, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLongString,
                mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShort,
                mapper.map( getParameters(), PARAMS_KEY__SHORT, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShortString,
                mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(String)}
     */
    @Test
    void map12() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(null);
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(null);
        BigDecimal defaultByteString        = this.getDefaultByte(null);
        BigDecimal defaultDoubleString      = this.getDefaultDouble(null);
        BigDecimal defaultFloatString       = this.getDefaultFloat(null);
        BigDecimal defaultIntegerString     = this.getDefaultInteger(null);
        BigDecimal defaultLongString        = this.getDefaultLong(null);
        BigDecimal defaultShortString       = this.getDefaultShort(null);

        assertEquals( defaultBigDecimalString, mapper.map( sBigDecimalString ) );
        assertEquals( defaultBigIntegerString, mapper.map( sBigIntegerString ) );
        assertEquals( defaultByteString, mapper.map( sByteString ) );
        assertEquals( defaultDoubleString, mapper.map( sDoubleString ) );
        assertEquals( defaultFloatString, mapper.map( sFloatString ) );
        assertEquals( defaultIntegerString, mapper.map( sIntegerString ) );
        assertEquals( defaultLongString, mapper.map( sLongString ) );
        assertEquals( defaultShortString, mapper.map( sShortString ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( sNull ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sObject ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, boolean, boolean, Number)}
     */
    @Test
    void map13() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(null);
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(null);
        BigDecimal defaultByteString        = this.getDefaultByte(null);
        BigDecimal defaultDoubleString      = this.getDefaultDouble(null);
        BigDecimal defaultFloatString       = this.getDefaultFloat(null);
        BigDecimal defaultIntegerString     = this.getDefaultInteger(null);
        BigDecimal defaultLongString        = this.getDefaultLong(null);
        BigDecimal defaultShortString       = this.getDefaultShort(null);

        assertEquals( defaultBigDecimalString, mapper.map( sBigDecimalString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigIntegerString, mapper.map( sBigIntegerString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByteString, mapper.map( sByteString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDoubleString, mapper.map( sDoubleString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloatString, mapper.map( sFloatString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultIntegerString, mapper.map( sIntegerString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLongString, mapper.map( sLongString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShortString, mapper.map( sShortString, true, true, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, true, true, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, Locale)}
     */
    @Test
    void map14() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(locale);
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(locale);
        BigDecimal defaultByteString        = this.getDefaultByte(locale);
        BigDecimal defaultDoubleString      = this.getDefaultDouble(locale);
        BigDecimal defaultFloatString       = this.getDefaultFloat(locale);
        BigDecimal defaultIntegerString     = this.getDefaultInteger(locale);
        BigDecimal defaultLongString        = this.getDefaultLong(locale);
        BigDecimal defaultShortString       = this.getDefaultShort(locale);

        assertEquals( defaultBigDecimalString, mapper.map( sBigDecimalString, locale ) );
        assertEquals( defaultBigIntegerString, mapper.map( sBigIntegerString, locale ) );
        assertEquals( defaultByteString, mapper.map( sByteString, locale ) );
        assertEquals( defaultDoubleString, mapper.map( sDoubleString, locale ) );
        assertEquals( defaultFloatString, mapper.map( sFloatString, locale ) );
        assertEquals( defaultIntegerString, mapper.map( sIntegerString, locale ) );
        assertEquals( defaultLongString, mapper.map( sLongString, locale ) );
        assertEquals( defaultShortString, mapper.map( sShortString, locale ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( sNull, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sObject, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sString, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder, locale ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, String)}
     */
    @Test
    void map15() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(null);
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(null);
        BigDecimal defaultByteString        = this.getDefaultByte(null);
        BigDecimal defaultDoubleString      = this.getDefaultDouble(null);
        BigDecimal defaultFloatString       = this.getDefaultFloat(null);
        BigDecimal defaultIntegerString     = this.getDefaultInteger(null);
        BigDecimal defaultLongString        = this.getDefaultLong(null);
        BigDecimal defaultShortString       = this.getDefaultShort(null);

        assertEquals( defaultBigDecimalString, mapper.map( sBigDecimalString, FORMAT_PATTERN ) );
        assertEquals( defaultBigIntegerString, mapper.map( sBigIntegerString, FORMAT_PATTERN ) );
        assertEquals( defaultByteString, mapper.map( sByteString, FORMAT_PATTERN ) );
        assertEquals( defaultDoubleString, mapper.map( sDoubleString, FORMAT_PATTERN ) );
        assertEquals( defaultFloatString, mapper.map( sFloatString, FORMAT_PATTERN ) );
        assertEquals( defaultIntegerString, mapper.map( sIntegerString, FORMAT_PATTERN ) );
        assertEquals( defaultLongString, mapper.map( sLongString, FORMAT_PATTERN ) );
        assertEquals( defaultShortString, mapper.map( sShortString, FORMAT_PATTERN ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( sNull, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sObject, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder, FORMAT_PATTERN ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, Locale, String)}
     */
    @Test
    void map16() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(locale);
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(locale);
        BigDecimal defaultByteString        = this.getDefaultByte(locale);
        BigDecimal defaultDoubleString      = this.getDefaultDouble(locale);
        BigDecimal defaultFloatString       = this.getDefaultFloat(locale);
        BigDecimal defaultIntegerString     = this.getDefaultInteger(locale);
        BigDecimal defaultLongString        = this.getDefaultLong(locale);
        BigDecimal defaultShortString       = this.getDefaultShort(locale);

        assertEquals( defaultBigDecimalString, mapper.map( sBigDecimalString, locale, FORMAT_PATTERN ) );
        assertEquals( defaultBigIntegerString, mapper.map( sBigIntegerString, locale, FORMAT_PATTERN ) );
        assertEquals( defaultByteString, mapper.map( sByteString, locale, FORMAT_PATTERN ) );
        assertEquals( defaultDoubleString, mapper.map( sDoubleString, locale, FORMAT_PATTERN ) );
        assertEquals( defaultFloatString, mapper.map( sFloatString, locale, FORMAT_PATTERN ) );
        assertEquals( defaultIntegerString, mapper.map( sIntegerString, locale, FORMAT_PATTERN ) );
        assertEquals( defaultLongString, mapper.map( sLongString, locale, FORMAT_PATTERN ) );
        assertEquals( defaultShortString, mapper.map( sShortString, locale, FORMAT_PATTERN ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( sNull, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sObject, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sString, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder, locale, FORMAT_PATTERN ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, Locale, String, DecimalFormatSymbols)}
     */
    @Test
    void map17() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);

        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(locale);
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(locale);
        BigDecimal defaultByteString        = this.getDefaultByte(locale);
        BigDecimal defaultDoubleString      = this.getDefaultDouble(locale);
        BigDecimal defaultFloatString       = this.getDefaultFloat(locale);
        BigDecimal defaultIntegerString     = this.getDefaultInteger(locale);
        BigDecimal defaultLongString        = this.getDefaultLong(locale);
        BigDecimal defaultShortString       = this.getDefaultShort(locale);

        assertEquals( defaultBigDecimalString, mapper.map( sBigDecimalString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultBigIntegerString, mapper.map( sBigIntegerString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultByteString, mapper.map( sByteString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultDoubleString, mapper.map( sDoubleString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultFloatString, mapper.map( sFloatString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultIntegerString, mapper.map( sIntegerString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultLongString, mapper.map( sLongString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultShortString, mapper.map( sShortString, locale, FORMAT_PATTERN, symbols ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( sNull, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sObject, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder, locale, FORMAT_PATTERN, symbols ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, String, DecimalFormatSymbols)}
     */
    @Test
    void map18() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();

        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(null);
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(null);
        BigDecimal defaultByteString        = this.getDefaultByte(null);
        BigDecimal defaultDoubleString      = this.getDefaultDouble(null);
        BigDecimal defaultFloatString       = this.getDefaultFloat(null);
        BigDecimal defaultIntegerString     = this.getDefaultInteger(null);
        BigDecimal defaultLongString        = this.getDefaultLong(null);
        BigDecimal defaultShortString       = this.getDefaultShort(null);

        assertEquals( defaultBigDecimalString, mapper.map( sBigDecimalString, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultBigIntegerString, mapper.map( sBigIntegerString, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultByteString, mapper.map( sByteString, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultDoubleString, mapper.map( sDoubleString, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultFloatString, mapper.map( sFloatString, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultIntegerString, mapper.map( sIntegerString, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultLongString, mapper.map( sLongString, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultShortString, mapper.map( sShortString, FORMAT_PATTERN, symbols ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( sNull, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sObject, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder, FORMAT_PATTERN, symbols ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, Number)}
     */
    @Test
    void map19() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(null);
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(null);
        BigDecimal defaultByteString        = this.getDefaultByte(null);
        BigDecimal defaultDoubleString      = this.getDefaultDouble(null);
        BigDecimal defaultFloatString       = this.getDefaultFloat(null);
        BigDecimal defaultIntegerString     = this.getDefaultInteger(null);
        BigDecimal defaultLongString        = this.getDefaultLong(null);
        BigDecimal defaultShortString       = this.getDefaultShort(null);

        assertEquals( defaultBigDecimalString, mapper.map( sBigDecimalString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigIntegerString, mapper.map( sBigIntegerString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByteString, mapper.map( sByteString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDoubleString, mapper.map( sDoubleString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloatString, mapper.map( sFloatString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultIntegerString, mapper.map( sIntegerString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLongString, mapper.map( sLongString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShortString, mapper.map( sShortString, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, Locale, Number)}
     */
    @Test
    void map20() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(locale);
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(locale);
        BigDecimal defaultByteString        = this.getDefaultByte(locale);
        BigDecimal defaultDoubleString      = this.getDefaultDouble(locale);
        BigDecimal defaultFloatString       = this.getDefaultFloat(locale);
        BigDecimal defaultIntegerString     = this.getDefaultInteger(locale);
        BigDecimal defaultLongString        = this.getDefaultLong(locale);
        BigDecimal defaultShortString       = this.getDefaultShort(locale);

        assertEquals( defaultBigDecimalString, mapper.map( sBigDecimalString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigIntegerString, mapper.map( sBigIntegerString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByteString, mapper.map( sByteString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDoubleString, mapper.map( sDoubleString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloatString, mapper.map( sFloatString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultIntegerString, mapper.map( sIntegerString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLongString, mapper.map( sLongString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShortString, mapper.map( sShortString, locale, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, locale, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, String, Number)}
     */
    @Test
    void map21() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(null);
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(null);
        BigDecimal defaultByteString        = this.getDefaultByte(null);
        BigDecimal defaultDoubleString      = this.getDefaultDouble(null);
        BigDecimal defaultFloatString       = this.getDefaultFloat(null);
        BigDecimal defaultIntegerString     = this.getDefaultInteger(null);
        BigDecimal defaultLongString        = this.getDefaultLong(null);
        BigDecimal defaultShortString       = this.getDefaultShort(null);

        assertEquals( defaultBigDecimalString, mapper.map( sBigDecimalString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigIntegerString, mapper.map( sBigIntegerString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByteString, mapper.map( sByteString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDoubleString, mapper.map( sDoubleString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloatString, mapper.map( sFloatString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultIntegerString, mapper.map( sIntegerString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLongString, mapper.map( sLongString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShortString, mapper.map( sShortString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, Locale, String, Number)}
     */
    @Test
    void map22() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(locale);
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(locale);
        BigDecimal defaultByteString        = this.getDefaultByte(locale);
        BigDecimal defaultDoubleString      = this.getDefaultDouble(locale);
        BigDecimal defaultFloatString       = this.getDefaultFloat(locale);
        BigDecimal defaultIntegerString     = this.getDefaultInteger(locale);
        BigDecimal defaultLongString        = this.getDefaultLong(locale);
        BigDecimal defaultShortString       = this.getDefaultShort(locale);

        assertEquals( defaultBigDecimalString, mapper.map( sBigDecimalString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigIntegerString, mapper.map( sBigIntegerString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByteString, mapper.map( sByteString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDoubleString, mapper.map( sDoubleString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloatString, mapper.map( sFloatString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultIntegerString, mapper.map( sIntegerString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLongString, mapper.map( sLongString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShortString, mapper.map( sShortString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void map23() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();

        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(null);
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(null);
        BigDecimal defaultByteString        = this.getDefaultByte(null);
        BigDecimal defaultDoubleString      = this.getDefaultDouble(null);
        BigDecimal defaultFloatString       = this.getDefaultFloat(null);
        BigDecimal defaultIntegerString     = this.getDefaultInteger(null);
        BigDecimal defaultLongString        = this.getDefaultLong(null);
        BigDecimal defaultShortString       = this.getDefaultShort(null);

        assertEquals( defaultBigDecimalString, mapper.map( sBigDecimalString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigIntegerString, mapper.map( sBigIntegerString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByteString, mapper.map( sByteString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDoubleString, mapper.map( sDoubleString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloatString, mapper.map( sFloatString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultIntegerString, mapper.map( sIntegerString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLongString, mapper.map( sLongString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShortString, mapper.map( sShortString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, Locale, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void map24() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);

        BigDecimal defaultBigDecimalString  = this.getDefaultBigDecimal(locale);
        BigDecimal defaultBigIntegerString  = this.getDefaultBigInteger(locale);
        BigDecimal defaultByteString        = this.getDefaultByte(locale);
        BigDecimal defaultDoubleString      = this.getDefaultDouble(locale);
        BigDecimal defaultFloatString       = this.getDefaultFloat(locale);
        BigDecimal defaultIntegerString     = this.getDefaultInteger(locale);
        BigDecimal defaultLongString        = this.getDefaultLong(locale);
        BigDecimal defaultShortString       = this.getDefaultShort(locale);

        assertEquals( defaultBigDecimalString, mapper.map( sBigDecimalString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigIntegerString, mapper.map( sBigIntegerString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByteString, mapper.map( sByteString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDoubleString, mapper.map( sDoubleString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloatString, mapper.map( sFloatString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultIntegerString, mapper.map( sIntegerString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLongString, mapper.map( sLongString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShortString, mapper.map( sShortString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String)}
     */
    @Test
    void unformat() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultShort             = this.getDefaultShort();

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString ) );
        assertEquals( defaultByte, mapper.unformat( sByteString ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString ) );
        assertEquals( defaultLong, mapper.unformat( sLongString ) );
        assertEquals( defaultShort, mapper.unformat( sShortString ) );

        assertEquals( mapper.getDefaultValue(), mapper.unformat( sNull ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sObject ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringEmpty ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmed ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmedEmpty ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringBuilder ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, Locale)}
     */
    @Test
    void unformat1() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultShort             = this.getDefaultShort();

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, locale ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, locale ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, locale ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, locale ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, locale ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, locale ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, locale ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, locale ) );

        assertEquals( mapper.getDefaultValue(), mapper.unformat( sNull, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sObject, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sString, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringEmpty, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmed, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmedEmpty, locale ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringBuilder, locale ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, String)}
     */
    @Test
    void unformat2() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultShort             = this.getDefaultShort();

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, FORMAT_PATTERN ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, FORMAT_PATTERN ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, FORMAT_PATTERN ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, FORMAT_PATTERN ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, FORMAT_PATTERN ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, FORMAT_PATTERN ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, FORMAT_PATTERN ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, FORMAT_PATTERN ) );

        assertEquals( mapper.getDefaultValue(), mapper.unformat( sNull, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sObject, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringEmpty, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmed, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmedEmpty, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringBuilder, FORMAT_PATTERN ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, Locale, String)}
     */
    @Test
    void unformat3() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultShort             = this.getDefaultShort();

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, locale, FORMAT_PATTERN ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, locale, FORMAT_PATTERN ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, locale, FORMAT_PATTERN ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, locale, FORMAT_PATTERN ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, locale, FORMAT_PATTERN ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, locale, FORMAT_PATTERN ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, locale, FORMAT_PATTERN ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, locale, FORMAT_PATTERN ) );

        assertEquals( mapper.getDefaultValue(), mapper.unformat( sNull, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sObject, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sString, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringEmpty, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmed, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmedEmpty, locale, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringBuilder, locale, FORMAT_PATTERN ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, Locale, String, DecimalFormatSymbols)}
     */
    @Test
    void unformat4() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultShort             = this.getDefaultShort();

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, locale, FORMAT_PATTERN, symbols ) );

        assertEquals( mapper.getDefaultValue(), mapper.unformat( sNull, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sObject, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sString, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringEmpty, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmed, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmedEmpty, locale, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringBuilder, locale, FORMAT_PATTERN, symbols ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, String, DecimalFormatSymbols)}
     */
    @Test
    void unformat5() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultShort             = this.getDefaultShort();

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, FORMAT_PATTERN, symbols ) );

        assertEquals( mapper.getDefaultValue(), mapper.unformat( sNull, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sObject, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringEmpty, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmed, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmedEmpty, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringBuilder, FORMAT_PATTERN, symbols ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, Number)}
     */
    @Test
    void unformat6() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultShort             = this.getDefaultShort();

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sNull, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sObject, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringEmpty, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmed, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmedEmpty, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringBuilder, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, Locale, Number)}
     */
    @Test
    void unformat7() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultShort             = this.getDefaultShort();

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, locale, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sNull, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sObject, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sString, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringEmpty, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmed, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmedEmpty, locale, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringBuilder, locale, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, String, Number)}
     */
    @Test
    void unformat8() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultShort             = this.getDefaultShort();

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sNull, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sObject, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringEmpty, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmed, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmedEmpty, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringBuilder, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, Locale, String, Number)}
     */
    @Test
    void unformat9() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultShort             = this.getDefaultShort();

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sNull, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sObject, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sString, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringEmpty, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmed, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmedEmpty, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringBuilder, locale, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void unformat10() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultShort             = this.getDefaultShort();

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sNull, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sObject, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringEmpty, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmed, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmedEmpty, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringBuilder, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, Locale, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void unformat11() {
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);

        String sNull                    = null;
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);

        BigDecimal defaultBigDecimal        = this.getDefaultBigDecimal();
        BigDecimal defaultBigInteger        = this.getDefaultBigInteger();
        BigDecimal defaultByte              = this.getDefaultByte();
        BigDecimal defaultDouble            = this.getDefaultDouble();
        BigDecimal defaultFloat             = this.getDefaultFloat();
        BigDecimal defaultInteger           = this.getDefaultInteger();
        BigDecimal defaultLong              = this.getDefaultLong();
        BigDecimal defaultShort             = this.getDefaultShort();

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sNull, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sObject, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sString, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringEmpty, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmed, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmedEmpty, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringBuilder, locale, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
    }

}