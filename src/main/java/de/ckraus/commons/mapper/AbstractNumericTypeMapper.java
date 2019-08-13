package de.ckraus.commons.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter( AccessLevel.PROTECTED )
@SuppressWarnings( { "WeakerAccess", "javadoc", "unused" } )
public abstract class AbstractNumericTypeMapper<E extends Number> extends AbstractTypeMapper<E>
        implements INumericTypeMapper<E> {

    private final static String CLASS = AbstractNumericTypeMapper.class.getSimpleName();


    /**
     * Constructor
     */
    public AbstractNumericTypeMapper() {
        super();
    }

    /**
     * Constructor
     *
     * @param defaultValue
     */
    public AbstractNumericTypeMapper( E defaultValue ) {
        super( defaultValue );
    }

    /**
     * Constructor
     *
     * @param defaultValue
     * @param bTrimStrings
     * @param bEmptyStringNull
     */
    public AbstractNumericTypeMapper( E defaultValue, boolean bTrimStrings, boolean bEmptyStringNull ) {
        super( defaultValue, bTrimStrings, bEmptyStringNull );
    }

}
