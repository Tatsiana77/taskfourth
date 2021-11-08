package by.epam.task04.parser;

import by.epam.task04.exception.TextException;

import java.awt.*;

public interface InformationParser {
    TextComponent parse(String text) throws TextException;
}
