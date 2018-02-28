package de.ckraus.commons

import de.ckraus.commons.parser.type.BooleanParser
import de.ckraus.commons.parser.type.IntegerParser
import de.ckraus.commons.parser.type.TypeParserUtils
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * Created by ckraus on 21.10.15.
 */
class Initializer {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/commons-spring-beans.xml");

        if ( context ) {
            TypeParserUtils parserUtils = ( TypeParserUtils ) context.getBean( "typeParseUtils" );

            if ( parserUtils ) {
                Integer i = parserUtils.integerParser.parse( "5" );
                println (i + 3);

                IntegerParser integerParser = parserUtils.integerParser;
                IntegerParser integerParser2 = parserUtils.integerParser;

                BooleanParser booleanParser = parserUtils.booleanParser;

                println "char (0)" + parserUtils.booleanParser.parse('0', null);
                println "char (1)" + parserUtils.booleanParser.parse('1', null);
                println "char (j)" + parserUtils.booleanParser.parse('j', null);
                println "char (J)" + parserUtils.booleanParser.parse('J', null);
                println "char (n)" + parserUtils.booleanParser.parse('n', null);
                println "char (N)" + parserUtils.booleanParser.parse('N', null);
                println "char (f)" + parserUtils.booleanParser.parse('f', null);
                println "int (0)" + parserUtils.booleanParser.parse(0, null);
                println "int (1)" + parserUtils.booleanParser.parse(1, null);
            }
        }
    }
}
