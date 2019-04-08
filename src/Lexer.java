import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private List<IReadable> ReadersList = new ArrayList<IReadable>();

    void Register(IReadable reader){
        ReadersList.add(reader);
    }

    Token[] Tokenize(String str){
        int startIndex=0;
        List<Token> tokens = new ArrayList<Token>();
        for(int i=0; startIndex<str.length();){
            String form = str.substring(startIndex);
            Token maxToken = null;
            for(IReadable reader : ReadersList){
                Token token = reader.read(form);
                if(token != null){
                    if(maxToken == null)
                        maxToken= token;
                    else if (token.lenght > maxToken.lenght)
                        maxToken = token;
                }
            }
            if(maxToken == null){
                return null;
            }
            tokens.add(maxToken);
            startIndex = startIndex + maxToken.lenght;
        }

        return tokens.toArray(new Token[0]);
    }

    public static void main(String[] args) throws Exception {
        Lexer lexer = new Lexer();
        IReadable reader1 = new WhiteBordReader();
        IReadable reader2 = new WordReader();
        IReadable reader3 = new NumReader();
        IReadable reader5 = new IntReader();
        IReadable reader4 = new PunctReader();
        lexer.Register(reader1);
        lexer.Register(reader2);
        lexer.Register(reader3);
        lexer.Register(reader4);
        lexer.Register(reader5);
        String s = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("pr.txt"), "windows-1251"));
        for (int i = 0; bufferedReader.ready() ; i++) {
            s =s + bufferedReader.readLine();
        }
        bufferedReader.close();

        Token[] tokens= lexer.Tokenize(s);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("tokens1.txt")));
        ArrayList<String> list = new ArrayList<>();
        for (Token t : tokens) {
            String str = t.toString();
            if(str.length()>2 && t.type==Type.Word) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }


}
