package de.ckraus.commons.mapper;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

public interface IBigIntegerMapper
    extends INumericTypeMapper<BigInteger> {

    /**
     * unformat
     * @param sNumber the number string
     * @param locale the locale to use for the format.
     * @param sPattern a non-localized pattern string.
     * @param decimalFormatSymbols symbols the set of symbols to be used
     * @param defaultValue default value used, when sNumber is null or cannot be parsed
     * @return
     */
    default BigInteger unformat(
            String sNumber,
            Locale locale,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols,
            BigInteger defaultValue
    ) {
        BigInteger returnValue = defaultValue;

        if (StringUtils.isNotEmpty(sNumber)) {
            DecimalFormat decimalFormat = this.getDecimalFormat(
                    locale,
                    sPattern,
                    decimalFormatSymbols
            );

            try {
                returnValue = BigInteger.valueOf(
                        decimalFormat.parse(sNumber).longValue()
                );
            }
            catch ( ParseException pe ) {
                // pe.printStackTrace();
            }
        }
        return returnValue;
    }

}
