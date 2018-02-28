package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public class CharacterMapper
        extends AbstractMapper<Character>
        implements IMapper<Character> {

    private final static String CLASS   = CharacterMapper.class.getSimpleName();
//    protected static Logger log = LoggerFactory.getLogger(CharacterMapper.class);

}
