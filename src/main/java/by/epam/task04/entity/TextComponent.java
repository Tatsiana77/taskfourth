package by.epam.task04.entity;

import java.util.List;

public interface TextComponent {

    boolean add(TextComponent component);

    boolean remove(TextComponent component);

    List<TextComponent> getChildren();

    TextComponentType getType();

    String toString();
}
