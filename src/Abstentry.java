
public abstract class Abstentry<T> {
    public T key;
    public char value;
    Abstentry(T k, char v){
        key = k;
        value =v;
    }

    @Override
    public abstract int hashCode();
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Abstentry){
            if(((Abstentry) obj).key== key && ((Abstentry) obj).value == value)
                return true;
            else
                return false;
        }
        else return false;
    }
}
