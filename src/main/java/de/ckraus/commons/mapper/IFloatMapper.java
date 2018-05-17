package de.ckraus.commons.mapper;

@SuppressWarnings({"javadoc"})
public interface IFloatMapper
    extends INumericTypeMapper<Float> {

    @Override
    default Float toType(Number number) {
        Float returnValue = null;

        if (number instanceof Float) {
            returnValue = (Float) number;
        }
        else
        if (null != number) {
            returnValue = number.floatValue();
        }
        return returnValue;
    }

}
