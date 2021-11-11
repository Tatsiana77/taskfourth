package by.epam.task04.parser.impl;

import by.epam.task04.entity.TextComponent;
import by.epam.task04.entity.TextComponentType;
import by.epam.task04.entity.TextComposite;
import by.epam.task04.exception.TextException;
import by.epam.task04.parser.InfoParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser implements InfoParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String PARAGRAPH_SPLIT_REGEX = "((?<=[?!]|((?<!\\.)\\.(?!\\.))|(\\.\\.\\.)))\\s+";
    private InfoParser nextParser;

    public ParagraphParser(InfoParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public TextComponent parse(String text) throws TextException {
        if (nextParser == null) {
            logger.log(Level.ERROR, "Sentence parser is not specified");
            throw new TextException("Sentence parser is not specified");
        }
        String[] sentences = text.split(PARAGRAPH_SPLIT_REGEX);
        var component = new TextComposite(TextComponentType.PARAGRAPH);
        for (String sentence : sentences) {
            TextComponent sentenceComponent = nextParser.parse(sentence);
            component.add(sentenceComponent);
        }
        logger.log(Level.INFO, "Paragraph parsed successfully: " + text);
        return component;
    }
}
