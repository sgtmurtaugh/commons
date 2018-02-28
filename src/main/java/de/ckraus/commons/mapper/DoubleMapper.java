package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public class DoubleMapper
        extends AbstractNumericMapper<Double>
        implements IDoubleMapper {

    private final static String CLASS   = DoubleMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(DoubleMapper.class);

}
