package de.ckraus.commons.mapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

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
            returnValue = new BigInteger(number.toString());
        }
        return returnValue;
    }

//    /**
//     * unformat
//     * @param sNumber the number string
//     * @param locale the locale to use for the format.
//     * @param sPattern a non-localized pattern string.
//     * @param decimalFormatSymbols symbols the set of symbols to be used
//     * @param defaultValue default value used, when sNumber is null or cannot be parsed
//     * @return
//     */
//    @Override
//    default BigInteger unformat(
//            String sNumber,
//            Locale locale,
//            String sPattern,
//            DecimalFormatSymbols decimalFormatSymbols,
//            BigInteger defaultValue
//    ) {
//        BigInteger returnValue = this.unformatToNumber(
//                sNumber,
//                locale,
//                sPattern,
//                decimalFormatSymbols,
//                defaultValue
//        );
//        return returnValue;
//    }
//
}
