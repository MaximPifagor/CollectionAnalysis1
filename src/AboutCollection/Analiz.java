package AboutCollection;

import java.io.*;
import java.util.*;

public class Analiz {
    TreeMap<Integer, Double> MakingArray;
    TreeMap<Integer, Double> SearchingArray;

    TreeMap<Integer, Double> MakingLinked;
    TreeMap<Integer, Double> SearchingLinked;

    TreeMap<Integer, Double> MakingMap;
    TreeMap<Integer, Double> SearchingMap;
    protected String prefix;

    Analiz(String prefix) {
        MakingArray = new TreeMap<>();
        SearchingArray = new TreeMap<>();
        MakingLinked = new TreeMap<>();
        SearchingLinked = new TreeMap<>();
        MakingMap = new TreeMap<>();
        SearchingMap = new TreeMap<>();
        this.prefix = prefix;
    }

    public void Test(String[] s) {
        double a1 = 0;
        double b1 = 0;
        for (int i = 0; i < 100; i++) {
            AnalyzerList analyzerList = new AnalyzerList(10, new ArrayList<>());
            a1 = a1 + analyzerList.AddWordsIntoDictionary(s);
            b1 = b1 + analyzerList.SearingInDictionary(prefix);
        }
        MakingArray.put(s.length, a1 / 100);
        SearchingArray.put(s.length, b1 / 100);

        double a2 = 0;
        double b2 = 0;
        for (int i = 0; i < 100; i++) {
            AnalyzerList analyzerList = new AnalyzerList(10, new LinkedList<>());
            a2 = a2 + analyzerList.AddWordsIntoDictionary(s);
            b2 = b2 + analyzerList.SearingInDictionary(prefix);
        }
        MakingLinked.put(s.length, a2 / 100);
        SearchingLinked.put(s.length, b2 / 100);

        double a3 = 0;
        double b3 = 0;
        for (int i = 0; i < 100; i++) {
            HashMapAnalyz hashMapAnalyz = new HashMapAnalyz(10, new HashMap<>());
            a3 = a3 + hashMapAnalyz.MakeDictionary(s);
            b3 = b3 + hashMapAnalyz.SearchInDictionary(prefix);
        }
        MakingMap.put(s.length, a3 / 100);
        SearchingMap.put(s.length, b3 / 100);


    }


    public static void main(String[] args) throws Exception {
       /* String prefix;
        Scanner scanner;
        scanner = new Scanner(System.in);
        prefix = scanner.nextLine();
        scanner.close();
*/
        ArrayList<String> arrayList = new ArrayList<>();
        Analiz analiz = new Analiz("гов");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("tokens2.txt"), "windows-1251"));
            try {
                int y = 0;
                while (bufferedReader.ready()&& y <80000) {
                    String s = bufferedReader.readLine();
                    if (s.length() >= 3) {
                        arrayList.add(s);
                        y++;
                    }
                }
            } catch (Exception e) {
            } finally {
                bufferedReader.close();
            }
        } catch (Exception e) {
        }

        analiz.Test(arrayList.toArray(new String[0]));
        for (int i = 1; i <5 ; i++) {
            ArrayList<String> arrayList1 = new ArrayList<>();
            for (int j = 0; j < arrayList.size() /Math.pow(2,i); j++) {
                arrayList1.add(arrayList.get(j));
            }
            analiz.Test(arrayList1.toArray(new String[0]));
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        ArrayList<String> s = new ArrayList<String>();

        for (Map.Entry entry : analiz.MakingArray.entrySet()) {
           writer.write(entry.toString());
           writer.newLine();
        }
        writer.newLine();
        for (Map.Entry entry : analiz.SearchingArray.entrySet()) {
            writer.write(entry.toString());
            writer.newLine();

        }
        writer.newLine();
        for (Map.Entry entry : analiz.MakingLinked.entrySet()) {
            writer.write(entry.toString());
            writer.newLine();
        }
        writer.newLine();
        for (Map.Entry entry : analiz.SearchingLinked.entrySet()) {
            writer.write(entry.toString());
            writer.newLine();
        }
        writer.newLine();
        for (Map.Entry entry : analiz.MakingMap.entrySet()) {
            writer.write(entry.toString());
            writer.newLine();
        }
        writer.newLine();
        for (Map.Entry entry : analiz.SearchingMap.entrySet()) {
            writer.write(entry.toString());
            writer.newLine();
        }
        writer.close();

    }

}


