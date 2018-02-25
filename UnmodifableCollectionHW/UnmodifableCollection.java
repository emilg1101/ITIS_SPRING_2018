package collections;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * UnmodifableCollection
 * Created by Emil Gafiyatullin (Git:emilg1101)
 * on 20.02.18
 */

public class UnmodifableCollection<E> extends AbstractCollection<E> {

    private ModifableCollection<E> collection;

    public UnmodifableCollection(Collection<? extends E> collection) {
        this.collection = (ModifableCollection<E>) collection;
    }

    @Override
    public Iterator<E> iterator() {
        return collection.iterator();
    }

    @Override
    public int size() {
        return 0;
    }
}
