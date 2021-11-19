package by.epam.task04.entity;

public enum TextComponentType {
    TEXT(" \n\t", ""),
    PARAGRAPH(" ", ""),
    SENTENCE(" ", ""),
    LEXEME("", ""),
    WORD("", ""),
    PUNCTUATION("", "");


    private String prefix = "";
    private String suffix = "";

    TextComponentType(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    TextComponentType() {
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }
}
