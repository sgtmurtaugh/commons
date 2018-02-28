package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public class ShortMapper
        extends AbstractNumericMapper<Short>
        implements IShortMapper {

    private final static String CLASS   = ShortMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(ShortMapper.class);

}
