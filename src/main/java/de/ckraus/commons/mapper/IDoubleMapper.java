package de.ckraus.commons.mapper;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

@SuppressWarnings({"javadoc"})
public interface IDoubleMapper
    extends INumericTypeMapper<Double> {

    @Override
    default Double toType(Number number) {
        Double returnValue = null;

        if (number instanceof Double) {
            returnValue = (Double) number;
        }
        else
        if (null != number) {
            returnValue = number.doubleValue();
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
//    default Double unformat(
//            String sNumber,
//            Locale locale,
//            String sPattern,
//            DecimalFormatSymbols decimalFormatSymbols,
//            Double defaultValue
//    ) {
//        Double returnValue = this.unformatToNumber(
//                sNumber,
//                locale,
//                sPattern,
//                decimalFormatSymbols,
//                defaultValue
//        );
//        return returnValue;
//    }

}
