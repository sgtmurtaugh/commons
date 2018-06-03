import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

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
public class TestMain {

    private static String s;

    public static void main (String ... arg) {
//        Predicate<Character> isDigit = (Character c) -> Character.isDigit(c);

        Logger logger = LoggerFactory.getLogger(TestMain.class);
        XLogger xlogger = XLoggerFactory.getXLogger(TestMain.class);

        List<String> names = Arrays.asList("  jutta   ", "kevin", "chantal", "", null);
        names.forEach(System.out::println);
    }

}
