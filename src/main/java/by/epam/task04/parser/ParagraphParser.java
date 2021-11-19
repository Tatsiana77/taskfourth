package by.epam.task04.parser;

import by.epam.task04.entity.TextComponent;
import by.epam.task04.entity.TextComponentType;
import by.epam.task04.entity.TextComposite;

public class ParagraphParser extends AbstractTextParser {

    private static final String PARAGRAPH_SPLIT_REGEX = "(?m)(?=^((\\t)|(\\s{4})))";

    public ParagraphParser() {
        this.nextParser = new SentenceParser();
    }

    @Override
    public void parse(TextComponent component, String textPart) {
        String[] paragraphs = textPart.split(PARAGRAPH_SPLIT_REGEX);

        for (String paragraph : paragraphs) {
            TextComponent paragraphComponent = new TextComposite(TextComponentType.PARAGRAPH);
            component.add(paragraphComponent);
            nextParser.parse(paragraphComponent, paragraph);
        }

    }
}
