package de.ckraus.commons.mapper;

import java.math.BigDecimal;

@SuppressWarnings({"javadoc"})
public interface IBigDecimalMapper
    extends INumericTypeMapper<BigDecimal> {

    @Override
    default BigDecimal toType(Number number) {
        BigDecimal returnValue = null;

        if (number instanceof BigDecimal) {
            returnValue = (BigDecimal) number;
        }
        else
        if (null != number) {
            returnValue = new BigDecimal( number.toString() );
        }
        return returnValue;
    }

}
