package de.ckraus.commons.mapper;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

@SuppressWarnings({"javadoc"})
public interface IBigIntegerMapper
    extends INumericTypeMapper<BigInteger> {

    @Override
    default BigInteger map(
            Number number,
            BigInteger defaultValue
    ) {
        BigInteger returnValue = defaultValue;

        if (null != number) {
            if (number instanceof BigInteger) {
                returnValue = (BigInteger) number;
            }
            else {
                returnValue = new BigInteger(number.toString());
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
// TODO: or better use String Constructor?
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
