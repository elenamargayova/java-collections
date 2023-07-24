/*
There are 2 collections with id and title properties.
Task: find items that are present in both collections without duplicates and
sort them by title taking in account localization.
*/

package collections;

import java.text.Collator;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Item> items1 = new ArrayList<>();
        Collections.addAll(items1,
                new Item(5, "E"),
                new Item(6, "F"),
                new Item(1, "A"),
                new Item(1, "A"),
                new Item(27, "Ä"),
                new Item(2, "B"),
                new Item(3, "C"));
        List<Item> items2 = new ArrayList<>();
        Collections.addAll(items2,
                new Item(4, "D"),
                new Item(7, "G"),
                new Item(28, "Ü"),
                new Item(5, "E"),
                new Item(27, "Ä"),
                new Item(3, "C"),
                new Item(3, "C"),
                new Item(1, "A"));
        printCommonSortedItems(items1,items2, Locale.GERMAN);
    }

    private static void printCommonSortedItems(List<Item> list1, List<Item> list2, Locale locale) {
        Collator localeCollector = Collator.getInstance(locale);
        Set<Item> common = new LinkedHashSet<>(list1);
        common.retainAll(list2);
        common.stream()
                .sorted(Comparator.comparing(Item::getTitle,localeCollector))
                .forEach(System.out::println);
    }
}