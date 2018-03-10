package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"javadoc", "unused"})
public class LocalDateTimeMapper
        extends AbstractTemporalTypeMapper<LocalDateTime>
        implements ILocalDateTimeMapper {

    private final static String CLASS   = LocalDateTimeMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(StringMapper.class);


    /**
     * Constructor
     */
    public LocalDateTimeMapper() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue
     */
    public LocalDateTimeMapper(LocalDateTime defaultValue) {
        super(defaultValue);
    }

}
