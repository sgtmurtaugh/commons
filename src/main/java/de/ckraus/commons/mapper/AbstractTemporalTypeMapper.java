package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.temporal.Temporal;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"WeakerAccess", "javadoc", "unused"})
public abstract class AbstractTemporalTypeMapper<E extends Temporal>
        extends AbstractTypeMapper<E>
        implements ITemporalTypeMapper<E> {

    private final static String CLASS   = AbstractTemporalTypeMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(AbstractNumericTypeMapper.class);


    /**
     * Constructor
     */
    public AbstractTemporalTypeMapper() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue
     */
    public AbstractTemporalTypeMapper(E defaultValue) {
        super(defaultValue);
    }

    /**
     * Constructor
     * @param defaultValue
     * @param bTrimStrings
     * @param bEmptyStringNull
     */
    public AbstractTemporalTypeMapper(
            E defaultValue,
            boolean bTrimStrings,
            boolean bEmptyStringNull
    ) {
        super(
                defaultValue,
                bTrimStrings,
                bEmptyStringNull
        );
    }

}
