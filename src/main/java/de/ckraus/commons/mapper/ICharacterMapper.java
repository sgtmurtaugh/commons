package de.ckraus.commons.mapper;

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
}
