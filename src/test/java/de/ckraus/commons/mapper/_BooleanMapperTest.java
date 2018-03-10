package de.ckraus.commons.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _BooleanMapperTest {
    private BooleanMapper booleanMapper = new BooleanMapper();

    @Test
    public void testIsFalse() {
        // Character
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_CHAR_0)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_CHAR_F)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_CHAR_F_LOWERCASE)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_CHAR_N)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_CHAR_N_LOWERCASE)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_CHAR_X)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_CHAR_X_LOWERCASE)
        );
        assertFalse(
                booleanMapper.isFalse('a')
        );

        // Integer
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_INT_0)
        );
        assertFalse(
                booleanMapper.isFalse(2)
        );

        // Object
        assertFalse(
                booleanMapper.isFalse(new ArrayList<>())
        );
        assertTrue(
                booleanMapper.isFalse(new StringBuffer().append("false"))
        );

        // String
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_0)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_BACK)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_BREAK)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_CANCEL)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_ERR)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_ERROR)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_FAIL)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_FAILURE)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_FALSCH)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_FEHLER)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_N)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_NEIN)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_NO)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_OFF)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_WRONG)
        );
        assertTrue(
                booleanMapper.isFalse(BooleanMapper.FALSE_STRING_X)
        );
        assertFalse(
                booleanMapper.isFalse("BAM!!!")
        );
    }

    @Test
    public void testIsTrue() {
        // Character
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_CHAR_1)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_CHAR_J)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_CHAR_J_LOWERCASE)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_CHAR_Y)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_CHAR_Y_LOWERCASE)
        );
        assertFalse(
                booleanMapper.isTrue('a')
        );

        // Integer
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_INT_1)
        );
        assertFalse(
                booleanMapper.isTrue(2)
        );

        // Object
        assertFalse(
                booleanMapper.isTrue(new ArrayList<>())
        );
        assertTrue(
                booleanMapper.isTrue(new StringBuffer().append("true"))
        );

        // String
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_STRING_1)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_STRING_ERFOLG)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_STRING_FORWARD)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_STRING_J)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_STRING_JA)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_STRING_NEXT)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_STRING_OK)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_STRING_OKAY)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_STRING_ON)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_STRING_SUCCESS)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_STRING_SUCCESSFUL)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_STRING_WAHR)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_STRING_Y)
        );
        assertTrue(
                booleanMapper.isTrue(BooleanMapper.TRUE_STRING_YES)
        );
        assertFalse(
                booleanMapper.isTrue("BAM!!!")
        );
    }

    @Test
    public void testIsMappable() {
        assertTrue(
            booleanMapper.isMappable(Boolean.FALSE)
        );
        assertTrue(
            booleanMapper.isMappable(BooleanMapper.FALSE_CHAR_0)
        );
        assertTrue(
            booleanMapper.isMappable(BooleanMapper.FALSE_INT_0)
        );
        assertTrue(
            booleanMapper.isMappable(new StringBuffer("false"))
        );
        assertTrue(
            booleanMapper.isMappable(BooleanMapper.FALSE_STRING_0)
        );
        assertFalse(
            booleanMapper.isMappable(new ArrayList<>())
        );
    }

    @Test
    public void testMap() {
        final String keyFalseChar      = "falseChar";
        final String keyFalseInt       = "falseInt";
        final String keyFalseObject    = "falseObject";
        final String keyFalseString    = "falseString";

        final String keyTrueChar       = "trueChar";
        final String keyTrueInt        = "trueInt";
        final String keyTrueObject     = "trueObject";
        final String keyTrueString     = "trueString";

        final String keyWrongChar      = "wrongChar";
        final String keyWrongInt       = "wrongInt";
        final String keyWrongObject    = "wrongObject";
        final String keyWrongString    = "wrongString";

        Map<String, Object> mapTest = new HashMap<>();
        mapTest.put(keyFalseChar, BooleanMapper.FALSE_CHAR_0);
        mapTest.put(keyTrueChar, BooleanMapper.TRUE_CHAR_1);
        mapTest.put(keyWrongChar, ' ');

        mapTest.put(keyFalseInt, BooleanMapper.FALSE_INT_0);
        mapTest.put(keyTrueInt, BooleanMapper.TRUE_INT_1);
        mapTest.put(keyWrongInt, 2);

        mapTest.put(keyFalseObject, new StringBuffer(BooleanMapper.FALSE_STRING_0));
        mapTest.put(keyTrueObject, new StringBuffer(BooleanMapper.TRUE_STRING_1));
        mapTest.put(keyWrongObject, new ArrayList<>());

        mapTest.put(keyFalseString, BooleanMapper.FALSE_STRING_0);
        mapTest.put(keyTrueString, BooleanMapper.TRUE_STRING_1);
        mapTest.put(keyWrongString, "BAM!");


        // map, key
        assertTrue(
                booleanMapper.map(mapTest, keyTrueString)
        );
        assertFalse(
                booleanMapper.map(mapTest, keyFalseString)
        );
        assertNull(
                booleanMapper.map(mapTest, keyWrongString)
        );

        // map, key, default
        assertTrue(
            booleanMapper.map(mapTest, keyWrongString, true)
        );


        // char
        assertFalse(
                booleanMapper.map(BooleanMapper.FALSE_CHAR_0)
        );
        assertNull(
                booleanMapper.map(' ')
        );
        assertTrue(
                booleanMapper.map(BooleanMapper.TRUE_CHAR_1)
        );

        // char, default
        assertTrue(
                booleanMapper.map(' ', Boolean.TRUE)
        );

        // int
        assertTrue(
                booleanMapper.map(BooleanMapper.TRUE_CHAR_1)
        );
        assertFalse(
                booleanMapper.map(BooleanMapper.FALSE_INT_0)
        );
        assertNull(
                booleanMapper.map(2)
        );

        // int, default
        assertTrue(
                booleanMapper.map(2, Boolean.TRUE)
        );

        // obj
        assertFalse(
                booleanMapper.map(new StringBuffer("false"))
        );
        assertTrue(
                booleanMapper.map(new StringBuffer("true"))
        );
        assertNull(
                booleanMapper.map(new StringBuffer("BAM!"))
        );

        // obj, default
        assertTrue(
                booleanMapper.map(new StringBuffer("BAM!"), Boolean.TRUE)
        );

        // str
        String str = "  0  ";
        assertFalse(
                booleanMapper.map(str)
        );
        // str, default
        assertFalse(
                booleanMapper.map(str,  Boolean.TRUE)
        );
        // str, trim, emptyIsNull
        assertNull(
                booleanMapper.map(str, false, false)
        );
        // str, trim, emptyIsNull, default
        assertTrue(
                booleanMapper.map(str, false, false,  Boolean.TRUE)
        );
    }
}
