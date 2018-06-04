package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IBooleanMapperTest {

    private final static char FALSE_CHAR__0             = '0';
    private final static char FALSE_CHAR__N             = 'N';
    private final static char FALSE_CHAR__N_LOWERCASE   = 'n';

    private final static int FALSE_INT__0   = 0;

    private final static String FALSE_STRING__0     = "0";
    private final static String FALSE_STRING__FALSE = "false";
    private final static String FALSE_STRING__N     = "n";
    private final static String FALSE_STRING__NO    = "no";

    private final static char TRUE_CHAR__1              = '1';
    private final static char TRUE_CHAR__Y              = 'Y';
    private final static char TRUE_CHAR__Y_LOWERCASE    = 'y';

    private final static int TRUE_INT__1    = 1;

    private final static String TRUE_STRING__1      = "1";
    private final static String TRUE_STRING__TRUE   = "true";
    private final static String TRUE_STRING__Y      = "y";
    private final static String TRUE_STRING__YES    = "yes";

    private final static char INVALID_CHAR__2   = '2';

    private final static int INVALID_INT__2 = 2;

    private final static String INVALID_STRING__2 = "2";

    private final boolean DEFAULT               = Boolean.FALSE;
    private final boolean DUMMY_IMPLEMENTATION  = Boolean.FALSE;

    // create mapper instance
    IBooleanMapper mapper = new IBooleanMapper() {
        // Dummy implementations

        @Override
        public boolean isFalse(Character c) {
            return DUMMY_IMPLEMENTATION;
        }
        @Override
        public boolean isFalse(Integer i) {
            return DUMMY_IMPLEMENTATION;
        }
        @Override
        public boolean isFalse(String s) {
            return DUMMY_IMPLEMENTATION;
        }

        @Override
        public boolean isTrue(Character c) {
            return DUMMY_IMPLEMENTATION;
        }
        @Override
        public boolean isTrue(Integer i) {
            return DUMMY_IMPLEMENTATION;
        }
        @Override
        public boolean isTrue(String s) {
            return DUMMY_IMPLEMENTATION;
        }
    };

    /**
     * test for {@link IBooleanMapper#isMappable(Object)}
     */
    @Test
    void isMappable() {
        assertTrue( mapper.isMappable(Boolean.TRUE) );
        assertTrue( mapper.isMappable(Boolean.FALSE) );

        assertFalse( mapper.isMappable(null) );
        assertFalse( mapper.isMappable(FALSE_CHAR__0) );
        assertFalse( mapper.isMappable(TRUE_CHAR__1) );
        assertFalse( mapper.isMappable(FALSE_CHAR__N) );
        assertFalse( mapper.isMappable(FALSE_CHAR__N_LOWERCASE) );
        assertFalse( mapper.isMappable(TRUE_CHAR__Y) );
        assertFalse( mapper.isMappable(TRUE_CHAR__Y_LOWERCASE) );
        assertFalse( mapper.isMappable(INVALID_CHAR__2) );

        assertFalse( mapper.isMappable(FALSE_INT__0) );
        assertFalse( mapper.isMappable(TRUE_INT__1) );
        assertFalse( mapper.isMappable(INVALID_INT__2) );

        assertFalse( mapper.isMappable(FALSE_STRING__0) );
        assertFalse( mapper.isMappable(TRUE_STRING__1) );
        assertFalse( mapper.isMappable(FALSE_STRING__N) );
        assertFalse( mapper.isMappable(TRUE_STRING__Y) );
        assertFalse( mapper.isMappable(FALSE_STRING__NO) );
        assertFalse( mapper.isMappable(TRUE_STRING__YES) );
        assertFalse( mapper.isMappable(FALSE_STRING__FALSE) );
        assertFalse( mapper.isMappable(TRUE_STRING__TRUE) );
        assertFalse( mapper.isMappable(INVALID_STRING__2) );
    }

    /**
     * test for {@link IBooleanMapper#map(Character)}
     */
    @Test
    void mapCharacter() {
        assertNull( mapper.map((Character) null) );
        assertNull( mapper.map(FALSE_CHAR__0) );
        assertNull( mapper.map(TRUE_CHAR__1) );
        assertNull( mapper.map(FALSE_CHAR__N) );
        assertNull( mapper.map(FALSE_CHAR__N_LOWERCASE) );
        assertNull( mapper.map(TRUE_CHAR__Y) );
        assertNull( mapper.map(TRUE_CHAR__Y_LOWERCASE) );
        assertNull( mapper.map(INVALID_CHAR__2) );
    }

    /**
     * test for {@link IBooleanMapper#map(Character, Boolean)}
     */
    @Test
    void mapCharacterWithDefault() {
        assertFalse( mapper.map((Character) null, DEFAULT) );
        assertFalse( mapper.map(FALSE_CHAR__0, DEFAULT) );
        assertFalse( mapper.map(TRUE_CHAR__1, DEFAULT) );
        assertFalse( mapper.map(FALSE_CHAR__N, DEFAULT) );
        assertFalse( mapper.map(FALSE_CHAR__N_LOWERCASE, DEFAULT) );
        assertFalse( mapper.map(TRUE_CHAR__Y, DEFAULT) );
        assertFalse( mapper.map(TRUE_CHAR__Y_LOWERCASE, DEFAULT) );
        assertFalse( mapper.map(INVALID_CHAR__2, DEFAULT) );
    }

    /**
     * test for {@link IBooleanMapper#map(Integer)}
     */
    @Test
    void mapInteger() {
        assertNull( mapper.map((Integer) null) );
        assertNull( mapper.map(FALSE_INT__0) );
        assertNull( mapper.map(TRUE_INT__1) );
        assertNull( mapper.map(INVALID_INT__2) );
    }

    /**
     * test for {@link IBooleanMapper#map(Integer, Boolean)}
     */
    @Test
    void mapIntegerWithDefault() {
        assertFalse( mapper.map((Integer) null, DEFAULT) );
        assertFalse( mapper.map(FALSE_INT__0, DEFAULT) );
        assertFalse( mapper.map(TRUE_INT__1, DEFAULT) );
        assertFalse( mapper.map(INVALID_INT__2, DEFAULT) );
    }

    /**
     * test for {@link IBooleanMapper#map(String)}
     */
    @Test
    void mapString() {
        assertNull( mapper.map((String) null) );
        assertNull( mapper.map(FALSE_STRING__0) );
        assertNull( mapper.map(TRUE_STRING__1) );
        assertNull( mapper.map(FALSE_STRING__N) );
        assertNull( mapper.map(TRUE_STRING__Y) );
        assertNull( mapper.map(FALSE_STRING__NO) );
        assertNull( mapper.map(TRUE_STRING__YES) );
        assertNull( mapper.map(FALSE_STRING__FALSE) );
        assertNull( mapper.map(TRUE_STRING__TRUE) );
        assertNull( mapper.map(INVALID_STRING__2) );
    }

    /**
     * test for {@link IBooleanMapper#map(String, Object)}
     */
    @Test
    void mapStringWithDefault() {
        assertFalse( mapper.map((String) null, DEFAULT) );
        assertFalse( mapper.map(FALSE_STRING__0, DEFAULT) );
        assertFalse( mapper.map(TRUE_STRING__1, DEFAULT) );
        assertFalse( mapper.map(FALSE_STRING__N, DEFAULT) );
        assertFalse( mapper.map(TRUE_STRING__Y, DEFAULT) );
        assertFalse( mapper.map(FALSE_STRING__NO, DEFAULT) );
        assertFalse( mapper.map(TRUE_STRING__YES, DEFAULT) );
        assertFalse( mapper.map(FALSE_STRING__FALSE, DEFAULT) );
        assertFalse( mapper.map(TRUE_STRING__TRUE, DEFAULT) );
        assertFalse( mapper.map(INVALID_STRING__2, DEFAULT) );
    }

    /**
     * test for {@link IBooleanMapper#isFalse(Character)}
     */
    @Test
    void isFalseCharacter() {
        // Dummy implementation -> not neccessary
    }

    /**
     * test for {@link IBooleanMapper#isFalse(Integer)}
     */
    @Test
    void isFalseInteger() {
        // Dummy implementation -> not neccessary
    }

    /**
     * test for {@link IBooleanMapper#isFalse(Object)}
     */
    @Test
    void isFalseObject() {
        assertFalse( mapper.isFalse(Boolean.TRUE) );
        assertTrue( mapper.isFalse(Boolean.FALSE) );

        assertFalse( mapper.isFalse((Object) null) );
        assertFalse( mapper.isFalse(FALSE_CHAR__0) );
        assertFalse( mapper.isFalse(TRUE_CHAR__1) );
        assertFalse( mapper.isFalse(FALSE_CHAR__N) );
        assertFalse( mapper.isFalse(FALSE_CHAR__N_LOWERCASE) );
        assertFalse( mapper.isFalse(TRUE_CHAR__Y) );
        assertFalse( mapper.isFalse(TRUE_CHAR__Y_LOWERCASE) );
        assertFalse( mapper.isFalse(INVALID_CHAR__2) );

        assertFalse( mapper.isFalse(FALSE_INT__0) );
        assertFalse( mapper.isFalse(TRUE_INT__1) );
        assertFalse( mapper.isFalse(INVALID_INT__2) );

        assertFalse( mapper.isFalse(FALSE_STRING__0) );
        assertFalse( mapper.isFalse(TRUE_STRING__1) );
        assertFalse( mapper.isFalse(FALSE_STRING__N) );
        assertFalse( mapper.isFalse(TRUE_STRING__Y) );
        assertFalse( mapper.isFalse(FALSE_STRING__NO) );
        assertFalse( mapper.isFalse(TRUE_STRING__YES) );
        assertFalse( mapper.isFalse(FALSE_STRING__FALSE) );
        assertFalse( mapper.isFalse(TRUE_STRING__TRUE) );
        assertFalse( mapper.isFalse(INVALID_STRING__2) );
    }

    /**
     * test for {@link IBooleanMapper#isFalse(String)}
     */
    @Test
    void isFalseString() {
        // Dummy implementation -> not neccessary
    }

    /**
     * test for {@link IBooleanMapper#isTrue(Character)}
     */
    @Test
    void isTrueCharacter() {
        // Dummy implementation -> not neccessary
    }

    /**
     * test for {@link IBooleanMapper#isTrue(Integer)}
     */
    @Test
    void isTrueInteger() {
        // Dummy implementation -> not neccessary
    }

    /**
     * test for {@link IBooleanMapper#isTrue(Object)}
     */
    @Test
    void isTrueObject() {
        assertTrue( mapper.isTrue(Boolean.TRUE) );
        assertFalse( mapper.isTrue(Boolean.FALSE) );

        assertFalse( mapper.isTrue((Object) null) );
        assertFalse( mapper.isTrue(FALSE_CHAR__0) );
        assertFalse( mapper.isTrue(TRUE_CHAR__1) );
        assertFalse( mapper.isTrue(FALSE_CHAR__N) );
        assertFalse( mapper.isTrue(FALSE_CHAR__N_LOWERCASE) );
        assertFalse( mapper.isTrue(TRUE_CHAR__Y) );
        assertFalse( mapper.isTrue(TRUE_CHAR__Y_LOWERCASE) );
        assertFalse( mapper.isTrue(INVALID_CHAR__2) );

        assertFalse( mapper.isTrue(FALSE_INT__0) );
        assertFalse( mapper.isTrue(TRUE_INT__1) );
        assertFalse( mapper.isTrue(INVALID_INT__2) );

        assertFalse( mapper.isTrue(FALSE_STRING__0) );
        assertFalse( mapper.isTrue(TRUE_STRING__1) );
        assertFalse( mapper.isTrue(FALSE_STRING__N) );
        assertFalse( mapper.isTrue(TRUE_STRING__Y) );
        assertFalse( mapper.isTrue(FALSE_STRING__NO) );
        assertFalse( mapper.isTrue(TRUE_STRING__YES) );
        assertFalse( mapper.isTrue(FALSE_STRING__FALSE) );
        assertFalse( mapper.isTrue(TRUE_STRING__TRUE) );
        assertFalse( mapper.isTrue(INVALID_STRING__2) );
    }

    /**
     * test for {@link IBooleanMapper#isTrue(String)}
     */
    @Test
    void isTrueString() {
        // Dummy implementation -> not neccessary
    }
}