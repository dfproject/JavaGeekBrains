package geekbrains.dfprojectJava.lesson2;

import java.util.Random;

public class MyArr {
    private int[] arr;
    private int size;

    public MyArr(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.arr[i]);
        }
    }

    //    2.Написать методы удаления, добавления, поиска элемента массива.
    public void insert(int value) {    // Добавление элемента
        int i;
        for(i=0;i<this.size;i++){
            if (this.arr[i]>value)
                break;
        }
        for(int j=this.size;j>i;j--){
            this.arr[j] = this.arr[j-1];
        }
        this.arr[i] = value;
        this.size++;
    }
    public void delete(int value) {    // Удаление элемента
        int i = 0;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] == value) break;
        }

        for (int j = i; j < this.size-1; j++) {
            this.arr[j] = this.arr[j +1];
        }
        this.size--;
    }
    public boolean find(int value){     // Поиск элемента
        int i;
        for(i=0;i<this.size;i++){
            if (this.arr[i] == value) break;
        }
        if (i==this.size)
            return false;
        else
            return true;
    }
    public boolean binaryFind(int value) {    // Бинарный поиск элемента
        int low = 0;
        int high = this.size - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (value == this.arr[mid]) {
                return true;
            } else {
                if (value < this.arr[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }
    public void sortBubble(){
        int out, in;
        for (out = this.size-1;out>1;out--){
            for(in=0;in<out;in++){
                if (this.arr[in]>this.arr[in+1]){
                    change(in, in+1);
                }
            }
        }
    }

    private void change(int a, int b){
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }

    public void sortSelect(){
        int out, in, mark;
        for(out=0;out<this.size;out++){
            mark = out;
            for(in = out+1;in<this.size;in++){
                if (this.arr[in]< this.arr[mark]){
                    mark = in;
                }
            }
            change(out, mark);
        }
    }
    public void sortInsert(){
        int in, out;
        for(out = 1;out < this.size; out++){
            int temp = this.arr[out];
            in = out;
            while(in > 0 && this.arr[in-1] >=temp){
                this.arr[in] = this.arr[in-1];
                --in;
            }
            this.arr[in] = temp;
        }
    }

    public void mix() {              // Перемешать элементы в массиве
        Random rnd = new Random();
        for (int i = 1; i < this.size; i++) {
            int j = rnd.nextInt(i);
            int temp = this.arr[i];
            this.arr[i] = this.arr[j];
            this.arr[j] = temp;
        }
    }
}
