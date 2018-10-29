package geekbrains.dfprojectJava.lesson8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MethodChainApp {

    public static void main(String[] args) throws IOException {
        Item aDataItem;
        int aKey, size, n, keysPerCell;

        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;

        HashTable theHashTable = new HashTable(size);
        for (int j = 0; j < n; j++) {
            aKey = (int) (java.lang.Math.random() *
                    keysPerCell * size);
            aDataItem = new Item(aKey);
            theHashTable.insert(aDataItem);
        }
        while (true) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new Item(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if (aDataItem != null)
                        System.out.println("Found " + aKey);
                    else
                        System.out.println("Could not find " + aKey);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}

class Item {
    private int data;
    public Item next;

    public Item(int it) {
        data = it;
    }
    public int getKey() {
        return data;
    }
    public void display() {
        System.out.print(data + " ");
    }
}

class SortedList {
        private Item first;

        public void SortedList() {
            first = null;
        }

        public void insert(Item item) {
            int key = item.getKey();
            Item previous = null;
            Item current = first;

            while( current != null && key > current.getKey() ) {
                previous = current;
                current = current.next;
            }
            if(previous==null)
                first = item;
            else
                previous.next = item;
            item.next = current;
        }

        public void delete(int key) {
            Item previous = null;
            Item current = first;

            while( current != null && key != current.getKey() ) {
                previous = current;
                current = current.next;
            }

            if(previous==null)
                first = first.next;
            else
                previous.next = current.next;
        }
        public Item find(int key) {
        Item current = first;
        while(current != null &&  current.getKey() <= key) {
            if(current.getKey() == key)
                return current;
            current = current.next;
        }
        return null;
    }

        public void displayList() {
            System.out.print("List (first-->last): ");
            Item current = first;
            while(current != null)
            {
                current.display();
                current = current.next;
            }
            System.out.println(" ");
        }
}

class HashTable {
        private SortedList[] hashArr;
        private int arrSize;

        public HashTable(int size) {
            arrSize = size;
            hashArr = new SortedList[arrSize];
            for(int j = 0; j< arrSize; j++)
                hashArr[j] = new SortedList();
        }

        public void displayTable() {
            for(int j = 0; j< arrSize; j++) {
                System.out.print(j + ". ");
                hashArr[j].displayList();
            }
        }
        public int hashFunc(int key) {
        return key % arrSize;
        }

        public void insert(Item theItem) {
            int key = theItem.getKey();
            int hashVal = hashFunc(key);
            hashArr[hashVal].insert(theItem);
        }

        public void delete(int key) {
            int hashVal = hashFunc(key);
            hashArr[hashVal].delete(key);
        }

        public Item find(int key) {
            int hashVal = hashFunc(key);
            Item item = hashArr[hashVal].find(key);
            return item;
        }

}


