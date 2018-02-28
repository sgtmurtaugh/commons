package de.ckraus.commons.parser.type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by ckraus on 07.08.15.
 */
@SuppressWarnings({ "unused" })
public class TypeParserUtils {

    private final static String CLASS = TypeParserUtils.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(TypeParserUtils.class);

    private ConcurrentMap<Class<? extends ITypeParser<?>>, ITypeParser<?>> mapTypeParsers = null;


    /**
     * Constructor
     */
    public TypeParserUtils() {
        super();
    }


    /* ### getter- / setter-Methods ############ */


    public ConcurrentMap<Class<? extends ITypeParser<?>>, ITypeParser<?>> getRegisteredTypeParsers() {
        if ( null == mapTypeParsers ) {
            this.setRegisteredTypeParsers(new ConcurrentHashMap<Class<? extends ITypeParser<?>>, ITypeParser<?>>());
        }
        return mapTypeParsers;
    }

    public void setRegisteredTypeParsers( ConcurrentMap<Class<? extends ITypeParser<?>>, ITypeParser<?>> mapTypeParsers ) {
        this.mapTypeParsers = mapTypeParsers;
    }


    /* ### additional Methods ############ */


    @SuppressWarnings( "unchecked" )
    public <T extends ITypeParser<?>> T getTypeParser( Class<? extends ITypeParser<?>> clazzTypeParser ) {
        ITypeParser<?> typeParser = null;

        if ( null != clazzTypeParser ) {
            if ( this.getRegisteredTypeParsers().containsKey( clazzTypeParser ) ) {
                typeParser = this.getRegisteredTypeParsers().get(clazzTypeParser);
            }
            else {
                try {
                    typeParser = clazzTypeParser.newInstance();

                    this.getRegisteredTypeParsers().put(
                            clazzTypeParser,
                            typeParser
                    );
                }
                catch ( InstantiationException | IllegalAccessException e ) {
                    e.printStackTrace();
                }
            }
        }
        return ( T ) typeParser;
    }

    public BigDecimalParser getBigDecimalParser() {
        return this.getTypeParser( BigDecimalParser.class );
    }

    public BigIntegerParser getBigIntegerParser() {
        return this.getTypeParser( BigIntegerParser.class );
    }

    public BooleanParser getBooleanParser() {
        return this.getTypeParser( BooleanParser.class );
    }

    public ByteParser getByteParser() {
        return this.getTypeParser( ByteParser.class );
    }

    public GregorianCalendarParser getGregorianCalendarParser() {
        return this.getTypeParser( GregorianCalendarParser.class );
    }

    public CharacterParser getCharacterParser() {
        return this.getTypeParser( CharacterParser.class );
    }

    public DateParser getDateParser() {
        return this.getTypeParser( DateParser.class );
    }

    public DoubleParser getDoubleParser() {
        return this.getTypeParser( DoubleParser.class );
    }

    public FloatParser getFloatParser() {
        return this.getTypeParser( FloatParser.class );
    }

    public IntegerParser getIntegerParser() {
        return this.getTypeParser( IntegerParser.class );
    }

    public LongParser getLongParser() {
        return this.getTypeParser( LongParser.class );
    }

    public ShortParser getShortParser() {
        return this.getTypeParser( ShortParser.class );
    }

    public StringParser getStringParser() {
        return this.getTypeParser( StringParser.class );
    }

}
