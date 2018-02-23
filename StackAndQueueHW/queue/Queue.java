package queue;

import java.util.NoSuchElementException;

/**
 * HW_N1_120218_StackQueue
 * Created by Emil Gafiyatullin (Git:emilg1101)
 * on 20.02.18
 */

@SuppressWarnings("unchecked")
public class Queue<E> {

    private int count;

    private Node<E> head;
    private Node<E> tail;

    public Queue() {
        count = 0;
        head = null;
        tail = null;
    }

    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);

        if (size() == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        count++;
        return true;
    }

    public E remove() {
        if (isEmpty()) throw new NoSuchElementException();
        E value = head.value;
        head = head.next;
        count--;
        return value;
    }

    public E element() {
        if (isEmpty()) throw new NoSuchElementException();
        return head.value;
    }

    public boolean isEmpty() {
        return count == 0 || head == null;
    }

    public int size() {
        return count;
    }

    public void clear() {
        head = tail = null;
        count = 0;
    }
}