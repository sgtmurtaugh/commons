package de.ckraus.commons.mapper;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class TestHelper {

    public static final String PARAMS_KEY__BOOLEAN                 = "boolean";
    public static final String PARAMS_KEY__BOOLEAN_STRING          = "booleanString";
    public static final String PARAMS_KEY__CALENDAR                = "calendar";
    public static final String PARAMS_KEY__CALENDAR_STRING         = "calendarString";
    public static final String PARAMS_KEY__CHARACTER               = "character";
    public static final String PARAMS_KEY__DATE                    = "date";
    public static final String PARAMS_KEY__DATE_STRING             = "dateString";
    public static final String PARAMS_KEY__DOUBLE                  = "double";
    public static final String PARAMS_KEY__DOUBLE_STRING           = "doubleString";
    public static final String PARAMS_KEY__FLOAT                   = "float";
    public static final String PARAMS_KEY__FLOAT_STRING            = "floatString";
    public static final String PARAMS_KEY__INTEGER                 = "integer";
    public static final String PARAMS_KEY__INTEGER_STRING          = "integerString";
    public static final String PARAMS_KEY__LIST                    = "list";
    public static final String PARAMS_KEY__LOCALDATE               = "localdate";
    public static final String PARAMS_KEY__LOCALDATE_STRING        = "localdateString";
    public static final String PARAMS_KEY__LOCALDATETIME           = "localdatetime";
    public static final String PARAMS_KEY__LOCALDATETIME_STRING    = "localdatetimeString";
    public static final String PARAMS_KEY__LOCALTIME               = "localtime";
    public static final String PARAMS_KEY__LOCALTIME_STRING        = "localtimeString";
    public static final String PARAMS_KEY__LONG                    = "long";
    public static final String PARAMS_KEY__LONG_STRING             = "longString";
    public static final String PARAMS_KEY__NO_KEY                  = "noKey";
    public static final String PARAMS_KEY__NO_VALUE                = "noValue";
    public static final String PARAMS_KEY__OBJECT                  = "object";
    public static final String PARAMS_KEY__STRING                  = "string";
    public static final String PARAMS_KEY__STRING__EMPTY           = "stringEmpty";
    public static final String PARAMS_KEY__STRING__UNTRIMMED       = "stringUntrimmed";
    public static final String PARAMS_KEY__STRING__UNTRIMMED_EMPTY = "stringUntrimmedEmpty";
    public static final String PARAMS_KEY__STRING_BUILDER          = "stringBuilder";

    @Getter
    private static Map<String, Object> parameters;

    static {
        parameters = new HashMap<>();
        parameters.put(PARAMS_KEY__BOOLEAN, Boolean.TRUE);
        parameters.put(PARAMS_KEY__BOOLEAN_STRING, "true");
        parameters.put(PARAMS_KEY__CALENDAR, new GregorianCalendar());
        parameters.put(PARAMS_KEY__CALENDAR_STRING, new GregorianCalendar().toString());
        parameters.put(PARAMS_KEY__CHARACTER, 'a');
        parameters.put(PARAMS_KEY__DATE, new Date());
        parameters.put(PARAMS_KEY__DATE_STRING, new Date().toString());
        parameters.put(PARAMS_KEY__DOUBLE, 1.23d);
        parameters.put(PARAMS_KEY__DOUBLE_STRING, "1.23d");
        parameters.put(PARAMS_KEY__FLOAT, 2.34f);
        parameters.put(PARAMS_KEY__FLOAT_STRING, "2.34f");
        parameters.put(PARAMS_KEY__INTEGER, 42);
        parameters.put(PARAMS_KEY__INTEGER_STRING, "42");
        parameters.put(PARAMS_KEY__LIST, new ArrayList());
        parameters.put(PARAMS_KEY__LOCALDATE, LocalDate.now());
        parameters.put(PARAMS_KEY__LOCALDATE_STRING, LocalDate.now().toString());
        parameters.put(PARAMS_KEY__LOCALDATETIME, LocalDateTime.now());
        parameters.put(PARAMS_KEY__LOCALDATETIME_STRING, LocalDateTime.now().toString());
        parameters.put(PARAMS_KEY__LOCALTIME, LocalTime.now());
        parameters.put(PARAMS_KEY__LOCALTIME_STRING, LocalTime.now().toString());
        parameters.put(PARAMS_KEY__LONG, 4711L);
        parameters.put(PARAMS_KEY__LONG_STRING, "4711L");
        parameters.put(PARAMS_KEY__NO_VALUE, null);
        parameters.put(PARAMS_KEY__OBJECT, new Object());
        parameters.put(PARAMS_KEY__STRING, "Hello World!");
        parameters.put(PARAMS_KEY__STRING__EMPTY, "");
        parameters.put(PARAMS_KEY__STRING__UNTRIMMED, "   BAM!   ");
        parameters.put(PARAMS_KEY__STRING__UNTRIMMED_EMPTY, "      ");
        parameters.put(PARAMS_KEY__STRING_BUILDER, new StringBuilder("false"));
    }

}
