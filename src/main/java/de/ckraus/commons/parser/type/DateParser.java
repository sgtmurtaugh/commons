package de.ckraus.commons.parser.type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by ckraus on 07.08.15.
 */
public class DateParser
    extends AbstractDateParser<Date> {

    private final static String CLASS   = DateParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(DateParser.class);

    /**
     * Constructor
     */
    public DateParser() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public DateParser(Date defaultValue) {
        super( defaultValue );
    }


}
