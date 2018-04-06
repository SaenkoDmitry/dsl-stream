import java.util.Iterator;
import java.util.function.Function;

public class Map<T, R> implements Source<R> {
    private Source<T> source;
    private Function<T, R> function;

    public Map(Source<T> source, Function<T, R> function) {
        this.source = source;
        this.function = function;
    }

    @Override
    public R get() {
        T item = source.get();
        if (item != null)
            return function.apply(item);
        return null;
    }
}
