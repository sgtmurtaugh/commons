package de.ckraus.commons.parser.type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.GregorianCalendar;

/**
 * Created by ckraus on 07.08.15.
 */
public class GregorianCalendarParser
    extends AbstractCalendarParser<GregorianCalendar> {

    private final static String CLASS   = GregorianCalendarParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(GregorianCalendarParser.class);

    /**
     * Constructor
     */
    public GregorianCalendarParser() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public GregorianCalendarParser(GregorianCalendar defaultValue) {
        super( defaultValue );
    }


}
