package de.ckraus.commons.mapper;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

@SuppressWarnings({ "javadoc", "unused" })
public interface ILocalDateTimeMapper
    extends ITemporalTypeMapper<LocalDateTime> {

    /**
     * map
     * @param s
     * @param formatter
     * @param defaultValue
     * @return
     */
    @Override
    default LocalDateTime map(
            String s,
            DateTimeFormatter formatter,
            LocalDateTime defaultValue
    ) {
        LocalDateTime localDateTime = defaultValue;

        if (StringUtils.isNotEmpty(s)) {
            if (null != formatter) {
                try {
                    localDateTime = LocalDateTime.parse(
                            s,
                            formatter
                    );
                }
                catch (DateTimeParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return localDateTime;
    }

    /**
     * map
     * @param s
     * @param formatStyle
     * @param defaultValue
     * @return
     */
    @Override
    default LocalDateTime map(
            String s,
            FormatStyle formatStyle,
            LocalDateTime defaultValue
    ) {
        DateTimeFormatter formatter = null;

        if (null != formatStyle) {
            formatter = DateTimeFormatter.ofLocalizedDateTime(formatStyle);
        }

        return this.map(
                s,
                formatter,
                defaultValue
        );
    }

    /**
     * map
     * @param s
     * @param dateStyle
     * @param timeStyle
     * @return
     */
    default LocalDateTime map(
            String s,
            FormatStyle dateStyle,
            FormatStyle timeStyle
    ) {
        return this.map(
                s,
                dateStyle,
                timeStyle,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param s
     * @param dateStyle
     * @param timeStyle
     * @param defaultValue
     * @return
     */
    default LocalDateTime map(
            String s,
            FormatStyle dateStyle,
            FormatStyle timeStyle,
            LocalDateTime defaultValue
    ) {
        DateTimeFormatter formatter = null;

        if (null != dateStyle
                && null != timeStyle) {

            formatter = DateTimeFormatter.ofLocalizedDateTime(
                    dateStyle,
                    timeStyle
            );
        }

        return this.map(
                s,
                formatter,
                defaultValue
        );
    }

}
