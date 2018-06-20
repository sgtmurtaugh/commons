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

        if (StringUtils.isNotEmpty(s)) {
            if (null != formatter) {
                try {
                    localDate = LocalDate.parse(
                            s,
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
