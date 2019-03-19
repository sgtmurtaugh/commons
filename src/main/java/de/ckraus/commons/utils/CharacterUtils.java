package de.ckraus.commons.utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({"javadoc", "unused"})
public class CharacterUtils
        extends AbstractUtils<Character>
        implements ICharacterUtils {

    private final static String CLASS   = CharacterUtils.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(CharacterUtils.class);


    /**
     * Constructor
     */
    public CharacterUtils() {
        super();
    }


}
