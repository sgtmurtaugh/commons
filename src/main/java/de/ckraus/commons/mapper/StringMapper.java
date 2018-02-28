package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public class StringMapper
        extends AbstractMapper<String> {

    private final static String CLASS   = StringMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(StringMapper.class);

}
