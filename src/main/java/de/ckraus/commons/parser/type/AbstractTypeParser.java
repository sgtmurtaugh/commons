package de.ckraus.commons.parser.type;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by gandalf on 16.03.14.
 */
public abstract class AbstractTypeParser<E>
    implements ITypeParser<E> {

    private final static String CLASS   = AbstractTypeParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger( AbstractTypeParser.class );

    private final boolean m_defaultTrimStrings;
    private final boolean m_defaultEmptyIsNull;

    private final E m_defaultValue;


    /**
     * Constructor
     */
    public AbstractTypeParser() {
        this ( null );
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public AbstractTypeParser(E defaultValue) {
        this(
                defaultValue,
                Boolean.TRUE,
                Boolean.TRUE
        );
    }

    /**
     * Constructor
     * @param defaultTrimStrings - default flag for string handling
     * @param defaultEmptyIsNull - default flag for empty string handling
     */
    public AbstractTypeParser(
            boolean defaultTrimStrings,
            boolean defaultEmptyIsNull
    ) {
        this(
                ( E ) null,
                defaultTrimStrings,
                defaultEmptyIsNull
        );
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     * @param defaultTrimStrings - default flag for string handling
     * @param defaultEmptyIsNull - default flag for empty string handling
     */
    public AbstractTypeParser(
            E defaultValue,
            boolean defaultTrimStrings,
            boolean defaultEmptyIsNull
    ) {
        super ();
        this.m_defaultValue = defaultValue;
        this.m_defaultTrimStrings = defaultTrimStrings;
        this.m_defaultEmptyIsNull= defaultEmptyIsNull;
    }


    /* ### getter- / setter-Methods ### */


    public E getDefaultValue () {
        return this.m_defaultValue;
    }

    public boolean getDefaultEmptyIsNull () {
        return this.m_defaultEmptyIsNull;
    }

    public boolean getDefaultTrimStrings () {
        return this.m_defaultTrimStrings;
    }


    /* ### Interface Implementations ### */


    /**
     * @see ITypeParser#isParsable(Object)
     */
    public boolean isParsable( Object obj ) {
        return ( null != this.parse( obj, null ) );
    }

    /**
     * @see ITypeParser#parse(Map, Object)
     */
    public <K> E parse(
            Map<K, ?> map,
            K key
    ) {
        return this.parse(
                map,
                key,
                this.getDefaultValue()
        );
    }

    /**
     * @see ITypeParser#parse(Map, Object, Object)
     */
    public <K> E parse(
            Map<K, ?> map,
            K key,
            E defaultValue
    ) {
        E retVal = defaultValue;

        if ( null == map ) {
            log.debug("map param is null.");
        }
        else
        if ( null == key ) {
            log.debug("key param is null.");
        }
        else
        if ( ! map.containsKey(key) ) {
            log.debug("map param does not contains the key param.");
        }
        else {
            retVal = this.parse(
                    map.get(key),
                    defaultValue
            );
        }
        return retVal;
    }

    /**
     * @see ITypeParser#parse(Object)
     */
    public E parse( Object obj ) {
        return this.parse(
                obj,
                this.getDefaultValue()
        );
    }

    /**
     * @see ITypeParser#parse(Object, Object)
     * <p>This default implementation only return the defaultValue param.</p>
     */
    public E parse(
            Object obj,
            E defaultValue
    ) {
        E retVal = defaultValue;

        if ( null == obj ) {
            log.debug("obj param is null.");
        }
        else
        if ( obj instanceof String ) {
            log.debug("obj param is String instance.");
            retVal = this.parse(
                    (String) obj,
                    defaultValue
            );
        }
        else {
            log.debug("toString method is executed on obj param.");
            retVal = this.parse(
                    obj.toString(),
                    defaultValue
            );
        }
        return retVal;
    }

    /**
     * @see ITypeParser#parse(String)
     */
    public E parse( String s ) {
        return this.parse(
                s,
                this.getDefaultValue()
        );
    }

    /**
     * @see ITypeParser#parse(String, Object)
     * <p>This default implementation only return the defaultValue param.</p>
     */
    public E parse(
            String s,
            E defaultValue
    ) {
        return defaultValue;
    }

    /* ### additional Methods ### */

    /**
     * prepareStringToParse
     * @param s the string to prepare if necessary
     * @param bTrim flag for trimming the string
     * @param bEmptyIsNull flag for using null, when the given string is empty
     * @return a prepared String for parsing. The flags are evaluated and the string is reworked if necessary. When the
     * trim param is true, trim is performed on the string. When the string is empty and the emptyIsNull param is
     * true, null will be returned.
     */
    protected String prepareStringToParse(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull
    ) {
        String sRetVal = s;

        if ( null != sRetVal ) {
            if ( bTrim ) {
                sRetVal = sRetVal.trim();
            }
            if ( bEmptyIsNull ) {
                if ( sRetVal.isEmpty() ) {
                    sRetVal = null;
                }
            }

        }
        return sRetVal;
    }

    public String toString () {
        return new ToStringBuilder ( this )
                .appendSuper( super.toString() )
                .append("defaultValue", m_defaultValue)
                .append("defaultEmptyIsNull", m_defaultEmptyIsNull )
                .append("defaultTrimStrings", m_defaultTrimStrings )
                .toString();
    }


}
