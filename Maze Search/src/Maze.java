import java.util.ArrayList;
import java.util.List;
import Algs4.*;
public class Maze {

    Node start;
    Node end;
    char[][] baseMaze;
    char[][] currentState;
    private int mazeWidth;
    private int mazeHeight;
    Node[] list;
    EdgeWeightedGraph graph;

    public Maze(char[][] textMaze) {
        mazeWidth=textMaze[0].length;
        mazeHeight=textMaze.length;
        baseMaze=new char[mazeHeight][mazeWidth];
        currentState=new char[mazeHeight][mazeWidth];
        assign(baseMaze,textMaze);
        assign(currentState,textMaze);
        start = findStart();
        end = findEnd();
        //int start;
        //int end;
        list = new Node[10000];
        createGraph();
        start.checkMinDistance(0,null);
    }

    public void printMaze(){
        System.out.print("\n");
        for(int x = 0; x < mazeHeight; x++){
            for (int y = 0; y < mazeWidth; y++) {
                System.out.print(currentState[x][y] + " ");
            }
            System.out.print("\n");
        }
    }

    private void createGraph(){
        //create nodes for start and end
        hashIndex(start);
        hashIndex(end);
        int s = 1; // changed so it holds the correct value from the graph, add 1 to find total count
        for(int i =0; i<mazeHeight;i++){  // non edge values
            for(int j=0; j<mazeWidth;j++){
                int count = 0;
                if(baseMaze[i][j]==' ') { // all the spaces we can visit
                    if(baseMaze[i][j+1]==' '|| baseMaze[i][j+1]=='P'|| baseMaze[i][j+1]=='*') { // up
                        count++;
                    }
                    if(baseMaze[i+1][j]==' '|| baseMaze[i+1][j]=='P'|| baseMaze[i+1][j]=='*') { // right
                        count++;
                    }
                    if(baseMaze[i][j-1]==' '|| baseMaze[i][j-1]=='P'|| baseMaze[i][j-1]=='*') { // down
                        count++;
                    }
                    if(baseMaze[i-1][j]==' '|| baseMaze[i-1][j]=='P'|| baseMaze[i-1][j]=='*') { // left
                        count++;
                    }
                    if(count>=3){
                        Node node = new Node(i,j,s);
                        hashIndex(node);
                        node.setEndDistance(end.getX(),end.getY());
                        currentState[i][j] = 'O';
                        s++;
                    }


                }
                                          //if no chekc 4 adjasent square if at least 3 blank make node\
                                          // store in array list of nodes
            }
        }

        //System.out.println(s);
        graph = new EdgeWeightedGraph(s);   // find length of array list and create graph with that many nodes
    }


    public void hashIndex(Node temp){
        int x = temp.getX();
        int y = temp.getY();

        list[(x*100+y)]= temp;
    }



    public Node hashpull(int x,int y){
        Node temp = list[(x*100)+y];
        return(temp);
    }



    private Node findStart(){
        for (int i=0; i < mazeHeight; i++)
            for (int j = 0; j < mazeWidth; j++)
                if (baseMaze[i][j] == 'P') {
                    start = new Node(i, j, 0);
                    //System.out.printf("start at (%d,%d)\n", i, j);
                }
        return start;
    }

    private Node findEnd(){
        for (int i = 0; i < mazeHeight; i++)
            for (int j = 0; j < mazeWidth; j++)
                if (baseMaze[i][j] == '*') {
                    end = new Node(i, j, 1);
                    //System.out.printf("end at (%d,%d)\n", i, j);
                }
        return end;
    }

    public void printStart() {
        System.out.printf("Start at (%d,%d)\n", start.getX(), start.getY());
    }

    public void printEnd() {
        System.out.printf("End at (%d,%d)\n", end.getX(), end.getY());
    }

    private void assign(char[][] assignTo, char[][] assignFrom) {
        for (int i = 0; i < mazeHeight; i++)
            for (int j = 0; j < mazeWidth; j++) assignTo[i][j] = assignFrom[i][j];
    }

    public char getSpot(int inX, int inY){
        return currentState[inX][inY];
    }
    public Node getStart(){
        return start;
    }

    public Node getEnd(){
        return end;
    }

    public void reset(){
        assign(currentState,baseMaze);
        createGraph();
    }
}
