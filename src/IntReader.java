
public class IntReader implements IReadable {
    @Override
    public Token read(String s) {
        String str = s;
        int i;
        for(i=-1;i<str.length()-1;i++){
            Character ch = str.charAt(i+1);
            if(!Character.isDigit(ch))
                break;
        }
        if(i==-1)
            return null;
        Token token = new Token(Type.Number, str.substring(0,i+1));
        return token;
    }
}

