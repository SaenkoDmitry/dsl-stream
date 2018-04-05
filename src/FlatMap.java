import java.util.function.Function;

public class FlatMap<T> extends Source<T> {
    private Source<T> source;
    private Function<T, DSL<? extends T>> function;

    public FlatMap(Source<T> source, Function<T, DSL<? extends T>> function) {
        this.source = source;
        this.function = function;
    }

    @Override
    public T get() {
        T item = source.get();
//        if (item != null)
//            return function.apply(item);
        return null;
    }
}