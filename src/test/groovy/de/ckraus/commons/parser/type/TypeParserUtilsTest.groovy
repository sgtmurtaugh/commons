package de.ckraus.commons.parser.type

/**
 * Created by ckraus on 07.08.15.
 */
class TypeParserUtilsTest extends GroovyTestCase {

    void testGetMapTypeParser() {

    }

    void testGetTypeParser() {
        TypeParserUtils typeParserUtils = new TypeParserUtils();

        BigDecimalParser bigDecimalParser = typeParserUtils.getTypeParser(BigDecimalParser.class);
        println bigDecimalParser.class.simpleName;

        DummyParser dummyParser = typeParserUtils.getTypeParser(DummyParser.class);
        println dummyParser.class.simpleName;
        println typeParserUtils.mapTypeParser;

        DummyParser sameDummyParser = typeParserUtils.getTypeParser(DummyParser.class);
        println ( dummyParser == sameDummyParser );

        DummyParser newDummyParser = new DummyParser();
        println ( dummyParser == newDummyParser );
    }

    void testGetBigDecimalParser() {
        TypeParserUtils typeParserUtils = new TypeParserUtils();
        BigDecimalParser bigDecimalParser = typeParserUtils.getBigDecimalParser()
        println bigDecimalParser.getDefaultValue()
    }

    void testGetBigIntegerParser() {

    }

    void testGetByteParser() {

    }

    void testGetGregorianCalendarParser() {

    }

    void testGetCharacterParser() {

    }

    void testGetDateParser() {

    }

    void testGetDoubleParser() {

    }

    void testGetFloatParser() {

    }

    void testGetIntegerParser() {

    }

    void testGetLongParser() {

    }

    void testGetShortParser() {

    }

    void testGetStringParser() {

    }

}

class DummyParser extends AbstractTypeParser<String> {

}