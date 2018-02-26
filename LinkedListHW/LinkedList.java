package list;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedList
 * Created by Emil Gafiyatullin (Git:emilg1101)
 * on 26.02.18
 */

public class LinkedList<E> extends AbstractList<E> {

    private Node<E> head;
    private Node<E> tail;

    private int count;

    public LinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();

        if (index == 0) {
            linkFirst(element);
            return;
        }

        if (index == size()) {
            linkLast(element);
            return;
        }

        Node<E> newNode = new Node<>(element);
        Node<E> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        count++;
    }

    public void addFirst(E e) {
        linkFirst(e);
    }

    public void addLast(E e) {
        linkLast(e);
    }

    @Override
    public void clear() {
        head = tail = null;
        count = 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object o1 : this) {
            if (o1.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    public boolean isEmpty() {
        return count == 0 || head == null;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        return node(index).data;
    }

    public E getFirst() {
        return head.data;
    }

    public E getLast() {
        return tail.data;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (Object o1 : this) {
            if (o1.equals(o)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public E remove() {
        if (isEmpty()) throw new NoSuchElementException();
        E data = head.data;
        head = head.next;
        count--;
        return data;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        if (index == 0) return remove();
        Node<E> current = head;
        E data = null;
        for (int i = 0; i < index; i++) {
            if (i == index - 1) {
                data = current.next.data;
                current.next = current.next.next;
            }
            current = current.next;
        }
        count--;
        return data;
    }

    @Override
    public boolean remove(Object o) {
        int index = -1;
        Iterator it = iterator();
        while (it.hasNext()) {
            index++;
            if (it.next().equals(o)) {
                remove(index);
                return true;
            }
        }
        if (index == -1) return false;
        return true;
    }

    public E removeFirst() {
        return remove();
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E data = current.data;
        current.data = element;
        return data;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[count];
        Node<E> current = head;
        for (int i = 0; i < count; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return super.toArray(a);
    }

    private void linkFirst(E e) {
        Node<E> newNode = new Node<>(e);

        if (isEmpty()) {
            head = tail;
        } else {
            newNode.next = head;
        }
        head = newNode;
        count++;
    }

    private void linkLast(E e) {
        Node<E> newNode = new Node<>(e);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        count++;
    }

    private Node<E> node(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public class LinkedListIterator implements Iterator<E> {

        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}
