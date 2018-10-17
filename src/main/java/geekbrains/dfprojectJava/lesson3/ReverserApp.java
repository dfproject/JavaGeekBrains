package geekbrains.dfprojectJava.lesson3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverserApp {

    public static void main(String[] args) throws IOException {
        String input, output;
        while(true)
        {
            System.out.print("Введите строку: ");
            System.out.flush();
            input = getString();
            if( input.equals("") )
                break;
            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev();
            System.out.println("Перевернутая строка: " + output);
        }
    }
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
class Reverser {
    private String input;
    private String output;

    public Reverser(String in)
    { input = in; }
    public String doRev()
    {
        int size = input.length();
        Stack stack = new Stack(size);
        for(int j=0; j<input.length(); j++)
        {
            char ch = input.charAt(j);
            stack.push(ch);
        }
        output = "";
        while( !stack.isEmpty() )
        {
            char ch = stack.pop();
            output = output + ch;
        }
        return output;
    }
}