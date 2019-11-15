package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.GregorianCalendar;

@Getter
@Setter( AccessLevel.PROTECTED )
@SuppressWarnings( { "javadoc", "unused" } )
public class GregorianCalendarMapper extends AbstractCalendarMapper<GregorianCalendar>
        implements IGregorianCalendarMapper {

    private final static String CLASS = GregorianCalendarMapper.class.getSimpleName();
    //    protected static Logger log = LoggerFactory.getLogger(IntegerMapper.class);


    /**
     * Constructor
     */
    public GregorianCalendarMapper() {
        super();
    }

    /**
     * Constructor
     *
     * @param defaultValue
     */
    public GregorianCalendarMapper( GregorianCalendar defaultValue ) {
        super( defaultValue );
    }

}
