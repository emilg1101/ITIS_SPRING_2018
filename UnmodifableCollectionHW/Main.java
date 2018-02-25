import collections.ModifableCollection;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        Collection<Integer> modifable = new ModifableCollection<>();

        modifable.add(111);

        Collection<Integer> unmodifable = ModifableCollection.unmodifableCollection(modifable);

        try {
            unmodifable.add(555);
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex);
        }

        modifable.add(777);

        for (Integer i : modifable) {
            System.out.println(i);
        }

        System.out.println("---------------");

        for (Integer i : unmodifable) {
            System.out.println(i);
        }

        System.out.println(modifable.contains(111));

    }
}
