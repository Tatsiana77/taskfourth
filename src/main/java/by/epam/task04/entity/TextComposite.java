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
        return components.add(component);
    }

    @Override
    public boolean remove(TextComponent component) {
        return components.remove(component);
    }

    @Override
    public List<TextComponent> getChildren() {
        return new ArrayList<TextComponent>(components);
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(type.getPrefix());
        components.forEach(c -> stringBuilder.append(c.toString()));
        stringBuilder.append(type.getSuffix());
        return stringBuilder.toString();
    }
}
