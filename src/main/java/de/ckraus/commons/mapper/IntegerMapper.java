package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public class IntegerMapper
        extends AbstractNumericTypeMapper<Integer>
        implements IIntegerMapper {

    private final static String CLASS   = IntegerMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(IntegerMapper.class);


    /**
     * Constructor
     */
    public IntegerMapper() {
        super();
    }

}
