package de.ckraus.commons.mapper;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

class TestHelper {

    static final String PARAMS_KEY__BIG_DECIMAL              = "bigDecimal";
    static final String PARAMS_KEY__BIG_DECIMAL_STRING       = "bigDecimalString";
    static final String PARAMS_KEY__BIG_INTEGER              = "bigInteger";
    static final String PARAMS_KEY__BIG_INTEGER_STRING       = "bigIntegerString";
    static final String PARAMS_KEY__BOOLEAN                  = "boolean";
    static final String PARAMS_KEY__BOOLEAN_STRING           = "booleanString";
    static final String PARAMS_KEY__BYTE                     = "byte";
    static final String PARAMS_KEY__BYTE_STRING              = "byteString";
    static final String PARAMS_KEY__CALENDAR                 = "calendar";
    static final String PARAMS_KEY__CALENDAR_STRING          = "calendarString";
    static final String PARAMS_KEY__CHARACTER                = "character";
    static final String PARAMS_KEY__DATE                     = "date";
    static final String PARAMS_KEY__DATE_STRING              = "dateString";
    static final String PARAMS_KEY__DOUBLE                   = "double";
    static final String PARAMS_KEY__DOUBLE_STRING            = "doubleString";
    static final String PARAMS_KEY__FLOAT                    = "float";
    static final String PARAMS_KEY__FLOAT_STRING             = "floatString";
    static final String PARAMS_KEY__INTEGER                  = "integer";
    static final String PARAMS_KEY__INTEGER_STRING           = "integerString";
    static final String PARAMS_KEY__LIST                     = "list";
    static final String PARAMS_KEY__LOCALDATE                = "localdate";
    static final String PARAMS_KEY__LOCALDATE_STRING         = "localdateString";
    static final String PARAMS_KEY__LOCALDATETIME            = "localdatetime";
    static final String PARAMS_KEY__LOCALDATETIME_STRING     = "localdatetimeString";
    static final String PARAMS_KEY__LOCALTIME                = "localtime";
    static final String PARAMS_KEY__LOCALTIME_STRING         = "localtimeString";
    static final String PARAMS_KEY__LONG                     = "long";
    static final String PARAMS_KEY__LONG_STRING              = "longString";
    static final String PARAMS_KEY__NO_KEY                   = "noKey";
    static final String PARAMS_KEY__NO_VALUE                 = "noValue";
    static final String PARAMS_KEY__OBJECT                   = "object";
    static final String PARAMS_KEY__SHORT                    = "short";
    static final String PARAMS_KEY__SHORT_STRING             = "shortString";
    static final String PARAMS_KEY__STRING                   = "string";
    static final String PARAMS_KEY__STRING__EMPTY            = "stringEmpty";
    static final String PARAMS_KEY__STRING__UNTRIMMED        = "stringUntrimmed";
    static final String PARAMS_KEY__STRING__UNTRIMMED_EMPTY  = "stringUntrimmedEmpty";
    static final String PARAMS_KEY__STRING_BUILDER           = "stringBuilder";

    @Getter
    private static Map<String, Object> parameters;

    static {
        parameters = new HashMap<>();
        parameters.put(PARAMS_KEY__BIG_DECIMAL, new BigDecimal(987654321.0));
        parameters.put(PARAMS_KEY__BIG_DECIMAL_STRING, "987654321,0");
        parameters.put(PARAMS_KEY__BIG_INTEGER, new BigInteger("123456789"));
        parameters.put(PARAMS_KEY__BIG_INTEGER_STRING, "123456789");
        parameters.put(PARAMS_KEY__BOOLEAN, Boolean.TRUE);
        parameters.put(PARAMS_KEY__BOOLEAN_STRING, "true");
        parameters.put(PARAMS_KEY__BYTE, (byte) 1);
        parameters.put(PARAMS_KEY__BYTE_STRING, "1");
        parameters.put(PARAMS_KEY__CALENDAR, new GregorianCalendar());
        parameters.put(PARAMS_KEY__CALENDAR_STRING, new GregorianCalendar().toString());
        parameters.put(PARAMS_KEY__CHARACTER, 'a');
        parameters.put(PARAMS_KEY__DATE, new Date());
        parameters.put(PARAMS_KEY__DATE_STRING, new Date().toString());
        parameters.put(PARAMS_KEY__DOUBLE, 1.23d);
        parameters.put(PARAMS_KEY__DOUBLE_STRING, "1,23");
        parameters.put(PARAMS_KEY__FLOAT, 2.34f);
        parameters.put(PARAMS_KEY__FLOAT_STRING, "2,34");
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
        parameters.put(PARAMS_KEY__LONG_STRING, "4711");
        parameters.put(PARAMS_KEY__NO_VALUE, null);
        parameters.put(PARAMS_KEY__OBJECT, new Object());
        parameters.put(PARAMS_KEY__SHORT, (short) 127);
        parameters.put(PARAMS_KEY__SHORT_STRING, "127");
        parameters.put(PARAMS_KEY__STRING, "Hello World!");
        parameters.put(PARAMS_KEY__STRING__EMPTY, "");
        parameters.put(PARAMS_KEY__STRING__UNTRIMMED, "   BAM!   ");
        parameters.put(PARAMS_KEY__STRING__UNTRIMMED_EMPTY, "      ");
        parameters.put(PARAMS_KEY__STRING_BUILDER, new StringBuilder("false"));
    }

}
