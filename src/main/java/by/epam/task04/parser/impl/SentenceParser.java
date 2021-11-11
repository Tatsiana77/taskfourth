package by.epam.task04.parser.impl;

import by.epam.task04.entity.TextComponent;
import by.epam.task04.entity.TextComponentType;
import by.epam.task04.entity.TextComposite;
import by.epam.task04.exception.TextException;
import by.epam.task04.parser.InfoParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser implements InfoParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String SENTENCE_SPLIT_REGEX = "\\s+";
    private InfoParser nextParser;

    public SentenceParser(InfoParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public TextComponent parse(String text) throws TextException {
        if (nextParser == null) {
            logger.log(Level.ERROR, "Lexeme parser is not specified");
            throw new TextException("Lexeme parser is not specified");
        }
        String[] lexemes = text.split(SENTENCE_SPLIT_REGEX);
        var component = new TextComposite(TextComponentType.SENTENCE);
        for (String lexeme : lexemes) {
            TextComponent lexemeComponent = nextParser.parse(lexeme);
            component.add(lexemeComponent);
        }
        logger.log(Level.INFO, "Sentence parsed successfully: " + text);
        return component;
    }
}
