package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter(AccessLevel.PROTECTED)
public class BigDecimalMapper
        extends AbstractNumericMapper<BigDecimal>
        implements IBigDecimalMapper {

    private final static String CLASS   = BigDecimalMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(BigDecimalMapper.class);

}
