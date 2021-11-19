package by.epam.task04.parser;


import by.epam.task04.entity.TextComponent;

public abstract class AbstractTextParser {
    protected AbstractTextParser nextParser;

    public AbstractTextParser() {
    }

    public AbstractTextParser(AbstractTextParser parser) {
        this.nextParser = parser;
    }

    public void setNextParser(AbstractTextParser textParser) {
        this.nextParser = textParser;
    }

    public AbstractTextParser getNextParser() {
        return nextParser;
    }

    public abstract void parse(TextComponent component, String textPart);
}
