package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter( AccessLevel.PROTECTED )
@SuppressWarnings( { "javadoc", "unused", "WeakerAccess" } )
public class BooleanMapper extends AbstractTypeMapper<Boolean> implements IBooleanMapper {

    private final static String CLASS = BooleanMapper.class.getSimpleName();
    //    protected static Logger log = LoggerFactory.getLogger(BooleanMapper.class);

    private final static Character FALSE_CHAR_0 = '0';
    private final static Character FALSE_CHAR_N = 'N';
    private final static Character FALSE_CHAR_N_LOWERCASE = 'n';
    private final static Character TRUE_CHAR_1 = '1';
    private final static Character TRUE_CHAR_Y = 'Y';
    private final static Character TRUE_CHAR_Y_LOWERCASE = 'y';

    private final static Integer FALSE_INT_0 = 0;
    private final static Integer TRUE_INT_1 = 1;

    private final static String FALSE_STRING_0 = "0";
    private final static String FALSE_STRING_FALSE = "false";
    private final static String FALSE_STRING_N = "n";
    private final static String FALSE_STRING_NO = "no";
    private final static String TRUE_STRING_1 = "1";
    private final static String TRUE_STRING_TRUE = "true";
    private final static String TRUE_STRING_Y = "y";
    private final static String TRUE_STRING_YES = "yes";

    private List<Character> falseCharacterValues;
    private List<Character> trueCharacterValues;
    private List<Integer> falseIntegerValues;
    private List<Integer> trueIntegerValues;
    private List<String> falseStringValues;
    private List<String> trueStringValues;


    /**
     * Constructor
     */
    public BooleanMapper() {
        super();
    }

    /**
     * Constructor
     *
     * @param defaultValue
     */
    public BooleanMapper( Boolean defaultValue ) {
        super( defaultValue );
    }


    /**
     * getFalseCharacterValues
     *
     * @return
     */
    @SuppressWarnings( "Duplicates" )
    public List<Character> getFalseCharacterValues() {
        if ( null == falseCharacterValues ) {
            falseCharacterValues = new ArrayList<>();
            falseCharacterValues.add( FALSE_CHAR_0 );
            falseCharacterValues.add( FALSE_CHAR_N );
            falseCharacterValues.add( FALSE_CHAR_N_LOWERCASE );
        }
        return falseCharacterValues;
    }

    /**
     * getFalseIntegerValues
     *
     * @return
     */
    @SuppressWarnings( "Duplicates" )
    public List<Integer> getFalseIntegerValues() {
        if ( null == falseIntegerValues ) {
            falseIntegerValues = new ArrayList<>();
            falseIntegerValues.add( FALSE_INT_0 );
        }
        return falseIntegerValues;
    }

    /**
     * getFalseStringValues
     *
     * @return
     */
    @SuppressWarnings( "Duplicates" )
    public List<String> getFalseStringValues() {
        if ( null == falseStringValues ) {
            falseStringValues = new ArrayList<>();
            falseStringValues.add( FALSE_STRING_0 );
            falseStringValues.add( FALSE_STRING_FALSE );
            falseStringValues.add( FALSE_STRING_N );
            falseStringValues.add( FALSE_STRING_NO );
        }
        return falseStringValues;
    }

    /**
     * getTrueCharacterValues
     *
     * @return
     */
    @SuppressWarnings( "Duplicates" )
    public List<Character> getTrueCharacterValues() {
        if ( null == trueCharacterValues ) {
            trueCharacterValues = new ArrayList<>();
            trueCharacterValues.add( TRUE_CHAR_1 );
            trueCharacterValues.add( TRUE_CHAR_Y );
            trueCharacterValues.add( TRUE_CHAR_Y_LOWERCASE );
        }
        return trueCharacterValues;
    }

    /**
     * getTrueIntegerValues
     *
     * @return
     */
    public List<Integer> getTrueIntegerValues() {
        if ( null == trueIntegerValues ) {
            trueIntegerValues = new ArrayList<>();
            trueIntegerValues.add( TRUE_INT_1 );
        }
        return trueIntegerValues;
    }

    /**
     * getTrueStringValues
     *
     * @return
     */
    @SuppressWarnings( "Duplicates" )
    public List<String> getTrueStringValues() {
        if ( null == trueStringValues ) {
            trueStringValues = new ArrayList<>();
            trueStringValues.add( TRUE_STRING_1 );
            trueStringValues.add( TRUE_STRING_TRUE );
            trueStringValues.add( TRUE_STRING_Y );
            trueStringValues.add( TRUE_STRING_YES );
        }
        return trueStringValues;
    }


    /**
     * isFalse
     *
     * @param c
     *
     * @return
     */
    public boolean isFalse( Character c ) {
        boolean bIsFalse = false;

        if ( null != c ) {
            bIsFalse = this.getFalseCharacterValues().stream().anyMatch( character -> character.equals( c ) );
        }
        return bIsFalse;
    }

    /**
     * isFalse
     *
     * @param i
     *
     * @return
     */
    public boolean isFalse( Integer i ) {
        boolean bIsFalse = false;

        if ( null != i ) {
            bIsFalse = this.getFalseIntegerValues().stream().anyMatch( integer -> integer.equals( i ) );
        }
        return bIsFalse;
    }

    /**
     * isFalse
     *
     * @param s
     *
     * @return
     */
    public boolean isFalse( String s ) {
        boolean bIsFalse = false;

        if ( null != s ) {
            bIsFalse = this.getFalseStringValues().stream()
                           .anyMatch( string -> string.trim().equalsIgnoreCase( s.trim() ) );
        }
        return bIsFalse;
    }

    /**
     * isTrue
     *
     * @param c
     *
     * @return
     */
    public boolean isTrue( Character c ) {
        boolean bIsTrue = false;

        if ( null != c ) {
            bIsTrue = this.getTrueCharacterValues().stream().anyMatch( character -> character.equals( c ) );
        }
        return bIsTrue;
    }

    /**
     * isTrue
     *
     * @param i
     *
     * @return
     */
    public boolean isTrue( Integer i ) {
        boolean bIsTrue = false;

        if ( null != i ) {
            bIsTrue = this.getTrueIntegerValues().stream().anyMatch( integer -> integer.equals( i ) );
        }
        return bIsTrue;
    }

    /**
     * isTrue
     *
     * @param s
     *
     * @return
     */
    public boolean isTrue( String s ) {
        boolean bIsTrue = false;

        if ( null != s ) {
            bIsTrue = this.getTrueStringValues().stream()
                          .anyMatch( string -> string.trim().equalsIgnoreCase( s.trim() ) );
        }
        return bIsTrue;
    }

}
