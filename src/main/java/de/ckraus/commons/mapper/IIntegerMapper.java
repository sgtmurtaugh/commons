package de.ckraus.commons.mapper;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

@SuppressWarnings({"javadoc"})
public interface IIntegerMapper
    extends INumericTypeMapper<Integer> {

    @Override
    default Integer toType(Number number) {
        Integer returnValue = null;

        if (number instanceof Integer) {
            returnValue = (Integer) number;
        }
        else
        if (null != number) {
            returnValue = number.intValue();
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
//    default Integer unformat(
//            String sNumber,
//            Locale locale,
//            String sPattern,
//            DecimalFormatSymbols decimalFormatSymbols,
//            Integer defaultValue
//    ) {
//        Integer returnValue = this.unformatToNumber(
//                sNumber,
//                locale,
//                sPattern,
//                decimalFormatSymbols,
//                defaultValue
//        );
//        return returnValue;
//    }

}
