package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static de.ckraus.commons.mapper.TestHelper.*;

class INumericTypeMapperTest {

    private final static Locale GERMAN_LOCALE = Locale.GERMAN;
    private final static String FORMAT_PATTERN = "#,##0.00;(#,##0.00)";

    private final static Number ANOTHER_DEFAULT_VALUE   = 5113;

    // create mapper instance
    private INumericTypeMapper<Number> mapper = (str, locale, pattern, decFormatSymbols, defVal) -> defVal;


    /**
     * test for {@link INumericTypeMapper#getDecimalFormat()}
     */
    @Test
    void getDecimalFormat() {
        assertEquals(
                DecimalFormat.getInstance(),
                mapper.getDecimalFormat()
        );
    }

    /**
     * test for {@link INumericTypeMapper#getDecimalFormat(Locale)}
     */
    @Test
    void getDecimalFormat1() {
        assertEquals(
                DecimalFormat.getInstance(GERMAN_LOCALE),
                mapper.getDecimalFormat(GERMAN_LOCALE)
        );
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

        assertEquals(
                format.toPattern(),
                mapperFormat.toPattern()
        );
    }

    /**
     * test for {@link INumericTypeMapper#getDecimalFormat(String)}
     */
    @Test
    void getDecimalFormat3() {
        DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
        format.applyPattern(FORMAT_PATTERN);

        DecimalFormat mapperFormat = mapper.getDecimalFormat(FORMAT_PATTERN);

        assertEquals(
                format,
                mapperFormat
        );
        assertEquals(
                format.toPattern(),
                mapperFormat.toPattern()
        );
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

        assertEquals(
                format,
                mapperFormat
        );
        assertEquals(
                format.toPattern(),
                mapperFormat.toPattern()
        );
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

        assertEquals(
                format,
                mapperFormat
        );
        assertEquals(
                format.toPattern(),
                mapperFormat.toPattern()
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String)}
     */
    @Test
    void map() {
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE )
        );

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__FLOAT )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__INTEGER )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__LIST )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__LONG )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__OBJECT )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, Locale)}
     */
    @Test
    void map1() {
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE )
        );

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER, GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__LIST, GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, String)}
     */
    @Test
    void map2() {
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, FORMAT_PATTERN )
        );

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__LIST, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__LONG, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, FORMAT_PATTERN  )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, Locale, String)}
     */
    @Test
    void map3() {
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE,
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE,
                        FORMAT_PATTERN )
        );

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, GERMAN_LOCALE,
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER, GERMAN_LOCALE,
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE,
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE,
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE,
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__LIST, GERMAN_LOCALE,
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE,
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE,
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE,
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE,
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE,
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE,
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE,
                        FORMAT_PATTERN )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, Locale, String, DecimalFormatSymbols)}
     */
    @Test
    void map5() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols )
        );

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__LIST, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, String, DecimalFormatSymbols)}
     */
    @Test
    void map6() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, FORMAT_PATTERN,
                        symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, FORMAT_PATTERN,
                        symbols )
        );

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, FORMAT_PATTERN,
                        symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER, FORMAT_PATTERN,
                        symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, FORMAT_PATTERN,
                        symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, FORMAT_PATTERN,
                        symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, FORMAT_PATTERN,
                        symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__LIST, FORMAT_PATTERN,
                        symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__LONG, FORMAT_PATTERN,
                        symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, FORMAT_PATTERN,
                        symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING, FORMAT_PATTERN,
                        symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, FORMAT_PATTERN,
                        symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, FORMAT_PATTERN,
                        symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, FORMAT_PATTERN,
                        symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, FORMAT_PATTERN,
                        symbols )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, Number)}
     */
    @Test
    void map7() {
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, ANOTHER_DEFAULT_VALUE )
        );

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LIST, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LONG, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, ANOTHER_DEFAULT_VALUE )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, Locale, Number)}
     */
    @Test
    void map8() {
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE,
                        ANOTHER_DEFAULT_VALUE )
        );

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, GERMAN_LOCALE,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER, GERMAN_LOCALE,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LIST, GERMAN_LOCALE,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE,
                        ANOTHER_DEFAULT_VALUE )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, String, Number)}
     */
    @Test
    void map9() {
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, FORMAT_PATTERN,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, FORMAT_PATTERN,
                        ANOTHER_DEFAULT_VALUE )
        );

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, FORMAT_PATTERN,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER, FORMAT_PATTERN,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, FORMAT_PATTERN,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, FORMAT_PATTERN,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, FORMAT_PATTERN,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LIST, FORMAT_PATTERN,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LONG, FORMAT_PATTERN,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, FORMAT_PATTERN,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING, FORMAT_PATTERN,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, FORMAT_PATTERN,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, FORMAT_PATTERN,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, FORMAT_PATTERN,
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, FORMAT_PATTERN,
                        ANOTHER_DEFAULT_VALUE )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, Locale, String, Number)}
     */
    @Test
    void map10() {
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE,
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE,
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, GERMAN_LOCALE,
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER, GERMAN_LOCALE,
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE,
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE,
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE,
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LIST, GERMAN_LOCALE,
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE,
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE,
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE,
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE,
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE,
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE,
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE,
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void map11() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, FORMAT_PATTERN,
                        symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, FORMAT_PATTERN,
                        symbols, ANOTHER_DEFAULT_VALUE )
        );

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, FORMAT_PATTERN,
                        symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER, FORMAT_PATTERN,
                        symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, FORMAT_PATTERN,
                        symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, FORMAT_PATTERN,
                        symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, FORMAT_PATTERN,
                        symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LIST, FORMAT_PATTERN,
                        symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LONG, FORMAT_PATTERN,
                        symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, FORMAT_PATTERN,
                        symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING, FORMAT_PATTERN,
                        symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, FORMAT_PATTERN,
                        symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, FORMAT_PATTERN,
                        symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, FORMAT_PATTERN,
                        symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, FORMAT_PATTERN,
                        symbols, ANOTHER_DEFAULT_VALUE )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(Map, String, Locale, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void map12() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_KEY, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LIST, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LONG, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__OBJECT, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, GERMAN_LOCALE,
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(String)}
     */
    @Test
    void map13() {
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( null )
        );

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__BOOLEAN).toString() )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__CHARACTER).toString() )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__DOUBLE).toString() )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__FLOAT).toString() )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__INTEGER).toString() )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__LIST).toString() )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__LONG).toString() )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__OBJECT).toString() )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING).toString() )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__EMPTY).toString() )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED).toString() )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY).toString() )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING_BUILDER).toString() )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, boolean, boolean, Number)}
     */
    @Test
    void map14() {
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( null, true, true, ANOTHER_DEFAULT_VALUE )
        );

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__BOOLEAN).toString(),
                        true, true, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__CHARACTER).toString(),
                        true, true, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__DOUBLE).toString(),
                        true, true, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__FLOAT).toString(),
                        true, true, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__INTEGER).toString(),
                        true, true, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__LIST).toString(),
                        true, true, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__LONG).toString(),
                        true, true, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__OBJECT).toString(),
                        true, true, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING).toString(),
                        true, true, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__EMPTY).toString(),
                        true, true, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED).toString(),
                        true, true, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY).toString(),
                        true, true, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING_BUILDER).toString(),
                        true, true, ANOTHER_DEFAULT_VALUE )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, Locale)}
     */
    @Test
    void map15() {
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( null, GERMAN_LOCALE )
        );

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__BOOLEAN).toString(),
                        GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__CHARACTER).toString(),
                        GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__DOUBLE).toString(),
                        GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__FLOAT).toString(),
                        GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__INTEGER).toString(),
                        GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__LIST).toString(),
                        GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__LONG).toString(),
                        GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__OBJECT).toString(),
                        GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING).toString(),
                        GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__EMPTY).toString(),
                        GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED).toString(),
                        GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY).toString(),
                        GERMAN_LOCALE )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING_BUILDER).toString(),
                        GERMAN_LOCALE )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, String)}
     */
    @Test
    void map16() {
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( (String) null, FORMAT_PATTERN )
        );

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__BOOLEAN).toString(),
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__CHARACTER).toString(),
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__DOUBLE).toString(),
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__FLOAT).toString(),
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__INTEGER).toString(),
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__LIST).toString(),
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__LONG).toString(),
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__OBJECT).toString(),
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING).toString(),
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__EMPTY).toString(),
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED).toString(),
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY).toString(),
                        FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING_BUILDER).toString(),
                        FORMAT_PATTERN )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, Locale, String)}
     */
    @Test
    void map17() {
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( null, GERMAN_LOCALE, FORMAT_PATTERN )
        );

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__BOOLEAN).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__CHARACTER).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__DOUBLE).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__FLOAT).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__INTEGER).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__LIST).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__LONG).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__OBJECT).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__EMPTY).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING_BUILDER).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, Locale, String, DecimalFormatSymbols)}
     */
    @Test
    void map18() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( null, GERMAN_LOCALE, FORMAT_PATTERN, symbols )
        );

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__BOOLEAN).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__CHARACTER).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__DOUBLE).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__FLOAT).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__INTEGER).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__LIST).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__LONG).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__OBJECT).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__EMPTY).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING_BUILDER).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, symbols )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, String, DecimalFormatSymbols)}
     */
    @Test
    void map19() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( null, FORMAT_PATTERN, symbols )
        );

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__BOOLEAN).toString(),
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__CHARACTER).toString(),
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__DOUBLE).toString(),
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__FLOAT).toString(),
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__INTEGER).toString(),
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__LIST).toString(),
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__LONG).toString(),
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__OBJECT).toString(),
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING).toString(),
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__EMPTY).toString(),
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED).toString(),
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY).toString(),
                        FORMAT_PATTERN, symbols )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map( getParameters().get(PARAMS_KEY__STRING_BUILDER).toString(),
                        FORMAT_PATTERN, symbols )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, Number)}
     */
    @Test
    void map20() {
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( null, ANOTHER_DEFAULT_VALUE )
        );

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__BOOLEAN).toString(),
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__CHARACTER).toString(),
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__DOUBLE).toString(),
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__FLOAT).toString(),
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__INTEGER).toString(),
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__LIST).toString(),
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__LONG).toString(),
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__OBJECT).toString(),
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING).toString(),
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__EMPTY).toString(),
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED).toString(),
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY).toString(),
                        ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING_BUILDER).toString(),
                        ANOTHER_DEFAULT_VALUE )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, Locale, Number)}
     */
    @Test
    void map21() {
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( null, GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE )
        );

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__BOOLEAN).toString(),
                        GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__CHARACTER).toString(),
                        GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__DOUBLE).toString(),
                        GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__FLOAT).toString(),
                        GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__INTEGER).toString(),
                        GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__LIST).toString(),
                        GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__LONG).toString(),
                        GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__OBJECT).toString(),
                        GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING).toString(),
                        GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__EMPTY).toString(),
                        GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED).toString(),
                        GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY).toString(),
                        GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING_BUILDER).toString(),
                        GERMAN_LOCALE, ANOTHER_DEFAULT_VALUE )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, String, Number)}
     */
    @Test
    void map22() {
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( (String) null, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__BOOLEAN).toString(),
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__CHARACTER).toString(),
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__DOUBLE).toString(),
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__FLOAT).toString(),
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__INTEGER).toString(),
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__LIST).toString(),
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__LONG).toString(),
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__OBJECT).toString(),
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING).toString(),
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__EMPTY).toString(),
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED).toString(),
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY).toString(),
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING_BUILDER).toString(),
                        FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, Locale, String, Number)}
     */
    @Test
    void map23() {
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( null, GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__BOOLEAN).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__CHARACTER).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__DOUBLE).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__FLOAT).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__INTEGER).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__LIST).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__LONG).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__OBJECT).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__EMPTY).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING_BUILDER).toString(),
                        GERMAN_LOCALE, FORMAT_PATTERN, ANOTHER_DEFAULT_VALUE )
        );
    }

    /**
     * test for {@link INumericTypeMapper#map(String, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void map24() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(GERMAN_LOCALE);

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( null, FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__BOOLEAN).toString(),
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__CHARACTER).toString(),
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__DOUBLE).toString(),
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__FLOAT).toString(),
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__INTEGER).toString(),
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__LIST).toString(),
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__LONG).toString(),
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__OBJECT).toString(),
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING).toString(),
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__EMPTY).toString(),
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED).toString(),
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY).toString(),
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get(PARAMS_KEY__STRING_BUILDER).toString(),
                        FORMAT_PATTERN, symbols, ANOTHER_DEFAULT_VALUE )
        );
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String)}
     */
    @Test
    void unformat() {
// TODO
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, Locale)}
     */
    @Test
    void unformat1() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, String)}
     */
    @Test
    void unformat2() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, Locale, String)}
     */
    @Test
    void unformat3() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, Locale, String, DecimalFormatSymbols)}
     */
    @Test
    void unformat4() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, String, DecimalFormatSymbols)}
     */
    @Test
    void unformat5() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, Number)}
     */
    @Test
    void unformat6() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, Locale, Number)}
     */
    @Test
    void unformat7() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, String, Number)}
     */
    @Test
    void unformat8() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, Locale, String, Number)}
     */
    @Test
    void unformat9() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void unformat10() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat(String, Locale, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void unformat11() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformatToNumber(String, Locale, String, DecimalFormatSymbols, Number)}
     */
    @Test
    void unformatToNumber() {
// TODO
//        mapper.unformatToNumber()
    }
}