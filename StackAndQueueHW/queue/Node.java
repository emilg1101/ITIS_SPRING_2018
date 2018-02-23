package queue;

/**
 * HW_N1_120218_StackQueue
 * Created by Emil Gafiyatullin (Git:emilg1101)
 * on 20.02.18
 */

class Node<E> {

    public Node<E> next = null;
    public E value;

    Node(E value) {
        this.value = value;
    }
}