package by.epam.task04.parser;

import by.epam.task04.entity.TextComponentType;
import by.epam.task04.entity.TextComposite;

import java.util.List;

public class LexemeParser extends TextAbstractParser {
    private static final String LEXEME_REGEX = "\\s";

    @Override
    public void parse(TextComposite composite, String part) {
        List<String> lexemes = List.of(part.split(LEXEME_REGEX));
        for (String lexeme : lexemes) {
            TextComposite lexemeComposite = new TextComposite(TextComponentType.LEXEME);
            composite.add(lexemeComposite);
            nextParser.parse(lexemeComposite, lexeme);
        }
    }
}
