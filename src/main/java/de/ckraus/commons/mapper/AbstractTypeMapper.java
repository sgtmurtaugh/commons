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

        this.defaultValue      = defaultValue;
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

        this.defaultValue      = defaultValue;
        this.trimStrings       = bTrimStrings;
        this.emptyStringNull   = bEmptyStringNull;
    }

}
