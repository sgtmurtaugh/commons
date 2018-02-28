package de.ckraus.commons.parser.type;

import java.util.Date;

/**
 * Created by gandalf on 25.04.14.
 */
@SuppressWarnings({ "javadoc" })
public interface IDateTypeParser<E extends Date>
    extends ITypeParser<E> {

    /**
     * unformat
     * @param sDate
     * @return
     */
    E unformat ( String sDate );

    /**
     * unformat
     * @param sDate
     * @param defaultValue
     * @return
     */
    E unformat (
            String sDate,
            E defaultValue
    );

    // TODO format


}
