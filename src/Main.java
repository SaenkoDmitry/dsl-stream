import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DSL<Integer> dsl = new DSL(Arrays.asList(1, 2, 5, 5, 8, 3, 10, 5));
        dsl
                .filter(x -> x % 2 == 1)
//                .filter(x -> x % 2 == 1)
                .map(x -> x * 2)
                .forEach(System.out::println);

        DSL<List<Integer>> dsl1 = new DSL<>(Arrays.asList(Arrays.asList(1, 5, 8), Arrays.asList(2, 7, 8), Arrays.asList(1, 5, 8)));
        dsl1
//                .flatMap(x -> new DSL<Integer>(x))
                .forEach(System.out::println);
    }
}