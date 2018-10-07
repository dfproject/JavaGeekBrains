package geekbrains.dfprojectJava.lesson3;

public class Queue {
    private int maxSize;
    private int[] queue;
    private int front;
    private int rear;
    private int items;

    public Queue(int s){
        maxSize = s;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }
    public void insert(int i){
        if(rear == maxSize-1)
            rear = -1;
        queue[++rear] = i;
        items++;
    }

    public int remove(){
        int temp = queue[front++];
        if(front == maxSize)
            front = 0;
        items--;
        return temp;
    }

    public int peek(){
        return queue[front];
    }
    public boolean isEmpty(){
        return (items==0);
    }

    public boolean isFull(){
        return (items==maxSize);
    }

    public int size(){
        return items;
    }
}
class QueueApp{
    public static void main(String[] args){
        Queue q = new Queue(5);
        q.insert(10);
        q.insert(20);
        q.insert(30);
        q.insert(40);
        q.insert(50);
        q.remove();
        q.remove();

        q.insert(50);
        q.insert(60);
        q.insert(70);
        q.insert(80);
        while( !q.isEmpty() ){
            int n = q.remove();
            System.out.println(n);

        }
    }
}
