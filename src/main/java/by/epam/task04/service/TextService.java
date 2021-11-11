package by.epam.task04.service;

import by.epam.task04.entity.TextComponent;
import by.epam.task04.exception.TextException;

import java.util.List;

public interface TextService {
    void sortParagraphBySentenceCount(TextComponent component) throws TextException;

    List<TextComponent> findSentencesContainingLongestWord(TextComponent component) throws TextException;

    void removeSentencesContainingLessWords(TextComponent component, int wordCount) throws TextException;

    int countEqualWords(TextComponent component, String wordToSearchFor) throws TextException;

    int countVowels(TextComponent component) throws TextException;

    int countConsonants(TextComponent component) throws TextException;
}
