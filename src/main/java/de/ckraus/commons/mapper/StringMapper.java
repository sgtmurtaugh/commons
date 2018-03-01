package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public class StringMapper
        extends AbstractTypeMapper<String> {

    private final static String CLASS   = StringMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(StringMapper.class);


    /**
     * Constructor
     */
    public StringMapper() {
        super();
    }

}
