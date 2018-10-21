package geekbrains.dfprojectJava.lesson5;

public class ExponentApp {
    public static void main(String[] args) {

        System.out.println(exp(2,4));
    }

    static int exp(int a, int b) {
        if (b == 0)
            return 1;
        if (b == 1)
            return a;
        else return a * (exp(a, b-1));
    }
}
