package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"javadoc", "unused"})
public class LongMapper
        extends AbstractNumericTypeMapper<Long>
        implements ILongMapper {

    private final static String CLASS   = LongMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(LongMapper.class);


    /**
     * Constructor
     */
    public LongMapper() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue
     */
    public LongMapper(Long defaultValue) {
        super(defaultValue);
    }

}
