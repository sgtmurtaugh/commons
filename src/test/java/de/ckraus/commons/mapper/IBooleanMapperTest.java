package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IBooleanMapperTest {

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
        assertFalse( mapper.isMappable('0') );
        assertFalse( mapper.isMappable('1') );
        assertFalse( mapper.isMappable('N') );
        assertFalse( mapper.isMappable('n') );
        assertFalse( mapper.isMappable('Y') );
        assertFalse( mapper.isMappable('y') );
        assertFalse( mapper.isMappable('2') );

        assertFalse( mapper.isMappable(0) );
        assertFalse( mapper.isMappable(1) );
        assertFalse( mapper.isMappable(2) );

        assertFalse( mapper.isMappable("0") );
        assertFalse( mapper.isMappable("1") );
        assertFalse( mapper.isMappable("n") );
        assertFalse( mapper.isMappable("y") );
        assertFalse( mapper.isMappable("no") );
        assertFalse( mapper.isMappable("yes") );
        assertFalse( mapper.isMappable("false") );
        assertFalse( mapper.isMappable("true") );
    }

    /**
     * test for {@link IBooleanMapper#map(Character)}
     */
    @Test
    void mapCharacter() {
        assertNull( mapper.map((Character) null) );
        assertNull( mapper.map('0') );
        assertNull( mapper.map('1') );
        assertNull( mapper.map('N') );
        assertNull( mapper.map('n') );
        assertNull( mapper.map('Y') );
        assertNull( mapper.map('y') );
        assertNull( mapper.map('2') );
    }

    /**
     * test for {@link IBooleanMapper#map(Character, Boolean)}
     */
    @Test
    void mapCharacterWithDefault() {
        assertFalse( mapper.map((Character) null, DEFAULT) );
        assertFalse( mapper.map('0', DEFAULT) );
        assertFalse( mapper.map('1', DEFAULT) );
        assertFalse( mapper.map('N', DEFAULT) );
        assertFalse( mapper.map('n', DEFAULT) );
        assertFalse( mapper.map('Y', DEFAULT) );
        assertFalse( mapper.map('y', DEFAULT) );
        assertFalse( mapper.map('2', DEFAULT) );
    }

    /**
     * test for {@link IBooleanMapper#map(Integer)}
     */
    @Test
    void mapInteger() {
        assertNull( mapper.map((Integer) null) );
        assertNull( mapper.map(0) );
        assertNull( mapper.map(1) );
        assertNull( mapper.map(2) );
    }

    /**
     * test for {@link IBooleanMapper#map(Integer, Boolean)}
     */
    @Test
    void mapIntegerWithDefault() {
        assertFalse( mapper.map((Integer) null, DEFAULT) );
        assertFalse( mapper.map(0, DEFAULT) );
        assertFalse( mapper.map(1, DEFAULT) );
        assertFalse( mapper.map(2, DEFAULT) );
    }

    /**
     * test for {@link IBooleanMapper#map(String)}
     */
    @Test
    void mapString() {
        assertNull( mapper.map((String) null) );
        assertNull( mapper.map("0") );
        assertNull( mapper.map("1") );
        assertNull( mapper.map("n") );
        assertNull( mapper.map("y") );
        assertNull( mapper.map("no") );
        assertNull( mapper.map("yes") );
        assertNull( mapper.map("false") );
        assertNull( mapper.map("true") );
    }

    /**
     * test for {@link IBooleanMapper#map(String, Object)}
     */
    @Test
    void mapStringWithDefault() {
        assertFalse( mapper.map((String) null, DEFAULT) );
        assertFalse( mapper.map("0", DEFAULT) );
        assertFalse( mapper.map("1", DEFAULT) );
        assertFalse( mapper.map("n", DEFAULT) );
        assertFalse( mapper.map("y", DEFAULT) );
        assertFalse( mapper.map("no", DEFAULT) );
        assertFalse( mapper.map("yes", DEFAULT) );
        assertFalse( mapper.map("false", DEFAULT) );
        assertFalse( mapper.map("true", DEFAULT) );
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
        assertFalse( mapper.isFalse('0') );
        assertFalse( mapper.isFalse('1') );
        assertFalse( mapper.isFalse('N') );
        assertFalse( mapper.isFalse('n') );
        assertFalse( mapper.isFalse('Y') );
        assertFalse( mapper.isFalse('y') );
        assertFalse( mapper.isFalse('2') );

        assertFalse( mapper.isFalse(0) );
        assertFalse( mapper.isFalse(1) );
        assertFalse( mapper.isFalse(2) );

        assertFalse( mapper.isFalse("0") );
        assertFalse( mapper.isFalse("1") );
        assertFalse( mapper.isFalse("n") );
        assertFalse( mapper.isFalse("y") );
        assertFalse( mapper.isFalse("no") );
        assertFalse( mapper.isFalse("yes") );
        assertFalse( mapper.isFalse("false") );
        assertFalse( mapper.isFalse("true") );
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
        assertFalse( mapper.isTrue('0') );
        assertFalse( mapper.isTrue('1') );
        assertFalse( mapper.isTrue('N') );
        assertFalse( mapper.isTrue('n') );
        assertFalse( mapper.isTrue('Y') );
        assertFalse( mapper.isTrue('y') );
        assertFalse( mapper.isTrue('2') );

        assertFalse( mapper.isTrue(0) );
        assertFalse( mapper.isTrue(1) );
        assertFalse( mapper.isTrue(2) );

        assertFalse( mapper.isTrue("0") );
        assertFalse( mapper.isTrue("1") );
        assertFalse( mapper.isTrue("n") );
        assertFalse( mapper.isTrue("y") );
        assertFalse( mapper.isTrue("no") );
        assertFalse( mapper.isTrue("yes") );
        assertFalse( mapper.isTrue("false") );
        assertFalse( mapper.isTrue("true") );
    }

    /**
     * test for {@link IBooleanMapper#isTrue(String)}
     */
    @Test
    void isTrueString() {
        // Dummy implementation -> not neccessary
    }
}