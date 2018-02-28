package de.ckraus.commons.parser.type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by ckraus on 02.07.15.
 */
public abstract class AbstractDateParser<E extends Date>
    extends AbstractTypeParser<E>
    implements IDateTypeParser<E> {

    private final static String CLASS   = AbstractDateParser.class.getSimpleName();
    protected static Logger log = LoggerFactory.getLogger(AbstractDateParser.class);

    /**
     * Constructor
     */
    public AbstractDateParser() {
        super();
    }

    /**
     * Constructor
     * @param defaultValue - The default value
     */
    public AbstractDateParser(E defaultValue) {
        super( defaultValue );
    }


    /**
     * @see IDateTypeParser#unformat(String)
     */
    public E unformat ( String sDate ) {
        return this.unformat(
                sDate,
                null
        );
    }

    /**
     * @see IDateTypeParser#unformat(String, Date)
     * <p>This default implementation only return the defaultValue param.</p>
     */
    public E unformat (
            String sDate,
            E defaultValue
    ) {
        return defaultValue;
    }

}
