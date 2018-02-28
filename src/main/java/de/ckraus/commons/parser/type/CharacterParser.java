package de.ckraus.commons.parser.type;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ckraus on 02.07.15.
 */
public class CharacterParser
    extends AbstractTypeParser<Character> {

    private final static String CLASS   = CharacterParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(CharacterParser.class);

    public final static boolean DEFAULT_EVALUATE_CODE_POINTS    = Boolean.TRUE;

    /**
     * Constructor
     */
    public CharacterParser() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public CharacterParser(Character defaultValue) {
        super( defaultValue );
    }


    @Override
    public boolean isParsable(Object obj) {
        boolean bIsParsable = super.isParsable( obj );

        if ( bIsParsable ) {
            if ( obj instanceof Character ) {
                log.debug("obj param is an Character instance.");
            }
            else
            if ( obj instanceof String ) {
                log.debug("obj param is an String instance.");
            }
            else
            if ( obj instanceof Integer ) {
                log.debug("obj param is an Integer instance.");
            }
            else {
                log.debug("obj param is an {} instance.", obj.getClass() );
            }
        }
        return bIsParsable;
    }

    /**
     * parse
     * @param s
     * @param bEvaluateCodePoints
     * @return
     * <p></p>
     */
    public Character parse(
            String s,
            boolean bEvaluateCodePoints
    ) {
        return this.parse(
                s,
                this.getDefaultValue(),
                bEvaluateCodePoints
        );
    }

    /**
     * parse
     * @param s
     * @param defaultValue
     * @param bEvaluateCodePoints
     * @return
     * <p></p>
     */
    public Character parse(
            String s,
            Character defaultValue,
            boolean bEvaluateCodePoints
    ) {
        return this.parse(
                s,
                defaultValue,
                this.getDefaultTrimStrings(),
                this.getDefaultEmptyIsNull(),
                bEvaluateCodePoints
        );
    }

    /**
     * @see IAlphaTypeParser#parse(String, Object, boolean, boolean)
     * <p>This implementation uses the {@link #prepareStringToParse(String, boolean, boolean)} Method with the given
     * string param and then checks the value with in Implementation of an IntegerParser to check for an Character Code
     * Point. When the value can be parsed to an Integer, the {@link Character#toChars(int)} is used to get an char
     * array. The first element of this array will be returned. Otherwise the first Character of the String will be
     * returned.</p>
     * <p>When the string param is empty the default value will be returned.</p>
     */
    public Character parse(
            String s,
            Character defaultValue,
            boolean bTrim,
            boolean bEmptyIsNull
    ) {
        return this.parse(
                s,
                defaultValue,
                bTrim,
                bEmptyIsNull,
                DEFAULT_EVALUATE_CODE_POINTS
        );
    }

    /**
     * parse
     * @param s
     * @param defaultValue
     * @param bTrim
     * @param bEmptyIsNull
     * @param bEvaluateCodePoints
     * @return
     * <p></p>
     */
    public Character parse(
            String s,
            Character defaultValue,
            boolean bTrim,
            boolean bEmptyIsNull,
            boolean bEvaluateCodePoints
    ) {
        Character cRetVal = defaultValue;
        String sPreparedString = this.prepareStringToParse(
                s,
                bTrim,
                bEmptyIsNull
        );

        if ( null != sPreparedString ) {
            if ( ! sPreparedString.isEmpty() ) {
                Integer iVal = null;

                if ( bEvaluateCodePoints ) {
                    // Pruefen, ob der String evtl ein Integerwert ist

                    // TODO durch Spring Framework ermitteln
                    TypeParserUtils typeParserUtils = new TypeParserUtils();
                    iVal = typeParserUtils.getIntegerParser().parse(sPreparedString, null);
                }

                if (iVal != null) {
                    char[] acVals = Character.toChars(iVal);

                    if (!ArrayUtils.isEmpty(acVals)) {
                        cRetVal = acVals[0];
                    }
                }
                else {
                    cRetVal = sPreparedString.charAt(0);
                }
            }
        }
        return cRetVal;
    }

}
