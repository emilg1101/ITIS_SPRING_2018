package collections;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * ModifiableCollection
 * Created by Emil Gafiyatullin (Git:emilg1101)
 * on 25.02.18
 */

@SuppressWarnings("unchecked")
public class ModifiableCollection<E> extends AbstractCollection<E> {

    private final static int DEFAULT_CAPACITY = 10;

    private E[] data;
    private int capacity;
    private int size;

    public ModifiableCollection(){
        data = (E[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    public ModifiableCollection(Collection<E> col){
        data = (E[]) new Object[col.size()];
        capacity = 0;
        for(E el : col){
            data[capacity] = el;
            capacity++;
        }
        size = capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new BasicCollectionIterator<>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Object el){
        if (capacity == size) {
            capacity *= 2;
            data = Arrays.copyOf(data, capacity);
        }
        data[size] = (E) el;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Iterator it = new BasicCollectionIterator();
        while (it.hasNext()) {
            if (it.next().equals(o)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    public class BasicCollectionIterator<E> implements Iterator<E> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public E next() {
            Object value = data[current];
            current++;
            return (E) value;
        }

        @Override
        public void remove() {
            current--;
            size--;
            data[current] = null;
            for (int i = current; i < size; i++) {
                data[i] = data[i+1];
            }
        }
    }
}
