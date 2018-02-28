import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by gandalf on 16.03.14.
 */
public class Main {

    private static String s;

    public static void main (String ... arg) {
//        Byte b = (byte)366;
//        byte b2 = 11;
//
//        System.out.println( "b: " + b );
//        Predicate<Character> isDigit = (Character c) -> Character.isDigit(c);

        List<String> names = Arrays.asList("  jutta   ", "kevin", "chantal", "", null);
        names.forEach(System.out::println);
    }

}
