import collections.ModifiableCollection;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        Collection<Integer> collection = new ModifiableCollection<>();
        collection.add(111);
        collection.add(222);
        collection.add(333);
        collection.add(444);

        for (Integer i : collection) {
            System.out.println(i);
        }

        collection.remove(444);

        System.out.println("----------------");

        for (Integer i : collection) {
            System.out.println(i);
        }
    }
}
