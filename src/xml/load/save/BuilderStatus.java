package xml.load.save;

public enum BuilderStatus {
    IDLE,
    READING_OPERATOR,
    READING_VALUE,
    CREATING_EXPRESSION;
}
