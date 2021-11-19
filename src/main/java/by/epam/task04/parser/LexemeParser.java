package by.epam.task04.parser;

import by.epam.task04.entity.TextComponent;
import by.epam.task04.entity.TextComponentType;
import by.epam.task04.entity.TextComposite;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_SPLIT_REGEX = "\\s";

    public LexemeParser() {
        this.nextParser = new WordParser();
    }

    @Override
    public void parse(TextComponent component, String textPart) {
        String[] lexemes = textPart.split(LEXEME_SPLIT_REGEX);

        for (String lexeme : lexemes) {
            TextComponent lexemeComponent = new TextComposite(TextComponentType.LEXEME);
            component.add(lexemeComponent);
            nextParser.parse(lexemeComponent, lexeme);
        }
    }
}
