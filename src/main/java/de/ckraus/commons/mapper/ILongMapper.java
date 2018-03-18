package de.ckraus.commons.mapper;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

@SuppressWarnings({"javadoc"})
public interface ILongMapper
    extends INumericTypeMapper<Long> {

    @Override
    default Long map(
            Number number,
            Long defaultValue
    ) {
        Long returnValue = defaultValue;

        if (null != number) {
            returnValue = number.longValue();
        }
        return returnValue;
    }

    /**
     * unformat
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @param defaultValue default value used, when sNumber is null or cannot be parsed
     * @return
     */
    @Override
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
