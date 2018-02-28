package de.ckraus.commons.parser.type;

/**
 * Created by ckraus on 09.08.15.
 */
public interface IBooleanTypeParser
    extends ITypeParser<Boolean> {

    public final static Character TRUE_CHAR_1           = '1';
    public final static Character TRUE_CHAR_J           = 'J';
    public final static Character TRUE_CHAR_J_LOWERCASE = 'j';
    public final static Character TRUE_CHAR_Y           = 'Y';
    public final static Character TRUE_CHAR_Y_LOWERCASE = 'y';

    public final static Integer TRUE_INT_1              = 1;

    public final static String TRUE_STRING_1            = "1";
    public final static String TRUE_STRING_ERFOLG       = "erfolg";
    public final static String TRUE_STRING_J            = "j";
    public final static String TRUE_STRING_JA           = "ja";
    public final static String TRUE_STRING_OK           = "ok";
    public final static String TRUE_STRING_OKAY         = "okay";
    public final static String TRUE_STRING_SUCCESS      = "success";
    public final static String TRUE_STRING_SUCCESSFUL   = "successful";
    public final static String TRUE_STRING_WAHR         = "wahr";
    public final static String TRUE_STRING_Y            = "y";
    public final static String TRUE_STRING_YES          = "yes";

    public final static Character FALSE_CHAR_0              = '0';
    public final static Character FALSE_CHAR_F              = 'F';
    public final static Character FALSE_CHAR_F_LOWERCASE    = 'f';
    public final static Character FALSE_CHAR_N              = 'N';
    public final static Character FALSE_CHAR_N_LOWERCASE    = 'n';
    public final static Character FALSE_CHAR_X              = 'X';
    public final static Character FALSE_CHAR_X_LOWERCASE    = 'x';

    public final static Integer FALSE_INT_0                 = 0;

    public final static String FALSE_STRING_0       = "0";
    public final static String FALSE_STRING_ERROR   = "error";
    public final static String FALSE_STRING_FAILURE = "failure";
    public final static String FALSE_STRING_FALSCH  = "falsch";
    public final static String FALSE_STRING_FEHLER  = "fehler";
    public final static String FALSE_STRING_N       = "n";
    public final static String FALSE_STRING_NEIN    = "nein";
    public final static String FALSE_STRING_NO      = "no";
    public final static String FALSE_STRING_WRONG   = "wrong";
    public final static String FALSE_STRING_X       = "x";


    /**
     * parse
     * @param c - character to parse
     */
    Boolean parse ( Character c );

    /**
     * parse
     * @param c - character to parse
     * @param defaultValue - The default value
     * @return
     */
    Boolean parse (
            Character c,
            Boolean defaultValue
    );

    /**
     * parse
     * @param i - integer to parse
     * @return
     */
    Boolean parse ( Integer i );

    /**
     * parse
     * @param i - integer to parse
     * @param defaultValue - The default value
     * @return
     */
    Boolean parse (
            Integer i,
            Boolean defaultValue
    );

    /**
     * parse
     * @param s - string to parse
     * @param bTrim - default flag for string handling
     * @param bEmptyIsNull - default flag for empty string handling
     * @return
     */
    Boolean parse(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull
    );

    /**
     * parse
     * @param s - string to parse
     * @param defaultValue - The default value
     * @param bTrim - default flag for string handling
     * @param bEmptyIsNull - default flag for empty string handling
     * @return
     */
    Boolean parse(
            String s,
            Boolean defaultValue,
            boolean bTrim,
            boolean bEmptyIsNull
    );

}
