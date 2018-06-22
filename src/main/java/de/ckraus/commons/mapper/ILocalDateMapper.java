package de.ckraus.commons.mapper;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

@SuppressWarnings({ "javadoc", "unused" })
public interface ILocalDateMapper
    extends ITemporalTypeMapper<LocalDate> {

    /**
     * map
     * @param s - string to map
     * @param bTrim - default flag for string handling
     * @param bEmptyIsNull - default flag for empty string handling
     * @param defaultValue - The default value
     * @return
     * <p>Delegates to {@link #map(String, DateTimeFormatter, LocalDate)} with {@link DateTimeFormatter#ISO_DATE}
     */
    @Override
    default LocalDate map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull,
            LocalDate defaultValue
    ) {
        return this.map(
                this.prepareStringToMap(
                        s,
                        bTrim,
                        bEmptyIsNull
                ),
                DateTimeFormatter.ISO_DATE,
                defaultValue
        );
    }

    /**
     * map
     * @param s
     * @param formatter
     * @param defaultValue
     * @return
     */
    @Override
    default LocalDate map(
            String s,
            DateTimeFormatter formatter,
            LocalDate defaultValue
    ) {
        LocalDate localDate = defaultValue;
        String preparedString = this.prepareStringToMap(
                s,
                this.isTrimStrings(),
                this.isEmptyStringNull()
        );

        if (StringUtils.isNotEmpty(preparedString)) {
            if (null != formatter) {
                try {
                    localDate = LocalDate.parse(
                            preparedString,
                            formatter
                    );
                }
                catch (DateTimeParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return localDate;
    }

    /**
     * map
     * @param s
     * @param formatStyle
     * @param defaultValue
     * @return
     */
    @Override
    default LocalDate map(
            String s,
            FormatStyle formatStyle,
            LocalDate defaultValue
    ) {
        DateTimeFormatter formatter = null;

        if (null != formatStyle) {
            formatter = DateTimeFormatter.ofLocalizedDate(formatStyle);
        }

        return this.map(
                s,
                formatter,
                defaultValue
        );
    }

}
