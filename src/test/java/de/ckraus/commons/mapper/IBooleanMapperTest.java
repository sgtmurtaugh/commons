package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings({"UnnecessaryLocalVariable"})
class IBooleanMapperTest {
    private final String HELLO_WORLD = "Hello World!";

    // create mapper instance
    IBooleanMapper mapper = () -> null;


    @Test
    void predicateFalseChar0() {
        final char LEGAL_VALUE      = IBooleanMapper.FALSE_CHAR_0;
        final char ILLEGAL_VALUE    = '?';

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseChar0().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseChar0().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseCharF() {
        final char LEGAL_VALUE              = IBooleanMapper.FALSE_CHAR_F;
        final char ILLEGAL_VALUE            = '?';
        final char ILLEGAL_LOWERCASE_VALUE  = IBooleanMapper.FALSE_CHAR_F_LOWERCASE;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseCharF().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseCharF().test(ILLEGAL_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateFalseCharF().test(ILLEGAL_LOWERCASE_VALUE)
        );
    }

    @Test
    void predicateFalseCharFLowercase() {
        final char LEGAL_VALUE              = IBooleanMapper.FALSE_CHAR_F_LOWERCASE;
        final char ILLEGAL_VALUE            = '?';
        final char ILLEGAL_UPPERCASE_VALUE  = IBooleanMapper.FALSE_CHAR_F;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseCharFLowercase().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseCharFLowercase().test(ILLEGAL_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateFalseCharFLowercase().test(ILLEGAL_UPPERCASE_VALUE)
        );
    }

    @Test
    void predicateFalseCharN() {
        final char LEGAL_VALUE              = IBooleanMapper.FALSE_CHAR_N;
        final char ILLEGAL_VALUE            = '?';
        final char ILLEGAL_LOWERCASE_VALUE  = IBooleanMapper.FALSE_CHAR_N_LOWERCASE;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseCharN().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseCharN().test(ILLEGAL_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateFalseCharN().test(ILLEGAL_LOWERCASE_VALUE)
        );
    }

    @Test
    void predicateFalseCharNLowercase() {
        final char LEGAL_VALUE              = IBooleanMapper.FALSE_CHAR_N_LOWERCASE;
        final char ILLEGAL_VALUE            = '?';
        final char ILLEGAL_UPPERCASE_VALUE  = IBooleanMapper.FALSE_CHAR_N;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseCharNLowercase().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseCharNLowercase().test(ILLEGAL_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateFalseCharNLowercase().test(ILLEGAL_UPPERCASE_VALUE)
        );
    }

    @Test
    void predicateFalseCharX() {
        final char LEGAL_VALUE              = IBooleanMapper.FALSE_CHAR_X;
        final char ILLEGAL_VALUE            = '?';
        final char ILLEGAL_LOWERCASE_VALUE  = IBooleanMapper.FALSE_CHAR_X_LOWERCASE;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseCharX().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseCharX().test(ILLEGAL_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateFalseCharX().test(ILLEGAL_LOWERCASE_VALUE)
        );
    }

    @Test
    void predicateFalseCharXLowercase() {
        final char LEGAL_VALUE              = IBooleanMapper.FALSE_CHAR_X_LOWERCASE;
        final char ILLEGAL_VALUE            = '?';
        final char ILLEGAL_UPPERCASE_VALUE  = IBooleanMapper.FALSE_CHAR_X;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseCharXLowercase().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseCharXLowercase().test(ILLEGAL_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateFalseCharXLowercase().test(ILLEGAL_UPPERCASE_VALUE)
        );
    }

    @Test
    void predicateFalseCharacters() {
        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseCharacters().test(IBooleanMapper.FALSE_CHAR_0)
        );
        assertTrue(
                IBooleanMapper.predicateFalseCharacters().test(IBooleanMapper.FALSE_CHAR_F)
        );
        assertTrue(
                IBooleanMapper.predicateFalseCharacters().test(IBooleanMapper.FALSE_CHAR_F_LOWERCASE)
        );
        assertTrue(
                IBooleanMapper.predicateFalseCharacters().test(IBooleanMapper.FALSE_CHAR_N)
        );
        assertTrue(
                IBooleanMapper.predicateFalseCharacters().test(IBooleanMapper.FALSE_CHAR_N_LOWERCASE)
        );
        assertTrue(
                IBooleanMapper.predicateFalseCharacters().test(IBooleanMapper.FALSE_CHAR_X)
        );
        assertTrue(
                IBooleanMapper.predicateFalseCharacters().test(IBooleanMapper.FALSE_CHAR_X_LOWERCASE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseCharacters().test(IBooleanMapper.TRUE_CHAR_1)
        );
        assertFalse(
                IBooleanMapper.predicateFalseCharacters().test(IBooleanMapper.TRUE_CHAR_J)
        );
        assertFalse(
                IBooleanMapper.predicateFalseCharacters().test(IBooleanMapper.TRUE_CHAR_J_LOWERCASE)
        );
        assertFalse(
                IBooleanMapper.predicateFalseCharacters().test(IBooleanMapper.TRUE_CHAR_Y)
        );
        assertFalse(
                IBooleanMapper.predicateFalseCharacters().test(IBooleanMapper.TRUE_CHAR_Y_LOWERCASE)
        );
    }

    @Test
    void predicateFalseInt0() {
        final int LEGAL_VALUE   = IBooleanMapper.FALSE_INT_0;
        final int ILLEGAL_VALUE = IBooleanMapper.TRUE_INT_1;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseInt0().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseInt0().test(ILLEGAL_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateFalseInt0().test(Integer.MIN_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateFalseInt0().test(Integer.MAX_VALUE)
        );
    }

    @Test
    void predicateFalseIntegers() {
        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseIntegers().test(IBooleanMapper.FALSE_INT_0)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseIntegers().test(IBooleanMapper.TRUE_INT_1)
        );
        assertFalse(
                IBooleanMapper.predicateFalseIntegers().test(Integer.MIN_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateFalseIntegers().test(Integer.MAX_VALUE)
        );
    }

    @Test
    void predicateFalseString0() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_0;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseString0().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseString0().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringBack() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_BACK;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringBack().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringBack().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringBreak() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_BREAK;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringBreak().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringBreak().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringCancel() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_CANCEL;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringCancel().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringCancel().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringError() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_ERROR;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringError().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringError().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringErr() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_ERR;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringErr().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringErr().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringFail() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_FAIL;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringFail().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringFail().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringFailure() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_FAILURE;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringFailure().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringFailure().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringFalsch() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_FALSCH;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringFalsch().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringFalsch().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringFalse() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_FALSE;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringFalse().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringFalse().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringFehler() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_FEHLER;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringFehler().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringFehler().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringN() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_N;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringN().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringN().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringNein() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_NEIN;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringNein().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringNein().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringNo() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_NO;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringNo().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringNo().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringOff() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_OFF;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringOff().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringOff().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringWrong() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_WRONG;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringWrong().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringWrong().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStringX() {
        final String LEGAL_VALUE    = IBooleanMapper.FALSE_STRING_X;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStringX().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStringX().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateFalseStrings() {
        // success checks
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_0)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_BACK)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_BREAK)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_CANCEL)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_ERR)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_ERROR)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_FAIL)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_FAILURE)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_FALSCH)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_FALSE)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_FEHLER)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_N)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_NEIN)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_NO)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_OFF)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_WRONG)
        );
        assertTrue(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.FALSE_STRING_X)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.TRUE_STRING_1)
        );
        assertFalse(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.TRUE_STRING_ERFOLG)
        );
        assertFalse(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.TRUE_STRING_FORWARD)
        );
        assertFalse(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.TRUE_STRING_J)
        );
        assertFalse(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.TRUE_STRING_JA)
        );
        assertFalse(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.TRUE_STRING_NEXT)
        );
        assertFalse(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.TRUE_STRING_OK)
        );
        assertFalse(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.TRUE_STRING_OKAY)
        );
        assertFalse(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.TRUE_STRING_ON)
        );
        assertFalse(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.TRUE_STRING_SUCCESS)
        );
        assertFalse(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.TRUE_STRING_SUCCESSFUL)
        );
        assertFalse(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.TRUE_STRING_TRUE)
        );
        assertFalse(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.TRUE_STRING_WAHR)
        );
        assertFalse(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.TRUE_STRING_Y)
        );
        assertFalse(
                IBooleanMapper.predicateFalseStrings().test(IBooleanMapper.TRUE_STRING_YES)
        );
    }

    @Test
    void predicateTrueChar1() {
        final char LEGAL_VALUE      = IBooleanMapper.TRUE_CHAR_1;
        final char ILLEGAL_VALUE    = '?';

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueChar1().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueChar1().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueCharJ() {
        final char LEGAL_VALUE              = IBooleanMapper.TRUE_CHAR_J;
        final char ILLEGAL_VALUE            = '?';
        final char ILLEGAL_LOWERCASE_VALUE  = IBooleanMapper.TRUE_CHAR_J_LOWERCASE;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueCharJ().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueCharJ().test(ILLEGAL_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateTrueCharJ().test(ILLEGAL_LOWERCASE_VALUE)
        );
    }

    @Test
    void predicateTrueCharJLowercase() {
        final char LEGAL_VALUE              = IBooleanMapper.TRUE_CHAR_J_LOWERCASE;
        final char ILLEGAL_VALUE            = '?';
        final char ILLEGAL_UPPERCASE_VALUE  = IBooleanMapper.TRUE_CHAR_J;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueCharJLowercase().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueCharJLowercase().test(ILLEGAL_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateTrueCharJLowercase().test(ILLEGAL_UPPERCASE_VALUE)
        );
    }

    @Test
    void predicateTrueCharY() {
        final char LEGAL_VALUE              = IBooleanMapper.TRUE_CHAR_Y;
        final char ILLEGAL_VALUE            = '?';
        final char ILLEGAL_LOWERCASE_VALUE  = IBooleanMapper.TRUE_CHAR_Y_LOWERCASE;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueCharY().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueCharY().test(ILLEGAL_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateTrueCharY().test(ILLEGAL_LOWERCASE_VALUE)
        );
    }

    @Test
    void predicateTrueCharYLowercase() {
        final char LEGAL_VALUE              = IBooleanMapper.TRUE_CHAR_Y_LOWERCASE;
        final char ILLEGAL_VALUE            = '?';
        final char ILLEGAL_UPPERCASE_VALUE  = IBooleanMapper.TRUE_CHAR_Y;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueCharYLowercase().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueCharYLowercase().test(ILLEGAL_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateTrueCharYLowercase().test(ILLEGAL_UPPERCASE_VALUE)
        );
    }

    @Test
    void predicateTrueCharacters() {
        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueCharacters().test(IBooleanMapper.TRUE_CHAR_1)
        );
        assertTrue(
                IBooleanMapper.predicateTrueCharacters().test(IBooleanMapper.TRUE_CHAR_J)
        );
        assertTrue(
                IBooleanMapper.predicateTrueCharacters().test(IBooleanMapper.TRUE_CHAR_J_LOWERCASE)
        );
        assertTrue(
                IBooleanMapper.predicateTrueCharacters().test(IBooleanMapper.TRUE_CHAR_Y)
        );
        assertTrue(
                IBooleanMapper.predicateTrueCharacters().test(IBooleanMapper.TRUE_CHAR_Y_LOWERCASE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueCharacters().test(IBooleanMapper.FALSE_CHAR_0)
        );
        assertFalse(
                IBooleanMapper.predicateTrueCharacters().test(IBooleanMapper.FALSE_CHAR_F)
        );
        assertFalse(
                IBooleanMapper.predicateTrueCharacters().test(IBooleanMapper.FALSE_CHAR_F_LOWERCASE)
        );
        assertFalse(
                IBooleanMapper.predicateTrueCharacters().test(IBooleanMapper.FALSE_CHAR_N)
        );
        assertFalse(
                IBooleanMapper.predicateTrueCharacters().test(IBooleanMapper.FALSE_CHAR_N_LOWERCASE)
        );
        assertFalse(
                IBooleanMapper.predicateTrueCharacters().test(IBooleanMapper.FALSE_CHAR_X)
        );
        assertFalse(
                IBooleanMapper.predicateTrueCharacters().test(IBooleanMapper.FALSE_CHAR_X_LOWERCASE)
        );
    }

    @Test
    void predicateTrueInt1() {
        final int LEGAL_VALUE   = IBooleanMapper.TRUE_INT_1;
        final int ILLEGAL_VALUE = IBooleanMapper.FALSE_INT_0;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueInt1().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueInt1().test(ILLEGAL_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateTrueInt1().test(Integer.MIN_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateTrueInt1().test(Integer.MAX_VALUE)
        );
    }

    @Test
    void predicateTrueIntegers() {
        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueIntegers().test(IBooleanMapper.TRUE_INT_1)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueIntegers().test(IBooleanMapper.FALSE_INT_0)
        );
        assertFalse(
                IBooleanMapper.predicateTrueIntegers().test(Integer.MIN_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateTrueIntegers().test(Integer.MAX_VALUE)
        );
    }

    @Test
    void predicateTrueString1() {
        final String LEGAL_VALUE    = IBooleanMapper.TRUE_STRING_1;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueString1().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueString1().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueStringErfolg() {
        final String LEGAL_VALUE    = IBooleanMapper.TRUE_STRING_ERFOLG;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueStringErfolg().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueStringErfolg().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueStringForward() {
        final String LEGAL_VALUE    = IBooleanMapper.TRUE_STRING_FORWARD;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueStringForward().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueStringForward().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueStringJ() {
        final String LEGAL_VALUE    = IBooleanMapper.TRUE_STRING_J;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueStringJ().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueStringJ().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueStringJa() {
        final String LEGAL_VALUE    = IBooleanMapper.TRUE_STRING_JA;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueStringJa().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueStringJa().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueStringNext() {
        final String LEGAL_VALUE    = IBooleanMapper.TRUE_STRING_NEXT;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueStringNext().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueStringNext().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueStringOk() {
        final String LEGAL_VALUE    = IBooleanMapper.TRUE_STRING_OK;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueStringOk().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueStringOk().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueStringOkay() {
        final String LEGAL_VALUE    = IBooleanMapper.TRUE_STRING_OKAY;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueStringOkay().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueStringOkay().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueStringOn() {
        final String LEGAL_VALUE    = IBooleanMapper.TRUE_STRING_ON;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueStringOn().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueStringOn().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueStringSuccess() {
        final String LEGAL_VALUE    = IBooleanMapper.TRUE_STRING_SUCCESS;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueStringSuccess().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueStringSuccess().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueStringSuccessful() {
        final String LEGAL_VALUE    = IBooleanMapper.TRUE_STRING_SUCCESSFUL;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueStringSuccessful().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueStringSuccessful().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueStringTrue() {
        final String LEGAL_VALUE    = IBooleanMapper.TRUE_STRING_TRUE;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueStringTrue().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueStringTrue().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueStringWahr() {
        final String LEGAL_VALUE    = IBooleanMapper.TRUE_STRING_WAHR;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueStringWahr().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueStringWahr().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueStringY() {
        final String LEGAL_VALUE    = IBooleanMapper.TRUE_STRING_Y;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueStringY().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueStringY().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueStringYes() {
        final String LEGAL_VALUE    = IBooleanMapper.TRUE_STRING_YES;
        final String ILLEGAL_VALUE  = HELLO_WORLD;

        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueStringYes().test(LEGAL_VALUE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueStringYes().test(ILLEGAL_VALUE)
        );
    }

    @Test
    void predicateTrueStrings() {
        // success checks
        assertTrue(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.TRUE_STRING_1)
        );
        assertTrue(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.TRUE_STRING_ERFOLG)
        );
        assertTrue(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.TRUE_STRING_FORWARD)
        );
        assertTrue(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.TRUE_STRING_J)
        );
        assertTrue(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.TRUE_STRING_JA)
        );
        assertTrue(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.TRUE_STRING_NEXT)
        );
        assertTrue(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.TRUE_STRING_OK)
        );
        assertTrue(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.TRUE_STRING_OKAY)
        );
        assertTrue(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.TRUE_STRING_ON)
        );
        assertTrue(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.TRUE_STRING_SUCCESS)
        );
        assertTrue(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.TRUE_STRING_SUCCESSFUL)
        );
        assertTrue(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.TRUE_STRING_TRUE)
        );
        assertTrue(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.TRUE_STRING_WAHR)
        );
        assertTrue(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.TRUE_STRING_Y)
        );
        assertTrue(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.TRUE_STRING_YES)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_0)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_BACK)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_BREAK)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_CANCEL)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_ERR)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_ERROR)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_FAIL)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_FAILURE)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_FALSCH)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_FALSE)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_FEHLER)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_N)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_NEIN)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_NO)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_OFF)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_WRONG)
        );
        assertFalse(
                IBooleanMapper.predicateTrueStrings().test(IBooleanMapper.FALSE_STRING_X)
        );
    }

    @Test
    void predicateBooleanCharacters() {
        // success checks
        assertTrue(
                IBooleanMapper.predicateBooleanCharacters().test(IBooleanMapper.TRUE_CHAR_1)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanCharacters().test(IBooleanMapper.TRUE_CHAR_J)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanCharacters().test(IBooleanMapper.TRUE_CHAR_J_LOWERCASE)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanCharacters().test(IBooleanMapper.TRUE_CHAR_Y)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanCharacters().test(IBooleanMapper.TRUE_CHAR_Y_LOWERCASE)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanCharacters().test(IBooleanMapper.FALSE_CHAR_0)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanCharacters().test(IBooleanMapper.FALSE_CHAR_F)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanCharacters().test(IBooleanMapper.FALSE_CHAR_F_LOWERCASE)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanCharacters().test(IBooleanMapper.FALSE_CHAR_N)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanCharacters().test(IBooleanMapper.FALSE_CHAR_N_LOWERCASE)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanCharacters().test(IBooleanMapper.FALSE_CHAR_X)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanCharacters().test(IBooleanMapper.FALSE_CHAR_X_LOWERCASE)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateBooleanCharacters().test('?')
        );
    }

    @Test
    void predicateBooleanIntegers() {
        // success checks
        assertTrue(
                IBooleanMapper.predicateBooleanIntegers().test(IBooleanMapper.TRUE_INT_1)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanIntegers().test(IBooleanMapper.FALSE_INT_0)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateBooleanIntegers().test(2)
        );
        assertFalse(
                IBooleanMapper.predicateBooleanIntegers().test(Integer.MIN_VALUE)
        );
        assertFalse(
                IBooleanMapper.predicateBooleanIntegers().test(Integer.MAX_VALUE)
        );
    }

    @Test
    void predicateBooleanStrings() {
        // success checks
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.TRUE_STRING_1)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.TRUE_STRING_ERFOLG)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.TRUE_STRING_FORWARD)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.TRUE_STRING_J)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.TRUE_STRING_JA)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.TRUE_STRING_NEXT)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.TRUE_STRING_OK)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.TRUE_STRING_OKAY)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.TRUE_STRING_ON)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.TRUE_STRING_SUCCESS)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.TRUE_STRING_SUCCESSFUL)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.TRUE_STRING_TRUE)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.TRUE_STRING_WAHR)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.TRUE_STRING_Y)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.TRUE_STRING_YES)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_0)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_BACK)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_BREAK)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_CANCEL)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_ERR)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_ERROR)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_FAIL)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_FAILURE)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_FALSCH)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_FALSE)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_FEHLER)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_N)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_NEIN)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_NO)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_OFF)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_WRONG)
        );
        assertTrue(
                IBooleanMapper.predicateBooleanStrings().test(IBooleanMapper.FALSE_STRING_X)
        );

        // fail checks
        assertFalse(
                IBooleanMapper.predicateBooleanStrings().test(HELLO_WORLD)
        );
    }

    @Test
    void isMappable() {
        // success checks
        // boolean
        assertTrue(
                mapper.isMappable(Boolean.TRUE)
        );
        // char
        assertTrue(
                mapper.isMappable(IBooleanMapper.TRUE_CHAR_Y)
        );
        // int
        assertTrue(
                mapper.isMappable(IBooleanMapper.TRUE_INT_1)
        );
        // String
        assertTrue(
                mapper.isMappable(IBooleanMapper.TRUE_STRING_TRUE)
        );

        // fail checks
        assertFalse(
                mapper.isMappable(null)
        );
        assertFalse(
                mapper.isMappable('?')
        );
        assertFalse(
                mapper.isMappable(2)
        );
        assertFalse(
                mapper.isMappable(HELLO_WORLD)
        );
    }

    @Test
    void mapCharacter() {
        // success checks
        assertTrue(
                mapper.map(IBooleanMapper.TRUE_CHAR_1)
        );

        // fail checks
        assertNull(
                mapper.map((Character) null)
        );
        assertNull(
                mapper.map('?')
        );
    }

    @Test
    void mapCharacterWithDefault() {
        // success checks
        assertTrue(
                mapper.map(IBooleanMapper.TRUE_CHAR_1, Boolean.FALSE)
        );
        assertTrue(
                mapper.map((Character) null, Boolean.TRUE)
        );
        assertTrue(
                mapper.map('?', Boolean.TRUE)
        );

        // fail checks
        assertFalse(
                mapper.map((Character) null, Boolean.FALSE)
        );
        assertFalse(
                mapper.map('?', Boolean.FALSE)
        );
    }

    @Test
    void mapInteger() {
        // success checks
        assertTrue(
                mapper.map(IBooleanMapper.TRUE_INT_1)
        );

        // fail checks
        assertNull(
                mapper.map((Integer) null)
        );
        assertNull(
                mapper.map(2)
        );
        assertNull(
                mapper.map(Integer.MAX_VALUE)
        );
        assertNull(
                mapper.map(Integer.MIN_VALUE)
        );
    }

    @Test
    void mapIntegerWithDefault() {
        // success checks
        assertTrue(
                mapper.map(IBooleanMapper.TRUE_INT_1, Boolean.FALSE)
        );
        assertTrue(
                mapper.map((Integer) null, Boolean.TRUE)
        );
        assertTrue(
                mapper.map(2, Boolean.TRUE)
        );

        // fail checks
        assertFalse(
                mapper.map((Integer) null, Boolean.FALSE)
        );
        assertFalse(
                mapper.map(2, Boolean.FALSE)
        );
        assertFalse(
                mapper.map(Integer.MAX_VALUE, Boolean.FALSE)
        );
        assertFalse(
                mapper.map(Integer.MIN_VALUE, Boolean.FALSE)
        );
    }

    @Test
    void mapString() {
        // success checks
        assertTrue(
                mapper.map(IBooleanMapper.TRUE_STRING_TRUE)
        );

        // fail checks
        assertNull(
                mapper.map((String) null)
        );
        assertNull(
                mapper.map(HELLO_WORLD)
        );
    }

    @Test
    void mapStringWithDefault() {
        // success checks
        assertTrue(
                mapper.map(IBooleanMapper.TRUE_STRING_TRUE, Boolean.FALSE)
        );
        assertTrue(
                mapper.map((String) null, Boolean.TRUE)
        );
        assertTrue(
                mapper.map(HELLO_WORLD, Boolean.TRUE)
        );

        // fail checks
        assertFalse(
                mapper.map((String) null, Boolean.FALSE)
        );
        assertFalse(
                mapper.map(HELLO_WORLD, Boolean.FALSE)
        );
    }

    @Test
    void evalPredicate() {
        // success checks
        assertTrue(
                mapper.evalPredicate((str) -> str.length() > 0, HELLO_WORLD)
        );

        // fail checks
        assertFalse(
                mapper.evalPredicate((ch) -> ch == '?', IBooleanMapper.FALSE_CHAR_N)
        );
    }

    @Test
    void isFalseCharacter() {
        // success checks
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_CHAR_0)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_CHAR_F)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_CHAR_F_LOWERCASE)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_CHAR_N)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_CHAR_N_LOWERCASE)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_CHAR_X)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_CHAR_X_LOWERCASE)
        );

        // fail checks
        assertFalse(
                mapper.isFalse((Character) null)
        );
        assertFalse(
                mapper.isFalse('?')
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_CHAR_1)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_CHAR_J)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_CHAR_J_LOWERCASE)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_CHAR_Y)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_CHAR_Y_LOWERCASE)
        );
    }

    @Test
    void isFalseInteger() {
        // success checks
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_INT_0)
        );

        // fail checks
        assertFalse(
                mapper.isFalse((Integer) null)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_INT_1)
        );
        assertFalse(
                mapper.isFalse(2)
        );
        assertFalse(
                mapper.isFalse(Integer.MAX_VALUE)
        );
        assertFalse(
                mapper.isFalse(Integer.MIN_VALUE)
        );
    }

    @Test
    void isFalseObject() {
        // success checks
        assertTrue(
                mapper.isFalse(Boolean.FALSE)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_CHAR_N)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_INT_0)
        );
        assertTrue(
                mapper.isFalse(
                        new StringBuilder(IBooleanMapper.FALSE_STRING_FALSE)
                )
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_FALSE)
        );

        // fail checks
        assertFalse(
                mapper.isFalse((Object) null)
        );
        assertFalse(
                mapper.isFalse(new ArrayList<>())
        );
    }

    @Test
    void isFalseString() {
        // success checks
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_0)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_BACK)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_BREAK)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_CANCEL)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_ERR)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_ERROR)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_FAIL)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_FAILURE)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_FALSCH)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_FALSE)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_FEHLER)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_N)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_NEIN)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_NO)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_OFF)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_WRONG)
        );
        assertTrue(
                mapper.isFalse(IBooleanMapper.FALSE_STRING_X)
        );

        // fail checks
        assertFalse(
                mapper.isFalse((String) null)
        );
        assertFalse(
                mapper.isFalse(HELLO_WORLD)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_STRING_1)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_STRING_ERFOLG)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_STRING_FORWARD)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_STRING_J)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_STRING_JA)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_STRING_NEXT)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_STRING_OK)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_STRING_OKAY)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_STRING_ON)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_STRING_SUCCESS)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_STRING_SUCCESSFUL)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_STRING_TRUE)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_STRING_WAHR)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_STRING_Y)
        );
        assertFalse(
                mapper.isFalse(IBooleanMapper.TRUE_STRING_YES)
        );
    }

    @Test
    void isTrueCharacter() {
        // success checks
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_CHAR_1)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_CHAR_J)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_CHAR_J_LOWERCASE)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_CHAR_Y)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_CHAR_Y_LOWERCASE)
        );

        // fail checks
        assertFalse(
                mapper.isTrue((Character) null)
        );
        assertFalse(
                mapper.isTrue('?')
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_CHAR_0)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_CHAR_F)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_CHAR_F_LOWERCASE)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_CHAR_N)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_CHAR_N_LOWERCASE)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_CHAR_X)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_CHAR_X_LOWERCASE)
        );
    }

    @Test
    void isTrueInteger() {
        // success checks
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_INT_1)
        );

        // fail checks
        assertFalse(
                mapper.isTrue((Integer) null)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_INT_0)
        );
        assertFalse(
                mapper.isTrue(2)
        );
        assertFalse(
                mapper.isTrue(Integer.MAX_VALUE)
        );
        assertFalse(
                mapper.isTrue(Integer.MIN_VALUE)
        );
    }

    @Test
    void isTrueObject() {
        // success checks
        assertTrue(
                mapper.isTrue(Boolean.TRUE)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_CHAR_Y)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_INT_1)
        );
        assertTrue(
                mapper.isTrue(
                        new StringBuilder(IBooleanMapper.TRUE_STRING_TRUE)
                )
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_TRUE)
        );

        // fail checks
        assertFalse(
                mapper.isTrue((Object) null)
        );
        assertFalse(
                mapper.isTrue(new ArrayList<>())
        );
    }

    @Test
    void isTrueString() {
        // success checks
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_1)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_ERFOLG)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_FORWARD)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_J)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_JA)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_NEXT)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_OK)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_OKAY)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_ON)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_SUCCESS)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_SUCCESSFUL)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_TRUE)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_WAHR)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_Y)
        );
        assertTrue(
                mapper.isTrue(IBooleanMapper.TRUE_STRING_YES)
        );

        // fail checks
        assertFalse(
                mapper.isTrue((String) null)
        );
        assertFalse(
                mapper.isTrue(HELLO_WORLD)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_0)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_BACK)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_BREAK)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_CANCEL)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_ERR)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_ERROR)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_FAIL)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_FAILURE)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_FALSCH)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_FALSE)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_FEHLER)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_N)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_NEIN)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_NO)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_OFF)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_WRONG)
        );
        assertFalse(
                mapper.isTrue(IBooleanMapper.FALSE_STRING_X)
        );
    }
}