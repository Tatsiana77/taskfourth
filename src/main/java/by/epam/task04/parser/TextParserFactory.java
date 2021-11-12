package by.epam.task04.parser;

public class TextParserFactory {
    public TextParserFactory() {
    }

    public static TextAbstractParser createParser() {
        LexemeParser lexemeParser = new LexemeParser();
        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser();

        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);

        return paragraphParser;
    }
}
