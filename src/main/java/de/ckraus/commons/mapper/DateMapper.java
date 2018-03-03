package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"javadoc", "unused"})
public class DateMapper
        extends AbstractTypeMapper<Date>
        implements IDateMapper {

    private final static String CLASS   = DateMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(IntegerMapper.class);


    /**
     * Constructor
     */
    public DateMapper() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue
     */
    public DateMapper(Date defaultValue) {
        super(defaultValue);
    }

}
