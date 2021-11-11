package by.epam.task04.service.impl;

import by.epam.task04.entity.TextComponent;
import by.epam.task04.entity.TextComponentType;
import by.epam.task04.exception.TextException;
import by.epam.task04.service.TextService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TextServiceImpl implements TextService {

    private static final Logger logger = LogManager.getLogger();
    private static final String VOWEL_REGEX = "[AEIOUaeiou]";
    private static final String CONSONANT_REGEX = "[[^AEIOUaeiou]&&A-Za-z]";


    @Override
    public void sortParagraphBySentenceCount(TextComponent component) throws TextException {
        if (component.getType() != TextComponentType.TEXT) {
            logger.log(Level.ERROR, "Illegal component type: {}. Expected TEXT.", component.getType());
            throw new TextException("Illegal component type: . Expected TEXT." + component.getType());
        }
        Comparator<TextComponent> sentenceCountComparator = (o1, o2) -> {
            int count1 = o1.getChildren().size();
            int count2 = o2.getChildren().size();
            return Integer.compare(count1, count2);
        };
        List<TextComponent> paragraphs = component.getChildren();
        paragraphs.sort(sentenceCountComparator);
    }

    @Override
    public void removeSentencesContainingLessWords(TextComponent component, int minWordCount)
            throws TextException {
        if (component.getType() != TextComponentType.TEXT) {
            logger.log(Level.ERROR, "Illegal component type: {}. Expected TEXT.", component.getType());
            throw new TextException("Illegal component type: . Expected TEXT." + component.getType());
        }

        List<TextComponent> paragraphs = component.getChildren();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getChildren();
            sentences.removeIf(sentence -> countWords(sentence) < minWordCount);
        }
    }

    @Override
    public List<TextComponent> findSentencesContainingLongestWord(TextComponent component) throws TextException {
        if (component.getType() != TextComponentType.TEXT) {
            logger.log(Level.ERROR, "Illegal component type: {}. Expected TEXT.", component.getType());
            throw new TextException("Illegal component type: . Expected TEXT." + component.getType());
        }

        Optional<Integer> maxLength = component.getChildren().stream()
                .flatMap(paragraph -> paragraph.getChildren().stream())
                .map(this::countMaxWordLength)
                .max(Integer::compareTo);

        if (maxLength.isEmpty()) {
            logger.log(Level.ERROR, "Component contains no words");
            throw new TextException("Component contains no words");
        }

        return component.getChildren().stream()
                .flatMap(paragraph -> paragraph.getChildren().stream())
                .filter(sentence -> countMaxWordLength(sentence) == maxLength.get())
                .collect(Collectors.toList());
    }

    @Override
    public int countEqualWords(TextComponent component, String wordToSearchFor) throws TextException {
        if (component.getType() != TextComponentType.TEXT) {
            logger.log(Level.ERROR, "Illegal component type: {}. Expected TEXT.", component.getType());
            throw new TextException("Illegal component type: . Expected TEXT." + component.getType());
        }
        return (int) component.getChildren().stream()
                .flatMap(paragraph -> paragraph.getChildren().stream())
                .flatMap(sentence -> sentence.getChildren().stream())
                .flatMap(lexeme -> lexeme.getChildren().stream())
                .filter(el -> el.getType() == TextComponentType.WORD)
                .filter(word -> word.toString().equals(wordToSearchFor))
                .count();
    }

    @Override
    public int countVowels(TextComponent component) throws TextException {
        if (component.getType() != TextComponentType.SENTENCE) {
            logger.log(Level.ERROR, "Illegal component type: {}. Expected SENTENCE.", component.getType());
            throw new TextException("Illegal component type: . Expected SENTENCE." + component.getType());

        }
        return countLetters(component, VOWEL_REGEX);
    }

    @Override
    public int countConsonants(TextComponent component) throws TextException {
        if (component.getType() != TextComponentType.SENTENCE) {
            logger.log(Level.ERROR, "Illegal component type: {}. Expected SENTENCE.", component.getType());
            throw new TextException("Illegal component type: . Expected SENTENCE." + component.getType());
        }
        return countLetters(component, CONSONANT_REGEX);
    }

    private int countLetters(TextComponent component, String regex) {
        long count = component.getChildren().stream()
                .flatMap(lexeme -> lexeme.getChildren().stream())
                .filter(el -> el.getType() == TextComponentType.WORD)
                .flatMap(word -> word.getChildren().stream())
                .filter(el -> el.toString().matches(regex))
                .count();
        return (int) count;
    }

    private int countWords(TextComponent component) {
        List<TextComponent> childComponents = component.getChildren();
        int count = 0;
        EnumSet<TextComponentType> typesContainingWords = EnumSet.range(TextComponentType.TEXT, TextComponentType.LEXEME);
        for (TextComponent childComponent : childComponents) {
            TextComponentType currentType = childComponent.getType();
            if (currentType == TextComponentType.WORD) {
                count++;
            } else if (typesContainingWords.contains(currentType)) {
                count += countWords(childComponent);
            }
        }
        return count;
    }

    private int countMaxWordLength(TextComponent sentence) {
        return sentence.getChildren().stream()
                .flatMap(lexeme -> lexeme.getChildren().stream())
                .filter(el -> el.getType() == TextComponentType.WORD)
                .map(el -> el.getChildren().size())
                .max(Integer::compareTo)
                .orElse(-1);
    }
}
