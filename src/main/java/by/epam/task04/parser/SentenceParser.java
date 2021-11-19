package by.epam.task04.parser;

import by.epam.task04.entity.TextComponent;
import by.epam.task04.entity.TextComponentType;
import by.epam.task04.entity.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractTextParser {
    private static final String SENTENCE_REGEX = "(\\p{Upper}|[А-ЯЁ]).+?(\\.|\\!|\\?|\\u2026)(\\s|$)";

    public SentenceParser() {
        this.nextParser = new LexemeParser();
    }

    @Override
    public void parse(TextComponent component, String textPart) {
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(textPart);

        while (matcher.find()) {
            String sentence = matcher.group();
            TextComponent sentenceComponent = new TextComposite(TextComponentType.SENTENCE);
            component.add(sentenceComponent);
            nextParser.parse(sentenceComponent, sentence);
        }
    }
}
