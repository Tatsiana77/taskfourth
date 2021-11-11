package by.epam.task04.parser.impl;

import by.epam.task04.entity.SymbolLeaf;
import by.epam.task04.entity.TextComponent;
import by.epam.task04.entity.TextComponentType;
import by.epam.task04.entity.TextComposite;
import by.epam.task04.exception.TextException;
import by.epam.task04.parser.InfoParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser implements InfoParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String WORD_SPLIT_REGEX = "";

    @Override
    public TextComponent parse(String text) throws TextException {
        var component = new TextComposite(TextComponentType.WORD);
        String[] characters = text.split(WORD_SPLIT_REGEX);
        for (String ch : characters) {
            var symbolComponent = new SymbolLeaf(TextComponentType.SYMBOL, ch.charAt(0));
            component.add(symbolComponent);
        }
        logger.log(Level.INFO, "Word parsed successfully: " + text);
        return component;
    }
}
