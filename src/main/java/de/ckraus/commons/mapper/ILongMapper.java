package de.ckraus.commons.mapper;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

public interface ILongMapper
    extends INumericTypeMapper<Long> {

    /**
     * unformat
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @param defaultValue default value used, when sNumber is null or cannot be parsed
     * @return
     */
    default Long unformat(
            String sNumber,
            Locale locale,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols,
            Long defaultValue
    ) {
        Long returnValue = defaultValue;
        Number number = this.unformatToNumber(
                sNumber,
                locale,
                sPattern,
                decimalFormatSymbols,
                defaultValue
        );

        if (null != number) {
            returnValue = number.longValue();
        }

        return returnValue;
    }

}
