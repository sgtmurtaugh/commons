package de.ckraus.commons.mapper;

import java.util.Date;

public interface IDateMapper
    extends ITypeMapper<Date> {

    // TODO: implement

    /**
     * map
     * @param s - string to map
     * @param bTrim - default flag for string handling
     * @param bEmptyIsNull - default flag for empty string handling
     * @param defaultValue - The default value
     * @return
     * <p>TODO
     */
    @Override
    default Date map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull,
            Date defaultValue
    ) {
        return defaultValue;
    }

}
