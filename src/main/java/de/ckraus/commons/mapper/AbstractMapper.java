package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"WeakerAccess"})
public abstract class AbstractMapper<E>
        implements IMapper<E> {

    private final static String CLASS   = AbstractMapper.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(AbstractMapper.class);

    private E defaultValue;


    /**
     * Constructor
     */
    public AbstractMapper() {
        this(null);
    }

    /**
     * Constructor
     * @param defaultValue
     */
    public AbstractMapper(E defaultValue) {
        super();
        this.setDefaultValue(defaultValue);
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
