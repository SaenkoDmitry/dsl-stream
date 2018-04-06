import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        new DSL<>(
                Arrays.asList(
                    Arrays.asList(1,2,3),
                    Arrays.asList(4,5,6),
                    Arrays.asList(7,8,9)
                )
        )
        .flatMap(IteratorSource::new)
        .filter(x -> x % 2 == 1)
        .map(x -> "Number " + x)
        .forEach(System.out::println);

        if (true) return;

        System.out.println("-----");
        DSL<List<Integer>> dsl1 = new DSL<>(Arrays.asList(
                Arrays.asList(2, 3, 4),
                Arrays.asList(5, 6, 7),
                Arrays.asList(9, 10, 11),
                Arrays.asList(12, 13, 14)
        ));
        dsl1
                .flatMap(IteratorSource::new)
                .filter(x -> x % 2 == 0)
                .map(x -> x * 3)
                .forEach(System.out::println);
    }
}
// TODO Pull Filter with operations: map, flatMap, filter, foreach; clarify paterns
