package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter( AccessLevel.PROTECTED )
@SuppressWarnings( { "javadoc", "unused" } )
public class StringMapper extends AbstractTypeMapper<String> implements IStringMapper {

    private final static String CLASS = StringMapper.class.getSimpleName();
    //    protected static Logger log = LoggerFactory.getLogger(StringMapper.class);


    /**
     * Constructor
     */
    public StringMapper() {
        super();
    }

    /**
     * Constructor
     *
     * @param defaultValue
     */
    public StringMapper( String defaultValue ) {
        super( defaultValue );
    }

}
