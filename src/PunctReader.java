

public class PunctReader implements IReadable {
    public Token read(String s) {
        String str = s;
        Character ch = str.charAt(0);
            if(Character.isDigit(ch) || Character.isWhitespace(ch) || Character.isLetter(ch))
                return null;
            else
                return  new Token(Type.Punct, ch.toString());
    }
}
