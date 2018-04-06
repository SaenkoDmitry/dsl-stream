import java.util.function.Function;

public class FlatMap<T, R> implements Source<R> {
    private Source<T> source;
    private Source<R> sourceFlatted;
    private Function<T, Source<R>> function;

    public FlatMap(Source<T> source, Function<T, Source<R>> function) {
        this.source = source;
        this.function = function;
        this.sourceFlatted = function.apply(source.get());
    }

    @Override
    public R get() {
        while (true) {
            R item = sourceFlatted.get();
            if (item != null) {
                return item;
            } else {
                T item1 = source.get();
                if (item1 == null)
                    return null;
                sourceFlatted = function.apply(item1);
            }
        }
    }
}
