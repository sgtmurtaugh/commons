package de.ckraus.commons.mapper;

import java.text.DateFormat;
import java.util.Calendar;

public class AbstractCalendarMapperTest {

    // create mapper instance
    ITypeMapper<Calendar> mapper = new AbstractCalendarMapper<Calendar>() {
        @Override
        public Calendar map(
                String s,
                DateFormat format,
                boolean lenient,
                Calendar defaultValue
        ) {
            return defaultValue;
        }

        @Override
        public Calendar map(
                String s,
                boolean bTrim,
                boolean bEmptyIsNull,
                Calendar defaultValue
        ) {
            return defaultValue;
        }
    };

}
