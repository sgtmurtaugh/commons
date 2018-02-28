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
public class ShortParser
    extends AbstractNumericTypeParser<Short> {

    private final static String CLASS   = ShortParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(ShortParser.class);

    /**
     * Constructor
     */
    public ShortParser() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public ShortParser(Short defaultValue) {
        super( defaultValue );
    }


    @Override
    public Short parse(
            String s,
            Short defaultValue,
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
    public Short unformat(
            String sNumber,
            Short defaultValue,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        Short retVal = defaultValue;
        if ( null == StringUtils.trimToNull(sNumber) ) {
            log.debug( "number param is null." );
        }
        else {
            DecimalFormat decimalFormat = this.getDecimalFormat(
                    sPattern,
                    decimalFormatSymbols
            );

            try {
                retVal = decimalFormat.parse(sNumber).shortValue();
            }
            catch ( ParseException pe ) {
                pe.printStackTrace();
            }
        }
        return retVal;
    }


}
