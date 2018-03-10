package de.ckraus.commons.mapper;

import org.junit.Test;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerMapperTest {
    private IntegerMapper integerMapper = new IntegerMapper();

//    @Test
//    public void testMap() {
//    }

    @Test
    public void testUnformat() {
        DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance();

        Integer defaultValue = 4711;

        Locale locale = Locale.GERMAN;

        String sNumber = "123";
        String sPattern = "pattern";

        assertEquals(
                (Integer) 123,
                integerMapper.unformat(sNumber)
        );

        assertEquals(
                (Integer) 123,
                integerMapper.unformat(
                        sNumber,
                        locale
                )
        );

        assertNull(
                integerMapper.unformat(
                        sNumber,
                        sPattern
                )
        );

        assertNull(
                integerMapper.unformat(
                        sNumber,
                        locale,
                        sPattern
                )
        );

        assertNull(
                integerMapper.unformat(
                        sNumber,
                        locale,
                        sPattern,
                        dfs
                )
        );

        assertNull(
                integerMapper.unformat(
                        sNumber,
                        sPattern,
                        dfs
                )
        );

        assertEquals(
                (Integer) 123,
                integerMapper.unformat(
                        sNumber,
                        defaultValue
                )
        );

        assertEquals(
                (Integer) 123,
                integerMapper.unformat(
                        sNumber,
                        locale,
                        defaultValue
                )
        );

        assertEquals(
                defaultValue,
                integerMapper.unformat(
                        sNumber,
                        sPattern,
                        defaultValue
                )
        );

        assertEquals(
                defaultValue,
                integerMapper.unformat(
                        sNumber,
                        locale,
                        sPattern,
                        defaultValue
                )
        );

        assertEquals(
                defaultValue,
                integerMapper.unformat(
                        sNumber,
                        sPattern,
                        dfs,
                        defaultValue
                )
        );

        assertEquals(
                defaultValue,
                integerMapper.unformat(
                        sNumber,
                        locale,
                        sPattern,
                        dfs,
                        defaultValue
                )
        );

    }
}
