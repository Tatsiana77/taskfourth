package by.epam.task04.parser;

import by.epam.task04.entity.TextComponentType;
import by.epam.task04.entity.TextComposite;

import java.util.List;

public class SentenceParser extends TextAbstractParser {
    private static final String SENTENCE_SPLIT_REGEX = "(?<=\\.{3}|\\.|\\?|!)\\s";

    @Override
    public void parse(TextComposite composite, String part) {
        List<String> listSentences = List.of(part.split(SENTENCE_SPLIT_REGEX));
        for (String sentence : listSentences) {
            TextComposite sentenceComposite = new TextComposite(TextComponentType.SENTENCE);
            composite.add(sentenceComposite);
            nextParser.parse(sentenceComposite, sentence);
        }
    }
}
