package de.ckraus.commons.parser.type

import java.text.DecimalFormatSymbols

/**
 * Created by ckraus on 10.08.15.
 */
class BigDecimalParserTest extends GroovyTestCase {
    void testParse() {
        BigDecimalParser parser = new BigDecimalParser( new BigDecimal("54321") );

        BigDecimal newDefaultValue = new BigDecimal("12345");
        String sPattern = "#";
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.GERMAN);

        String s = " 65 ";
        assertEquals( 65, parser.parse(s) );
        assertEquals( 65, parser.parse(s, newDefaultValue) );
        assertEquals( 65, parser.parse(s, newDefaultValue, sPattern) );
        assertEquals( 65, parser.parse(s, newDefaultValue, sPattern, decimalFormatSymbols ) );

        s = "23";
        assertEquals( 23, parser.parse(s) );
        assertEquals( 23, parser.parse(s, newDefaultValue) );
        assertEquals( 23, parser.parse(s, newDefaultValue, sPattern) );
        assertEquals( 23, parser.parse(s, newDefaultValue, sPattern, decimalFormatSymbols ) );

        s = "0 12 34 12 34 56 78 90";
        assertEquals( 0, parser.parse(s) );
        assertEquals( 0, parser.parse(s, newDefaultValue) );
        assertEquals( 0, parser.parse(s, newDefaultValue, sPattern) );
        assertEquals( 0, parser.parse(s, newDefaultValue, sPattern, decimalFormatSymbols ) );

        s = "41,54€";
        assertEquals( 41.54, parser.parse(s) );
        assertEquals( 41.54, parser.parse(s, newDefaultValue) );
        assertEquals( 41.54, parser.parse(s, newDefaultValue, sPattern) );
        assertEquals( 41.54, parser.parse(s, newDefaultValue, sPattern, decimalFormatSymbols ) );

        s = "366,87EUR";
        assertEquals( 366.87, parser.parse(s) );
        assertEquals( 366.87, parser.parse(s, newDefaultValue) );
        assertEquals( 366.87, parser.parse(s, newDefaultValue, sPattern) );
        assertEquals( 366.87, parser.parse(s, newDefaultValue, sPattern, decimalFormatSymbols ) );

        s = "57%";
        assertEquals( 57, parser.parse(s) );
        assertEquals( 57, parser.parse(s, newDefaultValue) );
        assertEquals( 57, parser.parse(s, newDefaultValue, sPattern) );
        assertEquals( 57, parser.parse(s, newDefaultValue, sPattern, decimalFormatSymbols ) );

        s = "76%€abc";
        assertEquals( 76, parser.parse(s) );
        assertEquals( 76, parser.parse(s, newDefaultValue) );
        assertEquals( 76, parser.parse(s, newDefaultValue, sPattern) );
        assertEquals( 76, parser.parse(s, newDefaultValue, sPattern, decimalFormatSymbols ) );

        s = "6.005,3";
        assertEquals( 6005.3, parser.parse(s) );
        assertEquals( 6005.3, parser.parse(s, newDefaultValue) );
        assertEquals( 6, parser.parse(s, newDefaultValue, sPattern) );
        assertEquals( 6, parser.parse(s, newDefaultValue, sPattern, decimalFormatSymbols ) );

        s = "423,005.3";
        assertEquals( 423.005, parser.parse(s) );
        assertEquals( 423.005, parser.parse(s, newDefaultValue) );
        assertEquals( 423.005, parser.parse(s, newDefaultValue, sPattern) );
        assertEquals( 423.005, parser.parse(s, newDefaultValue, sPattern, decimalFormatSymbols ) );

        s = "1asd3";
        assertEquals( 1, parser.parse(s) );
        assertEquals( 1, parser.parse(s, newDefaultValue) );
        assertEquals( 1, parser.parse(s, newDefaultValue, sPattern) );
        assertEquals( 1, parser.parse(s, newDefaultValue, sPattern, decimalFormatSymbols ) );

        s = "Lirum Larum Löffelstiel";
        assertEquals( parser.getDefaultValue(), parser.parse(s) );
        assertEquals( newDefaultValue, parser.parse(s, newDefaultValue) );
        assertEquals( newDefaultValue, parser.parse(s, newDefaultValue, sPattern) );
        assertEquals( newDefaultValue, parser.parse(s, newDefaultValue, sPattern, decimalFormatSymbols ) );

        s = "  Wer viel fragt, der weiss nicht viel  ";
        assertEquals( parser.getDefaultValue(), parser.parse(s) );
        assertEquals( newDefaultValue, parser.parse(s, newDefaultValue) );
        assertEquals( newDefaultValue, parser.parse(s, newDefaultValue, sPattern) );
        assertEquals( newDefaultValue, parser.parse(s, newDefaultValue, sPattern, decimalFormatSymbols ) );

        s = "    ";
        assertEquals( parser.getDefaultValue(), parser.parse(s) );
        assertEquals( newDefaultValue, parser.parse(s, newDefaultValue) );
        assertEquals( newDefaultValue, parser.parse(s, newDefaultValue, sPattern) );
        assertEquals( newDefaultValue, parser.parse(s, newDefaultValue, sPattern, decimalFormatSymbols ) );

        s = "";
        assertEquals( parser.getDefaultValue(), parser.parse(s) );
        assertEquals( newDefaultValue, parser.parse(s, newDefaultValue) );
        assertEquals( newDefaultValue, parser.parse(s, newDefaultValue, sPattern) );
        assertEquals( newDefaultValue, parser.parse(s, newDefaultValue, sPattern, decimalFormatSymbols ) );

        s = null;
        assertEquals( parser.getDefaultValue(), parser.parse(s) );
        assertEquals( newDefaultValue, parser.parse((String) s, newDefaultValue) );
        assertEquals( newDefaultValue, parser.parse(s, newDefaultValue, sPattern) );
        assertEquals( newDefaultValue, parser.parse(s, newDefaultValue, sPattern, decimalFormatSymbols ) );

    }

    void testUnformat() {

    }
}
