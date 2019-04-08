package AboutCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class HashMapAnalyz {
    private int count;
    private Map<String, Integer> Dictionary;

    HashMapAnalyz(int c, Map<String, Integer> map) {
        count = c;
        Dictionary = map;
    }

    public long MakeDictionary(String[] s) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < s.length; i++) {
            Dictionary.put(s[i], Dictionary.getOrDefault(s[i], 0) + 1);
        }
        return System.currentTimeMillis() - time;
    }

    public long SearchInDictionary(String prefi) {
        String prefix= "";
        try {
            prefix = new String(prefi.getBytes(), "UTF-8");
        }catch (Exception e){}
        if (Dictionary == null || Dictionary.size() == 0 || prefix == "")
            return 0;

        long time = System.currentTimeMillis()*1000;
        int i = 0;
        ArrayList<Entry> entries = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : Dictionary.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                entries.add(new Entry(entry.getKey(), entry.getValue()));
                i++;
            }
            if (i == count)
                break;
        }
        Entry[] entryArr = entries.toArray(new Entry[0]);
        Arrays.sort(entryArr);
        return System.currentTimeMillis()*1000 - time;
    }
}
