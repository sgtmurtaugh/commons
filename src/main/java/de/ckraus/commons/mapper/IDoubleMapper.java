package de.ckraus.commons.mapper;

@SuppressWarnings({"javadoc"})
public interface IDoubleMapper
    extends INumericTypeMapper<Double> {

    @Override
    default Double toType(Number number) {
        Double returnValue = null;

        if (number instanceof Double) {
            returnValue = (Double) number;
        }
        else
        if (null != number) {
            returnValue = number.doubleValue();
        }
        return returnValue;
    }

}
