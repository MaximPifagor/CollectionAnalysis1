
public class Token {
    public Type type;
    public String str;
    public Object data;
    public int lenght;
    Token(Type ty, String s){
        str = s;
        type = ty;
        lenght = s.length();
    }

    @Override
    public String toString() {
        return str;
    }
}
