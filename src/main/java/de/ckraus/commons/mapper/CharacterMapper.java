package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ArrayUtils;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"javadoc", "unused"})
public class CharacterMapper
        extends AbstractTypeMapper<Character>
        implements ICharacterMapper {

    private final static String CLASS   = CharacterMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(CharacterMapper.class);

    private final boolean evaluateCodePoints;


    /**
     * Constructor
     */
    public CharacterMapper() {
        this(null);
    }

    /**
     * Constructor
     */
    public CharacterMapper(Character defaultValue) {
        super(defaultValue);

        this.evaluateCodePoints = ICharacterMapper.super.isEvaluateCodePoints();
    }

    /**
     * Constructor
     * @param bIsEvaluateCodePoints
     */
    public CharacterMapper(boolean bIsEvaluateCodePoints) {
        this(null, bIsEvaluateCodePoints);
    }

    /**
     * Constructor
     * @param defaultValue
     * @param bIsEvaluateCodePoints
     */
    public CharacterMapper(
            Character defaultValue,
            boolean bIsEvaluateCodePoints
    ) {
        super(defaultValue);

        this.evaluateCodePoints = bIsEvaluateCodePoints;
    }

    @Override
    public boolean isEvaluateCodePoints() {
        return this.evaluateCodePoints;
    }


    /**
     * map
     * @param s
     * @param bEvaluateCodePoints
     * @return
     * <p></p>
     */
    public Character map(
            String s,
            boolean bEvaluateCodePoints
    ) {
        return this.map(
                s,
                bEvaluateCodePoints,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param s
     * @param bEvaluateCodePoints
     * @param defaultValue
     * @return
     * <p></p>
     */
    public Character map(
            String s,
            boolean bEvaluateCodePoints,
            Character defaultValue
    ) {
        return this.map(
                s,
                this.isTrimStrings(),
                this.isEmptyStringNull(),
                bEvaluateCodePoints,
                defaultValue
        );
    }

    /**
     * map
     * <p>This implementation uses the {@link #prepareStringToParse(String, boolean, boolean)} Method with the given
     * string param and then checks the value with in Implementation of an IntegerParser to check for an Character Code
     * Point. When the value can be parsed to an Integer, the {@link Character#toChars(int)} is used to get an char
     * array. The first element of this array will be returned. Otherwise the first Character of the String will be
     * returned.</p>
     * <p>When the string param is empty the default value will be returned.</p>
     */
    public Character map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull,
            Character defaultValue
    ) {
        return this.map(
                s,
                bTrim,
                bEmptyIsNull,
                this.isEvaluateCodePoints(),
                defaultValue
        );
    }

    /**
     * map
     * @param s
     * @param bTrim
     * @param bEmptyIsNull
     * @param bEvaluateCodePoints
     * @param defaultValue
     * @return
     * <p></p>
     */
    public Character map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull,
            boolean bEvaluateCodePoints,
            Character defaultValue
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
                    iVal = TypeMapperUtils.getDefaults().getIntegerMapper().map(
                            sPreparedString,
                            (String) null
                    );
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
