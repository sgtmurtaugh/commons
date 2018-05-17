package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"javadoc", "unused"})
public class BooleanMapper
        extends AbstractTypeMapper<Boolean>
        implements IBooleanMapper {

    private final static String CLASS   = BooleanMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(BooleanMapper.class);


    /**
     * Constructor
     */
    public BooleanMapper() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue
     */
    public BooleanMapper(Boolean defaultValue) {
        super(defaultValue);
    }

}
