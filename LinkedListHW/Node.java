package list;

/**
 * LinkedList
 * Created by Emil Gafiyatullin (Git:emilg1101)
 * on 26.02.18
 */

class Node<E> {

    public Node<E> next = null;

    public E data;

    public Node(E data) {
        this.data = data;
    }
}
