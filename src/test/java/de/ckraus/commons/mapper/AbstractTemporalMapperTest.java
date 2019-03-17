package de.ckraus.commons.mapper;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;

public class AbstractTemporalMapperTest {

    ITypeMapper<Temporal> mapper = new AbstractTemporalTypeMapper<>() {
        @Override
        public Temporal map(
                String s,
                DateTimeFormatter formatter,
                Temporal defaultValue
        ) {
            return defaultValue;
        }

        @Override
        public Temporal map(
                String s,
                FormatStyle formatStyle,
                Temporal defaultValue
        ) {
            return defaultValue;
        }

        @Override
        public Temporal map(
                String s,
                boolean bTrim,
                boolean bEmptyIsNull,
                Temporal defaultValue
        ) {
            return defaultValue;
        }
    };

}
