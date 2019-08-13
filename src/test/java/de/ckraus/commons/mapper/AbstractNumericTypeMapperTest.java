package de.ckraus.commons.mapper;

import org.junit.jupiter.api.Test;

class AbstractNumericTypeMapperTest {

    ITypeMapper<Number> mapper = new AbstractNumericTypeMapper<>() {
        @Override
        public Number toType( Number number ) {
            return null;
        }
    };

    @Test
    void map() {
    }

}