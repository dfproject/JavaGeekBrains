package geekbrains.dfprojectJava.lesson6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Stack;

public class TreeApp {

    public static void main(String[] args) throws IOException{

        int amount = 20;
        int depth;
        int n;

        Tree[] tree = new Tree[amount];
        for (int i = 0; i < amount; i++) {
            tree[i] = new Tree();
        }

        while(true){
            System.out.print("Enter d - to set depth of threes, ");
            System.out.print("s - to show threes: ");
            int choice = getChar();
            switch(choice){
                case 'd':
                    System.out.print("Enter depth of threes: ");
                    depth = getInt();
                    n = exp(depth) - 1;
                    for (int j = 0; j < amount; j++) {
                    for (int i = 0; i <= n; i++) {
                        tree[j].insert(new Random().nextInt(101 + 100) - 100);
                    }}
                    break;
                case 's':
                    for (int i = 0; i < amount; i++) {
                        tree[i].displayTree();
                    }
                    break;
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException{
        String s = getString();
        return Integer.parseInt(s);
    }

    public static int exp(int b) {
        if (b == 0)
            return 1;
        if (b == 1)
            return 2;
        else return 2 * (exp( b-1));
    }
}

class Node{
    public int number;
    public Node leftChild;
    public Node rightChild;

    public void display(){
        System.out.print('{');
        System.out.print(number);
        System.out.print('}');
    }
}

class Tree{

    private Node root;

    public void insert(int number){
        Node node = new Node();
        node.number = number;
        if (root == null){
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (number < current.number){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public void displayTree(){
        Stack stack = new Stack();
        stack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");

        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for(int i=0;i<nBlanks;i++){
                System.out.println(" ");
            }
            while (stack.isEmpty() == false) {
                Node temp = (Node)stack.pop();
                if (temp != null){
                    temp.display();
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null || temp.rightChild != null){
                        isRowEmpty = false;
                    }
                }else{
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j<nBlanks*2-2; j++)
                    System.out.print(' ');
            }
            System.out.println(" ");
            nBlanks = nBlanks/2;
            while (localStack.isEmpty() == false) {
                stack.push(localStack.pop());
            }
            System.out.println("......................................................");
        }
    }

}
