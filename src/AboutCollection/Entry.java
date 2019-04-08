package AboutCollection;

import java.util.Map;

public class Entry implements Map.Entry<String, Integer>, Comparable<Entry> {
    private String key;
    private Integer value;

    public Entry(String k, Integer v) {
        key = k;
        value = v;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Integer setValue(Integer value) {
        this.value = value;
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(Entry e) {
        int del = value.compareTo(e.getValue());
        return del != 0 ? del :
                key.compareTo(e.key);
    }


}
