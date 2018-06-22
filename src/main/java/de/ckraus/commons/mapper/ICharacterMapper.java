package de.ckraus.commons.mapper;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings({"javadoc"})
public interface ICharacterMapper
    extends ITypeMapper<Character> {

    /**
     * isTrimStrings
     * @return
     */
    default boolean isEvaluateCodePoints() {
        return Boolean.TRUE;
    }

    @Override
    default boolean isMappable(Object o) {
        boolean bIsMappable;

        if ( o instanceof Character ) {
            bIsMappable = true;
        }
        else
        if ( o instanceof Integer ) {
            bIsMappable = Character.isDefined( (Integer) o );
        }
        else {
            bIsMappable = ITypeMapper.super.isMappable(o);
        }

        return bIsMappable;
    }

    /**
     * map
     * @param s
     * @param bEvaluateCodePoints
     * @return
     * <p></p>
     */
    default Character map(
            String s,
            boolean bEvaluateCodePoints
    ) {
        return this.map(
                s,
                bEvaluateCodePoints,
                this.getDefaultValue()
        );
    }

    /**
     * map
     * @param s
     * @param bEvaluateCodePoints
     * @param defaultValue
     * @return
     * <p></p>
     */
    default Character map(
            String s,
            boolean bEvaluateCodePoints,
            Character defaultValue
    ) {
        return this.map(
                s,
                this.isTrimStrings(),
                this.isEmptyStringNull(),
                bEvaluateCodePoints,
                defaultValue
        );
    }

    /**
     * map
     * @param s
     * @param bTrim
     * @param bEmptyIsNull
     * @param defaultValue
     */
    default Character map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull,
            Character defaultValue
    ) {
        return this.map(
                s,
                bTrim,
                bEmptyIsNull,
                this.isEvaluateCodePoints(),
                defaultValue
        );
    }

    /**
     * map
     * @param s
     * @param bTrim
     * @param bEmptyIsNull
     * @param bEvaluateCodePoints
     * @param defaultValue
     * @return
     * <p></p>
     */
    default Character map(
            String s,
            boolean bTrim,
            boolean bEmptyIsNull,
            boolean bEvaluateCodePoints,
            Character defaultValue
    ) {
        Character cRetVal = defaultValue;
        String preparedString = this.prepareStringToMap(
                s,
                bTrim,
                bEmptyIsNull
        );

        if (StringUtils.isNotEmpty(preparedString)) {
            Integer iVal = null;

            if ( bEvaluateCodePoints ) {
                // Pruefen, ob der String evtl ein Integerwert ist
                iVal = this.getIIntegerMapper().map(
                        preparedString,
                        (String) null
                );
            }

            if (iVal != null) {
                char[] acVals = Character.toChars(iVal);

                if (!ArrayUtils.isEmpty(acVals)) {
                    cRetVal = acVals[0];
                }
            }
            else {
                cRetVal = preparedString.charAt(0);
            }
        }
        return cRetVal;
    }

    /**
     * getIIntegerMapper
     * @return
     */
    default IIntegerMapper getIIntegerMapper() {
        return TypeMapperUtils.getDefaults().getIntegerMapper();
    }

}
