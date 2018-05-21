package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooleanMapperTest {

    private final boolean DEFAULT   = Boolean.FALSE;

    private IBooleanMapper mapper = new BooleanMapper();

    /**
     * test for {@link IBooleanMapper#isMappable(Object)}
     */
    @Test
    void isMappable() {
        assertTrue( mapper.isMappable(Boolean.TRUE) );
        assertTrue( mapper.isMappable(Boolean.FALSE) );

        assertFalse( mapper.isMappable(null) );
        assertTrue( mapper.isMappable('0') );
        assertTrue( mapper.isMappable('1') );
        assertTrue( mapper.isMappable('N') );
        assertTrue( mapper.isMappable('n') );
        assertTrue( mapper.isMappable('Y') );
        assertTrue( mapper.isMappable('y') );
        assertFalse( mapper.isMappable('2') );

        assertTrue( mapper.isMappable(0) );
        assertTrue( mapper.isMappable(1) );
        assertFalse( mapper.isMappable(2) );

        assertTrue( mapper.isMappable("0") );
        assertTrue( mapper.isMappable("1") );
        assertTrue( mapper.isMappable("n") );
        assertTrue( mapper.isMappable("y") );
        assertTrue( mapper.isMappable("no") );
        assertTrue( mapper.isMappable("yes") );
        assertTrue( mapper.isMappable("false") );
        assertTrue( mapper.isMappable("true") );
    }

    /**
     * test for {@link IBooleanMapper#map(Character)}
     */
    @Test
    void mapCharacter() {
        assertNull( mapper.map((Character) null) );
        assertFalse( mapper.map('0') );
        assertTrue( mapper.map('1') );
        assertFalse( mapper.map('N') );
        assertFalse( mapper.map('n') );
        assertTrue( mapper.map('Y') );
        assertTrue( mapper.map('y') );
        assertNull( mapper.map('2') );
    }

    /**
     * test for {@link IBooleanMapper#map(Character, Boolean)}
     */
    @Test
    void mapCharacterWithDefault() {
        assertFalse( mapper.map((Character) null, DEFAULT) );
        assertFalse( mapper.map('0', DEFAULT) );
        assertTrue( mapper.map('1', DEFAULT) );
        assertFalse( mapper.map('N', DEFAULT) );
        assertFalse( mapper.map('n', DEFAULT) );
        assertTrue( mapper.map('Y', DEFAULT) );
        assertTrue( mapper.map('y', DEFAULT) );
        assertFalse( mapper.map('2', DEFAULT) );
    }

    /**
     * test for {@link IBooleanMapper#map(Integer)}
     */
    @Test
    void mapInteger() {
        assertNull( mapper.map((Integer) null) );
        assertFalse( mapper.map(0) );
        assertTrue( mapper.map(1) );
        assertNull( mapper.map(2) );
    }

    /**
     * test for {@link IBooleanMapper#map(Integer, Boolean)}
     */
    @Test
    void mapIntegerWithDefault() {
        assertFalse( mapper.map((Integer) null, DEFAULT) );
        assertFalse( mapper.map(0, DEFAULT) );
        assertTrue( mapper.map(1, DEFAULT) );
        assertFalse( mapper.map(2, DEFAULT) );
    }

    /**
     * test for {@link IBooleanMapper#map(String)}
     */
    @Test
    void mapString() {
        assertNull( mapper.map((String) null) );
        assertFalse( mapper.map("0") );
        assertTrue( mapper.map("1") );
        assertFalse( mapper.map("n") );
        assertTrue( mapper.map("y") );
        assertFalse( mapper.map("no") );
        assertTrue( mapper.map("yes") );
        assertFalse( mapper.map("false") );
        assertTrue( mapper.map("true") );
    }

    /**
     * test for {@link IBooleanMapper#map(String, Object)}
     */
    @Test
    void mapStringWithDefault() {
        assertFalse( mapper.map((String) null, DEFAULT) );
        assertFalse( mapper.map("0", DEFAULT) );
        assertTrue( mapper.map("1", DEFAULT) );
        assertFalse( mapper.map("n", DEFAULT) );
        assertTrue( mapper.map("y", DEFAULT) );
        assertFalse( mapper.map("no", DEFAULT) );
        assertTrue( mapper.map("yes", DEFAULT) );
        assertFalse( mapper.map("false", DEFAULT) );
        assertTrue( mapper.map("true", DEFAULT) );
    }

    /**
     * test for {@link IBooleanMapper#isFalse(Character)}
     */
    @Test
    void isFalseCharacter() {
        assertFalse( mapper.isFalse((Character) null) );
        assertTrue( mapper.isFalse('0') );
        assertFalse( mapper.isFalse('1') );
        assertTrue( mapper.isFalse('N') );
        assertTrue( mapper.isFalse('n') );
        assertFalse( mapper.isFalse('Y') );
        assertFalse( mapper.isFalse('y') );
        assertFalse( mapper.isFalse('2') );
    }

    /**
     * test for {@link IBooleanMapper#isFalse(Integer)}
     */
    @Test
    void isFalseInteger() {
        assertFalse( mapper.isFalse((Integer) null) );
        assertTrue( mapper.isFalse(0) );
        assertFalse( mapper.isFalse(1) );
        assertFalse( mapper.isFalse(2) );
    }

    /**
     * test for {@link IBooleanMapper#isFalse(Object)}
     */
    @Test
    void isFalseObject() {
        assertFalse( mapper.isFalse(Boolean.TRUE) );
        assertTrue( mapper.isFalse(Boolean.FALSE) );

        assertFalse( mapper.isFalse((Object) null) );
        assertTrue( mapper.isFalse('0') );
        assertFalse( mapper.isFalse('1') );
        assertTrue( mapper.isFalse('N') );
        assertTrue( mapper.isFalse('n') );
        assertFalse( mapper.isFalse('Y') );
        assertFalse( mapper.isFalse('y') );
        assertFalse( mapper.isFalse('2') );

        assertTrue( mapper.isFalse(0) );
        assertFalse( mapper.isFalse(1) );
        assertFalse( mapper.isFalse(2) );

        assertTrue( mapper.isFalse("0") );
        assertFalse( mapper.isFalse("1") );
        assertTrue( mapper.isFalse("n") );
        assertFalse( mapper.isFalse("y") );
        assertTrue( mapper.isFalse("no") );
        assertFalse( mapper.isFalse("yes") );
        assertTrue( mapper.isFalse("false") );
        assertFalse( mapper.isFalse("true") );
    }

    /**
     * test for {@link IBooleanMapper#isFalse(String)}
     */
    @Test
    void isFalseString() {
        assertFalse( mapper.isFalse((String) null) );
        assertTrue( mapper.isFalse("0") );
        assertFalse( mapper.isFalse("1") );
        assertTrue( mapper.isFalse("n") );
        assertFalse( mapper.isFalse("y") );
        assertTrue( mapper.isFalse("no") );
        assertFalse( mapper.isFalse("yes") );
        assertTrue( mapper.isFalse("false") );
        assertFalse( mapper.isFalse("true") );
    }

    /**
     * test for {@link IBooleanMapper#isTrue(Character)}
     */
    @Test
    void isTrueCharacter() {
        assertFalse( mapper.isTrue((Character) null) );
        assertFalse( mapper.isTrue('0') );
        assertTrue( mapper.isTrue('1') );
        assertFalse( mapper.isTrue('N') );
        assertFalse( mapper.isTrue('n') );
        assertTrue( mapper.isTrue('Y') );
        assertTrue( mapper.isTrue('y') );
        assertFalse( mapper.isTrue('2') );
    }

    /**
     * test for {@link IBooleanMapper#isTrue(Integer)}
     */
    @Test
    void isTrueInteger() {
        assertFalse( mapper.isTrue((Integer) null) );
        assertFalse( mapper.isTrue(0) );
        assertTrue( mapper.isTrue(1) );
        assertFalse( mapper.isTrue(2) );
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
        assertTrue( mapper.isTrue('1') );
        assertFalse( mapper.isTrue('N') );
        assertFalse( mapper.isTrue('n') );
        assertTrue( mapper.isTrue('Y') );
        assertTrue( mapper.isTrue('y') );
        assertFalse( mapper.isTrue('2') );

        assertFalse( mapper.isTrue(0) );
        assertTrue( mapper.isTrue(1) );
        assertFalse( mapper.isTrue(2) );

        assertFalse( mapper.isTrue("0") );
        assertTrue( mapper.isTrue("1") );
        assertFalse( mapper.isTrue("n") );
        assertTrue( mapper.isTrue("y") );
        assertFalse( mapper.isTrue("no") );
        assertTrue( mapper.isTrue("yes") );
        assertFalse( mapper.isTrue("false") );
        assertTrue( mapper.isTrue("true") );
    }

    /**
     * test for {@link IBooleanMapper#isTrue(String)}
     */
    @Test
    void isTrueString() {
        assertFalse( mapper.isTrue((String) null) );
        assertFalse( mapper.isTrue("0") );
        assertTrue( mapper.isTrue("1") );
        assertFalse( mapper.isTrue("n") );
        assertTrue( mapper.isTrue("y") );
        assertFalse( mapper.isTrue("no") );
        assertTrue( mapper.isTrue("yes") );
        assertFalse( mapper.isTrue("false") );
        assertTrue( mapper.isTrue("true") );
    }
}