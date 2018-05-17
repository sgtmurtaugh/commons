package de.ckraus.commons.mapper;

import de.ckraus.commons.ModuleConstants;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class TypeMapperUtilsTest {

    TypeMapperUtils typeMapperUtils;

    @BeforeEach
    public void initializeTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext(ModuleConstants.SPRING_CONFIGURATION_BEANS);
        typeMapperUtils = (TypeMapperUtils) context.getBean("typeMapperUtils");
        typeMapperUtils = context.getBean(TypeMapperUtils.class);
    }

    @Test
    void initializationSuccessful() {
        assertNotNull(typeMapperUtils);
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