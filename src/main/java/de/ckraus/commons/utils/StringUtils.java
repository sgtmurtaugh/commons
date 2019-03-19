package de.ckraus.commons.utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"javadoc", "unused"})
public class StringUtils
        extends AbstractUtils<String>
        implements IStringUtils {

    private final static String CLASS   = StringUtils.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(StringUtils.class);


    /**
     * Constructor
     */
    public StringUtils() {
        super();
    }

}
