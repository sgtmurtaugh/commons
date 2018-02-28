package de.ckraus.commons.mapper;

import de.ckraus.commons.parser.type.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by ckraus on 07.08.15.
 */
@SuppressWarnings({ "unused" })
public class TypeMapperUtils {

    private final static String CLASS = TypeMapperUtils.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(TypeMapperUtils.class);

    private ConcurrentMap<Class<? extends IMapper<?>>, IMapper<?>> mapMappers = null;


    /**
     * Constructor
     */
    public TypeMapperUtils() {
        super();
    }


    /* ### getter- / setter-Methods ############ */


    public ConcurrentMap<Class<? extends IMapper<?>>, IMapper<?>> getRegisteredTypeMappers() {
        if ( null == mapMappers ) {
            this.setRegisteredTypeMappers(
                    new ConcurrentHashMap<Class<? extends IMapper<?>>, IMapper<?>>()
            );
        }
        return mapMappers;
    }

    public void setRegisteredTypeMappers(
            ConcurrentMap<Class<? extends IMapper<?>>, IMapper<?>> mapMappers) {
        this.mapMappers = mapMappers;
    }


    /* ### additional Methods ############ */


    @SuppressWarnings( "unchecked" )
    public <T extends IMapper<?>> T getTypeMapper( Class<? extends IMapper<?>> clazzTypeMapper ) {
        IMapper<?> typeMapper = null;

        if ( null != clazzTypeMapper) {
            if ( this.getRegisteredTypeMappers().containsKey( clazzTypeMapper ) ) {
                typeMapper = this.getRegisteredTypeMappers().get(clazzTypeMapper);
            }
            else {
                try {
                    typeMapper = clazzTypeMapper.newInstance();

                    this.getRegisteredTypeMappers().put(
                            clazzTypeMapper,
                            typeMapper
                    );
                }
                catch ( InstantiationException | IllegalAccessException e ) {
                    e.printStackTrace();
                }
            }
        }
        return ( T ) typeMapper;
    }

    public BigDecimalMapper getBigDecimalMapper() {
        return this.getTypeMapper( BigDecimalMapper.class );
    }

    public BigIntegerMapper getBigIntegerMapper() {
        return this.getTypeMapper( BigIntegerMapper.class );
    }

    public BooleanMapper getBooleanMapper() {
        return this.getTypeMapper( BooleanMapper.class );
    }

    public ByteMapper getByteMapper() {
        return this.getTypeMapper( ByteMapper.class );
    }

//    TODO
//    public GregorianCalendarMapper getGregorianCalendarParser() {
//        return this.getTypeMapper( GregorianCalendarMapper.class );
//    }

    public CharacterMapper getCharacterMapper() {
        return this.getTypeMapper( CharacterMapper.class );
    }

//    TODO
//    public DateMapper getDateMapper() {
//        return this.getTypeMapper( DateMapper.class );
//    }

    public DoubleMapper getDoubleMapper() {
        return this.getTypeMapper( DoubleMapper.class );
    }

    public FloatMapper getFloatMapper() {
        return this.getTypeMapper( FloatMapper.class );
    }

    public IntegerMapper getIntegerMapper() {
        return this.getTypeMapper( IntegerMapper.class );
    }

    public LongMapper getLongMapper() {
        return this.getTypeMapper( LongMapper.class );
    }

    public ShortMapper getShortMapper() {
        return this.getTypeMapper( ShortMapper.class );
    }

    public StringMapper getStringMapper() {
        return this.getTypeMapper( StringMapper.class );
    }

}
