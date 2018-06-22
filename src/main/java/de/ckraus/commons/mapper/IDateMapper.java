package de.ckraus.commons.mapper;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SuppressWarnings({ "javadoc", "unused" })
public interface IDateMapper
    extends ITypeMapper<Date> {

    boolean DEFAULT_LENIENT = Boolean.FALSE;


    /**
     * map
     * @param s - string to map
     * @param bTrim - default flag for string handling
     * @param bEmptyIsNull - default flag for empty string handling
     * @param defaultValue - The default value
     * @return
     * <p>Delegates to {@link #map(String, DateFormat, boolean, Date)} with {@link DateTimeFormatter#ISO_TIME}
     */
    @Override
    default Date map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull,
            Date defaultValue
    ) {
        return this.map(
                this.prepareStringToMap(
                        s,
                        bTrim,
                        bEmptyIsNull
                ),
                SimpleDateFormat.getDateInstance(),
                DEFAULT_LENIENT,
                defaultValue
        );
    }

    /**
     * map
     * @param s
     * @param format
     * @param defaultValue
     * @return
     * <p>Delegates to {@link #map(String, DateFormat, boolean, Date)} with default lenient value
     * {@link #DEFAULT_LENIENT}</p>
     */
    default Date map(
            String s,
            DateFormat format,
            Date defaultValue
    ) {
        return this.map(
                s,
                format,
                DEFAULT_LENIENT,
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
    default Date map(
            String s,
            DateFormat format,
            boolean lenient,
            Date defaultValue
    ) {
        Date date = defaultValue;
        String preparedString = this.prepareStringToMap(
                s,
                this.isTrimStrings(),
                this.isEmptyStringNull()
        );

        if (StringUtils.isNotEmpty(preparedString)) {
            if (null != format) {
                try {
                    format.setLenient(lenient);
                    date = format.parse(preparedString);
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return date;
    }

}
