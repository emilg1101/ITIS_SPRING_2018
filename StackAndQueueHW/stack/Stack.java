package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * HW_N1_120218_StackQueue
 * Created by Emil Gafiyatullin (Git:emilg1101)
 * on 20.02.18
 */

@SuppressWarnings("unchecked")
public class Stack<E> {

    private int DEFAULT_SIZE = 2;

    private int size;
    private int count;

    private E[] data;

    public Stack() {
        size = DEFAULT_SIZE;
        count = 0;
        data = (E[]) new Object[DEFAULT_SIZE];
    }

    public boolean push(E e) {
        if (size == count) {
            size *= 2;
            data = Arrays.copyOf(data, size);
        }
        data[count] = e;
        count++;
        return true;
    }

    public E peek() {
        if (empty()) throw new EmptyStackException();
        return data[count-1];
    }

    public E pop() {
        if (empty()) throw new EmptyStackException();
        count--;
        return data[count];
    }

    public boolean empty() {
        return count == 0;
    }

    public void clear() {
        size = DEFAULT_SIZE;
        data = (E[]) new Object[DEFAULT_SIZE];
        count = 0;
    }

    public int size() {
        return count;
    }
}