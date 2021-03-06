package by.epam.task04.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class SymbolLeaf implements TextComponent {

    private static final Logger logger = LogManager.getLogger();
    private TextComponentType type;
    private char symbol;

    public SymbolLeaf(TextComponentType type) {
        this.type = type;

    }

    public SymbolLeaf(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean add(TextComponent component) {
        logger.info("Operation is not available of this component");
        throw new UnsupportedOperationException("Operation is not available of this component");
    }

    @Override
    public boolean remove(TextComponent component) {
        logger.info("Operation is not available of this component");
        throw new UnsupportedOperationException("Operation is not available of this component");
    }

    @Override
    public List<TextComponent> getChildren() {
        logger.info("Operation is not available of this component");
        throw new UnsupportedOperationException("Operation is not available of this component");
    }

    @Override
    public TextComponentType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SymbolLeaf that = (SymbolLeaf) o;
        return symbol == that.symbol && type == that.type;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += result * 31 + type.hashCode();
        result += result * 31 + Character.hashCode(symbol);
        return result;
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}
