package de.ckraus.commons.parser.type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

/**
 * Created by ckraus on 02.07.15.
 */
public abstract class AbstractCalendarParser<E extends Calendar>
    extends AbstractTypeParser<E>
    implements ICalendarTypeParser<E> {

    private final static String CLASS   = AbstractCalendarParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(AbstractCalendarParser.class);

    /**
     * Constructor
     */
    public AbstractCalendarParser() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public AbstractCalendarParser(E defaultValue) {
        super( defaultValue );
    }


    /**
     * @see ICalendarTypeParser#unformat(String)
     */
    public E unformat ( String sCalendar ) {
        return this.unformat(
            sCalendar,
            null
        );
    }

    /**
     * @see ICalendarTypeParser#unformat(String, Calendar)
     * <p>This default implementation only return the defaultValue param.</p>
     */
    public E unformat (
            String sCalendar,
            E defaultValue
    ) {
        return defaultValue;
    }

}
