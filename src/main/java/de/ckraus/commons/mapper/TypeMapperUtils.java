package de.ckraus.commons.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by ckraus on 07.08.15.
 */
@SuppressWarnings({"WeakerAccess", "javadoc", "unused"})
public class TypeMapperUtils {

    private final static String CLASS = TypeMapperUtils.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(TypeMapperUtils.class);

    private static TypeMapperUtils typeMapperUtils;

    private ConcurrentMap<Class<? extends ITypeMapper>, ITypeMapper> mapMappers = null;

    private DefaultTypeMappers defaultTypeMappers;


    /**
     * Constructor
     */
    private TypeMapperUtils() {
        super();
    }

    /**
     * getInstance
     * @return
     */
    private static synchronized TypeMapperUtils getInstance() {
        if (null == typeMapperUtils) {
            typeMapperUtils = new TypeMapperUtils();
        }
        return typeMapperUtils;
    }


    /* ### getter- / setter-Methods ############ */


    /**
     * getRegistered
     * @return
     */
    public static ConcurrentMap<Class<? extends ITypeMapper>, ITypeMapper> getRegistered() {
        return getInstance().getRegisteredTypeMappers();
    }

    /**
     * getRegisteredTypeMappers
     * @return
     */
    public ConcurrentMap<Class<? extends ITypeMapper>, ITypeMapper> getRegisteredTypeMappers() {
        if ( null == mapMappers ) {
            this.setRegisteredTypeMappers(
                    new ConcurrentHashMap<>()
            );
        }
        return mapMappers;
    }

    /**
     * setRegisteredTypeMappers
     * @param mapMappers
     */
    protected void setRegisteredTypeMappers(
            ConcurrentMap<Class<? extends ITypeMapper>, ITypeMapper> mapMappers) {
        this.mapMappers = mapMappers;
    }


    /* ### additional Methods ############ */


    /**
     * addRegisteredTypeMapper
     * @param typeMapper
     */
    protected ITypeMapper addRegisteredTypeMapper(ITypeMapper typeMapper) {
        if (null != typeMapper) {
            this.getRegisteredTypeMappers().put(
                    typeMapper.getClass(),
                    typeMapper
            );
        }
        return typeMapper;
    }

    /**
     * getDefaults
     * @return
     */
    public static DefaultTypeMappers getDefaults() {
        return getInstance().getDefaultTypeMappers();
    }

    /**
     * getDefaultTypeMappers
     * @return
     */
    public DefaultTypeMappers getDefaultTypeMappers() {
        if (null == defaultTypeMappers) {
            defaultTypeMappers = new DefaultTypeMappers();
        }
        return this.defaultTypeMappers;
    }

    /**
     * get
     * @param clazzTypeMapper
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T extends ITypeMapper> T get(Class<T> clazzTypeMapper ) {
        return (T) getInstance().getTypeMapper(clazzTypeMapper);
    }

    /**
     * getTypeMapper
     * @param clazzTypeMapper
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends ITypeMapper> T getTypeMapper(Class<? extends ITypeMapper> clazzTypeMapper ) {
        final String METHOD = CLASS + ".getTypeMapper(Class<? extends ITypeMapper>)";
//        log.logEnter(METHOD, clazzTypeMapper);

        T typeMapper = null;

        if ( null != clazzTypeMapper) {
            if ( this.getRegisteredTypeMappers().containsKey( clazzTypeMapper ) ) {
                typeMapper = (T) this.getRegisteredTypeMappers().get(clazzTypeMapper);
            }
            else {
                try {
                    typeMapper = (T) this.addRegisteredTypeMapper(
                            clazzTypeMapper.newInstance()
                    );
                }
                catch ( InstantiationException | IllegalAccessException e ) {
                    e.printStackTrace();
                }
            }
        }
//        log.logReturn(METHOD, typeMapper);
        return typeMapper;
    }


    /**
     * Static Nested Class DefaultTypeMappers
     */
    public final static class DefaultTypeMappers {

        /**
         * Constructor
         */
        private DefaultTypeMappers() {
            super();
        }

        /**
         * getBigDecimalMapper
         * @return
         */
        public BigDecimalMapper getBigDecimalMapper() {
            return getInstance().getTypeMapper( BigDecimalMapper.class );
        }

        /**
         * getBigIntegerMapper
         * @return
         */
        public BigIntegerMapper getBigIntegerMapper() {
            return getInstance().getTypeMapper( BigIntegerMapper.class );
        }

        /**
         * getBooleanMapper
         * @return
         */
        public BooleanMapper getBooleanMapper() {
            return getInstance().getTypeMapper( BooleanMapper.class );
        }

        /**
         * getByteMapper
         * @return
         */
        public ByteMapper getByteMapper() {
            return getInstance().getTypeMapper( ByteMapper.class );
        }

        /**
         * getGregorianCalendarParser
         * @return
         */
        public GregorianCalendarMapper getGregorianCalendarParser() {
            return getInstance().getTypeMapper( GregorianCalendarMapper.class );
        }

        /**
         * getCharacterMapper
         * @return
         */
        public CharacterMapper getCharacterMapper() {
            return getInstance().getTypeMapper( CharacterMapper.class );
        }


        /**
         * getDateMapper
         * @return
         */
        public DateMapper getDateMapper() {
            return getInstance().getTypeMapper( DateMapper.class );
        }

        /**
         * getDoubleMapper
         * @return
         */
        public DoubleMapper getDoubleMapper() {
            return getInstance().getTypeMapper( DoubleMapper.class );
        }

        /**
         * getFloatMapper
         * @return
         */
        public FloatMapper getFloatMapper() {
            return getInstance().getTypeMapper( FloatMapper.class );
        }

        /**
         * getIntegerMapper
         * @return
         */
        public IntegerMapper getIntegerMapper() {
            return getInstance().getTypeMapper( IntegerMapper.class );
        }

        /**
         * getLocalDateMapper
         * @return
         */
        public LocalDateMapper getLocalDateMapper() {
            return getInstance().getTypeMapper( LocalDateMapper.class );
        }

        /**
         * getLocalDateTimeMapper
         * @return
         */
        public LocalDateTimeMapper getLocalDateTimeMapper() {
            return getInstance().getTypeMapper( LocalDateTimeMapper.class );
        }

        /**
         * getLocalTimeMapper
         * @return
         */
        public LocalTimeMapper getLocalTimeMapper() {
            return getInstance().getTypeMapper( LocalTimeMapper.class );
        }

        /**
         * getLongMapper
         * @return
         */
        public LongMapper getLongMapper() {
            return getInstance().getTypeMapper( LongMapper.class );
        }

        /**
         * getShortMapper
         * @return
         */
        public ShortMapper getShortMapper() {
            return getInstance().getTypeMapper( ShortMapper.class );
        }

        /**
         * getStringMapper
         * @return
         */
        public StringMapper getStringMapper() {
            return getInstance().getTypeMapper( StringMapper.class );
        }
    }
}
