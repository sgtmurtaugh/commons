package de.ckraus.commons.mapper;

import java.math.BigDecimal;
import java.math.BigInteger;

@SuppressWarnings({"javadoc"})
public interface IBigIntegerMapper
    extends INumericTypeMapper<BigInteger> {

    @Override
    default BigInteger toType(Number number) {
        BigInteger returnValue = null;

        if (number instanceof BigInteger) {
            returnValue = (BigInteger) number;
        }
        else
        if (null != number) {
            returnValue = new BigDecimal(number.toString()).toBigInteger();
        }
        return returnValue;
    }

}
