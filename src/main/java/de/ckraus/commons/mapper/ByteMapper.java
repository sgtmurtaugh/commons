package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter( AccessLevel.PROTECTED )
@SuppressWarnings( { "javadoc", "unused" } )
public class ByteMapper extends AbstractNumericTypeMapper<Byte> implements IByteMapper {

    private final static String CLASS = ByteMapper.class.getSimpleName();
    //    protected static Logger log = LoggerFactory.getLogger(ByteMapper.class);


    /**
     * Constructor
     */
    public ByteMapper() {
        super();
    }

    /**
     * Constructor
     *
     * @param defaultValue
     */
    public ByteMapper( Byte defaultValue ) {
        super( defaultValue );
    }

}
