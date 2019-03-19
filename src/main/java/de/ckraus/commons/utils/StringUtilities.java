package de.ckraus.commons.utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({ "javadoc", "unused", "WeakerAccess" })
public class StringUtilities
        extends AbstractUtilities<String>
        implements IStringUtilities {

    private final static String CLASS   = StringUtilities.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(StringUtilities.class);


    /**
     * Constructor
     */
    public StringUtilities() {
        super();
    }

}
