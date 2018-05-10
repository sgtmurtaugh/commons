package de.ckraus.commons.mapper;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

@SuppressWarnings({"javadoc"})
public interface IByteMapper
    extends INumericTypeMapper<Byte> {

    @Override
    default Byte toType(Number number) {
        Byte returnValue = null;

        if (number instanceof Byte) {
            returnValue = (Byte) number;
        }
        else
        if (null != number) {
            returnValue = number.byteValue();
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
//    default Byte unformat(
//            String sNumber,
//            Locale locale,
//            String sPattern,
//            DecimalFormatSymbols decimalFormatSymbols,
//            Byte defaultValue
//    ) {
//        Byte returnValue = this.unformatToNumber(
//                sNumber,
//                locale,
//                sPattern,
//                decimalFormatSymbols,
//                defaultValue
//        );
//        return returnValue;
//    }

}
