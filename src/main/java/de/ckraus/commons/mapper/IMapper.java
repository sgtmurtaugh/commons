package de.ckraus.commons.mapper;

import java.util.Map;
import java.util.function.Predicate;

@SuppressWarnings({"javadoc", "unused"})
public interface IMapper<E> {

    /**
     * getDefaultValue
     * @return
     */
    E getDefaultValue();

    /**
     * isTrimStrings
     * @return
     */
    default boolean isTrimStrings() {
        return Boolean.TRUE;
    }

    /**
     * isEmptyStringNull
     * @return
     */
    default boolean isEmptyStringNull() {
        return Boolean.TRUE;
    }

    /**
     * isMappable
     * @param o
     * @return
     */
    default boolean isMappable( Object o ) {
        boolean bIsMappable;

        if ( null == o ) {
            bIsMappable = false;
        }
        else
        if ( o instanceof String ) {
            bIsMappable = (
                    null != this.map(
                            (String) o,
                            null
                    )
            );
        }
        else {
            bIsMappable = this.isMappable( o.toString() );
        }
        return bIsMappable;
    }

    /**
     * isMappable
     * @param predicate
     * @param t
     * @return
     */
    default <T> boolean isMappable(
            Predicate<T> predicate,
            T t
    ) {
        boolean bIsMappable = false;

        if (null != predicate) {
            bIsMappable = predicate.test(t);
        }
        return bIsMappable;
    }

    /**
     * map
     * @param map parameter map
     * @param key map access key
     * @return
     */
    default E map(
            Map<String, ?> map,
            String key
    ) {
        return this.map(
                map,
                key,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param map parameter map
     * @param key map access key
     * @param defaultValue default value used, when the given map is null, the key cannot be found in map, or the map
     *                    value cannot be mapped to Number type
     * @return
     */
    default E map(
            Map<String, ?> map,
            String key,
            E defaultValue
    ) {
        E retVal = defaultValue;

        if ( null != map ) {
            if ( null != key ) {
                if ( map.containsKey(key) ) {
                    retVal = this.map(
                            map.get(key),
                            defaultValue
                    );
                }
            }
        }
        return retVal;
    }

    /**
     * map
     * @param obj
     * @return
     */
    default E map( Object obj ) {
        return this.map(
                obj,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param obj
     * @param defaultValue
     * @return
     */
    default E map(
            Object obj,
            E defaultValue
    ) {
        E e;

        if (null == obj) {
           e = defaultValue;
        }
        else
        if ( obj instanceof String ) {
            e = this.map(
                    (String) obj,
                    defaultValue
            );
        }
        else {
            e = this.map(
                    obj.toString(),
                    defaultValue
            );
        }
        return e;
    }

    /**
     * map
     * @param s - string to map
     * @return
     */
    default E map( String s ) {
        return this.map(
                s,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param s - string to map
     * @param defaultValue
     * @return
     */
    default E map(
            String s,
            E defaultValue
    ) {
        return this.map(
                s,
                this.isTrimStrings(),
                this.isEmptyStringNull(),
                defaultValue
        );
    }

    /**
     * map
     * @param s - string to map
     * @param bTrim - default flag for string handling
     * @param bEmptyIsNull - default flag for empty string handling
     * @return
     */
    default E map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull
    ) {
        return this.map(
                s,
                bTrim,
                bEmptyIsNull,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param s - string to map
     * @param bTrim - default flag for string handling
     * @param bEmptyIsNull - default flag for empty string handling
     * @param defaultValue - The default value
     * @return
     * This method should be overwritten individually.
     */
    E map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull,
            E defaultValue
    );

}
