import java.util.Iterator;
import java.util.function.Predicate;

public class Filter<T> extends Source<T> {
    private Source<T> source;
    private Predicate<T> predicate;

    public Filter(Source<T> source, Predicate<T> predicate) {
        this.source = source;
        this.predicate = predicate;
    }

    @Override
    public T get() {
        T item = source.get();
        if (item == null || predicate.test(item))
            return item;
        else
            return this.get();
    }
}