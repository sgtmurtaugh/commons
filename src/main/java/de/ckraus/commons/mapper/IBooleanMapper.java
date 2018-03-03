package de.ckraus.commons.mapper;


import java.util.function.Predicate;

/**
 * Created by ckraus on 09.08.15.
 */
@SuppressWarnings({"javadoc"})
public interface IBooleanMapper
    extends ITypeMapper<Boolean> {

    /*
        False Characters
     */
    Character FALSE_CHAR_0              = '0';
    Character FALSE_CHAR_F              = 'F';
    Character FALSE_CHAR_F_LOWERCASE    = 'f';
    Character FALSE_CHAR_N              = 'N';
    Character FALSE_CHAR_N_LOWERCASE    = 'n';
    Character FALSE_CHAR_X              = 'X';
    Character FALSE_CHAR_X_LOWERCASE    = 'x';

    /*
        True Characters
     */
    Character TRUE_CHAR_1           = '1';
    Character TRUE_CHAR_J           = 'J';
    Character TRUE_CHAR_J_LOWERCASE = 'j';
    Character TRUE_CHAR_Y           = 'Y';
    Character TRUE_CHAR_Y_LOWERCASE = 'y';

    /*
        False Integers
     */
    Integer FALSE_INT_0 = 0;

    /*
        True Integers
     */
    Integer TRUE_INT_1  = 1;

    /*
        False Integers
     */
    String FALSE_STRING_0       = "0";
    String FALSE_STRING_BACK    = "back";
    String FALSE_STRING_BREAK   = "break";
    String FALSE_STRING_CANCEL  = "cancel";
    String FALSE_STRING_ERROR   = "error";
    String FALSE_STRING_ERR     = "err";
    String FALSE_STRING_FAIL    = "fail";
    String FALSE_STRING_FAILURE = "failure";
    String FALSE_STRING_FALSCH  = "falsch";
    String FALSE_STRING_FALSE   = "false";
    String FALSE_STRING_FEHLER  = "fehler";
    String FALSE_STRING_N       = "n";
    String FALSE_STRING_NEIN    = "nein";
    String FALSE_STRING_NO      = "no";
    String FALSE_STRING_OFF     = "off";
    String FALSE_STRING_WRONG   = "wrong";
    String FALSE_STRING_X       = "x";

    /*
        True Integers
     */
    String TRUE_STRING_1            = "1";
    String TRUE_STRING_ERFOLG       = "erfolg";
    String TRUE_STRING_FORWARD      = "forward";
    String TRUE_STRING_J            = "j";
    String TRUE_STRING_JA           = "ja";
    String TRUE_STRING_NEXT         = "next";
    String TRUE_STRING_OK           = "ok";
    String TRUE_STRING_OKAY         = "okay";
    String TRUE_STRING_ON           = "on";
    String TRUE_STRING_SUCCESS      = "success";
    String TRUE_STRING_SUCCESSFUL   = "successful";
    String TRUE_STRING_TRUE         = "true";
    String TRUE_STRING_WAHR         = "wahr";
    String TRUE_STRING_Y            = "y";
    String TRUE_STRING_YES          = "yes";


    /*
        Predicates False Characters
     */
    static Predicate<Character> predicateFalseChar0() {
        return c -> c.equals(FALSE_CHAR_0);
    }
    static Predicate<Character> predicateFalseCharF() {
        return c -> c.equals(FALSE_CHAR_F);
    }
    static Predicate<Character> predicateFalseCharFLowercase() {
        return c -> c.equals(FALSE_CHAR_F_LOWERCASE);
    }
    static Predicate<Character> predicateFalseCharN() {
        return c -> c.equals(FALSE_CHAR_N);
    }
    static Predicate<Character> predicateFalseCharNLowercase() {
        return c -> c.equals(FALSE_CHAR_N_LOWERCASE);
    }
    static Predicate<Character> predicateFalseCharX() {
        return c -> c.equals(FALSE_CHAR_X);
    }
    static Predicate<Character> predicateFalseCharXLowercase() {
        return c -> c.equals(FALSE_CHAR_X_LOWERCASE);
    }

    static Predicate<Character> predicateFalseCharacters() {
        return predicateFalseChar0()
                .or(predicateFalseCharF())
                .or(predicateFalseCharFLowercase())
                .or(predicateFalseCharN())
                .or(predicateFalseCharNLowercase())
                .or(predicateFalseCharX())
                .or(predicateFalseCharXLowercase());
    }


    /*
        Predicates False Integers
     */
    static Predicate<Integer> predicateFalseInt0() {
        return i -> i.equals(FALSE_INT_0);
    }

    static Predicate<Integer> predicateFalseIntegers() {
        return predicateFalseInt0();
    }


    /*
        Predicates True Strings
     */
    static Predicate<String> predicateFalseString0() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_0);
    }
    static Predicate<String> predicateFalseStringBack() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_BACK);
    }
    static Predicate<String> predicateFalseStringBreak() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_BREAK);
    }
    static Predicate<String> predicateFalseStringCancel() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_CANCEL);
    }
    static Predicate<String> predicateFalseStringError() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_ERROR);
    }
    static Predicate<String> predicateFalseStringErr() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_ERR);
    }
    static Predicate<String> predicateFalseStringFail() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_FAIL);
    }
    static Predicate<String> predicateFalseStringFailure() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_FAILURE);
    }
    static Predicate<String> predicateFalseStringFalsch() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_FALSCH);
    }
    static Predicate<String> predicateFalseStringFalse() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_FALSE);
    }
    static Predicate<String> predicateFalseStringFehler() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_FEHLER);
    }
    static Predicate<String> predicateFalseStringN() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_N);
    }
    static Predicate<String> predicateFalseStringNein() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_NEIN);
    }
    static Predicate<String> predicateFalseStringNo() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_NO);
    }
    static Predicate<String> predicateFalseStringOff() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_OFF);
    }
    static Predicate<String> predicateFalseStringWrong() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_WRONG);
    }
    static Predicate<String> predicateFalseStringX() {
        return s -> s.equalsIgnoreCase(FALSE_STRING_X);
    }

    static Predicate<String> predicateFalseStrings() {
        return predicateFalseString0()
                .or(predicateFalseStringBack())
                .or(predicateFalseStringBreak())
                .or(predicateFalseStringCancel())
                .or(predicateFalseStringErr())
                .or(predicateFalseStringError())
                .or(predicateFalseStringFail())
                .or(predicateFalseStringFailure())
                .or(predicateFalseStringFalsch())
                .or(predicateFalseStringFalse())
                .or(predicateFalseStringFehler())
                .or(predicateFalseStringN())
                .or(predicateFalseStringNein())
                .or(predicateFalseStringNo())
                .or(predicateFalseStringOff())
                .or(predicateFalseStringWrong())
                .or(predicateFalseStringX());
    }


    /*
        Predicates True Characters
     */
    static Predicate<Character> predicateTrueChar1() {
        return c -> c.equals(TRUE_CHAR_1);
    }
    static Predicate<Character> predicateTrueCharJ() {
        return c -> c.equals(TRUE_CHAR_J);
    }
    static Predicate<Character> predicateTrueCharJLowercase() {
        return c -> c.equals(TRUE_CHAR_J_LOWERCASE);
    }
    static Predicate<Character> predicateTrueCharY() {
        return c -> c.equals(TRUE_CHAR_Y);
    }
    static Predicate<Character> predicateTrueCharYLowercase() {
        return c -> c.equals(TRUE_CHAR_Y_LOWERCASE);
    }

    static Predicate<Character> predicateTrueCharacters() {
        return predicateTrueChar1()
                .or(predicateTrueCharJ())
                .or(predicateTrueCharJLowercase())
                .or(predicateTrueCharY())
                .or(predicateTrueCharYLowercase());
    }


    /*
        Predicates True Integers
     */
    static Predicate<Integer> predicateTrueInt1() {
        return i -> i.equals(TRUE_INT_1);
    }

    static Predicate<Integer> predicateTrueIntegers() {
        return predicateTrueInt1();
    }


    /*
        Predicates True Strings
     */
    static Predicate<String> predicateTrueString1() {
        return s -> s.equalsIgnoreCase(TRUE_STRING_1);
    }
    static Predicate<String> predicateTrueStringErfolg() {
        return s -> s.equalsIgnoreCase(TRUE_STRING_ERFOLG);
    }
    static Predicate<String> predicateTrueStringForward() {
        return s -> s.equalsIgnoreCase(TRUE_STRING_FORWARD);
    }
    static Predicate<String> predicateTrueStringJ() {
        return s -> s.equalsIgnoreCase(TRUE_STRING_J);
    }
    static Predicate<String> predicateTrueStringJa() {
        return s -> s.equalsIgnoreCase(TRUE_STRING_JA);
    }
    static Predicate<String> predicateTrueStringNext() {
        return s -> s.equalsIgnoreCase(TRUE_STRING_NEXT);
    }
    static Predicate<String> predicateTrueStringOk() {
        return s -> s.equalsIgnoreCase(TRUE_STRING_OK);
    }
    static Predicate<String> predicateTrueStringOkay() {
        return s -> s.equalsIgnoreCase(TRUE_STRING_OKAY);
    }
    static Predicate<String> predicateTrueStringOn() {
        return s -> s.equalsIgnoreCase(TRUE_STRING_ON);
    }
    static Predicate<String> predicateTrueStringSuccess() {
        return s -> s.equalsIgnoreCase(TRUE_STRING_SUCCESS);
    }
    static Predicate<String> predicateTrueStringSuccessful() {
        return s -> s.equalsIgnoreCase(TRUE_STRING_SUCCESSFUL);
    }
    static Predicate<String> predicateTrueStringTrue() {
        return s -> s.equalsIgnoreCase(TRUE_STRING_TRUE);
    }
    static Predicate<String> predicateTrueStringWahr() {
        return s -> s.equalsIgnoreCase(TRUE_STRING_WAHR);
    }
    static Predicate<String> predicateTrueStringY() {
        return s -> s.equalsIgnoreCase(TRUE_STRING_Y);
    }
    static Predicate<String> predicateTrueStringYes() {
        return s -> s.equalsIgnoreCase(TRUE_STRING_YES);
    }

    static Predicate<String> predicateTrueStrings() {
        return predicateTrueString1()
                .or(predicateTrueStringErfolg())
                .or(predicateTrueStringForward())
                .or(predicateTrueStringJ())
                .or(predicateTrueStringJa())
                .or(predicateTrueStringNext())
                .or(predicateTrueStringOk())
                .or(predicateTrueStringOkay())
                .or(predicateTrueStringOn())
                .or(predicateTrueStringSuccess())
                .or(predicateTrueStringSuccessful())
                .or(predicateTrueStringTrue())
                .or(predicateTrueStringWahr())
                .or(predicateTrueStringY())
                .or(predicateTrueStringYes());
    }


    /*
        Boolean Predicates
     */
    static Predicate<Character> predicateBooleanCharacters() {
        return predicateTrueCharacters()
                .or(predicateFalseCharacters());
    }
    static Predicate<Integer> predicateBooleanIntegers() {
        return predicateTrueIntegers()
                .or(predicateFalseIntegers());
    }
    static Predicate<String> predicateBooleanStrings() {
        return predicateTrueStrings()
                .or(predicateFalseStrings());
    }


    /**
     * isMappable
     * @param o
     * @return
     */
    default boolean isMappable(Object o) {
        boolean bIsMappable;

        if ( null == o ) {
            bIsMappable = false;
        }
        else
        if ( o instanceof Boolean ) {
            bIsMappable = true;
        }
        else
        if ( o instanceof Character ) {
            bIsMappable = this.isMappable(
                    predicateBooleanCharacters(),
                    (Character) o
            );
        }
        else
        if ( o instanceof Integer ) {
            bIsMappable = this.isMappable(
                    predicateBooleanIntegers(),
                    (Integer) o
            );
        }
        else
        if ( o instanceof String ) {
            bIsMappable = this.isMappable(
                    predicateBooleanStrings(),
                    (String) o
            );
        }
        else {
            bIsMappable = this.isMappable( o.toString() );
        }
        return bIsMappable;
    }

    /**
     * map
     * @param c - character to map
     */
    default Boolean map(Character c) {
        return this.map(
                c,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param c - character to map
     * @param defaultValue - The default value
     * @return
     */
    default Boolean map(
            Character c,
            Boolean defaultValue
    ) {
        Boolean b = defaultValue;

        if (null != c) {
            if (this.isFalse(c)) {
                b = Boolean.FALSE;
            }
            else
            if (this.isTrue(c)) {
                b = Boolean.TRUE;
            }
        }
        return b;
    }

    /**
     * map
     * @param i - integer to map
     * @return
     */
    default Boolean map(Integer i) {
        return this.map(
                i,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param i - integer to map
     * @param defaultValue - The default value
     * @return
     */
    default Boolean map(
            Integer i,
            Boolean defaultValue
    ) {
        Boolean b = defaultValue;

        if (null != i) {
            if (this.isFalse(i)) {
                b = Boolean.FALSE;
            }
            else
            if (this.isTrue(i)) {
                b = Boolean.TRUE;
            }
        }
        return b;
    }

    /**
     * map
     * @param s - string to map
     * @param bTrim - default flag for string handling
     * @param bEmptyIsNull - default flag for empty string handling
     * @return
     */
    default Boolean map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull
    ) {
        return this.map(
                s,
                bTrim,
                bEmptyIsNull,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param s - string to map
     * @param bTrim - default flag for string handling
     * @param bEmptyIsNull - default flag for empty string handling
     * @param defaultValue - The default value
     * @return
     */
    default Boolean map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull,
            Boolean defaultValue
    ) {
        Boolean b = defaultValue;
        String preparedString = this.prepareStringToParse(
                s,
                bTrim,
                bEmptyIsNull
        );

        if (null != preparedString) {
            String val = preparedString;

            // optional trim
            if (bTrim) {
                val = val.trim();
            }

            // optional empty check
            if (bEmptyIsNull
                    && val.length() == 0) {
                val = null;
            }

            // true / false check
            if (null != val) {
                if (this.isFalse(val)) {
                    b = Boolean.FALSE;
                }
                else
                if (this.isTrue(val)) {
                    b = Boolean.TRUE;
                }
            }
        }
        return b;
    }

    /**
     * isFalse
     * @param predicate
     * @param t
     * @param <T>
     * @return
     */
    default <T> boolean isFalse(Predicate<T> predicate, T t) {
        boolean bIsFalse = false;

        if (null != predicate) {
            bIsFalse = predicate.test(t);
        }
        return bIsFalse;
    }

    /**
     * isFalse
     * @param c
     * @return
     */
    default boolean isFalse(Character c) {
        boolean bIsFalse = false;

        if (null != c) {
            bIsFalse = this.isFalse(
                    predicateFalseCharacters(),
                    c
            );
        }
        return bIsFalse;
    }

    /**
     * isFalse
     * @param i
     * @return
     */
    default boolean isFalse(Integer i) {
        boolean bIsFalse = false;

        if (null != i) {
            bIsFalse = this.isFalse(
                    predicateFalseIntegers(),
                    i
            );
        }
        return bIsFalse;
    }

    /**
     * isFalse
     * @param o
     * @return
     */
    default boolean isFalse(Object o) {
        boolean bIsFalse;

        if ( null == o ) {
            bIsFalse = false;
        }
        else
        if ( o instanceof Boolean ) {
            bIsFalse = (o == Boolean.FALSE) ;
        }
        else
        if ( o instanceof Character ) {
            bIsFalse = this.isFalse( (Character) o );
        }
        else
        if ( o instanceof Integer ) {
            bIsFalse = this.isFalse( (Integer) o );
        }
        else
        if ( o instanceof String ) {
            bIsFalse = this.isFalse( (String) o );
        }
        else {
            bIsFalse = this.isFalse( o.toString() );
        }
        return bIsFalse;
    }

    /**
     * isFalse
     * @param s
     * @return
     */
    default boolean isFalse(String s) {
        boolean bIsFalse = false;

        if (null != s) {
            bIsFalse = this.isFalse(
                    predicateFalseStrings(),
                    s
            );
        }
        return bIsFalse;
    }

    /**
     * isTrue
     * @param predicate
     * @param t
     * @param <T>
     * @return
     */
    default <T> boolean isTrue(Predicate<T> predicate, T t) {
        boolean bIsTrue = false;

        if (null != predicate) {
            bIsTrue = predicate.test(t);
        }
        return bIsTrue;
    }

    /**
     * isTrue
     * @param c
     * @return
     */
    default boolean isTrue(Character c) {
        boolean bIsTrue = false;

        if (null != c) {
            bIsTrue = this.isTrue(
                    predicateTrueCharacters(),
                    c
            );
        }
        return bIsTrue;
    }

    /**
     * isTrue
     * @param i
     * @return
     */
    default boolean isTrue(Integer i) {
        boolean bIsTrue = false;

        if (null != i) {
            bIsTrue = this.isTrue(
                    predicateTrueIntegers(),
                    i
            );
        }
        return bIsTrue;
    }

    /**
     * isTrue
     * @param o
     * @return
     */
    default boolean isTrue(Object o) {
        boolean bIsTrue;

        if ( null == o ) {
            bIsTrue = false;
        }
        else
        if ( o instanceof Boolean ) {
            bIsTrue = (o == Boolean.TRUE) ;
        }
        else
        if ( o instanceof Character ) {
            bIsTrue = this.isTrue( (Character) o );
        }
        else
        if ( o instanceof Integer ) {
            bIsTrue = this.isTrue( (Integer) o );
        }
        else
        if ( o instanceof String ) {
            bIsTrue = this.isTrue( (String) o );
        }
        else {
            bIsTrue = this.isTrue( o.toString() );
        }
        return bIsTrue;
    }

    /**
     * isTrue
     * @param s
     * @return
     */
    default boolean isTrue(String s) {
        boolean bIsTrue = false;

        if (null != s) {
            bIsTrue = this.isTrue(
                    predicateTrueStrings(),
                    s
            );
        }
        return bIsTrue;
    }

}
