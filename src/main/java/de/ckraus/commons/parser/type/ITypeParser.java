package de.ckraus.commons.parser.type;

import de.ckraus.commons.parser.IParser;

import java.util.Map;

/**
 * Created by gandalf on 15.03.14.
 */
@SuppressWarnings({ "unused", "javadoc" })
public interface ITypeParser<E>
    extends IParser<E> {

    /**
     * getDefaultValue
     * @return
     */
    E getDefaultValue ();

    /**
     * isParsable
     * @param obj
     * @return
     */
    boolean isParsable ( Object obj );

    /**
     * parse
     * @param map
     * @param key
     * @return
     */
    <K> E parse (
            Map<K, ?> map,
            K key
    );

    /**
     * parse
     * @param map
     * @param key
     * @param defaultValue
     * @return
     */
    <K> E parse (
            Map<K, ?> map,
            K key,
            E defaultValue
    );

    /**
     * parse
     * @param obj
     * @return
     */
    E parse ( Object obj );

    /**
     * parse
     * @param obj
     * @param defaultValue
     * @return
     */
    E parse (
            Object obj,
            E defaultValue
    );

    /**
     * parse
     * @param s
     * @return
     */
    E parse ( String s );

    /**
     * parse
     * @param s
     * @param defaultValue
     * @return
     */
    E parse (
            String s,
            E defaultValue
    );

}
