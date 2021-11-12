package by.epam.task04.parser;

import by.epam.task04.entity.TextComponentType;
import by.epam.task04.entity.TextComposite;

import java.util.List;

public class ParagraphParser extends TextAbstractParser {
    private static final String PARAGRAPH_SPLIT_REGEX = "[\\t\\n]+";

    @Override
    public void parse(TextComposite composite, String part) {
        List<String> listParagraph = List.of(part.split(PARAGRAPH_SPLIT_REGEX));
        for (String paragraph : listParagraph) {
            TextComposite paragraphComposite = new TextComposite(TextComponentType.PARAGRAPH);
            composite.add(paragraphComposite);
            nextParser.parse(paragraphComposite, paragraph);
        }
    }
}
