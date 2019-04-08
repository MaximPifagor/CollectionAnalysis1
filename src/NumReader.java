
import java.util.HashMap;
import java.util.HashSet;

public class NumReader implements IReadable {
    public static enum States {
        START(1), Integer(2),DOT(3),Double(4),END(5);
        int num;
        States(int i)
        {
            num = i;
        }
    }

    public class Entry extends Abstentry<States> {

        Entry(NumReader.States k, char v) {
            super(k, v);
        }

        @Override
        public int hashCode() {
            return (int)value + key.num*10000;
        }
    }

    HashSet<States> TerminalStates = new HashSet<States>();

    HashMap<Abstentry, States> table = new HashMap<>();

    {
        char [] ch = new char[]{'0','1','2','3','4','5','6','7','8','9'};
        for (int i = 0; i < 10; i++) {
            table.put(new Entry(States.START, ch[i]), States.Integer);
        }
        for (int i = 0; i < 10; i++) {
            table.put(new Entry(States.Integer, ch[i]), States.Integer);
        }

        table.put(new Entry(States.Integer,  ','), States.DOT);

        for (int i = 0; i < 10; i++) {
            table.put(new Entry(States.DOT, ch[i]), States.Double);
        }
        for (int i = 0; i < 10; i++) {
            table.put(new Entry(States.Double, ch[i]), States.Double);
        }

        TerminalStates.add(States.Integer);
        TerminalStates.add(States.Double);

    }
    @Override
    public Token read(String s) {
        States currentState = States.START;
        int count =0;
        for(int i = 0; i<s.length(); i++){
            if(table.containsKey(new Entry(currentState,s.charAt(i)))){
                currentState = table.get(new Entry(currentState,s.charAt(i)));
                count++;
            }
            else {
                break;
            }
        }

        if(TerminalStates.contains(currentState))
            return new Token(Type.Number,s.substring(0,count));
        else
            return null;
    }

    private Token Checker(String s){
        int count =0;
        for(int i =0;i<s.length(); i++){
            if(s.charAt(i)==',')
                count++;
        }
        if(count>1)
            return null;

        return new Token(Type.Number, s);
    }


}
