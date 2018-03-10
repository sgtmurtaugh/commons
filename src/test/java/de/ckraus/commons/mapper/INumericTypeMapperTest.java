package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class INumericTypeMapperTest {

    private final static Locale GERMAN_LOCALE = Locale.GERMAN;

    private final static String FORMAT_PATTERN = "#,##0.00;(#,##0.00)";

    private final String PARAMS_KEY__ = "";


    // create mapper instance
    private INumericTypeMapper<Number> mapper = (string, locale, pattern, decFormatSymbols, defVal) -> defVal;

    private Map<String, ?> mParams;


    /**
     * Constructor
     */
    public INumericTypeMapperTest() {
        mParams = new HashMap<>();
        mParams.put(PARAMS_KEY__, null);
    }

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
     * test for {@link INumericTypeMapper#map(Map, String, Locale)}
     */
    @Test
    void map() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map1() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map2() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map3() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map4() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map5() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map6() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map7() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map8() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map9() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map10() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map11() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map12() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map13() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map14() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map15() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map16() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map17() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map18() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map19() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map20() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map21() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#map}
     */
    @Test
    void map22() {
// TODO
//        mapper.map()
    }

    /**
     * test for {@link INumericTypeMapper#unformat}
     */
    @Test
    void unformat() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat}
     */
    @Test
    void unformat1() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat}
     */
    @Test
    void unformat2() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat}
     */
    @Test
    void unformat3() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat}
     */
    @Test
    void unformat4() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat}
     */
    @Test
    void unformat5() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat}
     */
    @Test
    void unformat6() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat}
     */
    @Test
    void unformat7() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat}
     */
    @Test
    void unformat8() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat}
     */
    @Test
    void unformat9() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat}
     */
    @Test
    void unformat10() {
// TODO
//        mapper.unformat()
    }

    /**
     * test for {@link INumericTypeMapper#unformat}
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