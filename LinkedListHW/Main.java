package list;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        //list.add(2);
        list.add(4);
        list.add(5);

        list.add(2, 3);
        list.add(0, 0);
        //System.out.println(list.size());
        list.add(6, 6);

        //list.remove();
        //list.remove(0);
        //list.remove((Integer) 2);

        System.out.println(list.set(0, 888));

        for (Integer i : list) {
            System.out.println(i);
        }

        System.out.println(list.contains(3));
    }
}
