package AboutCollection;

import java.util.*;

public class AnalyzerList {
    int count;
    private List<Entry> Dictionary;

    AnalyzerList(int c, List<Entry> list) {
        count = c;
        Dictionary = list;
    }
    public long AddWordsIntoDictionary(String[] inputWordsArray) {
        long time = System.currentTimeMillis();
        for (int inc = 0; inc < inputWordsArray.length; inc++) {
            int wordPosition = -1;
            ListIterator<Entry> iterator = Dictionary.listIterator();
            String d = inputWordsArray[inc];
            while (iterator.hasNext()) {
                Entry e = iterator.next();
                if (d.equals(e.getKey())) {
                    iterator.set(new Entry(e.getKey(), e.getValue() + 1));
                    wordPosition = 0;
                    break;
                }
            }
            if (wordPosition == -1)
                Dictionary.add(new Entry(inputWordsArray[inc], 1));
        }
        return System.currentTimeMillis() - time;
    }

    public long SearingInDictionary(String prefi){
        String prefix= "";
        try {
            prefix = new String(prefi.getBytes(), "UTF-8");
        }catch (Exception e){}
        if (Dictionary == null || Dictionary.size() == 0 || prefix == "")
            return 0;
        long time = System.currentTimeMillis()*1000;
        ArrayList<Entry> entryList = new ArrayList<>();
        int i = 0;
        for (Entry e : Dictionary) {
            if (e.getKey().startsWith(prefix)) {
                entryList.add(e);
                i++;
            }
            if (i == count)
                break;
        }
        Entry[] array =entryList.toArray(new Entry[0]);
        Arrays.sort(array);
        return System.currentTimeMillis()*1000 - time;
    }

}
