package de.ckraus.commons.parser.type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by ckraus on 09.08.15.
 */
public abstract class AbstractAlphaTypeParser<E>
    extends AbstractTypeParser<E>
    implements IAlphaTypeParser<E> {

    private final static String CLASS   = AbstractAlphaTypeParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(AbstractAlphaTypeParser.class);

    /**
     * Constructor
     */
    public AbstractAlphaTypeParser() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public AbstractAlphaTypeParser(E defaultValue) {
        super( defaultValue );
    }

    /**
     * Constructor
     * @param defaultTrimStrings - default flag for string handling
     * @param defaultEmptyIsNull - default flag for empty string handling
     */
    public AbstractAlphaTypeParser(
            boolean defaultTrimStrings,
            boolean defaultEmptyIsNull
    ) {
        super(
                null,
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
    public AbstractAlphaTypeParser(
            E defaultValue,
            boolean defaultTrimStrings,
            boolean defaultEmptyIsNull
    ) {
        super (
                defaultValue,
                defaultTrimStrings,
                defaultEmptyIsNull
        );
    }

    /* ### getter- / setter-Methods ### */




    /* ### Interface Implementations ### */


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
     * @see ITypeParser#parse(String, Object)
     */
    public E parse(
            String s,
            E defaultValue
    ) {
        return this.parse(
                s,
                defaultValue,
                this.getDefaultTrimStrings(),
                this.getDefaultEmptyIsNull()
        );
    }

    /**
     * @see IAlphaTypeParser#parse(String, boolean, boolean)
     */
    public E parse(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull
    ) {
        return this.parse(
                s,
                this.getDefaultValue(),
                bTrim,
                bEmptyIsNull
        );
    }

    /**
     * @see IAlphaTypeParser#parse(String, Object, boolean, boolean)
     * <p>This default implementation only return the defaultValue param.</p>
     */
    public E parse(
            String s,
            E defaultValue,
            boolean bTrim,
            boolean bEmptyIsNull
    ) {
        return defaultValue;
    }

}
