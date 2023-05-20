package xml.load.save;

public interface IBuilderXML {
    void buildTag(String tagName);
    void buildAttribute(String attributeName, String attributeValue);
    void buildContent(String content);
    // XMLFile getResult();

    /**
     *
     * buildTag(String tagName): Builds a tag with the given name.
     * buildAttribute(String attributeName, String attributeValue): Builds an attribute with the given name and value.
     * buildContent(String content): Builds the content of a tag.
     * getResult(): Retrieves the final result of building the XML.
     * **/
}
