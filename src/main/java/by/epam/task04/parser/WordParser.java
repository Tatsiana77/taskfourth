package by.epam.task04.parser;


import by.epam.task04.entity.TextComponent;
import by.epam.task04.entity.TextComponentType;
import by.epam.task04.entity.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordParser extends AbstractTextParser {
    private static final String WORD_REGEX = "[\\wа-яА-ЯёЁ]+";


    @Override
    public void parse(TextComponent component, String textPart) {
        Pattern wordPattern = Pattern.compile(WORD_REGEX);
        Matcher wordMatcher = wordPattern.matcher(textPart);

        if (wordMatcher.matches()) {
            TextComponent wordComponent = new TextComposite(TextComponentType.WORD);
            component.add(wordComponent);
            nextParser.parse(wordComponent, textPart);
        }
    }
}

