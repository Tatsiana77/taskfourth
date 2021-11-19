package by.epam.task04.parser;

import by.epam.task04.entity.SymbolLeaf;
import by.epam.task04.entity.TextComponent;

public class SymbolParser extends AbstractTextParser {
    @Override
    public void parse(TextComponent component, String textPart) {
        char[] symbols = textPart.toCharArray();
        for (char symbol : symbols) {
            component.add(new SymbolLeaf(symbol));
        }
    }
}
