package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

class AbstractNumericTypeMapperTest {

    // create mapper instance
    ITypeMapper<Number> mapper = new AbstractNumericTypeMapper<Number>() {
        @Override
        public Number toType(Number number) {
            return null;
        }
    };

    @Test
    void map() {
    }
}