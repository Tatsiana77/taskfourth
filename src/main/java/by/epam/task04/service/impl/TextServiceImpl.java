package by.epam.task04.service.impl;

import by.epam.task04.entity.TextComponent;
import by.epam.task04.exception.TextException;
import by.epam.task04.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TextServiceImpl implements TextService {

    private static final Logger logger = LogManager.getLogger();
    private static final String VOWEL_REGEX = "[AEIOUaeiou]";
    private static final String CONSONANT_REGEX = "[[^AEIOUaeiou]&&A-Za-z]";

    @Override
    public void sortParagraphsBySentenceCount(TextComponent component) throws TextException {

    }

    @Override
    public List<TextComponent> findSentencesContainingLongestWord(TextComponent component) throws TextException {
        return null;
    }

    @Override
    public void removeSentencesContainingLessWords(TextComponent component, int wordCount) throws TextException {

    }

    @Override
    public int countEqualWords(TextComponent component, String wordToSearchFor) throws TextException {
        return 0;
    }

    @Override
    public int countVowels(TextComponent component) throws TextException {
        return 0;
    }

    @Override
    public int countConsonants(TextComponent component) throws TextException {
        return 0;
    }
}
