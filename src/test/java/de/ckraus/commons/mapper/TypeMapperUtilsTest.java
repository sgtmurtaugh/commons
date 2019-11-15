package de.ckraus.commons.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TypeMapperUtilsTest {

    TypeMapperUtils typeMapperUtils;

    @BeforeEach
    public void initializeTest() {
        typeMapperUtils = TypeMapperUtils.getInstance();
    }

    @Test
    void initializationSuccessful() {
        assertNotNull( typeMapperUtils );
    }

    @Test
    void getRegistered() {
    }

    @Test
    void getRegisteredTypeMappers() {
    }

    @Test
    void setRegisteredTypeMappers() {
    }

    @Test
    void addRegisteredTypeMapper() {
    }

    @Test
    void getDefaults() {
    }

    @Test
    void getDefaultTypeMappers() {
    }

    @Test
    void get() {
    }

    @Test
    void getTypeMapper() {
    }

}