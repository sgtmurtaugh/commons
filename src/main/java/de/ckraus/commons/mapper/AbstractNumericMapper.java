package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class AbstractNumericMapper<E extends Number>
        extends AbstractMapper<E>
        implements INumericMapper<E> {

    private final static String CLASS   = AbstractNumericMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(AbstractNumericMapper.class);


    /**
     * Constructor
     */
    public AbstractNumericMapper() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue
     */
    public AbstractNumericMapper(E defaultValue) {
        super(defaultValue);
    }


}
