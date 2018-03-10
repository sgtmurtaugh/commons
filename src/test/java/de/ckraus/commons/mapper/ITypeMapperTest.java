package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ITypeMapperTest {

    private final String HELLO_WORLD = "Hello World!";

    // create mapper instance
    ITypeMapper mapper = (str, bTrim, bEmptyIsNull, t) -> null;

    @Test
    void getDefaultValue() {
        assertNull(
                mapper.getDefaultValue()
        );
    }

    @Test
    void isTrimStrings() {
        assertTrue(
                mapper.isTrimStrings()
        );
    }

    @Test
    void isEmptyStringNull() {
        assertTrue(
                mapper.isEmptyStringNull()
        );
    }

    @Test
    void evalPredicate() {
        // success checks
        assertTrue(
                mapper.evalPredicate((obj) -> obj instanceof String, HELLO_WORLD)
        );
        assertTrue(
                mapper.evalPredicate(Objects::isNull, null)
        );

        // fail checks
        assertFalse(
                mapper.evalPredicate((obj) -> obj instanceof Integer, HELLO_WORLD)
        );
    }

    @Test
    void isMappable() {
        // success checks
        // the default implementation of ITypeMapper#map(String, boolean, boolean, E) returns only the
        // defaultValue! therefore all #isMappable-tests will fail.

        // fail checks
        assertFalse(
                mapper.isMappable(null)
        );
        assertFalse(
                mapper.isMappable(new Object())
        );
        assertFalse(
                mapper.isMappable(HELLO_WORLD)
        );
        assertFalse(
                mapper.isMappable(new StringBuilder(HELLO_WORLD))
        );
        assertFalse(
                mapper.isMappable(new ArrayList<>())
        );
    }

    @Test
    void map() {
    }

    @Test
    void map1() {
    }

    @Test
    void map2() {
    }

    @Test
    void map3() {
    }

    @Test
    void map4() {
    }

    @Test
    void map5() {
    }

    @Test
    void map6() {
    }

    @Test
    void map7() {
    }
}