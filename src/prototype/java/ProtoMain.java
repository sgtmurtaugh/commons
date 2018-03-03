import de.ckraus.commons.mapper.BooleanMapper;
import de.ckraus.commons.mapper.TypeMapperUtils;

public class ProtoMain {
    public static void main(String[] args) {
        System.out.println(
                TypeMapperUtils.get(BooleanMapper.class).isFalse('0')
        );
        System.out.println(
                TypeMapperUtils.getDefaults().getBooleanMapper().isFalse('1')
        );
    }
}
