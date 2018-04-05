import java.util.Iterator;
import java.util.function.Function;

public class Map<T> extends Source<T> {
    private Source<T> source;
    private Function<T, T> function;

    public Map(Source<T> source, Function<T, T> function) {
        this.source = source;
        this.function = function;
    }

    @Override
    public T get() {
        T item = source.get();
        if (item != null)
            return function.apply(item);
        return null;
    }
}