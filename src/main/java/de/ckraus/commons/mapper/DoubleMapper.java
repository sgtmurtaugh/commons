package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"javadoc", "unused"})
public class DoubleMapper
        extends AbstractNumericTypeMapper<Double>
        implements IDoubleMapper {

    private final static String CLASS   = DoubleMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(DoubleMapper.class);


    /**
     * Constructor
     */
    public DoubleMapper() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue
     */
    public DoubleMapper(Double defaultValue) {
        super(defaultValue);
    }

}
