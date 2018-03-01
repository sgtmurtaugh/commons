package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public class CharacterMapper
        extends AbstractTypeMapper<Character>
        implements ITypeMapper<Character> {

    private final static String CLASS   = CharacterMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(CharacterMapper.class);


    /**
     * Constructor
     */
    public CharacterMapper() {
        super();
    }

}
