package de.ckraus.commons.mapper;

import java.math.BigDecimal;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@SuppressWarnings({"javadoc"})
public interface IBigDecimalMapper
    extends INumericTypeMapper<BigDecimal> {

    @Override
    default BigDecimal map(
            Number number,
            BigDecimal defaultValue
    ) {
        BigDecimal returnValue = defaultValue;

        if (null != number) {
            if (number instanceof BigDecimal) {
                returnValue = (BigDecimal) number;
            }
            else {
                returnValue = new BigDecimal(number.doubleValue());
            }
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
    default BigDecimal unformat(
            String sNumber,
            Locale locale,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols,
            BigDecimal defaultValue
    ) {
        BigDecimal returnValue = defaultValue;
        Number number = this.unformatToNumber(
                sNumber,
                locale,
                sPattern,
                decimalFormatSymbols,
                defaultValue
        );

        if (number instanceof BigDecimal) {
            returnValue = (BigDecimal) number;
        }
        else
        if (null != number) {
            returnValue = BigDecimal.valueOf( number.doubleValue() );
        }

        return returnValue;
    }

}
