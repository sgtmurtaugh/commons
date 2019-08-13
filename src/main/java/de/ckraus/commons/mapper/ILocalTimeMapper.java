package de.ckraus.commons.mapper;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

@SuppressWarnings( { "javadoc", "unused" } )
public interface ILocalTimeMapper extends ITemporalTypeMapper<LocalTime> {

    /**
     * map
     *
     * @param s
     *         - string to map
     * @param bTrim
     *         - default flag for string handling
     * @param bEmptyIsNull
     *         - default flag for empty string handling
     * @param defaultValue
     *         - The default value
     *
     * @return <p>Delegates to {@link #map(String, DateTimeFormatter, LocalTime)} with {@link
     *         DateTimeFormatter#ISO_TIME}
     */
    @Override
    default LocalTime map( String s, boolean bTrim, boolean bEmptyIsNull, LocalTime defaultValue ) {
        return this.map( this.prepareStringToMap( s, bTrim, bEmptyIsNull ), DateTimeFormatter.ISO_TIME, defaultValue );
    }

    /**
     * map
     *
     * @param s
     * @param formatter
     * @param defaultValue
     *
     * @return
     */
    @Override
    default LocalTime map( String s, DateTimeFormatter formatter, LocalTime defaultValue ) {
        LocalTime localTime = defaultValue;
        String preparedString = this.prepareStringToMap( s, this.isTrimStrings(), this.isEmptyStringNull() );

        if ( StringUtils.isNotEmpty( preparedString ) ) {
            if ( null != formatter ) {
                try {
                    localTime = LocalTime.parse( preparedString, formatter );
                } catch ( DateTimeParseException e ) {
                    e.printStackTrace();
                }
            }
        }
        return localTime;
    }

    /**
     * map
     *
     * @param s
     * @param formatStyle
     * @param defaultValue
     *
     * @return
     */
    @Override
    default LocalTime map( String s, FormatStyle formatStyle, LocalTime defaultValue ) {
        DateTimeFormatter formatter = null;

        if ( null != formatStyle ) {
            formatter = DateTimeFormatter.ofLocalizedTime( formatStyle );
        }

        return this.map( s, formatter, defaultValue );
    }

}
