package collections;

import java.util.Objects;

public class Item {
    private Integer id;
    private String title;

    public Item(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return id.equals(item.id) && title.equals(item.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}