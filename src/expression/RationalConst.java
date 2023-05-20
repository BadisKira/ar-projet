package expression;

import java.util.ArrayList;
import java.util.List;

public class RationalConst implements RationalExpression {
    private List<String> recognizedWords;
    public RationalConst(String word){
        recognizedWords = new ArrayList<String>();
        recognizedWords.add(word);
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        for(int i = 0; i < recognizedWords.size();i++){
            str.append(recognizedWords.get(i));
            if(i < recognizedWords.size() - 1)
                str.append(",");
        }
        str.append("}");
        return str.toString();
    }

    @Override
    public List<String> getRecognizedWords() {
        return recognizedWords;
    }
}