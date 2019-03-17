package de.ckraus.commons.mapper;

import de.ckraus.commons.CommonsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by ckraus on 07.08.15.
 */
@SuppressWarnings({"WeakerAccess", "javadoc", "unused"})
public class TypeMapperUtils {

    private final static String CLASS = TypeMapperUtils.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(TypeMapperUtils.class);

    private static TypeMapperUtils instance = null;

    private ConcurrentMap<Class<? extends ITypeMapper>, ITypeMapper> mapRegistredTypeMappers = null;

    private DefaultTypeMappers defaultTypeMappers = null;


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
    protected static synchronized TypeMapperUtils getInstance() {
        if (null == instance) {
            // TODO Application Context ermitteln nicht erzeugen!
            try {
                ApplicationContext context = CommonsUtils.getInstance().getApplicationContext();
                instance = (TypeMapperUtils) context.getBean("typeMapperUtils");
            }
            catch (BeansException be) {
                // TODO: logging
            }

            if (null == instance) {
                // TODO: logging
                instance = new TypeMapperUtils();
            }
        }
        return instance;
    }


    /* ### getter- / setter-Methods ############ */


    /**
     * get
     * @return
     */
    public static <T extends ITypeMapper<?>> T get( Class<T> clazz ) {
        final String METHOD = CLASS + ".get(Class<T>)";

        T mapper = null;

        if ( null != clazz ) {
            mapper = clazz.cast(
                    getInstance().getTypeMapper( clazz )
            );
        }
        return mapper;
    }

    /**
     * getRegisteredTypeMappers
     * @return
     */
    public ConcurrentMap<Class<? extends ITypeMapper>, ITypeMapper> getRegisteredTypeMappers() {
        if ( null == mapRegistredTypeMappers ) {
//            this.setRegisteredTypeMappers(
//                    new ConcurrentHashMap<>()
//            );
            mapRegistredTypeMappers = new ConcurrentHashMap<>();
        }
        return mapRegistredTypeMappers;
    }

    /**
     * setRegisteredTypeMappers
     * @param mapMappers
     */
    private void setRegisteredTypeMappers(
            ConcurrentMap<Class<? extends ITypeMapper>, ITypeMapper> mapMappers) {
        this.mapRegistredTypeMappers = mapMappers;
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
        return defaultTypeMappers;
    }

    /**
     * getTypeMapper
     * @param clazzTypeMapper
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends ITypeMapper> T getTypeMapper(Class<T> clazzTypeMapper ) {
        final String METHOD = CLASS + ".getTypeMapper(Class<T>)";
//        log.logEnter(METHOD, clazzTypeMapper);

        T typeMapper = null;

        if ( null != clazzTypeMapper) {
            if ( this.getRegisteredTypeMappers().containsKey( clazzTypeMapper ) ) {
                typeMapper = (T) this.getRegisteredTypeMappers().get(clazzTypeMapper);
            }
            else {
                try {
                    typeMapper = (T) this.addRegisteredTypeMapper(
                            clazzTypeMapper.getDeclaredConstructor().newInstance()
                    );
                }
                catch ( InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e ) {
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
    public class DefaultTypeMappers {

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
            return get( BigDecimalMapper.class );
        }

        /**
         * getBigIntegerMapper
         * @return
         */
        public BigIntegerMapper getBigIntegerMapper() {
            return get( BigIntegerMapper.class );
        }

        /**
         * getBooleanMapper
         * @return
         */
        public BooleanMapper getBooleanMapper() {
            return get( BooleanMapper.class );
        }

        /**
         * getByteMapper
         * @return
         */
        public ByteMapper getByteMapper() {
            return get( ByteMapper.class );
        }

        /**
         * getCharacterMapper
         * @return
         */
        public CharacterMapper getCharacterMapper() {
            return get( CharacterMapper.class );
        }

        /**
         * getDateMapper
         * @return
         */
        public DateMapper getDateMapper() {
            return get( DateMapper.class );
        }

        /**
         * getDoubleMapper
         * @return
         */
        public DoubleMapper getDoubleMapper() {
            return get( DoubleMapper.class );
        }

        /**
         * getFloatMapper
         * @return
         */
        public FloatMapper getFloatMapper() {
            return get( FloatMapper.class );
        }

        /**
         * getGregorianCalendarMapper
         * @return
         */
        public GregorianCalendarMapper getGregorianCalendarMapper() {
            return get( GregorianCalendarMapper.class );
        }

        /**
         * getIntegerMapper
         * @return
         */
        public IntegerMapper getIntegerMapper() {
            return get( IntegerMapper.class );
        }

        /**
         * getLocalDateMapper
         * @return
         */
        public LocalDateMapper getLocalDateMapper() {
            return get( LocalDateMapper.class );
        }

        /**
         * getLocalDateTimeMapper
         * @return
         */
        public LocalDateTimeMapper getLocalDateTimeMapper() {
            return get( LocalDateTimeMapper.class );
        }

        /**
         * getLocalTimeMapper
         * @return
         */
        public LocalTimeMapper getLocalTimeMapper() {
            return get( LocalTimeMapper.class );
        }

        /**
         * getLongMapper
         * @return
         */
        public LongMapper getLongMapper() {
            return get( LongMapper.class );
        }

        /**
         * getShortMapper
         * @return
         */
        public ShortMapper getShortMapper() {
            return get( ShortMapper.class );
        }

        /**
         * getStringMapper
         * @return
         */
        public StringMapper getStringMapper() {
            return get( StringMapper.class );
        }
    }

}
