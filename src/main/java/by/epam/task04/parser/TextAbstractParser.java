package by.epam.task04.parser;

import by.epam.task04.entity.TextComposite;

public abstract class TextAbstractParser {
    protected TextAbstractParser nextParser = DefaultParser.getParser();

    public void setNextParser(TextAbstractParser textParser) {
        this.nextParser = textParser;
    }

    public abstract void parse(TextComposite composite, String part);

    private static class DefaultParser extends TextAbstractParser {

        private static final DefaultParser parser = new DefaultParser();

        public static DefaultParser getParser() {
            return parser;
        }

        @Override
        public void parse(TextComposite composite, String part) {

        }
    }

}
