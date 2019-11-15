package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter( AccessLevel.PROTECTED )
@SuppressWarnings( { "javadoc", "unused" } )
public class CharacterMapper extends AbstractTypeMapper<Character> implements ICharacterMapper {

    private final static String CLASS = CharacterMapper.class.getSimpleName();
    //    protected static Logger log = LoggerFactory.getLogger(CharacterMapper.class);

    private final boolean evaluateCodePoints;


    /**
     * Constructor
     */
    public CharacterMapper() {
        this( null );
    }

    /**
     * Constructor
     */
    public CharacterMapper( Character defaultValue ) {
        super( defaultValue );

        this.evaluateCodePoints = ICharacterMapper.super.isEvaluateCodePoints();
    }

    /**
     * Constructor
     *
     * @param bIsEvaluateCodePoints
     */
    public CharacterMapper( boolean bIsEvaluateCodePoints ) {
        this( null, bIsEvaluateCodePoints );
    }

    /**
     * Constructor
     *
     * @param defaultValue
     * @param bIsEvaluateCodePoints
     */
    public CharacterMapper( Character defaultValue, boolean bIsEvaluateCodePoints ) {
        super( defaultValue );

        this.evaluateCodePoints = bIsEvaluateCodePoints;
    }

    @Override
    public boolean isEvaluateCodePoints() {
        return this.evaluateCodePoints;
    }

}
