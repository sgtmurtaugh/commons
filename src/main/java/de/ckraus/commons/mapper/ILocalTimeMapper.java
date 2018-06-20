package de.ckraus.commons.mapper;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

@SuppressWarnings({ "javadoc", "unused" })
public interface ILocalTimeMapper
    extends ITemporalTypeMapper<LocalTime> {

    /**
     * map
     * @param s
     * @param formatter
     * @param defaultValue
     * @return
     */
    @Override
    default LocalTime map(
            String s,
            DateTimeFormatter formatter,
            LocalTime defaultValue
    ) {
        LocalTime localTime = defaultValue;

        if (StringUtils.isNotEmpty(s)) {
            if (null != formatter) {
                try {
                    localTime = LocalTime.parse(
                            s,
                            formatter
                    );
                }
                catch (DateTimeParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return localTime;
    }

    /**
     * map
     * @param s
     * @param formatStyle
     * @param defaultValue
     * @return
     */
    @Override
    default LocalTime map(
            String s,
            FormatStyle formatStyle,
            LocalTime defaultValue
    ) {
        DateTimeFormatter formatter = null;

        if (null != formatStyle) {
            formatter = DateTimeFormatter.ofLocalizedTime(formatStyle);
        }

        return this.map(
                s,
                formatter,
                defaultValue
        );
    }

}
