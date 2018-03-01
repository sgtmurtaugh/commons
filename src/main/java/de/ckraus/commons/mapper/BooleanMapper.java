package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
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

}
