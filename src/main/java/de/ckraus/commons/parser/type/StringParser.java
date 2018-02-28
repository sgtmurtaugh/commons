package de.ckraus.commons.parser.type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ckraus on 02.07.15.
 */
public class StringParser
    extends AbstractTypeParser<String> {

    private final static String CLASS   = StringParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(StringParser.class);

    /**
     * Constructor
     */
    public StringParser() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public StringParser(String defaultValue) {
        super( defaultValue );
    }

}
