package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

import static de.ckraus.commons.mapper.TestHelper.*;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings( { "unchecked", "WeakerAccess" } )
class ITypeMapperTest {

    private final static Object ANOTHER_DEFAULT_VALUE = Boolean.TRUE;

    // due to the fact, that all methods delegate to the map(String, boolean, boolean, E) method this dummy
    // implementation (see mapper lambda) all objects are mapped to the mappers given defaultValue!
    private ITypeMapper mapper = ( str, bTrim, bEmptyIsNull, defVal ) -> defVal;


    /**
     * test for {@link ITypeMapper#getDefaultValue()}
     */
    @Test
    void getDefaultValue() {
        assertNull( mapper.getDefaultValue() );
    }

    /**
     * test for {@link ITypeMapper#isTrimStrings()}
     */
    @Test
    void isTrimStrings() {
        assertTrue( mapper.isTrimStrings() );
    }

    /**
     * test for {@link ITypeMapper#isEmptyStringNull()}
     */
    @Test
    void isEmptyStringNull() {
        assertTrue( mapper.isEmptyStringNull() );
    }

    /**
     * test for {@link ITypeMapper#evalPredicate(Predicate, Object)}
     */
    @Test
    void evalPredicate() {
        // success checks
        assertTrue(
                mapper.evalPredicate( ( obj ) -> obj instanceof String, getParameters().get( PARAMS_KEY__STRING ) ) );
        assertTrue( mapper.evalPredicate( Objects::isNull, null ) );

        // fail checks
        assertFalse(
                mapper.evalPredicate( ( obj ) -> obj instanceof Integer, getParameters().get( PARAMS_KEY__STRING ) ) );
    }

    /**
     * test for {@link ITypeMapper#isMappable(Object)}
     */
    @Test
    void isMappable() {
        // success checks
        // the default implementation of ITypeMapper#map(String, boolean, boolean, E) returns only the
        // defaultValue! therefore all #isMappable-tests will fail.

        // fail checks
        assertFalse( mapper.isMappable( null ) );
        assertFalse( mapper.isMappable( getParameters().get( PARAMS_KEY__OBJECT ) ) );
        assertFalse( mapper.isMappable( getParameters().get( PARAMS_KEY__STRING ) ) );
        assertFalse( mapper.isMappable( getParameters().get( PARAMS_KEY__STRING_BUILDER ) ) );
        assertFalse( mapper.isMappable( getParameters().get( PARAMS_KEY__LIST ) ) );
    }

    /**
     * test for {@link ITypeMapper#map(Map, String)}
     */
    @Test
    void map() {
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_KEY ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__NO_VALUE ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BOOLEAN ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BOOLEAN_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BYTE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CALENDAR ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CALENDAR_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__CHARACTER ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DOUBLE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__FLOAT ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__INTEGER ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LIST ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATE ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATE_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALTIME ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LOCALTIME_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LONG ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__LONG_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__OBJECT ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__SHORT ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER ) );
    }

    /**
     * test for {@link ITypeMapper#map(Map, String, Object)}
     */
    @Test
    void map1() {
        // check default value
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__NO_KEY, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__NO_VALUE, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_DECIMAL_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BIG_INTEGER_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BOOLEAN_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__BYTE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__BYTE_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CALENDAR, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CALENDAR_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__CHARACTER, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__DOUBLE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__DOUBLE_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__FLOAT, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__FLOAT_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__INTEGER_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LIST, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATE, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATE_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALDATETIME_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALTIME, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LOCALTIME_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__LONG, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__LONG_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__OBJECT, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__SHORT, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__SHORT_STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE, mapper.map( getParameters(), PARAMS_KEY__STRING, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__EMPTY, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING__UNTRIMMED_EMPTY, ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters(), PARAMS_KEY__STRING_BUILDER, ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link ITypeMapper#map(Object)}
     */
    @Test
    void map2() {
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__NO_KEY ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__NO_VALUE ) ) );

        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__BIG_DECIMAL ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__BIG_DECIMAL_STRING ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__BIG_INTEGER ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__BIG_INTEGER_STRING ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__BOOLEAN ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__BOOLEAN_STRING ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__BYTE ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__BYTE_STRING ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__CALENDAR ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__CALENDAR_STRING ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__CHARACTER ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__DOUBLE ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__DOUBLE_STRING ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__FLOAT ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__FLOAT_STRING ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__INTEGER ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__INTEGER_STRING ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__LIST ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__LOCALDATE ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__LOCALDATE_STRING ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__LOCALDATETIME ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__LOCALDATETIME_STRING ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__LOCALTIME ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__LOCALTIME_STRING ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__LONG ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__LONG_STRING ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__OBJECT ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__SHORT ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__SHORT_STRING ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__STRING ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__STRING__EMPTY ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ) ) );
        assertEquals( mapper.getDefaultValue(),
                mapper.map( getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__STRING_BUILDER ) ) );
    }

    /**
     * test for {@link ITypeMapper#map(Object, Object)}
     */
    @Test
    void map3() {
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__NO_KEY ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__NO_VALUE ), ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__BIG_DECIMAL ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__BIG_DECIMAL_STRING ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__BIG_INTEGER ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__BIG_INTEGER_STRING ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__BOOLEAN ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__BOOLEAN_STRING ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__BYTE ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__BYTE_STRING ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__CALENDAR ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__CALENDAR_STRING ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__CHARACTER ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__DOUBLE ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__DOUBLE_STRING ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__FLOAT ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__FLOAT_STRING ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__INTEGER ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__INTEGER_STRING ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__LIST ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__LOCALDATE ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__LOCALDATE_STRING ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__LOCALDATETIME ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__LOCALDATETIME_STRING ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__LOCALTIME ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__LOCALTIME_STRING ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__LONG ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__LONG_STRING ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__OBJECT ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__SHORT ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__SHORT_STRING ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__STRING ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__STRING__EMPTY ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__STRING_BUILDER ), ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link ITypeMapper#map(String)}
     */
    @Test
    void map4() {
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__STRING ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__STRING__EMPTY ) ) );
        assertEquals( mapper.getDefaultValue(), mapper.map( getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ) ) );
        assertEquals( mapper.getDefaultValue(),
                mapper.map( getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ) ) );
    }

    /**
     * test for {@link ITypeMapper#map(String, Object)}
     */
    @Test
    void map5() {
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__STRING ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__STRING__EMPTY ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ), ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ), ANOTHER_DEFAULT_VALUE ) );
    }

    /**
     * test for {@link ITypeMapper#map(String, boolean, boolean)}
     */
    @Test
    void map6() {
        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING ), false, false ) );
        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING ), false, true ) );
        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING ), true, false ) );
        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING ), true, true ) );

        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__EMPTY ), false, false ) );
        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__EMPTY ), false, true ) );
        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__EMPTY ), true, false ) );
        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__EMPTY ), true, true ) );

        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ), false, false ) );
        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ), false, true ) );
        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ), true, false ) );
        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ), true, true ) );

        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ), false, false ) );
        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ), false, true ) );
        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ), true, false ) );
        assertEquals( mapper.getDefaultValue(),
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ), true, true ) );
    }

    /**
     * test for {@link ITypeMapper#map(String, boolean, boolean, Object)}
     */
    @Test
    void map7() {
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING ), false, false,
                        ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING ), false, true,
                        ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING ), true, false,
                        ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING ), true, true, ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__EMPTY ), false, false,
                        ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__EMPTY ), false, true,
                        ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__EMPTY ), true, false,
                        ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__EMPTY ), true, true,
                        ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ), false, false,
                        ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ), false, true,
                        ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ), true, false,
                        ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ), true, true,
                        ANOTHER_DEFAULT_VALUE ) );

        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ), false, false,
                        ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ), false, true,
                        ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ), true, false,
                        ANOTHER_DEFAULT_VALUE ) );
        assertEquals( ANOTHER_DEFAULT_VALUE,
                mapper.map( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ), true, true,
                        ANOTHER_DEFAULT_VALUE ) );
    }

    @Test
    public void prepareStringToMap() {
        assertEquals( null,
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__NO_VALUE ), false, false ) );
        assertEquals( null,
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__NO_VALUE ), false, true ) );
        assertEquals( null,
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__NO_VALUE ), true, false ) );
        assertEquals( null,
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__NO_VALUE ), true, true ) );

        assertEquals( getParameters().get( PARAMS_KEY__STRING ),
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING ), false, false ) );
        assertEquals( getParameters().get( PARAMS_KEY__STRING ),
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING ), false, true ) );
        assertEquals( getParameters().get( PARAMS_KEY__STRING ),
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING ), true, false ) );
        assertEquals( getParameters().get( PARAMS_KEY__STRING ),
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING ), true, true ) );

        assertEquals( "", mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING__EMPTY ), false,
                false ) );
        assertEquals( null,
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING__EMPTY ), false, true ) );
        assertEquals( "",
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING__EMPTY ), true, false ) );
        assertEquals( null,
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING__EMPTY ), true, true ) );

        assertEquals( getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ),
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ), false,
                        false ) );
        assertEquals( getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ),
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ), false,
                        true ) );
        assertEquals( ( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ) ).trim(),
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ), true,
                        false ) );
        assertEquals( ( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ) ).trim(),
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED ), true,
                        true ) );

        assertEquals( getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ),
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ), false,
                        false ) );
        assertEquals( getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ),
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ), false,
                        true ) );
        assertEquals( "",
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ), true,
                        false ) );
        assertEquals( null,
                mapper.prepareStringToMap( ( String ) getParameters().get( PARAMS_KEY__STRING__UNTRIMMED_EMPTY ), true,
                        true ) );

    }

}