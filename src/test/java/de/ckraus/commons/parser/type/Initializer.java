package de.ckraus.commons.parser.type;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ckraus on 21.10.15.
 */
class Initializer {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/commons-spring-beans.xml");

        if ( null != context ) {
            TypeParserUtils parserUtils = ( TypeParserUtils ) context.getBean( "typeParseUtils" );

            if ( null != parserUtils ) {
                Integer i = parserUtils.getIntegerParser().parse("5");
                System.out.println(i + 3);

                IntegerParser integerParser = parserUtils.getIntegerParser();
                IntegerParser integerParser2 = parserUtils.getIntegerParser();

                BooleanParser booleanParser = parserUtils.getBooleanParser();

                System.out.println( "char (0)" + parserUtils.getBooleanParser().parse('0', null) );
                System.out.println( "char (1)" + parserUtils.getBooleanParser().parse('1', null) );
                System.out.println( "char (j)" + parserUtils.getBooleanParser().parse('j', null) );
                System.out.println( "char (J)" + parserUtils.getBooleanParser().parse('J', null) );
                System.out.println( "char (n)" + parserUtils.getBooleanParser().parse('n', null) );
                System.out.println( "char (N)" + parserUtils.getBooleanParser().parse('N', null) );
                System.out.println( "char (f)" + parserUtils.getBooleanParser().parse('f', null) );
                System.out.println( "int (0)" + parserUtils.getBooleanParser().parse(0, null) );
                System.out.println( "int (1)" + parserUtils.getBooleanParser().parse(1, null) );
                System.out.println( "RegisteredTypeParsers: " + parserUtils.getRegisteredTypeParsers().size() );

                for ( Object o : parserUtils.getRegisteredTypeParsers().keySet() ) {
                    System.out.println(o);
                }
            }
        }
    }
}
