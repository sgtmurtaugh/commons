package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"WeakerAccess", "javadoc"})
public abstract class AbstractTypeMapper<E>
        implements ITypeMapper<E> {

    private final static String CLASS   = AbstractTypeMapper.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(AbstractTypeMapper.class);

    private final E defaultValue;

    private final boolean emptyStringNull;
    private final boolean trimStrings;


    /**
     * Constructor
     */
    public AbstractTypeMapper() {
        this(null);
    }

    /**
     * Constructor
     * @param defaultValue
     */
    public AbstractTypeMapper(E defaultValue) {
        super();

        this.defaultValue       = defaultValue;
        this.trimStrings       = ITypeMapper.super.isTrimStrings();
        this.emptyStringNull   = ITypeMapper.super.isEmptyStringNull();
    }

    /**
     * Constructor
     * @param defaultValue
     * @param bTrimStrings
     * @param bEmptyStringNull
     */
    public AbstractTypeMapper(
            E defaultValue,
            boolean bTrimStrings,
            boolean bEmptyStringNull
    ) {
        super();

        this.defaultValue       = defaultValue;
        this.trimStrings       = bTrimStrings;
        this.emptyStringNull   = bEmptyStringNull;
    }


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

    @Override
    public E map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull,
            E defaultValue
    ) {
        return defaultValue;
    }


}
