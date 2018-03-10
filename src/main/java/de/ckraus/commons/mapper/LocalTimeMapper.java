package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"javadoc", "unused"})
public class LocalTimeMapper
        extends AbstractTemporalTypeMapper<LocalTime>
        implements ILocalTimeMapper {

    private final static String CLASS   = LocalTimeMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(StringMapper.class);


    /**
     * Constructor
     */
    public LocalTimeMapper() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue
     */
    public LocalTimeMapper(LocalTime defaultValue) {
        super(defaultValue);
    }

}
