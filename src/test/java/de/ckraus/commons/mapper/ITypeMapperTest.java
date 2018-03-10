package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings({"unchecked", "WeakerAccess"})
class ITypeMapperTest {

    private static final String PARAMS_KEY__BOOLEAN                 = "boolean";
    private static final String PARAMS_KEY__CALENDAR                = "calendar";
    private static final String PARAMS_KEY__CHARACTER               = "character";
    private static final String PARAMS_KEY__DATE                    = "date";
    private static final String PARAMS_KEY__DOUBLE                  = "double";
    private static final String PARAMS_KEY__FLOAT                   = "float";
    private static final String PARAMS_KEY__INTEGER                 = "integer";
    private static final String PARAMS_KEY__LIST                    = "list";
    private static final String PARAMS_KEY__LOCALDATE               = "localdate";
    private static final String PARAMS_KEY__LOCALDATETIME           = "localdatetime";
    private static final String PARAMS_KEY__LOCALTIME               = "localtime";
    private static final String PARAMS_KEY__LONG                    = "long";
    private static final String PARAMS_KEY__NO_KEY                  = "noKey";
    private static final String PARAMS_KEY__NO_VALUE                = "noValue";
    private static final String PARAMS_KEY__OBJECT                  = "object";
    private static final String PARAMS_KEY__STRING                  = "string";
    private static final String PARAMS_KEY__STRING__EMPTY           = "stringEmpty";
    private static final String PARAMS_KEY__STRING__UNTRIMMED       = "stringUntrimmed";
    private static final String PARAMS_KEY__STRING__UNTRIMMED_EMPTY = "stringUntrimmedEmpty";
    private static final String PARAMS_KEY__STRING_BUILDER          = "stringBuilder";

    private Map<String, Object> mParams;

    private final static Object ANOTHER_DEFAULT_VALUE   = Boolean.TRUE;

    // create mapper instance
    // due to the fact, that all methods delegate to the map(String, boolean, boolean, E) method this dummy
    // implementation (see mapper lambda) all objects are mapped to the mappers given defaultValue!
    private ITypeMapper mapper = (str, bTrim, bEmptyIsNull, t) -> t;


    /**
     * Constructor
     */
    public ITypeMapperTest() {
        mParams = new HashMap<>();
        mParams.put(PARAMS_KEY__BOOLEAN, Boolean.TRUE);
        mParams.put(PARAMS_KEY__CALENDAR, new GregorianCalendar());
        mParams.put(PARAMS_KEY__CHARACTER, 'a');
        mParams.put(PARAMS_KEY__DATE, new Date());
        mParams.put(PARAMS_KEY__DOUBLE, 1.23d);
        mParams.put(PARAMS_KEY__FLOAT, 2.34f);
        mParams.put(PARAMS_KEY__INTEGER, 42);
        mParams.put(PARAMS_KEY__LIST, new ArrayList());
        mParams.put(PARAMS_KEY__LOCALDATE, LocalDate.now());
        mParams.put(PARAMS_KEY__LOCALDATETIME, LocalDateTime.now());
        mParams.put(PARAMS_KEY__LOCALTIME, LocalTime.now());
        mParams.put(PARAMS_KEY__LONG, 4711L);
        mParams.put(PARAMS_KEY__NO_VALUE, null);
        mParams.put(PARAMS_KEY__OBJECT, new Object());
        mParams.put(PARAMS_KEY__STRING, "Hello World!");
        mParams.put(PARAMS_KEY__STRING__EMPTY, "");
        mParams.put(PARAMS_KEY__STRING__UNTRIMMED, "   BAM!   ");
        mParams.put(PARAMS_KEY__STRING__UNTRIMMED_EMPTY, "      ");
        mParams.put(PARAMS_KEY__STRING_BUILDER, new StringBuilder("false"));
    }


    /**
     * test for {@link ITypeMapper#getDefaultValue()}
     */
    @Test
    void getDefaultValue() {
        assertNull(
                mapper.getDefaultValue()
        );
    }

    /**
     * test for {@link ITypeMapper#isTrimStrings()}
     */
    @Test
    void isTrimStrings() {
        assertTrue(
                mapper.isTrimStrings()
        );
    }

    /**
     * test for {@link ITypeMapper#isEmptyStringNull()}
     */
    @Test
    void isEmptyStringNull() {
        assertTrue(
                mapper.isEmptyStringNull()
        );
    }

    /**
     * test for {@link ITypeMapper#evalPredicate(Predicate, Object)}
     */
    @Test
    void evalPredicate() {
        // success checks
        assertTrue(
                mapper.evalPredicate((obj) -> obj instanceof String, mParams.get(PARAMS_KEY__STRING))
        );
        assertTrue(
                mapper.evalPredicate(Objects::isNull, null)
        );

        // fail checks
        assertFalse(
                mapper.evalPredicate((obj) -> obj instanceof Integer, mParams.get(PARAMS_KEY__STRING))
        );
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
        assertFalse(
                mapper.isMappable(null)
        );
        assertFalse(
                mapper.isMappable(mParams.get(PARAMS_KEY__OBJECT))
        );
        assertFalse(
                mapper.isMappable(mParams.get(PARAMS_KEY__STRING))
        );
        assertFalse(
                mapper.isMappable(mParams.get(PARAMS_KEY__STRING_BUILDER))
        );
        assertFalse(
                mapper.isMappable(mParams.get(PARAMS_KEY__LIST))
        );
    }

    /**
     * test for {@link ITypeMapper#map(Map, String)}
     */
    @Test
    void map() {
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams, PARAMS_KEY__NO_KEY)
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams, PARAMS_KEY__NO_VALUE)
        );

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams, PARAMS_KEY__BOOLEAN)
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams, PARAMS_KEY__CHARACTER)
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams, PARAMS_KEY__DOUBLE)
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams, PARAMS_KEY__FLOAT)
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams, PARAMS_KEY__INTEGER)
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams, PARAMS_KEY__LIST)
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams, PARAMS_KEY__LONG)
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams, PARAMS_KEY__OBJECT)
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams, PARAMS_KEY__STRING)
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams, PARAMS_KEY__STRING__EMPTY)
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams, PARAMS_KEY__STRING__UNTRIMMED)
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams, PARAMS_KEY__STRING__UNTRIMMED_EMPTY)
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams, PARAMS_KEY__STRING_BUILDER)
        );
    }

    /**
     * test for {@link ITypeMapper#map(Map, String, Object)}
     */
    @Test
    void map1() {
        // check default value
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams,
                        PARAMS_KEY__NO_KEY,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams,
                        PARAMS_KEY__NO_VALUE,
                        ANOTHER_DEFAULT_VALUE
                )
        );

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams,
                        PARAMS_KEY__BOOLEAN,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams,
                        PARAMS_KEY__CHARACTER,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams,
                        PARAMS_KEY__DOUBLE,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams,
                        PARAMS_KEY__FLOAT,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams,
                        PARAMS_KEY__INTEGER,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams,
                        PARAMS_KEY__LIST,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams,
                        PARAMS_KEY__LONG,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams,
                        PARAMS_KEY__OBJECT,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams,
                        PARAMS_KEY__STRING,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams,
                        PARAMS_KEY__STRING__EMPTY,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams,
                        PARAMS_KEY__STRING__UNTRIMMED,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams,
                        PARAMS_KEY__STRING__UNTRIMMED_EMPTY,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams,
                        PARAMS_KEY__STRING_BUILDER,
                        ANOTHER_DEFAULT_VALUE
                )
        );
    }

    /**
     * test for {@link ITypeMapper#map(Object)}
     */
    @Test
    void map2() {
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__NO_KEY))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__NO_VALUE))
        );

        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__BOOLEAN))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__CHARACTER))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__DOUBLE))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__FLOAT))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__INTEGER))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__LIST))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__LONG))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__OBJECT))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__STRING))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__STRING__EMPTY))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__STRING__UNTRIMMED))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__STRING_BUILDER))
        );
    }

    /**
     * test for {@link ITypeMapper#map(Object, Object)}
     */
    @Test
    void map3() {
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__NO_KEY),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__NO_VALUE),
                        ANOTHER_DEFAULT_VALUE
                )
        );

        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__BOOLEAN),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__CHARACTER),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__DOUBLE),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__FLOAT),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__INTEGER),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__LIST),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__LONG),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__OBJECT),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__STRING),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__STRING__EMPTY),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__STRING__UNTRIMMED),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__STRING_BUILDER),
                        ANOTHER_DEFAULT_VALUE
                )
        );
    }

    /**
     * test for {@link ITypeMapper#map(String)}
     */
    @Test
    void map4() {
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__STRING))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__STRING__EMPTY))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__STRING__UNTRIMMED))
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(mParams.get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY))
        );
    }

    /**
     * test for {@link ITypeMapper#map(String, Object)}
     */
    @Test
    void map5() {
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__STRING),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__STRING__EMPTY),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__STRING__UNTRIMMED),
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        mParams.get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY),
                        ANOTHER_DEFAULT_VALUE
                )
        );
    }

    /**
     * test for {@link ITypeMapper#map(String, boolean, boolean)}
     */
    @Test
    void map6() {
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING),
                        false,
                        false
                )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING),
                        false,
                        true
                )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING),
                        true,
                        false
                )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING),
                        true,
                        true
                )
        );


        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__EMPTY),
                        false,
                        false
                )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__EMPTY),
                        false,
                        true
                )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__EMPTY),
                        true,
                        false
                )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__EMPTY),
                        true,
                        true
                )
        );



        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED),
                        false,
                        false
                )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED),
                        false,
                        true
                )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED),
                        true,
                        false
                )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED),
                        true,
                        true
                )
        );


        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY),
                        false,
                        false
                )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY),
                        false,
                        true
                )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY),
                        true,
                        false
                )
        );
        assertEquals(
                mapper.getDefaultValue(),
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY),
                        true,
                        true
                )
        );
    }

    /**
     * test for {@link ITypeMapper#map(String, boolean, boolean, Object)}
     */
    @Test
    void map7() {
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING),
                        false,
                        false,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING),
                        false,
                        true,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING),
                        true,
                        false,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING),
                        true,
                        true,
                        ANOTHER_DEFAULT_VALUE
                )
        );


        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__EMPTY),
                        false,
                        false,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__EMPTY),
                        false,
                        true,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__EMPTY),
                        true,
                        false,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__EMPTY),
                        true,
                        true,
                        ANOTHER_DEFAULT_VALUE
                )
        );



        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED),
                        false,
                        false,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED),
                        false,
                        true,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED),
                        true,
                        false,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED),
                        true,
                        true,
                        ANOTHER_DEFAULT_VALUE
                )
        );


        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY),
                        false,
                        false,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY),
                        false,
                        true,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY),
                        true,
                        false,
                        ANOTHER_DEFAULT_VALUE
                )
        );
        assertEquals(
                ANOTHER_DEFAULT_VALUE,
                mapper.map(
                        (String) mParams.get(PARAMS_KEY__STRING__UNTRIMMED_EMPTY),
                        true,
                        true,
                        ANOTHER_DEFAULT_VALUE
                )
        );
    }
}