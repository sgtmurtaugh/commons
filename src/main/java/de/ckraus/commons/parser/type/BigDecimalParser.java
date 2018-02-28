package de.ckraus.commons.parser.type;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

/**
 * Created by ckraus on 02.07.15.
 */
public class BigDecimalParser
    extends AbstractNumericTypeParser<BigDecimal> {

    private final static String CLASS   = BigDecimalParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(BigDecimalParser.class);

    /**
     * Constructor
     */
    public BigDecimalParser() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public BigDecimalParser(BigDecimal defaultValue) {
        super( defaultValue );
    }


    @Override
    public BigDecimal parse(
            String s,
            BigDecimal defaultValue,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        return this.unformat(
                this.prepareStringToParse(
                        s,
                        this.getDefaultTrimStrings(),
                        this.getDefaultEmptyIsNull()
                ),
                defaultValue,
                sPattern,
                decimalFormatSymbols
        );
    }

    /**
     * @see INumericTypeParser#unformat(String, Number, String, DecimalFormatSymbols)
     */
    public BigDecimal unformat(
            String sNumber,
            BigDecimal defaultValue,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        BigDecimal retVal = defaultValue;
        if ( null == StringUtils.trimToNull( sNumber ) ) {
            log.debug( "number param is null." );
        }
        else {
            DecimalFormat decimalFormat = this.getDecimalFormat(
                    sPattern,
                    decimalFormatSymbols
            );

            try {
                retVal = BigDecimal.valueOf(
                        decimalFormat.parse(sNumber).doubleValue()
                );
            }
            catch ( ParseException pe ) {
                pe.printStackTrace();
            }
        }
        return retVal;
    }

}
