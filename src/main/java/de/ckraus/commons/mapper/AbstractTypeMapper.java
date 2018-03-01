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

    private final boolean bEmptyStringNull;
    private final boolean bTrimStrings;


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
        this.bTrimStrings       = ITypeMapper.super.isTrimStrings();
        this.bEmptyStringNull   = ITypeMapper.super.isEmptyStringNull();
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
        this.bTrimStrings       = bTrimStrings;
        this.bEmptyStringNull   = bEmptyStringNull;
    }


    /**
     * isTrimStrings
     * @return
     */
    public boolean isTrimStrings() {
        return ITypeMapper.super.isTrimStrings();
    }

    /**
     * isEmptyStringNull
     * @return
     */
    public boolean isEmptyStringNull() {
        return ITypeMapper.super.isEmptyStringNull();
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
