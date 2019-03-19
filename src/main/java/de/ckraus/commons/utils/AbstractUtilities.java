package de.ckraus.commons.utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({ "javadoc", "unused", "WeakerAccess" })
public abstract class AbstractUtilities<E>
        implements IUtilities<E> {

    private final static String CLASS   = AbstractUtilities.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(AbstractUtilities.class);


    /**
     * Constructor
     */
    public AbstractUtilities() {
        super();
    }

}
