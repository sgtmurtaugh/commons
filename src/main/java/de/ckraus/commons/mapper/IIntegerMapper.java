package de.ckraus.commons.mapper;

@SuppressWarnings( { "javadoc" } )
public interface IIntegerMapper extends INumericTypeMapper<Integer> {

    @Override
    default Integer toType( Number number ) {
        Integer returnValue = null;

        if ( number instanceof Integer ) {
            returnValue = ( Integer ) number;
        } else if ( null != number ) {
            returnValue = number.intValue();
        }
        return returnValue;
    }

}
