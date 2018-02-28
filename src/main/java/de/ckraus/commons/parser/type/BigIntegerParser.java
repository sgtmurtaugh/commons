package de.ckraus.commons.parser.type;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

/**
 * Created by ckraus on 02.07.15.
 */
public class BigIntegerParser
    extends AbstractNumericTypeParser<BigInteger> {

    private final static String CLASS   = BigIntegerParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(BigIntegerParser.class);

    /**
     * Constructor
     */
    public BigIntegerParser() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public BigIntegerParser(BigInteger defaultValue) {
        super( defaultValue );
    }


    @Override
    public BigInteger parse(
            String s,
            BigInteger defaultValue,
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
    public BigInteger unformat(
            String sNumber,
            BigInteger defaultValue,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        BigInteger retVal = defaultValue;
        if ( null == StringUtils.trimToNull(sNumber) ) {
            log.debug( "number param is null." );
        }
        else {
            DecimalFormat decimalFormat = this.getDecimalFormat(
                    sPattern,
                    decimalFormatSymbols
            );

            try {
                retVal = BigInteger.valueOf(
                        decimalFormat.parse(sNumber).longValue()
                );
            }
            catch ( ParseException pe ) {
                pe.printStackTrace();
            }
        }
        return retVal;
    }

}
