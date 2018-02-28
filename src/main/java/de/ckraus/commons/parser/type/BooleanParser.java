package de.ckraus.commons.parser.type;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by ckraus on 02.07.15.
 *
 * Characters:
 *  n, y, j, 0, 1
 *
 * Numbers:
 *  0, 1
 *
 * Strings:
 *  no, nein, yes, ja, true, false, 0, 1
 */
@Getter
@Setter(AccessLevel.PROTECTED)
public class BooleanParser
    extends AbstractTypeParser<Boolean>
    implements IBooleanTypeParser {

    private final static String CLASS   = BooleanParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(BooleanParser.class);

    private Map<Class<?>, List<?>> trueValues;
    private Map<Class<?>, List<?>> falseValues;


    /**
     * Constructor
     */
    public BooleanParser() {
        this(null);
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public BooleanParser(Boolean defaultValue) {
        super( defaultValue );

        trueValues = new HashMap<>();
        trueValues.put(
                Character.class,
                Arrays.asList(
                        TRUE_CHAR_1,
                        TRUE_CHAR_J,
                        TRUE_CHAR_J_LOWERCASE,
                        TRUE_CHAR_Y,
                        TRUE_CHAR_Y_LOWERCASE
                )
        );
        trueValues.put(
                Integer.class,
                Collections.singletonList( TRUE_INT_1 )
        );
        trueValues.put(
                String.class,
                Arrays.asList(
                        TRUE_STRING_1,
                        TRUE_STRING_ERFOLG,
                        TRUE_STRING_J,
                        TRUE_STRING_JA,
                        TRUE_STRING_OK,
                        TRUE_STRING_OKAY,
                        TRUE_STRING_SUCCESS,
                        TRUE_STRING_SUCCESSFUL,
                        TRUE_STRING_WAHR,
                        TRUE_STRING_Y,
                        TRUE_STRING_YES
                )
        );

        falseValues = new HashMap<>();
        falseValues.put(
                Character.class,
                Arrays.asList(
                        FALSE_CHAR_0,
                        FALSE_CHAR_F,
                        FALSE_CHAR_F_LOWERCASE,
                        FALSE_CHAR_N,
                        FALSE_CHAR_N_LOWERCASE,
                        FALSE_CHAR_X,
                        FALSE_CHAR_X_LOWERCASE
                )
        );
        falseValues.put(
                Integer.class,
                Collections.singletonList(
                        FALSE_INT_0
                )
        );
        falseValues.put(
                String.class,
                Arrays.asList(
                        FALSE_STRING_0,
                        FALSE_STRING_ERROR,
                        FALSE_STRING_FAILURE,
                        FALSE_STRING_FALSCH,
                        FALSE_STRING_FEHLER,
                        FALSE_STRING_N,
                        FALSE_STRING_NEIN,
                        FALSE_STRING_NO,
                        FALSE_STRING_WRONG,
                        FALSE_STRING_X
                )
        );
    }

    @SuppressWarnings("unchecked")
    protected <T> List<Class<T>> getFalseValuesForType(Class<T> clazz) {
        return ( List<Class<T>> ) this.getFalseValues().get(clazz);
    }

//    public Map<Class<?>, List<?>> getTrueValues() {
//        return trueValues;
//    }
//
//    public void setTrueValues( Map<Class<?>, List<?>> trueValues ) {
//        this.trueValues = trueValues;
//    }

    @SuppressWarnings("unchecked")
    protected <T> List<Class<T>> getTrueValuesForType(Class<T> clazz) {
        return ( List<Class<T>> ) this.getTrueValues().get(clazz);
    }


    public <T> boolean isFalseValue( T t ) {
        boolean bIsFalseValue = false;

        if ( null != t ) {
            if ( null != this.getFalseValuesForType(t.getClass()) ) {
                bIsFalseValue = this.getFalseValuesForType(t.getClass()).contains(t);
            }
        }
        return bIsFalseValue;
    }

    public boolean isFalseValue( String s ) {
        boolean bIsFalseValue = false;

        if ( null != s ) {
            if ( null != this.getFalseValuesForType(s.getClass()) ) {
                bIsFalseValue = this.getFalseValuesForType(s.getClass()).contains(s.trim().toLowerCase(Locale.getDefault()));
            }
        }
        return bIsFalseValue;
    }

    public <T> boolean isTrueValue( T t ) {
        boolean bIsTrueValue = false;

        if ( null != t ) {
            if ( null != this.getTrueValuesForType(t.getClass()) ) {
                bIsTrueValue = this.getTrueValuesForType(t.getClass()).contains(t);
            }
        }
        return bIsTrueValue;
    }

    public boolean isTrueValue( String s ) {
        boolean bIsTrueValue = false;

        if ( null != s ) {
            if ( null != this.getTrueValuesForType(s.getClass()) ) {
                bIsTrueValue = this.getTrueValuesForType(s.getClass()).contains(s.trim().toLowerCase(Locale.getDefault()));
            }
        }
        return bIsTrueValue;
    }

    @Override
    public Boolean parse(Character c) {
        return this.parse(
                c,
                this.getDefaultValue()
        );
    }

    @Override
    public Boolean parse(
            Character c,
            Boolean defaultValue
    ) {
        Boolean bRetVal = defaultValue;

        if ( null != c ) {
            if ( isTrueValue( c ) ) {
                bRetVal = true;
            }
            else
            if ( isFalseValue( c ) ) {
                bRetVal = false;
            }
        }
        return bRetVal;
    }

    @Override
    public Boolean parse(Integer i) {
        return this.parse(
                i,
                this.getDefaultValue()
        );
    }

    @Override
    public Boolean parse(
            Integer i,
            Boolean defaultValue
    ) {
        Boolean bRetVal = defaultValue;

        if ( null != i ) {
            if ( isTrueValue( i ) ) {
                bRetVal = true;
            }
            else
            if ( isFalseValue( i ) ) {
                bRetVal = false;
            }
        }
        return bRetVal;
    }

    /**
     * @see ITypeParser#parse(String, Object)
     */
    public Boolean parse(
            String s,
            Boolean defaultValue
    ) {
        return this.parse(
                s,
                defaultValue,
                this.getDefaultTrimStrings(),
                this.getDefaultEmptyIsNull()
        );
    }

    @Override
    public Boolean parse(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull
    ) {
        return this.parse(
                s,
                this.getDefaultValue(),
                bTrim,
                bEmptyIsNull
        );
    }

    @Override
    public Boolean parse(
            String s,
            Boolean defaultValue,
            boolean bTrim,
            boolean bEmptyIsNull
    ) {
        Boolean bRetVal = defaultValue;

        String sPrepareStringToParse = this.prepareStringToParse(
                s,
                bTrim,
                bEmptyIsNull
        );

        if ( null != sPrepareStringToParse ) {
            if ( isTrueValue( sPrepareStringToParse ) ) {
                bRetVal = true;
            }
            else
            if ( isFalseValue( sPrepareStringToParse ) ) {
                bRetVal = false;
            }
        }
        return bRetVal;
    }

}
