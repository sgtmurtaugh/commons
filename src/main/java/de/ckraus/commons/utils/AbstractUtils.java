package de.ckraus.commons.utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"WeakerAccess", "javadoc"})
public abstract class AbstractUtils<E>
        implements IUtils<E> {

    private final static String CLASS   = AbstractUtils.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(AbstractUtils.class);


    /**
     * Constructor
     */
    public AbstractUtils() {
        super();
    }

}
