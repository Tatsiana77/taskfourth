package by.epam.task04.parser;

import by.epam.task04.entity.TextComponent;
import by.epam.task04.exception.TextException;

public interface InfoParser {
    TextComponent parse(String text) throws TextException;
}
