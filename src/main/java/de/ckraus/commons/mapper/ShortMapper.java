package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"javadoc", "unused"})
public class ShortMapper
        extends AbstractNumericTypeMapper<Short>
        implements IShortMapper {

    private final static String CLASS   = ShortMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(ShortMapper.class);


    /**
     * Constructor
     */
    public ShortMapper() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue
     */
    public ShortMapper(Short defaultValue) {
        super(defaultValue);
    }

}
