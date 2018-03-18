package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static de.ckraus.commons.mapper.TestHelper.*;

@SuppressWarnings({"WeakerAccess"})
class INumericTypeMapperTest {

    private final static Locale GERMAN_LOCALE = Locale.GERMAN;
    private final static String FORMAT_PATTERN = "#,##0.00;(#,##0.00)";

    private final static Number ANOTHER_DEFAULT_VALUE   = 5113;

    // create mapper instance
    private INumericTypeMapper<Number> mapper = new INumericTypeMapper<Number>() {
        @Override
        public Number map(
                Number number,
                Number defaultValue
        ) {
            return defaultValue;
        }

        @Override
        public Number unformat(
                String sNumber,
                Locale locale,
                String sPattern,
                DecimalFormatSymbols decimalFormatSymbols,
                Number defaultValue
        ) {
            return defaultValue;
        }
    };


    /**
     * test for {@link INumericTypeMapper#getDecimalFormat()}
     */
    @Test
    void getDecimalFormat() {
        assertEquals( DecimalFormat.getInstance(), mapper.getDecimalFormat() );
    }

    /**
     * test for {@link INumericTypeMapper#getDecimalFormat(Locale)}
     */
    @Test
    void getDecimalFormat1() {
        assertEquals( DecimalFormat.getInstance(GERMAN_LOCALE), mapper.getDecimalFormat(GERMAN_LOCALE) );
    }

    /**
     * test for {@link INumericTypeMapper#getDecimalFormat(Locale, String)}
     */
    @Test
    void getDecimalFormat2() {
        DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(GERMAN_LOCALE);
        format.applyPattern(FORMAT_PATTERN);

        DecimalFormat mapperFormat = mapper.getDecimalFormat(
                GERMAN_LOCALE,
                FORMAT_PATTERN
        );

        assertEquals( format.toPattern(), mapperFormat.toPattern() );
    }

    /**
     * test for {@link INumericTypeMapper#getDecimalFormat(String)}
     */
    @Test
    void getDecimalFormat3() {
        DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
        format.applyPattern(FORMAT_PATTERN);

        DecimalFormat mapperFormat = mapper.getDecimalFormat(FORMAT_PATTERN);

        assertEquals( format, mapperFormat );
        assertEquals( format.toPattern(), mapperFormat.toPattern() );
    }

    /**
     * test for {@link INumericTypeMapper#getDecimalFormat(String, DecimalFormatSymbols)}
     */
    @Test
    void getDecimalFormat4() {
        DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
        format.applyPattern(FORMAT_PATTERN);
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        format.setDecimalFormatSymbols(symbols);

        DecimalFormat mapperFormat = mapper.getDecimalFormat(
                FORMAT_PATTERN,
                symbols
        );

        assertEquals( format, mapperFormat );
        assertEquals( format.toPattern(), mapperFormat.toPattern() );
    }

    /**
     * test for {@link INumericTypeMapper#getDecimalFormat(Locale, String, DecimalFormatSymbols)}
     */
    @Test
    void getDecimalFormat5() {
        DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(GERMAN_LOCALE);
        format.applyPattern(FORMAT_PATTERN);
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);
        format.setDecimalFormatSymbols(symbols);

        DecimalFormat mapperFormat = mapper.getDecimalFormat(
                GERMAN_LOCALE,
                FORMAT_PATTERN,
                symbols
        );

        assertEquals( format, mapperFormat );
        assertEquals( format.toPattern(), mapperFormat.toPattern() );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String)}
     */
    @Test
    void map() {
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BOOLEAN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BOOLEAN_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BYTE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CALENDAR ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CALENDAR_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CHARACTER ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DATE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DATE_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DOUBLE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__FLOAT ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__INTEGER ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LIST ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATE_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALTIME ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALTIME_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LONG ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LONG_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__SHORT ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, Locale)}
     */
    @Test
    void map1() {
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BOOLEAN_STRING, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BYTE, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CALENDAR, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CALENDAR_STRING, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CHARACTER, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DATE, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DATE_STRING, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LIST, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATE, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATE_STRING, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME_STRING, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALTIME, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALTIME_STRING, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__SHORT, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, String)}
     */
    @Test
    void map2() {
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, FORMAT_PATTERN ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BOOLEAN_STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BYTE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CALENDAR, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CALENDAR_STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CHARACTER, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DATE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DATE_STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DOUBLE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__FLOAT, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__INTEGER, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LIST, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATE_STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME_STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALTIME, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALTIME_STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LONG, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__SHORT, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, FORMAT_PATTERN  ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, Locale, String)}
     */
    @Test
    void map3() {
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BOOLEAN_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BYTE, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CALENDAR, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CALENDAR_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CHARACTER, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DATE, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DATE_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LIST, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATE, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATE_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALTIME, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALTIME_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__SHORT, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE, FORMAT_PATTERN ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, Locale, String, DecimalFormatSymbols)}
     */
    @Test
    void map4() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BOOLEAN_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BYTE, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CALENDAR, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CALENDAR_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CHARACTER, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DATE, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DATE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LIST, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATE, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALTIME, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALTIME_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__SHORT, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, String, DecimalFormatSymbols)}
     */
    @Test
    void map5() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, FORMAT_PATTERN, symbols ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BOOLEAN_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BYTE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CALENDAR, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CALENDAR_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CHARACTER, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DATE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DATE_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DOUBLE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__FLOAT, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__INTEGER, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LIST, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATE_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALTIME, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALTIME_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LONG, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__SHORT, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, FORMAT_PATTERN, symbols ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, Number)}
     */
    @Test
    void map6() {
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__NO_KEY, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BOOLEAN_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BYTE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__CALENDAR, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__CALENDAR_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__CHARACTER, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__DATE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__DATE_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__FLOAT, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__INTEGER, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LIST, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALDATE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALDATE_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALTIME, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALTIME_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LONG, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__OBJECT, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__SHORT, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, Locale, Number)}
     */
    @Test
    void map7() {
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BOOLEAN_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BYTE, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__CALENDAR, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__CALENDAR_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__CHARACTER, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__DATE, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__DATE_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LIST, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALDATE, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALDATE_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALTIME, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALTIME_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__SHORT, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, String, Number)}
     */
    @Test
    void map8() {
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__NO_KEY, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BOOLEAN_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BYTE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__CALENDAR, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__CALENDAR_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__CHARACTER, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__DATE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__DATE_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__FLOAT, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__INTEGER, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LIST, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALDATE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALDATE_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALTIME, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LOCALTIME_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LONG, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__OBJECT, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__SHORT, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, Locale, String, Number)}
     */
    @Test
    void map9() {
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BYTE, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CALENDAR, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CALENDAR_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DATE, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DATE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LIST, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATE, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALTIME, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__SHORT, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
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

    /**
     * test for {@link INumericTypeMapper#map(Map, String, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void map10() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BYTE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CALENDAR, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CALENDAR_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DATE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DATE_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LIST, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATE_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALTIME, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALTIME_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LONG, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__SHORT, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
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
     * test for {@link INumericTypeMapper#map(Map, String, Locale, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void map11() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BYTE, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CALENDAR, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CALENDAR_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DATE, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DATE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LIST, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATE, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATE_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALTIME, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALTIME_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__SHORT, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
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

    /**
     * test for {@link INumericTypeMapper#map(String)}
     */
    @Test
    void map12() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( mapper.getDefaultValue(), mapper.map( sNull ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigDecimal ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigDecimalString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigInteger ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigIntegerString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBoolean ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBooleanString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sByte ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sByteString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCalendar ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCalendarString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCharacter ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDate ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDateString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDouble ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDoubleString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sFloat ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sFloatString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sInteger ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sIntegerString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sList ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDate ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateTime ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateTimeString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalTime ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalTimeString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLong ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLongString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sObject ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sShort ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sShortString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sString ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, boolean, boolean, Number)}
     */
    @Test
    void map13() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigDecimal, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigDecimalString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigInteger, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigIntegerString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBoolean, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBooleanString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sByte, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sByteString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCalendar, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCalendarString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCharacter, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDate, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDateString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDouble, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDoubleString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sFloat, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sFloatString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sInteger, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sIntegerString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sList, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDate, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateTime, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateTimeString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalTime, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalTimeString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLong, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLongString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sShort, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sShortString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, true, true, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, true, true, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, Locale)}
     */
    @Test
    void map14() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( mapper.getDefaultValue(), mapper.map( sNull, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigDecimal, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigDecimalString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigInteger, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigIntegerString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBoolean, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBooleanString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sByte, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sByteString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCalendar, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCalendarString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCharacter, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDate, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDateString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDouble, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDoubleString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sFloat, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sFloatString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sInteger, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sIntegerString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sList, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDate, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateTime, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateTimeString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalTime, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalTimeString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLong, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLongString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sObject, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sShort, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sShortString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder, GERMAN_LOCALE ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, String)}
     */
    @Test
    void map15() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( mapper.getDefaultValue(), mapper.map( sNull, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigDecimal, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigDecimalString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigInteger, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigIntegerString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBoolean, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBooleanString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sByte, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sByteString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCalendar, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCalendarString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCharacter, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDate, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDateString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDouble, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDoubleString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sFloat, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sFloatString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sInteger, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sIntegerString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sList, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDate, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateTime, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateTimeString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalTime, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalTimeString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLong, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLongString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sObject, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sShort, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sShortString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder, FORMAT_PATTERN ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, Locale, String)}
     */
    @Test
    void map16() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( mapper.getDefaultValue(), mapper.map( sNull, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigDecimal, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigInteger, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBoolean, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBooleanString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sByte, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sByteString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCalendar, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCalendarString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCharacter, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDate, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDateString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDouble, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sFloat, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sInteger, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sList, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDate, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateTime, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateTimeString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalTime, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalTimeString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLong, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLongString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sObject, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sShort, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sShortString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, Locale, String, DecimalFormatSymbols)}
     */
    @Test
    void map17() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals( mapper.getDefaultValue(), mapper.map( sNull, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigDecimal, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigInteger, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBoolean, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBooleanString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sByte, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sByteString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCalendar, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCalendarString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCharacter, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDate, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDateString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDouble, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sFloat, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sInteger, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sList, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDate, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateTime, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateTimeString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalTime, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalTimeString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLong, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLongString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sObject, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sShort, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sShortString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, String, DecimalFormatSymbols)}
     */
    @Test
    void map18() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals( mapper.getDefaultValue(), mapper.map( sNull, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigDecimal, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigDecimalString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigInteger, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBigIntegerString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBoolean, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sBooleanString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sByte, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sByteString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCalendar, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCalendarString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sCharacter, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDate, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDateString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDouble, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sDoubleString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sFloat, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sFloatString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sInteger, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sIntegerString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sList, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDate, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateTime, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalDateTimeString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalTime, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLocalTimeString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLong, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sLongString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sObject, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sShort, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sShortString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringEmpty, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmed, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringUntrimmedEmpty, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( sStringBuilder, FORMAT_PATTERN, symbols ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, Number)}
     */
    @Test
    void map19() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigDecimal, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigDecimalString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigInteger, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigIntegerString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBoolean, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBooleanString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sByte, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sByteString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCalendar, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCalendarString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCharacter, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDate, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDateString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDouble, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDoubleString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sFloat, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sFloatString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sInteger, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sIntegerString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sList, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDate, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateTime, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateTimeString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalTime, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalTimeString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLong, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLongString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sShort, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sShortString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, Locale, Number)}
     */
    @Test
    void map20() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigDecimal, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigDecimalString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigInteger, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigIntegerString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBoolean, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBooleanString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sByte, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sByteString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCalendar, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCalendarString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCharacter, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDate, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDateString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDouble, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDoubleString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sFloat, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sFloatString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sInteger, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sIntegerString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sList, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDate, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateTime, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateTimeString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalTime, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalTimeString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLong, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLongString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sShort, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sShortString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, String, Number)}
     */
    @Test
    void map21() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigDecimal, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigDecimalString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigInteger, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigIntegerString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBoolean, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBooleanString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sByte, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sByteString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCalendar, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCalendarString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCharacter, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDate, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDateString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDouble, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDoubleString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sFloat, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sFloatString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sInteger, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sIntegerString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sList, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDate, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateTime, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateTimeString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalTime, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalTimeString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLong, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLongString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sShort, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sShortString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, Locale, String, Number)}
     */
    @Test
    void map22() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigDecimal, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigInteger, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBoolean, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBooleanString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sByte, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sByteString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCalendar, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCalendarString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCharacter, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDate, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDateString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDouble, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sFloat, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sInteger, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sList, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDate, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateTime, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateTimeString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalTime, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalTimeString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLong, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLongString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sShort, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sShortString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void map23() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigDecimal, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigDecimalString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigInteger, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigIntegerString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBoolean, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBooleanString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sByte, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sByteString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCalendar, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCalendarString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCharacter, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDate, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDateString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDouble, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDoubleString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sFloat, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sFloatString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sInteger, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sIntegerString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sList, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDate, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateTime, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateTimeString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalTime, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalTimeString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLong, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLongString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sShort, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sShortString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, Locale, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void map24() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sNull, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigDecimal, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigInteger, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBoolean, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sBooleanString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sByte, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sByteString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCalendar, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCalendarString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sCharacter, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDate, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDateString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDouble, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sFloat, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sInteger, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sList, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDate, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateTime, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalDateTimeString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalTime, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLocalTimeString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLong, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sLongString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sObject, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sShort, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sShortString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String)}
     */
    @Test
    void unformat() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( mapper.getDefaultValue(), mapper.unformat( sNull ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigDecimal ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigDecimalString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigInteger ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigIntegerString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBoolean ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBooleanString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sByte ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sByteString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCalendar ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCalendarString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCharacter ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDate ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDateString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDouble ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDoubleString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sFloat ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sFloatString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sInteger ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sIntegerString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sList ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDate ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateTime ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateTimeString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalTime ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalTimeString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLong ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLongString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sObject ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sShort ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sShortString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sString ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringEmpty ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmed ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmedEmpty ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringBuilder ) );
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, Locale)}
     */
    @Test
    void unformat1() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( mapper.getDefaultValue(), mapper.unformat( sNull, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigDecimal, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigDecimalString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigInteger, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigIntegerString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBoolean, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBooleanString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sByte, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sByteString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCalendar, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCalendarString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCharacter, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDate, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDateString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDouble, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDoubleString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sFloat, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sFloatString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sInteger, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sIntegerString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sList, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDate, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateTime, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateTimeString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalTime, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalTimeString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLong, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLongString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sObject, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sShort, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sShortString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sString, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringEmpty, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmed, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmedEmpty, GERMAN_LOCALE ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringBuilder, GERMAN_LOCALE ) );
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, String)}
     */
    @Test
    void unformat2() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( mapper.getDefaultValue(), mapper.unformat( sNull, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigDecimal, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigDecimalString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigInteger, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigIntegerString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBoolean, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBooleanString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sByte, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sByteString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCalendar, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCalendarString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCharacter, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDate, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDateString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDouble, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDoubleString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sFloat, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sFloatString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sInteger, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sIntegerString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sList, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDate, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateTime, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateTimeString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalTime, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalTimeString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLong, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLongString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sObject, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sShort, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sShortString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sString, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringEmpty, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmed, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmedEmpty, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringBuilder, FORMAT_PATTERN ) );
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, Locale, String)}
     */
    @Test
    void unformat3() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( mapper.getDefaultValue(), mapper.unformat( sNull, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigDecimal, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigInteger, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBoolean, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBooleanString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sByte, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sByteString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCalendar, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCalendarString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCharacter, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDate, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDateString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDouble, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sFloat, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sInteger, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sList, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDate, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateTime, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateTimeString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalTime, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalTimeString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLong, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLongString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sObject, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sShort, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sShortString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sString, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN ) );
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, Locale, String, DecimalFormatSymbols)}
     */
    @Test
    void unformat4() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals( mapper.getDefaultValue(), mapper.unformat( sNull, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigDecimal, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigInteger, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBoolean, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBooleanString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sByte, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sByteString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCalendar, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCalendarString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCharacter, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDate, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDateString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDouble, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sFloat, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sInteger, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sList, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDate, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateTime, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateTimeString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalTime, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalTimeString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLong, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLongString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sObject, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sShort, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sShortString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sString, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN, symbols ) );
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, String, DecimalFormatSymbols)}
     */
    @Test
    void unformat5() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals( mapper.getDefaultValue(), mapper.unformat( sNull, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigDecimal, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigDecimalString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigInteger, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBigIntegerString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBoolean, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sBooleanString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sByte, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sByteString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCalendar, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCalendarString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sCharacter, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDate, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDateString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDouble, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sDoubleString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sFloat, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sFloatString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sInteger, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sIntegerString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sList, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDate, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateTime, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalDateTimeString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalTime, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLocalTimeString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLong, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sLongString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sObject, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sShort, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sShortString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sString, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringEmpty, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmed, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringUntrimmedEmpty, FORMAT_PATTERN, symbols ) );
        assertEquals( mapper.getDefaultValue(), mapper.unformat( sStringBuilder, FORMAT_PATTERN, symbols ) );
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, Number)}
     */
    @Test
    void unformat6() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sNull, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigDecimal, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigDecimalString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigInteger, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigIntegerString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBoolean, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBooleanString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sByte, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sByteString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCalendar, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCalendarString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCharacter, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDate, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDateString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDouble, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDoubleString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sFloat, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sFloatString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sInteger, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sIntegerString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sList, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDate, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateTime, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateTimeString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalTime, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalTimeString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLong, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLongString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sObject, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sShort, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sShortString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sString, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringEmpty, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmed, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmedEmpty, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringBuilder, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, Locale, Number)}
     */
    @Test
    void unformat7() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sNull, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigDecimal, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigDecimalString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigInteger, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigIntegerString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBoolean, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBooleanString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sByte, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sByteString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCalendar, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCalendarString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCharacter, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDate, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDateString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDouble, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDoubleString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sFloat, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sFloatString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sInteger, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sIntegerString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sList, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDate, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateTime, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateTimeString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalTime, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalTimeString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLong, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLongString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sObject, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sShort, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sShortString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sString, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringEmpty, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmed, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmedEmpty, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringBuilder, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, String, Number)}
     */
    @Test
    void unformat8() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sNull, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigDecimal, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigDecimalString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigInteger, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigIntegerString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBoolean, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBooleanString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sByte, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sByteString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCalendar, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCalendarString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCharacter, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDate, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDateString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDouble, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDoubleString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sFloat, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sFloatString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sInteger, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sIntegerString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sList, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDate, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateTime, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateTimeString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalTime, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalTimeString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLong, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLongString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sObject, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sShort, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sShortString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sString, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringEmpty, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmed, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmedEmpty, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringBuilder, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, Locale, String, Number)}
     */
    @Test
    void unformat9() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sNull, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigDecimal, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigInteger, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBoolean, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBooleanString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sByte, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sByteString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCalendar, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCalendarString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCharacter, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDate, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDateString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDouble, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sFloat, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sInteger, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sList, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDate, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateTime, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateTimeString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalTime, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalTimeString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLong, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLongString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sObject, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sShort, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sShortString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sString, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void unformat10() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sNull, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigDecimal, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigDecimalString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigInteger, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigIntegerString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBoolean, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBooleanString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sByte, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sByteString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCalendar, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCalendarString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCharacter, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDate, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDateString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDouble, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDoubleString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sFloat, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sFloatString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sInteger, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sIntegerString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sList, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDate, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateTime, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateTimeString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalTime, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalTimeString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLong, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLongString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sObject, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sShort, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sShortString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sString, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringEmpty, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmed, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmedEmpty, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringBuilder, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, Locale, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void unformat11() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sNull, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigDecimal, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigInteger, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBoolean, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sBooleanString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sByte, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sByteString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCalendar, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCalendarString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sCharacter, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDate, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDateString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDouble, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sFloat, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sInteger, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sList, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDate, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateTime, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalDateTimeString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalTime, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLocalTimeString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLong, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sLongString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sObject, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sShort, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sShortString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.unformat( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link INumericTypeMapper#unformatToNumber(String, Locale, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void unformatToNumber() {
        String sNull                    = null;
        String sBigDecimal              = getParameters().get(PARAMS_KEY__BIG_DECIMAL).toString();
        String sBigDecimalString        = (String) getParameters().get(PARAMS_KEY__BIG_DECIMAL_STRING);
        String sBigInteger              = getParameters().get(PARAMS_KEY__BIG_INTEGER).toString();
        String sBigIntegerString        = (String) getParameters().get(PARAMS_KEY__BIG_INTEGER_STRING);
        String sBoolean                 = getParameters().get(PARAMS_KEY__BOOLEAN).toString();
        String sBooleanString           = (String) getParameters().get(PARAMS_KEY__BOOLEAN_STRING);
        String sByte                    = getParameters().get(PARAMS_KEY__BYTE).toString();
        String sByteString              = (String) getParameters().get(PARAMS_KEY__BYTE_STRING);
        String sCalendar                = getParameters().get(PARAMS_KEY__CALENDAR).toString();
        String sCalendarString          = (String) getParameters().get(PARAMS_KEY__CALENDAR_STRING);
        String sCharacter               = getParameters().get(PARAMS_KEY__CHARACTER).toString();
        String sDate                    = getParameters().get(PARAMS_KEY__DATE).toString();
        String sDateString              = (String) getParameters().get(PARAMS_KEY__DATE_STRING);
        String sDouble                  = getParameters().get(PARAMS_KEY__DOUBLE).toString();
        String sDoubleString            = (String) getParameters().get(PARAMS_KEY__DOUBLE_STRING);
        String sFloat                   = getParameters().get(PARAMS_KEY__FLOAT).toString();
        String sFloatString             = (String) getParameters().get(PARAMS_KEY__FLOAT_STRING);
        String sInteger                 = getParameters().get(PARAMS_KEY__INTEGER).toString();
        String sIntegerString           = (String) getParameters().get(PARAMS_KEY__INTEGER_STRING);
        String sList                    = getParameters().get(PARAMS_KEY__LIST).toString();
        String sLocalDate               = getParameters().get(PARAMS_KEY__LOCALDATE).toString();
        String sLocalDateString         = (String) getParameters().get(PARAMS_KEY__LOCALDATE_STRING);
        String sLocalDateTime           = getParameters().get(PARAMS_KEY__LOCALDATETIME).toString();
        String sLocalDateTimeString     = (String) getParameters().get(PARAMS_KEY__LOCALDATETIME_STRING);
        String sLocalTime               = getParameters().get(PARAMS_KEY__LOCALTIME).toString();
        String sLocalTimeString         = (String) getParameters().get(PARAMS_KEY__LOCALTIME_STRING);
        String sLong                    = getParameters().get(PARAMS_KEY__LONG).toString();
        String sLongString              = (String) getParameters().get(PARAMS_KEY__LONG_STRING);
        String sObject                  = getParameters().get(PARAMS_KEY__OBJECT).toString();
        String sShort                   = getParameters().get(PARAMS_KEY__SHORT).toString();
        String sShortString             = (String) getParameters().get(PARAMS_KEY__SHORT_STRING);
        String sString                  = (String) getParameters().get(PARAMS_KEY__STRING);
        String sStringEmpty             = (String) getParameters().get(PARAMS_KEY__STRING__EMPTY);
        String sStringUntrimmed         = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED);
        String sStringUntrimmedEmpty    = (String) getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY);
        String sStringBuilder           = getParameters().get(PARAMS_KEY__STRING_BUILDER).toString();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sNull, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sBigDecimal, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sBigDecimalString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sBigInteger, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sBigIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sBoolean, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sBooleanString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sByte, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sByteString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sCalendar, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sCalendarString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sCharacter, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sDate, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sDateString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( 1.23d,
                mapper.unformatToNumber( sDouble, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sDoubleString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sFloat, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sFloatString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sInteger, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sIntegerString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sList, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sLocalDate, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sLocalDateString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sLocalDateTime, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sLocalDateTimeString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sLocalTime, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sLocalTimeString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sLong, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sLongString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sObject, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sShort, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sShortString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sString, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sStringEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sStringUntrimmed, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sStringUntrimmedEmpty, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.unformatToNumber( sStringBuilder, GERMAN_LOCALE, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE ) );
    }
}