import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class DSL<T> {
    private final Source<T> source;

    public DSL(List<T> list) {
        source = new IteratorSource<>(list.iterator());
    }

    public DSL(Source<T> source) {
        this.source = source;
    }

    public DSL<T> filter(Predicate<T> predicate) {
        return new DSL(new Filter(source, predicate));
    }

    public <R> DSL<R> map(Function<T, R> function) {
        return new DSL(new Map(source, function));
    }

    public <R> DSL<R> flatMap(Function<T, Source<R>> function) {
        return new DSL(new FlatMap(source, function));
    }

    public void forEach(Consumer<T> consumer) {
        T item = source.get();
        while (item != null) {
            consumer.accept(item);
            item = source.get();
        }
    }
}
