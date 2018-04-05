import java.io.FileReader;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class DSL<T> {
    private Source<T> source;
    private Iterator<T> iterator;

    public DSL(List<T> list) {
        iterator = list.iterator();
        source = new Source<T>();
        source.setIterator(iterator);
    }

    public DSL(Source<T> source) {
        source.setIterator(iterator);
        this.source = source;
    }

    public DSL<T> filter(Predicate<T> predicate) {
        return new DSL<T>(new Filter<T>(source, predicate));
    }

    public DSL<T> map(Function<T, T> function) {
        return new DSL<T>(new Map<T>(source, function));
    }

//    public DSL<R> flatMap(Function<? super T, ? extends DSL<? extends R>> function) {
//        return new DSL<R>(new FlatMap<R>(source, function));
//    }

    public void forEach(Consumer<T> consumer) {
        T item = source.get();
        while (item != null) {
            consumer.accept(item);
            item = source.get();
        }
    }
}