package by.epam.task04.parser.impl;

import by.epam.task04.entity.TextComponent;
import by.epam.task04.entity.TextComponentType;
import by.epam.task04.entity.TextComposite;
import by.epam.task04.exception.TextException;
import by.epam.task04.parser.InfoParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser implements InfoParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String TEXT_SPLIT_REGEX = "\\n+[\\s]*";
    private InfoParser nextParser;

    public TextParser(InfoParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public TextComponent parse(String text) throws TextException {
        if (nextParser == null) {
            logger.log(Level.ERROR, "Paragraph parser is not specified");
            throw new TextException("Paragraph parser is not specified");
        }

        String[] paragraphs = text.strip().split(TEXT_SPLIT_REGEX);
        var component = new TextComposite(TextComponentType.TEXT);
        for (String paragraph : paragraphs) {
            TextComponent paragraphComponent = nextParser.parse(paragraph);
            component.add(paragraphComponent);
        }
        logger.log(Level.INFO, "Text parsed successfully: " + text);
        return component;
    }
}
