package de.ckraus.commons.mapper;

import java.util.Calendar;

@SuppressWarnings( { "javadoc", "unused" } )
public abstract class AbstractCalendarMapper<E extends Calendar> extends AbstractTypeMapper<E>
        implements ICalendarMapper<E> {

    private final static String CLASS = AbstractCalendarMapper.class.getSimpleName();


    /**
     * Constructor
     */
    public AbstractCalendarMapper() {
        super();
    }

    /**
     * Constructor
     *
     * @param defaultValue
     */
    public AbstractCalendarMapper( E defaultValue ) {
        super( defaultValue );
    }

    /**
     * Constructor
     *
     * @param defaultValue
     * @param bTrimStrings
     * @param bEmptyStringNull
     */
    public AbstractCalendarMapper( E defaultValue, boolean bTrimStrings, boolean bEmptyStringNull ) {
        super( defaultValue, bTrimStrings, bEmptyStringNull );
    }


}
