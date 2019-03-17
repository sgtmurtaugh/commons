package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

class AbstractTypeMapperTest {

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