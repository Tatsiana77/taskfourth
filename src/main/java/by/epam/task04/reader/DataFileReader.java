package by.epam.task04.reader;

import by.epam.task04.exception.TextException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class DataFileReader {
    private static final Logger logger = LogManager.getLogger();

    public String readFromFile(String filePath) throws TextException {
        try {
            Path path = Path.of(filePath);
            return Files.readString(path);
        } catch (InvalidPathException | IOException e) {
            logger.info("Impossible to open file: " + filePath);
            throw new TextException("Impossible to open file: " + filePath, e);
        }
    }
}
