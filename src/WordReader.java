
import java.util.HashMap;

public class WordReader implements IReadable {
    HashMap<Character, Character> states = new HashMap<>();

    @Override
    public Token read(String s) {
        String str = s;
        int i;
        for(i=-1;i<str.length()-1;i++){
            Character ch = str.charAt(i+1);
            if(!Character.isLetter(ch))
                break;
        }
        if(i==-1)
            return null;
        Token token = new Token(Type.Word, str.substring(0,i+1));
        return token;
    }
}
