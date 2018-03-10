package de.ckraus.commons.mapper;

import java.time.temporal.Temporal;

public interface ITemporalTypeMapper<E extends Temporal>
    extends ITypeMapper<E> {

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
    default E map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull,
            E defaultValue
    ) {
        return defaultValue;
    }

}
