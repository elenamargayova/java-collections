/*
There are 2 collections with id and title properties.
Task: find items that are present in both collections without duplicates and sort them by title.
*/

package collections;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Item> items1 = new ArrayList<>();
        Collections.addAll(items1,
                new Item(5, "E"),
                new Item(6, "F"),
                new Item(1, "A"),
                new Item(1, "A"),
                new Item(2, "B"),
                new Item(3, "C"));
        List<Item> items2 = new ArrayList<>();
        Collections.addAll(items2,
                new Item(4, "D"),
                new Item(7, "G"),
                new Item(1, "A"),
                new Item(5, "E"),
                new Item(3, "C"),
                new Item(3, "C"));
        List<Item> uniqueItems = items1.stream()
                .distinct()
                .filter(items2::contains)
                .collect(Collectors.toList());
        uniqueItems.sort((o1, o2) -> {
            if (o1 instanceof Item && o2 instanceof Item) {
                Item item1 = o1;
                Item item2 = o2;
                return item1.getTitle().compareTo(item2.getTitle());
            }
            return 0;
        });
        for (Item item : uniqueItems) {
            System.out.println(item);
        }
    }
}