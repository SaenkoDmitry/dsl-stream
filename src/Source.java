import java.util.Iterator;

public class Source<T> {
    Iterator<T> iterator;

    public void setIterator(Iterator<T> iterator) {
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