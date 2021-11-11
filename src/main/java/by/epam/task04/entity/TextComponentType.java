package by.epam.task04.entity;

public enum TextComponentType {
    TEXT(" \n\t"),
    PARAGRAPH(" "),
    SENTENCE(" "),
    LEXEME(""),
    WORD(""),
    SYMBOL(""),
    PUNCTUATION("");


    private final String delimit;

    TextComponentType(String delimit) {
        this.delimit = delimit;
    }

    public String getDelimit() {
        return delimit;
    }
}
