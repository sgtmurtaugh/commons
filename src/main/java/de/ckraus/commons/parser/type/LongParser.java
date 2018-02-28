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
public class LongParser
    extends AbstractNumericTypeParser<Long> {

    private final static String CLASS   = LongParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(LongParser.class);

    /**
     * Constructor
     */
    public LongParser() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public LongParser(Long defaultValue) {
        super( defaultValue );
    }


    @Override
    public Long parse(
            String s,
            Long defaultValue,
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
    public Long unformat(
            String sNumber,
            Long defaultValue,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        Long retVal = defaultValue;
        if ( null == StringUtils.trimToNull(sNumber) ) {
            log.debug( "number param is null." );
        }
        else {
            DecimalFormat decimalFormat = this.getDecimalFormat(
                    sPattern,
                    decimalFormatSymbols
            );

            try {
                retVal = decimalFormat.parse(sNumber).longValue();
            }
            catch ( ParseException pe ) {
                pe.printStackTrace();
            }
        }
        return retVal;
    }


}
