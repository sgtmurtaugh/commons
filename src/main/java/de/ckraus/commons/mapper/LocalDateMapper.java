package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"javadoc", "unused"})
public class LocalDateMapper
        extends AbstractTemporalTypeMapper<LocalDate> {

    private final static String CLASS   = LocalDateMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(StringMapper.class);


    /**
     * Constructor
     */
    public LocalDateMapper() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue
     */
    public LocalDateMapper(LocalDate defaultValue) {
        super(defaultValue);
    }

}
