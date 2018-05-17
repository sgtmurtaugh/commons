package de.ckraus.commons.mapper;

@SuppressWarnings({"javadoc"})
public interface IShortMapper
    extends INumericTypeMapper<Short> {

    @Override
    default Short toType(Number number) {
        Short returnValue = null;

        if (number instanceof Short) {
            returnValue = (Short) number;
        }
        else
        if (null != number) {
            returnValue = number.shortValue();
        }
        return returnValue;
    }

}
