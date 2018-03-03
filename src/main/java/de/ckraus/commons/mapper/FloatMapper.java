package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"javadoc", "unused"})
public class FloatMapper
        extends AbstractNumericTypeMapper<Float>
        implements IFloatMapper {

    private final static String CLASS   = FloatMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(FloatMapper.class);


    /**
     * Constructor
     */
    public FloatMapper() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue
     */
    public FloatMapper(Float defaultValue) {
        super(defaultValue);
    }

}
