package de.ckraus.commons.mapper;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

@SuppressWarnings({ "javadoc", "unused" })
public interface IGregorianCalendarMapper
    extends ICalenderMapper<GregorianCalendar> {

    /**
     * map
     * @param s - string to map
     * @param bTrim - default flag for string handling
     * @param bEmptyIsNull - default flag for empty string handling
     * @param defaultValue - The default value
     * @return
     * <p>Delegates to {@link #map(String, DateFormat, boolean, GregorianCalendar)}
     * with {@link DateTimeFormatter#ISO_TIME}
     */
    @Override
    default GregorianCalendar map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull,
            GregorianCalendar defaultValue
    ) {
        return this.map(
                this.prepareStringToMap(
                        s,
                        bTrim,
                        bEmptyIsNull
                ),
                SimpleDateFormat.getDateTimeInstance(),
                defaultValue
        );
    }

    /**
     * map
     * @param s
     * @param format
     * @param lenient
     * @param defaultValue
     * @return
     */
    @Override
    default GregorianCalendar map(
            String s,
            DateFormat format,
            boolean lenient,
            GregorianCalendar defaultValue
    ) {
        GregorianCalendar gregorianCalendar = defaultValue;
        String preparedString = this.prepareStringToMap(
                s,
                this.isTrimStrings(),
                this.isEmptyStringNull()
        );

        if (StringUtils.isNotEmpty(preparedString)) {
            if (null != format) {
                try {
                    format.setLenient(lenient);
                    Date date = format.parse(preparedString);
                    gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
                    gregorianCalendar.setTime(date);
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return gregorianCalendar;
    }

}
