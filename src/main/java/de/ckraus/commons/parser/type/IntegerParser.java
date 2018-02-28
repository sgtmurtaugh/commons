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
public class IntegerParser
    extends AbstractNumericTypeParser<Integer> {

    private final static String CLASS   = IntegerParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(IntegerParser.class);

    /**
     * Constructor
     */
    public IntegerParser() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public IntegerParser(Integer defaultValue) {
        super( defaultValue );
    }


    @Override
    public Integer parse(
            String s,
            Integer defaultValue,
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
    public Integer unformat(
            String sNumber,
            Integer defaultValue,
            String sPattern,
            DecimalFormatSymbols decimalFormatSymbols
    ) {
        Integer retVal = defaultValue;
        if ( null == StringUtils.trimToNull(sNumber) ) {
            log.debug( "number param is null." );
        }
        else {
            DecimalFormat decimalFormat = this.getDecimalFormat(
                    sPattern,
                    decimalFormatSymbols
            );

            try {
                retVal = decimalFormat.parse(sNumber).intValue();
            }
            catch ( ParseException pe ) {
                log.debug(
                        "number param ({}) cannot be parsed into int value. pattern: {} / {}",
                        sNumber,
                        decimalFormat.toPattern(),
                        decimalFormat.toLocalizedPattern()
                );
            }
        }
        return retVal;
    }


}
