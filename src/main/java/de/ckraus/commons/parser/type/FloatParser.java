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
public class FloatParser
    extends AbstractNumericTypeParser<Float> {

    private final static String CLASS   = FloatParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(FloatParser.class);

    /**
     * Constructor
     */
    public FloatParser() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public FloatParser(Float defaultValue) {
        super( defaultValue );
    }


    @Override
    public Float parse(
            String s,
            Float defaultValue,
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
    public Float unformat(
            String sNumber,
            Float defaultValue,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        Float retVal = defaultValue;
        if ( null == StringUtils.trimToNull(sNumber) ) {
            log.debug( "number param is null." );
        }
        else {
            DecimalFormat decimalFormat = this.getDecimalFormat(
                    sPattern,
                    decimalFormatSymbols
            );

            try {
                retVal = decimalFormat.parse(sNumber).floatValue();
            }
            catch ( ParseException pe ) {
                pe.printStackTrace();
            }
        }
        return retVal;
    }


}
