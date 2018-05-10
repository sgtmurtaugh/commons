package de.ckraus.commons.mapper;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

@SuppressWarnings({"javadoc"})
public interface IFloatMapper
    extends INumericTypeMapper<Float> {

    @Override
    default Float toType(Number number) {
        Float returnValue = null;

        if (number instanceof Float) {
            returnValue = (Float) number;
        }
        else
        if (null != number) {
            returnValue = number.floatValue();
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
//    default Float unformat(
//            String sNumber,
//            Locale locale,
//            String sPattern,
//            DecimalFormatSymbols decimalFormatSymbols,
//            Float defaultValue
//    ) {
//        Float returnValue = this.unformatToNumber(
//                sNumber,
//                locale,
//                sPattern,
//                decimalFormatSymbols,
//                defaultValue
//        );
//        return returnValue;
//    }

}
