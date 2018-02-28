package de.ckraus.commons.parser.type;

import java.util.Calendar;

/**
 * Created by gandalf on 25.04.14.
 */
@SuppressWarnings({ "javadoc" })
public interface ICalendarTypeParser<E extends Calendar>
    extends ITypeParser<E> {

    /**
     * unformat
     * @param sCalendar
     * @return
     */
    E unformat ( String sCalendar );

    /**
     * unformat
     * @param sCalendar
     * @param defaultValue
     * @return
     */
    E unformat (
            String sCalendar,
            E defaultValue
    );

    // TODO format


}
