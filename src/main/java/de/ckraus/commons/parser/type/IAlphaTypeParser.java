package de.ckraus.commons.parser.type;

import java.util.Map;

/**
 * Created by ckraus on 09.08.15.
 */
public interface IAlphaTypeParser<E>
    extends ITypeParser<E> {

    /**
     * parse
     * @param s - string to parse
     * @param bTrim - default flag for string handling
     * @param bEmptyIsNull - default flag for empty string handling
     * @return
     */
    E parse (
            String s,
            boolean bTrim,
            boolean bEmptyIsNull
    );

    /**
     * parse
     * @param s - string to parse
     * @param defaultValue - The default value
     * @param bTrim - default flag for string handling
     * @param bEmptyIsNull - default flag for empty string handling
     * @return
     */
    E parse (
            String s,
            E defaultValue,
            boolean bTrim,
            boolean bEmptyIsNull
    );

}
