package de.ckraus.commons.parser.type

/**
 * Created by ckraus on 08.08.15.
 */
class CharacterParserTest extends GroovyTestCase {
    void testIsParsable() {

    }

    void testParse() {
        CharacterParser characterParser = new CharacterParser();
        println characterParser.parse(" 65 ");
        println characterParser.parse("65");
        println characterParser.parse("Lirum Larum Löffelstiel");
        println characterParser.parse(" Lirum Larum Löffelstiel ");
        println characterParser.parse("    ");
        println characterParser.parse("");
        println characterParser.parse(null);
    }
}
