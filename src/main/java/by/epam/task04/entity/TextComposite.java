package by.epam.task04.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

    private List<TextComponent> components = new ArrayList<>();
    private TextComponentType type;

    public TextComposite(TextComponentType type) {
        this.type = type;
    }

    @Override
    public boolean add(TextComponent component) {
        return false;
    }

    @Override
    public boolean remove(TextComponent component) {
        return false;
    }

    @Override
    public List<TextComponent> getChildren() {
        return null;
    }

    @Override
    public TextComponentType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextComposite that = (TextComposite) o;
        return components.equals(that.components) && type == that.type;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += result * 31 + components.hashCode();
        result += result * 31 + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TextComposite{" +
                "components=" + components +
                ", type=" + type +
                '}';
    }
}
