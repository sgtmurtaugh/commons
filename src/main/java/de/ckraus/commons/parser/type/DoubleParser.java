package de.ckraus.commons.parser.type;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

/**
 * Created by ckraus on 02.07.15.
 */
public class DoubleParser
    extends AbstractNumericTypeParser<Double> {

    private final static String CLASS   = DoubleParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(DoubleParser.class);

    /**
     * Constructor
     */
    public DoubleParser() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public DoubleParser(Double defaultValue) {
        super( defaultValue );
    }


    @Override
    public Double parse(
            String s,
            Double defaultValue,
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
    public Double unformat(
            String sNumber,
            Double defaultValue,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        Double retVal = defaultValue;
        if ( null == StringUtils.trimToNull(sNumber) ) {
            log.debug( "number param is null." );
        }
        else {
            DecimalFormat decimalFormat = this.getDecimalFormat(
                    sPattern,
                    decimalFormatSymbols
            );

            try {
                retVal = decimalFormat.parse(sNumber).doubleValue();
            }
            catch ( ParseException pe ) {
                pe.printStackTrace();
            }
        }
        return retVal;
    }


}
