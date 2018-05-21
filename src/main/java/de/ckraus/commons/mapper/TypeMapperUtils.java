package de.ckraus.commons.mapper;

import de.ckraus.commons.CommonsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by ckraus on 07.08.15.
 */
@SuppressWarnings({"WeakerAccess", "javadoc", "unused"})
public class TypeMapperUtils {

    private final static String CLASS = TypeMapperUtils.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(TypeMapperUtils.class);

    private ConcurrentMap<Class<? extends ITypeMapper>, ITypeMapper> mapRegistredTypeMappers = null;

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
    public static synchronized TypeMapperUtils getInstance() {
        // TODO Application Context ermitteln nicht erzeugen!
        TypeMapperUtils typeMapperUtils = null;

        try {
            ApplicationContext context = CommonsUtils.getInstance().getApplicationContext();
            typeMapperUtils = (TypeMapperUtils) context.getBean("typeMapperUtils");
        }
        catch (BeansException be) {
            // TODO: logging
        }

        if (null == typeMapperUtils) {
            // TODO: logging
            typeMapperUtils = new TypeMapperUtils();
        }
        return typeMapperUtils;
    }


    /* ### getter- / setter-Methods ############ */


    /**
     * getRegisteredTypeMappers
     * @return
     */
    public ConcurrentMap<Class<? extends ITypeMapper>, ITypeMapper> getRegisteredTypeMappers() {
        if ( null == mapRegistredTypeMappers ) {
            this.setRegisteredTypeMappers(
                    new ConcurrentHashMap<>()
            );
        }
        return mapRegistredTypeMappers;
    }

    /**
     * setRegisteredTypeMappers
     * @param mapMappers
     */
    protected void setRegisteredTypeMappers(
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
        return this.defaultTypeMappers;
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
            return getTypeMapper( BigDecimalMapper.class );
        }

        /**
         * getBigIntegerMapper
         * @return
         */
        public BigIntegerMapper getBigIntegerMapper() {
            return getTypeMapper( BigIntegerMapper.class );
        }

        /**
         * getBooleanMapper
         * @return
         */
        public BooleanMapper getBooleanMapper() {
            return getTypeMapper( BooleanMapper.class );
        }

        /**
         * getByteMapper
         * @return
         */
        public ByteMapper getByteMapper() {
            return getTypeMapper( ByteMapper.class );
        }

        /**
         * getCharacterMapper
         * @return
         */
        public CharacterMapper getCharacterMapper() {
            return getTypeMapper( CharacterMapper.class );
        }


        /**
         * getDateMapper
         * @return
         */
        public DateMapper getDateMapper() {
            return getTypeMapper( DateMapper.class );
        }

        /**
         * getDoubleMapper
         * @return
         */
        public DoubleMapper getDoubleMapper() {
            return getTypeMapper( DoubleMapper.class );
        }

        /**
         * getFloatMapper
         * @return
         */
        public FloatMapper getFloatMapper() {
            return getTypeMapper( FloatMapper.class );
        }

        /**
         * getGregorianCalendarParser
         * @return
         */
        public GregorianCalendarMapper getGregorianCalendarParser() {
            return getTypeMapper( GregorianCalendarMapper.class );
        }

        /**
         * getIntegerMapper
         * @return
         */
        public IntegerMapper getIntegerMapper() {
            return getTypeMapper( IntegerMapper.class );
        }

        /**
         * getLocalDateMapper
         * @return
         */
        public LocalDateMapper getLocalDateMapper() {
            return getTypeMapper( LocalDateMapper.class );
        }

        /**
         * getLocalDateTimeMapper
         * @return
         */
        public LocalDateTimeMapper getLocalDateTimeMapper() {
            return getTypeMapper( LocalDateTimeMapper.class );
        }

        /**
         * getLocalTimeMapper
         * @return
         */
        public LocalTimeMapper getLocalTimeMapper() {
            return getTypeMapper( LocalTimeMapper.class );
        }

        /**
         * getLongMapper
         * @return
         */
        public LongMapper getLongMapper() {
            return getTypeMapper( LongMapper.class );
        }

        /**
         * getShortMapper
         * @return
         */
        public ShortMapper getShortMapper() {
            return getTypeMapper( ShortMapper.class );
        }

        /**
         * getStringMapper
         * @return
         */
        public StringMapper getStringMapper() {
            return getTypeMapper( StringMapper.class );
        }
    }
}
