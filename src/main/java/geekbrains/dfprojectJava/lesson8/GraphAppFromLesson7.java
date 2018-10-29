package geekbrains.dfprojectJava.lesson8;

public class GraphAppFromLesson7 {
    public static void main(String[] args) {

        Graph theGraph = new Graph();
        theGraph.addVertex('A');    // 0  (исходная вершина)
        theGraph.addVertex('B');    // 1
        theGraph.addVertex('C');    // 2
        theGraph.addVertex('D');    // 3
        theGraph.addVertex('E');    // 4
        theGraph.addVertex('F');    // 5
        theGraph.addVertex('G');    // 6
        theGraph.addVertex('H');    // 7
        theGraph.addVertex('I');    // 8
        theGraph.addVertex('J');    // 9
        theGraph.addEdge(0, 1);     // AB
        theGraph.addEdge(1, 2);     // BC
        theGraph.addEdge(0, 3);     // AD
        theGraph.addEdge(3, 4);     // DE
        theGraph.addEdge(2, 3);     // DC
        theGraph.addEdge(1, 5);     // FB
        theGraph.addEdge(5, 8);     // FI
        theGraph.addEdge(2, 9);     // CJ
        theGraph.addEdge(4, 6);     // EG
        theGraph.addEdge(6, 7);     // GH
        System.out.print("Shortcut: ");

        // Минимальный кратчайший путь с помощью поиска в ширину
        theGraph.shortcut(0,6);         // from A to G
        System.out.println();
    }
}

class Queue {
    private final int SIZE = 20;
    private int[] queArray;
    private int front;
    private int rear;

    public Queue() {
        queArray = new int[SIZE];
        front = 0;
        rear = -1;
    }

    public void insert(int j) {
        if(rear == SIZE-1)
            rear = -1;
        queArray[++rear] = j;
    }

    public int remove() {
        int temp = queArray[front++];
        if(front == SIZE)
            front = 0;
        return temp;
    }

    public boolean isEmpty() {
        return ( rear+1==front || (front+SIZE-1==rear) );
    }
}

class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}

class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private Queue theQueue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];

        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++)
            for(int k=0; k<MAX_VERTS; k++)
                adjMat[j][k] = 0;
        theQueue = new Queue();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public int getAdjUnvisitedVertex(int v, int n) {
        for(int j=0; j<=n; j++)
            if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
                return j;
        return -1;
    }

    public void shortcut(int from, int to) {
        vertexList[from].wasVisited = true;
        theQueue.insert(from);
        int v2;
        while( !theQueue.isEmpty() )
        {
            int v1 = theQueue.remove();
            while( (v2=getAdjUnvisitedVertex(v1, to)) != -1 )
            {
                vertexList[v2].wasVisited = true;
                theQueue.insert(v2);
                displayVertex(v1);
                displayVertex(v2);
                System.out.print(" ");
            }
        }
        for(int j=from; j<=to; j++)
            vertexList[j].wasVisited = false;
    }
}
