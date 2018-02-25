package collections;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * UnmodifableCollection
 * Created by Emil Gafiyatullin (Git:emilg1101)
 * on 25.02.18
 */
public class ModifableCollection<E> extends AbstractCollection<E> {

    private final static int DEFAULT_SIZE = 10;

    private E[] data;
    private int size;
    private int count;

    public ModifableCollection(){
        data = (E[]) new Object[DEFAULT_SIZE];
        size = DEFAULT_SIZE;
        count = 0;
    }

    public ModifableCollection(Collection<E> col){
        data = (E[]) new Object[col.size()];
        size = 0;
        for(E el : col){
            data[size] = el;
            size++;
        }
        count = size;
    }

    @Override
    public Iterator<E> iterator() {
        return new BasicCollectionIterator();
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean add(Object el){
        if (size == count) {
            size *= 2;
            data = Arrays.copyOf(data, size);
        }
        data[count] = (E) el;
        count++;
        return true;
    }

    public static <T> UnmodifableCollection<T> unmodifableCollection(Collection<? extends T> collection) {
        return new UnmodifableCollection<T>(collection);
    }

    public class BasicCollectionIterator<E> implements Iterator<E> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < count;
        }

        @Override
        public E next() {
            Object value = data[current];
            current++;
            return (E) value;
        }
    }
}
