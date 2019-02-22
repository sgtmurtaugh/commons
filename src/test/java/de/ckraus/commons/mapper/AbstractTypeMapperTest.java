package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

import java.time.temporal.Temporal;

import static org.junit.jupiter.api.Assertions.*;

class AbstractTypeMapperTest {

    // create mapper instance
    ITypeMapper mapper = new AbstractTypeMapper() {
        @Override
        public Object map(
                String s,
                boolean bTrim,
                boolean bEmptyIsNull,
                Object defaultValue
        ) {
            return defaultValue;
        }
    };



    @Test
    void map() {
    }

    @Test
    void prepareStringToParse() {
    }

    @Test
    void getDefaultValue() {
    }

    @Test
    void isEmptyStringNull() {
    }

    @Test
    void isTrimStrings() {
    }
}