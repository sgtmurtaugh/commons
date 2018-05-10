package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.*;
import java.util.Map;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static de.ckraus.commons.mapper.TestHelper.*;

@SuppressWarnings({ "Duplicates" })
class IBigDecimalMapperTest {

    private final static Locale GERMAN_LOCALE = Locale.GERMAN;
    private final static String FORMAT_PATTERN = "#,##0.00;(#,##0.00)";

    private final static BigDecimal ANOTHER_DEFAULT_VALUE   = new BigDecimal(5113);

    // create mapper instance
    private IBigDecimalMapper mapper = new IBigDecimalMapper() {};

    /**
     * test for {@link IBigDecimalMapper#map(Map, String)}
     */
    @Test
    void map() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();

            BigDecimal defaultBigDecimal        = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
            BigDecimal defaultBigDecimalString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger        = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BIG_INTEGER).toString()
            );
            BigDecimal defaultBigIntegerString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BYTE).toString()
            );
            BigDecimal defaultByteString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble            = new BigDecimal(
                    getParameters().get(PARAMS_KEY__DOUBLE).toString()
            );
            BigDecimal defaultDoubleString      = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__FLOAT).toString()
            );
            BigDecimal defaultFloatString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger           = new BigDecimal(
                    getParameters().get(PARAMS_KEY__INTEGER).toString()
            );
            BigDecimal defaultIntegerString     = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__LONG).toString()
            );
            BigDecimal defaultLongString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__SHORT).toString()
            );
            BigDecimal defaultShortString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, Locale)}
     */
    @Test
    void map1() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(GERMAN_LOCALE);

            BigDecimal defaultBigDecimal        = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
            BigDecimal defaultBigDecimalString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger        = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BIG_INTEGER).toString()
            );
            BigDecimal defaultBigIntegerString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BYTE).toString()
            );
            BigDecimal defaultByteString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble            = new BigDecimal(
                    getParameters().get(PARAMS_KEY__DOUBLE).toString()
            );
            BigDecimal defaultDoubleString      = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__FLOAT).toString()
            );
            BigDecimal defaultFloatString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger           = new BigDecimal(
                    getParameters().get(PARAMS_KEY__INTEGER).toString()
            );
            BigDecimal defaultIntegerString     = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__LONG).toString()
            );
            BigDecimal defaultLongString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__SHORT).toString()
            );
            BigDecimal defaultShortString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

            assertEquals( defaultBigDecimal, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, GERMAN_LOCALE ) );
            assertEquals( defaultBigDecimalString, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, GERMAN_LOCALE ) );
            assertEquals( defaultBigInteger, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, GERMAN_LOCALE ) );
            assertEquals( defaultBigIntegerString, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, GERMAN_LOCALE ) );
            assertEquals( defaultByte, mapper.map( getParameters(), PARAMS_KEY__BYTE, GERMAN_LOCALE ) );
            assertEquals( defaultByteString, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, GERMAN_LOCALE ) );
            assertEquals( defaultDouble, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE ) );
            assertEquals( defaultDoubleString, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, GERMAN_LOCALE ) );
            assertEquals( defaultFloat, mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE ) );
            assertEquals( defaultFloatString, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, GERMAN_LOCALE ) );
            assertEquals( defaultInteger, mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE ) );
            assertEquals( defaultIntegerString, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, GERMAN_LOCALE ) );
            assertEquals( defaultLong, mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE ) );
            assertEquals( defaultLongString, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, GERMAN_LOCALE ) );
            assertEquals( defaultShort, mapper.map( getParameters(), PARAMS_KEY__SHORT, GERMAN_LOCALE ) );
            assertEquals( defaultShortString, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, GERMAN_LOCALE ) );

            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, String)}
     */
    @Test
    void map2() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();

            BigDecimal defaultBigDecimal        = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
            BigDecimal defaultBigDecimalString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger        = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BIG_INTEGER).toString()
            );
            BigDecimal defaultBigIntegerString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BYTE).toString()
            );
            BigDecimal defaultByteString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble            = new BigDecimal(
                    getParameters().get(PARAMS_KEY__DOUBLE).toString()
            );
            BigDecimal defaultDoubleString      = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__FLOAT).toString()
            );
            BigDecimal defaultFloatString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger           = new BigDecimal(
                    getParameters().get(PARAMS_KEY__INTEGER).toString()
            );
            BigDecimal defaultIntegerString     = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__LONG).toString()
            );
            BigDecimal defaultLongString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__SHORT).toString()
            );
            BigDecimal defaultShortString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, Locale, String)}
     */
    @Test
    void map3() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(GERMAN_LOCALE);

            BigDecimal defaultBigDecimal        = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
            BigDecimal defaultBigDecimalString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger        = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BIG_INTEGER).toString()
            );
            BigDecimal defaultBigIntegerString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BYTE).toString()
            );
            BigDecimal defaultByteString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble            = new BigDecimal(
                    getParameters().get(PARAMS_KEY__DOUBLE).toString()
            );
            BigDecimal defaultDoubleString      = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__FLOAT).toString()
            );
            BigDecimal defaultFloatString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger           = new BigDecimal(
                    getParameters().get(PARAMS_KEY__INTEGER).toString()
            );
            BigDecimal defaultIntegerString     = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__LONG).toString()
            );
            BigDecimal defaultLongString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__SHORT).toString()
            );
            BigDecimal defaultShortString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

            assertEquals( defaultBigDecimal, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultBigDecimalString, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultBigInteger, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultBigIntegerString, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultByte, mapper.map( getParameters(), PARAMS_KEY__BYTE, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultByteString, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultDouble, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultDoubleString, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultFloat, mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultFloatString, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultInteger, mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultIntegerString, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultLong, mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultLongString, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultShort, mapper.map( getParameters(), PARAMS_KEY__SHORT, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultShortString, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );

            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE, FORMAT_PATTERN ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, Locale, String, DecimalFormatSymbols)}
     */
    @Test
    void map4() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(GERMAN_LOCALE);
            DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

            BigDecimal defaultBigDecimal        = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
            BigDecimal defaultBigDecimalString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger        = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BIG_INTEGER).toString()
            );
            BigDecimal defaultBigIntegerString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BYTE).toString()
            );
            BigDecimal defaultByteString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble            = new BigDecimal(
                    getParameters().get(PARAMS_KEY__DOUBLE).toString()
            );
            BigDecimal defaultDoubleString      = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__FLOAT).toString()
            );
            BigDecimal defaultFloatString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger           = new BigDecimal(
                    getParameters().get(PARAMS_KEY__INTEGER).toString()
            );
            BigDecimal defaultIntegerString     = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__LONG).toString()
            );
            BigDecimal defaultLongString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__SHORT).toString()
            );
            BigDecimal defaultShortString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

            assertEquals( defaultBigDecimal, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultBigDecimalString, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultBigInteger, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultBigIntegerString, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultByte, mapper.map( getParameters(), PARAMS_KEY__BYTE, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultByteString, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultDouble, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultDoubleString, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultFloat, mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultFloatString, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultInteger, mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultIntegerString, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultLong, mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultLongString, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultShort, mapper.map( getParameters(), PARAMS_KEY__SHORT, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultShortString, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );

            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, String, DecimalFormatSymbols)}
     */
    @Test
    void map5() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
            DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();

            BigDecimal defaultBigDecimal        = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
            BigDecimal defaultBigDecimalString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger        = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BIG_INTEGER).toString()
            );
            BigDecimal defaultBigIntegerString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BYTE).toString()
            );
            BigDecimal defaultByteString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble            = new BigDecimal(
                    getParameters().get(PARAMS_KEY__DOUBLE).toString()
            );
            BigDecimal defaultDoubleString      = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__FLOAT).toString()
            );
            BigDecimal defaultFloatString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger           = new BigDecimal(
                    getParameters().get(PARAMS_KEY__INTEGER).toString()
            );
            BigDecimal defaultIntegerString     = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__LONG).toString()
            );
            BigDecimal defaultLongString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__SHORT).toString()
            );
            BigDecimal defaultShortString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, Number)}
     */
    @Test
    void map6() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();

            BigDecimal defaultBigDecimal        = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
            BigDecimal defaultBigDecimalString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger        = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BIG_INTEGER).toString()
            );
            BigDecimal defaultBigIntegerString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BYTE).toString()
            );
            BigDecimal defaultByteString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble            = new BigDecimal(
                    getParameters().get(PARAMS_KEY__DOUBLE).toString()
            );
            BigDecimal defaultDoubleString      = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__FLOAT).toString()
            );
            BigDecimal defaultFloatString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger           = new BigDecimal(
                    getParameters().get(PARAMS_KEY__INTEGER).toString()
            );
            BigDecimal defaultIntegerString     = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__LONG).toString()
            );
            BigDecimal defaultLongString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__SHORT).toString()
            );
            BigDecimal defaultShortString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, Locale, Number)}
     */
    @Test
    void map7() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(GERMAN_LOCALE);

            BigDecimal defaultBigDecimal        = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
            BigDecimal defaultBigDecimalString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger        = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BIG_INTEGER).toString()
            );
            BigDecimal defaultBigIntegerString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BYTE).toString()
            );
            BigDecimal defaultByteString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble            = new BigDecimal(
                    getParameters().get(PARAMS_KEY__DOUBLE).toString()
            );
            BigDecimal defaultDoubleString      = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__FLOAT).toString()
            );
            BigDecimal defaultFloatString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger           = new BigDecimal(
                    getParameters().get(PARAMS_KEY__INTEGER).toString()
            );
            BigDecimal defaultIntegerString     = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__LONG).toString()
            );
            BigDecimal defaultLongString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__SHORT).toString()
            );
            BigDecimal defaultShortString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

            assertEquals( defaultBigDecimal, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigDecimalString, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigInteger, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigIntegerString, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultByte, mapper.map( getParameters(), PARAMS_KEY__BYTE, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultByteString, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultDouble, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultDoubleString, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultFloat, mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultFloatString, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultInteger, mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultIntegerString, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultLong, mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultLongString, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultShort, mapper.map( getParameters(), PARAMS_KEY__SHORT, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultShortString, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );

            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, String, Number)}
     */
    @Test
    void map8() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();

            BigDecimal defaultBigDecimal        = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
            BigDecimal defaultBigDecimalString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger        = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BIG_INTEGER).toString()
            );
            BigDecimal defaultBigIntegerString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BYTE).toString()
            );
            BigDecimal defaultByteString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble            = new BigDecimal(
                    getParameters().get(PARAMS_KEY__DOUBLE).toString()
            );
            BigDecimal defaultDoubleString      = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__FLOAT).toString()
            );
            BigDecimal defaultFloatString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger           = new BigDecimal(
                    getParameters().get(PARAMS_KEY__INTEGER).toString()
            );
            BigDecimal defaultIntegerString     = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__LONG).toString()
            );
            BigDecimal defaultLongString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__SHORT).toString()
            );
            BigDecimal defaultShortString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, Locale, String, Number)}
     */
    @Test
    void map9() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(GERMAN_LOCALE);

            BigDecimal defaultBigDecimal        = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
            BigDecimal defaultBigDecimalString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger        = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BIG_INTEGER).toString()
            );
            BigDecimal defaultBigIntegerString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BYTE).toString()
            );
            BigDecimal defaultByteString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble            = new BigDecimal(
                    getParameters().get(PARAMS_KEY__DOUBLE).toString()
            );
            BigDecimal defaultDoubleString      = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__FLOAT).toString()
            );
            BigDecimal defaultFloatString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger           = new BigDecimal(
                    getParameters().get(PARAMS_KEY__INTEGER).toString()
            );
            BigDecimal defaultIntegerString     = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__LONG).toString()
            );
            BigDecimal defaultLongString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__SHORT).toString()
            );
            BigDecimal defaultShortString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

            assertEquals( defaultBigDecimal,
                    mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigDecimalString,
                    mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigInteger,
                    mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigIntegerString,
                    mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultByte,
                    mapper.map( getParameters(), PARAMS_KEY__BYTE, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultByteString,
                    mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultDouble,
                    mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultDoubleString,
                    mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultFloat,
                    mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultFloatString,
                    mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultInteger,
                    mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultIntegerString,
                    mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultLong,
                    mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultLongString,
                    mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultShort,
                    mapper.map( getParameters(), PARAMS_KEY__SHORT, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultShortString,
                    mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );

            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void map10() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
            DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();

            BigDecimal defaultBigDecimal        = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
            BigDecimal defaultBigDecimalString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger        = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BIG_INTEGER).toString()
            );
            BigDecimal defaultBigIntegerString  = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__BYTE).toString()
            );
            BigDecimal defaultByteString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble            = new BigDecimal(
                    getParameters().get(PARAMS_KEY__DOUBLE).toString()
            );
            BigDecimal defaultDoubleString      = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__FLOAT).toString()
            );
            BigDecimal defaultFloatString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger           = new BigDecimal(
                    getParameters().get(PARAMS_KEY__INTEGER).toString()
            );
            BigDecimal defaultIntegerString     = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong              = new BigDecimal(
                    getParameters().get(PARAMS_KEY__LONG).toString()
            );
            BigDecimal defaultLongString        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort             = new BigDecimal(
                    getParameters().get(PARAMS_KEY__SHORT).toString()
            );
            BigDecimal defaultShortString       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(Map, String, Locale, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void map11() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(GERMAN_LOCALE);
            DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

            BigDecimal defaultBigDecimal        = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
            BigDecimal defaultBigDecimalString  = new BigDecimal( format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString() );
            BigDecimal defaultBigInteger        = new BigDecimal( getParameters().get(PARAMS_KEY__BIG_INTEGER).toString() );
            BigDecimal defaultBigIntegerString  = new BigDecimal( format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString() );
            BigDecimal defaultByte              = new BigDecimal( getParameters().get(PARAMS_KEY__BYTE).toString() );
            BigDecimal defaultByteString        = new BigDecimal( format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString() );
            BigDecimal defaultDouble            = new BigDecimal( getParameters().get(PARAMS_KEY__DOUBLE).toString() );
            BigDecimal defaultDoubleString      = new BigDecimal( format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString() );
            BigDecimal defaultFloat             = new BigDecimal( getParameters().get(PARAMS_KEY__FLOAT).toString() );
            BigDecimal defaultFloatString       = new BigDecimal( format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString() );
            BigDecimal defaultInteger           = new BigDecimal( getParameters().get(PARAMS_KEY__INTEGER).toString() );
            BigDecimal defaultIntegerString     = new BigDecimal( format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString() );
            BigDecimal defaultLong              = new BigDecimal( getParameters().get(PARAMS_KEY__LONG).toString() );
            BigDecimal defaultLongString        = new BigDecimal( format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString() );
            BigDecimal defaultShort             = new BigDecimal( getParameters().get(PARAMS_KEY__SHORT).toString() );
            BigDecimal defaultShortString       = new BigDecimal( format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString() );

            assertEquals( defaultBigDecimal,
                    mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigDecimalString,
                    mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigInteger,
                    mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigIntegerString,
                    mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultByte,
                    mapper.map( getParameters(), PARAMS_KEY__BYTE, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultByteString,
                    mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultDouble,
                    mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultDoubleString,
                    mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultFloat,
                    mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultFloatString,
                    mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultInteger,
                    mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultIntegerString,
                    mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultLong,
                    mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultLongString,
                    mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultShort,
                    mapper.map( getParameters(), PARAMS_KEY__SHORT, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultShortString,
                    mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );

            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE,
                    mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(String)}
     */
    @Test
    void map12() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();

            BigDecimal defaultBigDecimal    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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

            assertEquals( defaultBigDecimal, mapper.map( sBigDecimalString ) );
            assertEquals( defaultBigInteger, mapper.map( sBigIntegerString ) );
            assertEquals( defaultByte, mapper.map( sByteString ) );
            assertEquals( defaultDouble, mapper.map( sDoubleString ) );
            assertEquals( defaultFloat, mapper.map( sFloatString ) );
            assertEquals( defaultInteger, mapper.map( sIntegerString ) );
            assertEquals( defaultLong, mapper.map( sLongString ) );
            assertEquals( defaultShort, mapper.map( sShortString ) );

            assertEquals( mapper.getDefaultValue(), mapper.map( sNull ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sObject ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sString ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, boolean, boolean, Number)}
     */
    @Test
    void map13() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();

            BigDecimal defaultBigDecimal    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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

            assertEquals( defaultBigDecimal, mapper.map( sBigDecimalString, true, true, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigInteger, mapper.map( sBigIntegerString, true, true, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultByte, mapper.map( sByteString, true, true, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultDouble, mapper.map( sDoubleString, true, true, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultFloat, mapper.map( sFloatString, true, true, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultInteger, mapper.map( sIntegerString, true, true, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultLong, mapper.map( sLongString, true, true, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultShort, mapper.map( sShortString, true, true, ANOTHER_DEFAULT_VALUE ) );

            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, true, true, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, true, true, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, true, true, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, true, true, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, true, true, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, true, true, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, true, true, ANOTHER_DEFAULT_VALUE ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, Locale)}
     */
    @Test
    void map14() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(GERMAN_LOCALE);

            BigDecimal defaultBigDecimal    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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

            assertEquals( defaultBigDecimal, mapper.map( sBigDecimalString, GERMAN_LOCALE ) );
            assertEquals( defaultBigInteger, mapper.map( sBigIntegerString, GERMAN_LOCALE ) );
            assertEquals( defaultByte, mapper.map( sByteString, GERMAN_LOCALE ) );
            assertEquals( defaultDouble, mapper.map( sDoubleString, GERMAN_LOCALE ) );
            assertEquals( defaultFloat, mapper.map( sFloatString, GERMAN_LOCALE ) );
            assertEquals( defaultInteger, mapper.map( sIntegerString, GERMAN_LOCALE ) );
            assertEquals( defaultLong, mapper.map( sLongString, GERMAN_LOCALE ) );
            assertEquals( defaultShort, mapper.map( sShortString, GERMAN_LOCALE ) );

            assertEquals( mapper.getDefaultValue(), mapper.map( sNull, GERMAN_LOCALE ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sObject, GERMAN_LOCALE ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sString, GERMAN_LOCALE ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty, GERMAN_LOCALE ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed, GERMAN_LOCALE ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty, GERMAN_LOCALE ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder, GERMAN_LOCALE ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, String)}
     */
    @Test
    void map15() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();

            BigDecimal defaultBigDecimal    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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

            assertEquals( defaultBigDecimal, mapper.map( sBigDecimalString, FORMAT_PATTERN ) );
            assertEquals( defaultBigInteger, mapper.map( sBigIntegerString, FORMAT_PATTERN ) );
            assertEquals( defaultByte, mapper.map( sByteString, FORMAT_PATTERN ) );
            assertEquals( defaultDouble, mapper.map( sDoubleString, FORMAT_PATTERN ) );
            assertEquals( defaultFloat, mapper.map( sFloatString, FORMAT_PATTERN ) );
            assertEquals( defaultInteger, mapper.map( sIntegerString, FORMAT_PATTERN ) );
            assertEquals( defaultLong, mapper.map( sLongString, FORMAT_PATTERN ) );
            assertEquals( defaultShort, mapper.map( sShortString, FORMAT_PATTERN ) );

            assertEquals( mapper.getDefaultValue(), mapper.map( sNull, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sObject, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sString, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder, FORMAT_PATTERN ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, Locale, String)}
     */
    @Test
    void map16() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(GERMAN_LOCALE);

            BigDecimal defaultBigDecimal    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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

            assertEquals( defaultBigDecimal, mapper.map( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultBigInteger, mapper.map( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultByte, mapper.map( sByteString, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultDouble, mapper.map( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultFloat, mapper.map( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultInteger, mapper.map( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultLong, mapper.map( sLongString, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( defaultShort, mapper.map( sShortString, GERMAN_LOCALE, FORMAT_PATTERN ) );

            assertEquals( mapper.getDefaultValue(), mapper.map( sNull, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sObject, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sString, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, Locale, String, DecimalFormatSymbols)}
     */
    @Test
    void map17() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(GERMAN_LOCALE);
            DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

            BigDecimal defaultBigDecimal    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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

            assertEquals( defaultBigDecimal, mapper.map( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultBigInteger, mapper.map( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultByte, mapper.map( sByteString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultDouble, mapper.map( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultFloat, mapper.map( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultInteger, mapper.map( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultLong, mapper.map( sLongString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultShort, mapper.map( sShortString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );

            assertEquals( mapper.getDefaultValue(), mapper.map( sNull, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sObject, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, String, DecimalFormatSymbols)}
     */
    @Test
    void map18() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
            DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();

            BigDecimal defaultBigDecimal    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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

            assertEquals( defaultBigDecimal, mapper.map( sBigDecimalString, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultBigInteger, mapper.map( sBigIntegerString, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultByte, mapper.map( sByteString, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultDouble, mapper.map( sDoubleString, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultFloat, mapper.map( sFloatString, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultInteger, mapper.map( sIntegerString, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultLong, mapper.map( sLongString, FORMAT_PATTERN, symbols ) );
            assertEquals( defaultShort, mapper.map( sShortString, FORMAT_PATTERN, symbols ) );

            assertEquals( mapper.getDefaultValue(), mapper.map( sNull, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sObject, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sString, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty, FORMAT_PATTERN, symbols ) );
            assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder, FORMAT_PATTERN, symbols ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, Number)}
     */
    @Test
    void map19() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();

            BigDecimal defaultBigDecimal    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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

            assertEquals( defaultBigDecimal, mapper.map( sBigDecimalString, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigInteger, mapper.map( sBigIntegerString, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultByte, mapper.map( sByteString, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultDouble, mapper.map( sDoubleString, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultFloat, mapper.map( sFloatString, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultInteger, mapper.map( sIntegerString, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultLong, mapper.map( sLongString, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultShort, mapper.map( sShortString, ANOTHER_DEFAULT_VALUE ) );

            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, ANOTHER_DEFAULT_VALUE ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, Locale, Number)}
     */
    @Test
    void map20() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(GERMAN_LOCALE);

            BigDecimal defaultBigDecimal    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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

            assertEquals( defaultBigDecimal, mapper.map( sBigDecimalString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigInteger, mapper.map( sBigIntegerString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultByte, mapper.map( sByteString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultDouble, mapper.map( sDoubleString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultFloat, mapper.map( sFloatString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultInteger, mapper.map( sIntegerString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultLong, mapper.map( sLongString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultShort, mapper.map( sShortString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );

            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, String, Number)}
     */
    @Test
    void map21() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();

            BigDecimal defaultBigDecimal    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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

            assertEquals( defaultBigDecimal, mapper.map( sBigDecimalString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigInteger, mapper.map( sBigIntegerString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultByte, mapper.map( sByteString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultDouble, mapper.map( sDoubleString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultFloat, mapper.map( sFloatString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultInteger, mapper.map( sIntegerString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultLong, mapper.map( sLongString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultShort, mapper.map( sShortString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );

            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, Locale, String, Number)}
     */
    @Test
    void map22() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(GERMAN_LOCALE);

            BigDecimal defaultBigDecimal    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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

            assertEquals( defaultBigDecimal, mapper.map( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigInteger, mapper.map( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultByte, mapper.map( sByteString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultDouble, mapper.map( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultFloat, mapper.map( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultInteger, mapper.map( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultLong, mapper.map( sLongString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultShort, mapper.map( sShortString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );

            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void map23() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
            DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();

            BigDecimal defaultBigDecimal    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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

            assertEquals( defaultBigDecimal, mapper.map( sBigDecimalString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigInteger, mapper.map( sBigIntegerString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultByte, mapper.map( sByteString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultDouble, mapper.map( sDoubleString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultFloat, mapper.map( sFloatString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultInteger, mapper.map( sIntegerString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultLong, mapper.map( sLongString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultShort, mapper.map( sShortString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );

            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#map(String, Locale, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void map24() {
        try {
            DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(GERMAN_LOCALE);
            DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

            BigDecimal defaultBigDecimal    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING).toString() ).toString()
            );
            BigDecimal defaultBigInteger    = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultByte          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__BYTE_STRING).toString() ).toString()
            );
            BigDecimal defaultDouble        = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__DOUBLE_STRING).toString() ).toString()
            );
            BigDecimal defaultFloat         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__FLOAT_STRING).toString() ).toString()
            );
            BigDecimal defaultInteger       = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__INTEGER_STRING).toString() ).toString()
            );
            BigDecimal defaultLong          = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__LONG_STRING).toString() ).toString()
            );
            BigDecimal defaultShort         = new BigDecimal(
                    format.parse( getParameters().get(PARAMS_KEY__SHORT_STRING).toString() ).toString()
            );

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

            assertEquals( defaultBigDecimal, mapper.map( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultBigInteger, mapper.map( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultByte, mapper.map( sByteString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultDouble, mapper.map( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultFloat, mapper.map( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultInteger, mapper.map( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultLong, mapper.map( sLongString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( defaultShort, mapper.map( sShortString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );

            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
            assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String)}
     */
    @Test
    void unformat() {
        BigDecimal defaultBigDecimal    = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
        BigDecimal defaultBigInteger    = new BigDecimal( getParameters().get(PARAMS_KEY__BIG_INTEGER).toString() );
        BigDecimal defaultByte          = new BigDecimal( getParameters().get(PARAMS_KEY__BYTE).toString() );
        BigDecimal defaultDouble        = new BigDecimal( getParameters().get(PARAMS_KEY__DOUBLE).toString() );
        BigDecimal defaultFloat         = new BigDecimal( getParameters().get(PARAMS_KEY__FLOAT).toString() );
        BigDecimal defaultInteger       = new BigDecimal( getParameters().get(PARAMS_KEY__INTEGER).toString() );
        BigDecimal defaultLong          = new BigDecimal( getParameters().get(PARAMS_KEY__LONG).toString() );
        BigDecimal defaultShort         = new BigDecimal( getParameters().get(PARAMS_KEY__SHORT).toString() );

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
        BigDecimal defaultBigDecimal    = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
        BigDecimal defaultBigInteger    = new BigDecimal( getParameters().get(PARAMS_KEY__BIG_INTEGER).toString() );
        BigDecimal defaultByte          = new BigDecimal( getParameters().get(PARAMS_KEY__BYTE).toString() );
        BigDecimal defaultDouble        = new BigDecimal( getParameters().get(PARAMS_KEY__DOUBLE).toString() );
        BigDecimal defaultFloat         = new BigDecimal( getParameters().get(PARAMS_KEY__FLOAT).toString() );
        BigDecimal defaultInteger       = new BigDecimal( getParameters().get(PARAMS_KEY__INTEGER).toString() );
        BigDecimal defaultLong          = new BigDecimal( getParameters().get(PARAMS_KEY__LONG).toString() );
        BigDecimal defaultShort         = new BigDecimal( getParameters().get(PARAMS_KEY__SHORT).toString() );

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

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, GERMAN_LOCALE ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, GERMAN_LOCALE ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, GERMAN_LOCALE ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, GERMAN_LOCALE ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, GERMAN_LOCALE ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, GERMAN_LOCALE ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, GERMAN_LOCALE ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, GERMAN_LOCALE ) );

        assertEquals( mapper.getDefaultValue(), mapper.unformat( sNull, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sObject, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringEmpty, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmed, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmedEmpty, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringBuilder, GERMAN_LOCALE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, String)}
     */
    @Test
    void unformat2() {
        BigDecimal defaultBigDecimal    = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
        BigDecimal defaultBigInteger    = new BigDecimal( getParameters().get(PARAMS_KEY__BIG_INTEGER).toString() );
        BigDecimal defaultByte          = new BigDecimal( getParameters().get(PARAMS_KEY__BYTE).toString() );
        BigDecimal defaultDouble        = new BigDecimal( getParameters().get(PARAMS_KEY__DOUBLE).toString() );
        BigDecimal defaultFloat         = new BigDecimal( getParameters().get(PARAMS_KEY__FLOAT).toString() );
        BigDecimal defaultInteger       = new BigDecimal( getParameters().get(PARAMS_KEY__INTEGER).toString() );
        BigDecimal defaultLong          = new BigDecimal( getParameters().get(PARAMS_KEY__LONG).toString() );
        BigDecimal defaultShort         = new BigDecimal( getParameters().get(PARAMS_KEY__SHORT).toString() );

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
        BigDecimal defaultBigDecimal    = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
        BigDecimal defaultBigInteger    = new BigDecimal( getParameters().get(PARAMS_KEY__BIG_INTEGER).toString() );
        BigDecimal defaultByte          = new BigDecimal( getParameters().get(PARAMS_KEY__BYTE).toString() );
        BigDecimal defaultDouble        = new BigDecimal( getParameters().get(PARAMS_KEY__DOUBLE).toString() );
        BigDecimal defaultFloat         = new BigDecimal( getParameters().get(PARAMS_KEY__FLOAT).toString() );
        BigDecimal defaultInteger       = new BigDecimal( getParameters().get(PARAMS_KEY__INTEGER).toString() );
        BigDecimal defaultLong          = new BigDecimal( getParameters().get(PARAMS_KEY__LONG).toString() );
        BigDecimal defaultShort         = new BigDecimal( getParameters().get(PARAMS_KEY__SHORT).toString() );

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

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, GERMAN_LOCALE, FORMAT_PATTERN ) );

        assertEquals( mapper.getDefaultValue(), mapper.unformat( sNull, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sObject, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, Locale, String, DecimalFormatSymbols)}
     */
    @Test
    void unformat4() {
        BigDecimal defaultBigDecimal    = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
        BigDecimal defaultBigInteger    = new BigDecimal( getParameters().get(PARAMS_KEY__BIG_INTEGER).toString() );
        BigDecimal defaultByte          = new BigDecimal( getParameters().get(PARAMS_KEY__BYTE).toString() );
        BigDecimal defaultDouble        = new BigDecimal( getParameters().get(PARAMS_KEY__DOUBLE).toString() );
        BigDecimal defaultFloat         = new BigDecimal( getParameters().get(PARAMS_KEY__FLOAT).toString() );
        BigDecimal defaultInteger       = new BigDecimal( getParameters().get(PARAMS_KEY__INTEGER).toString() );
        BigDecimal defaultLong          = new BigDecimal( getParameters().get(PARAMS_KEY__LONG).toString() );
        BigDecimal defaultShort         = new BigDecimal( getParameters().get(PARAMS_KEY__SHORT).toString() );

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

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );

        assertEquals( mapper.getDefaultValue(), mapper.unformat( sNull, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sObject, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, String, DecimalFormatSymbols)}
     */
    @Test
    void unformat5() {
        BigDecimal defaultBigDecimal    = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
        BigDecimal defaultBigInteger    = new BigDecimal( getParameters().get(PARAMS_KEY__BIG_INTEGER).toString() );
        BigDecimal defaultByte          = new BigDecimal( getParameters().get(PARAMS_KEY__BYTE).toString() );
        BigDecimal defaultDouble        = new BigDecimal( getParameters().get(PARAMS_KEY__DOUBLE).toString() );
        BigDecimal defaultFloat         = new BigDecimal( getParameters().get(PARAMS_KEY__FLOAT).toString() );
        BigDecimal defaultInteger       = new BigDecimal( getParameters().get(PARAMS_KEY__INTEGER).toString() );
        BigDecimal defaultLong          = new BigDecimal( getParameters().get(PARAMS_KEY__LONG).toString() );
        BigDecimal defaultShort         = new BigDecimal( getParameters().get(PARAMS_KEY__SHORT).toString() );

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

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

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
        BigDecimal defaultBigDecimal    = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
        BigDecimal defaultBigInteger    = new BigDecimal( getParameters().get(PARAMS_KEY__BIG_INTEGER).toString() );
        BigDecimal defaultByte          = new BigDecimal( getParameters().get(PARAMS_KEY__BYTE).toString() );
        BigDecimal defaultDouble        = new BigDecimal( getParameters().get(PARAMS_KEY__DOUBLE).toString() );
        BigDecimal defaultFloat         = new BigDecimal( getParameters().get(PARAMS_KEY__FLOAT).toString() );
        BigDecimal defaultInteger       = new BigDecimal( getParameters().get(PARAMS_KEY__INTEGER).toString() );
        BigDecimal defaultLong          = new BigDecimal( getParameters().get(PARAMS_KEY__LONG).toString() );
        BigDecimal defaultShort         = new BigDecimal( getParameters().get(PARAMS_KEY__SHORT).toString() );

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
        BigDecimal defaultBigDecimal    = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
        BigDecimal defaultBigInteger    = new BigDecimal( getParameters().get(PARAMS_KEY__BIG_INTEGER).toString() );
        BigDecimal defaultByte          = new BigDecimal( getParameters().get(PARAMS_KEY__BYTE).toString() );
        BigDecimal defaultDouble        = new BigDecimal( getParameters().get(PARAMS_KEY__DOUBLE).toString() );
        BigDecimal defaultFloat         = new BigDecimal( getParameters().get(PARAMS_KEY__FLOAT).toString() );
        BigDecimal defaultInteger       = new BigDecimal( getParameters().get(PARAMS_KEY__INTEGER).toString() );
        BigDecimal defaultLong          = new BigDecimal( getParameters().get(PARAMS_KEY__LONG).toString() );
        BigDecimal defaultShort         = new BigDecimal( getParameters().get(PARAMS_KEY__SHORT).toString() );

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

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sNull, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sObject, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringEmpty, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmed, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmedEmpty, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringBuilder, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, String, Number)}
     */
    @Test
    void unformat8() {
        BigDecimal defaultBigDecimal    = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
        BigDecimal defaultBigInteger    = new BigDecimal( getParameters().get(PARAMS_KEY__BIG_INTEGER).toString() );
        BigDecimal defaultByte          = new BigDecimal( getParameters().get(PARAMS_KEY__BYTE).toString() );
        BigDecimal defaultDouble        = new BigDecimal( getParameters().get(PARAMS_KEY__DOUBLE).toString() );
        BigDecimal defaultFloat         = new BigDecimal( getParameters().get(PARAMS_KEY__FLOAT).toString() );
        BigDecimal defaultInteger       = new BigDecimal( getParameters().get(PARAMS_KEY__INTEGER).toString() );
        BigDecimal defaultLong          = new BigDecimal( getParameters().get(PARAMS_KEY__LONG).toString() );
        BigDecimal defaultShort         = new BigDecimal( getParameters().get(PARAMS_KEY__SHORT).toString() );

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
        BigDecimal defaultBigDecimal    = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
        BigDecimal defaultBigInteger    = new BigDecimal( getParameters().get(PARAMS_KEY__BIG_INTEGER).toString() );
        BigDecimal defaultByte          = new BigDecimal( getParameters().get(PARAMS_KEY__BYTE).toString() );
        BigDecimal defaultDouble        = new BigDecimal( getParameters().get(PARAMS_KEY__DOUBLE).toString() );
        BigDecimal defaultFloat         = new BigDecimal( getParameters().get(PARAMS_KEY__FLOAT).toString() );
        BigDecimal defaultInteger       = new BigDecimal( getParameters().get(PARAMS_KEY__INTEGER).toString() );
        BigDecimal defaultLong          = new BigDecimal( getParameters().get(PARAMS_KEY__LONG).toString() );
        BigDecimal defaultShort         = new BigDecimal( getParameters().get(PARAMS_KEY__SHORT).toString() );

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

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sNull, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sObject, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link IBigDecimalMapper#unformat(String, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void unformat10() {
        BigDecimal defaultBigDecimal    = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
        BigDecimal defaultBigInteger    = new BigDecimal( getParameters().get(PARAMS_KEY__BIG_INTEGER).toString() );
        BigDecimal defaultByte          = new BigDecimal( getParameters().get(PARAMS_KEY__BYTE).toString() );
        BigDecimal defaultDouble        = new BigDecimal( getParameters().get(PARAMS_KEY__DOUBLE).toString() );
        BigDecimal defaultFloat         = new BigDecimal( getParameters().get(PARAMS_KEY__FLOAT).toString() );
        BigDecimal defaultInteger       = new BigDecimal( getParameters().get(PARAMS_KEY__INTEGER).toString() );
        BigDecimal defaultLong          = new BigDecimal( getParameters().get(PARAMS_KEY__LONG).toString() );
        BigDecimal defaultShort         = new BigDecimal( getParameters().get(PARAMS_KEY__SHORT).toString() );

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

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

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
        BigDecimal defaultBigDecimal    = (BigDecimal) getParameters().get(PARAMS_KEY__BIG_DECIMAL);
        BigDecimal defaultBigInteger    = new BigDecimal( getParameters().get(PARAMS_KEY__BIG_INTEGER).toString() );
        BigDecimal defaultByte          = new BigDecimal( getParameters().get(PARAMS_KEY__BYTE).toString() );
        BigDecimal defaultDouble        = new BigDecimal( getParameters().get(PARAMS_KEY__DOUBLE).toString() );
        BigDecimal defaultFloat         = new BigDecimal( getParameters().get(PARAMS_KEY__FLOAT).toString() );
        BigDecimal defaultInteger       = new BigDecimal( getParameters().get(PARAMS_KEY__INTEGER).toString() );
        BigDecimal defaultLong          = new BigDecimal( getParameters().get(PARAMS_KEY__LONG).toString() );
        BigDecimal defaultShort         = new BigDecimal( getParameters().get(PARAMS_KEY__SHORT).toString() );

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

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals( defaultBigDecimal, mapper.unformat( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultBigInteger, mapper.unformat( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultByte, mapper.unformat( sByteString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultDouble, mapper.unformat( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultFloat, mapper.unformat( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultInteger, mapper.unformat( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultLong, mapper.unformat( sLongString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( defaultShort, mapper.unformat( sShortString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sNull, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sObject, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
    }

}