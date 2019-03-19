package de.ckraus.commons.utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings({ "javadoc", "unused", "WeakerAccess" })
public class CharacterUtilities
        extends AbstractUtilities<Character>
        implements ICharacterUtilities {

    private final static String CLASS   = CharacterUtilities.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(CharacterUtilities.class);


    /**
     * Constructor
     */
    public CharacterUtilities() {
        super();
    }


}
