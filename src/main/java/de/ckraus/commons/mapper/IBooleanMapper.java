package de.ckraus.commons.mapper;


/**
 * Created by ckraus on 09.08.15.
 */
@SuppressWarnings({"javadoc"})
public interface IBooleanMapper
    extends ITypeMapper<Boolean> {


    /**
     * isMappable
     * @param o
     * @return
     */
    default boolean isMappable(Object o) {
        boolean bIsMappable;

        if ( null == o ) {
            bIsMappable = false;
        }
        else
        if ( o instanceof Boolean ) {
            bIsMappable = true;
        }
        else
        if ( o instanceof Character ) {
            bIsMappable = (
                    this.isFalse( (Character) o )
                            || this.isTrue( (Character) o )
            );
        }
        else
        if ( o instanceof Integer ) {
            bIsMappable = (
                    this.isFalse( (Integer) o )
                            || this.isTrue( (Integer) o )
            );
        }
        else
        if ( o instanceof String ) {
            bIsMappable = (
                    this.isFalse( (String) o )
                            || this.isTrue( (String) o )
            );
        }
        else {
            bIsMappable = this.isMappable( o.toString() );
        }
        return bIsMappable;
    }

    /**
     * map
     * @param c - character to map
     */
    default Boolean map(Character c) {
        return this.map(
                c,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param c - character to map
     * @param defaultValue - The default value
     * @return
     */
    default Boolean map(
            Character c,
            Boolean defaultValue
    ) {
        Boolean b = defaultValue;

        if (null != c) {
            if (this.isFalse(c)) {
                b = Boolean.FALSE;
            }
            else
            if (this.isTrue(c)) {
                b = Boolean.TRUE;
            }
        }
        return b;
    }

    /**
     * map
     * @param i - integer to map
     * @return
     */
    default Boolean map(Integer i) {
        return this.map(
                i,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param i - integer to map
     * @param defaultValue - The default value
     * @return
     */
    default Boolean map(
            Integer i,
            Boolean defaultValue
    ) {
        Boolean b = defaultValue;

        if (null != i) {
            if (this.isFalse(i)) {
                b = Boolean.FALSE;
            }
            else
            if (this.isTrue(i)) {
                b = Boolean.TRUE;
            }
        }
        return b;
    }

    /**
     * map
     * @param s - string to map
     * @param bTrim - default flag for string handling
     * @param bEmptyIsNull - default flag for empty string handling
     * @return
     */
    default Boolean map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull
    ) {
        return this.map(
                s,
                bTrim,
                bEmptyIsNull,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param s - string to map
     * @param bTrim - default flag for string handling
     * @param bEmptyIsNull - default flag for empty string handling
     * @param defaultValue - The default value
     * @return
     */
    default Boolean map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull,
            Boolean defaultValue
    ) {
        Boolean b = defaultValue;
        String preparedString = this.prepareStringToParse(
                s,
                bTrim,
                bEmptyIsNull
        );

        if (null != preparedString) {
            String val = preparedString;

            // optional trim
            if (bTrim) {
                val = val.trim();
            }

            // optional empty check
            if (bEmptyIsNull
                    && val.length() == 0) {
                val = null;
            }

            // true / false check
            if (null != val) {
                if (this.isFalse(val)) {
                    b = Boolean.FALSE;
                }
                else
                if (this.isTrue(val)) {
                    b = Boolean.TRUE;
                }
            }
        }
        return b;
    }

    /**
     * isFalse
     * @param c
     * @return
     */
    boolean isFalse(Character c);

    /**
     * isFalse
     * @param i
     * @return
     */
    boolean isFalse(Integer i);

    /**
     * isFalse
     * @param o
     * @return
     */
    default boolean isFalse(Object o) {
        boolean bIsFalse;

        if ( null == o ) {
            bIsFalse = false;
        }
        else
        if ( o instanceof Boolean ) {
            bIsFalse = (o == Boolean.FALSE);
        }
        else
        if ( o instanceof Character ) {
            bIsFalse = this.isFalse( (Character) o );
        }
        else
        if ( o instanceof Integer ) {
            bIsFalse = this.isFalse( (Integer) o );
        }
        else
        if ( o instanceof String ) {
            bIsFalse = this.isFalse( (String) o );
        }
        else {
            bIsFalse = this.isFalse( o.toString() );
        }
        return bIsFalse;
    }

    /**
     * isFalse
     * @param s
     * @return
     */
    boolean isFalse(String s);

    /**
     * isTrue
     * @param c
     * @return
     */
    boolean isTrue(Character c);

    /**
     * isTrue
     * @param i
     * @return
     */
    boolean isTrue(Integer i);

    /**
     * isTrue
     * @param o
     * @return
     */
    default boolean isTrue(Object o) {
        boolean bIsTrue;

        if ( null == o ) {
            bIsTrue = false;
        }
        else
        if ( o instanceof Boolean ) {
            bIsTrue = (o == Boolean.TRUE);
        }
        else
        if ( o instanceof Character ) {
            bIsTrue = this.isTrue( (Character) o );
        }
        else
        if ( o instanceof Integer ) {
            bIsTrue = this.isTrue( (Integer) o );
        }
        else
        if ( o instanceof String ) {
            bIsTrue = this.isTrue( (String) o );
        }
        else {
            bIsTrue = this.isTrue( o.toString() );
        }
        return bIsTrue;
    }

    /**
     * isTrue
     * @param s
     * @return
     */
    boolean isTrue(String s);

}
