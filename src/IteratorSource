import java.util.Iterator;
import java.util.List;

public class IteratorSource<T> implements Source<T> {
    private final Iterator<T> iterator;

    public IteratorSource(List<T> list) {
        this(list.iterator());
    }

    public IteratorSource(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    public T get() {
        if (iterator.hasNext()) {
            T item = iterator.next();
            return item;
        }
        return null;
    }
}
