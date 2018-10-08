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
    List<Node> list;
    Graph graph;

    public Maze(char[][] textMaze) {
        baseMaze=textMaze;
        currentState = textMaze;
        mazeWidth=textMaze[0].length;
        mazeHeight=textMaze.length;
        start = findStart();
        end = findEnd();
        int start;
        int end;
        list = new ArrayList<>();
        createGraph();
    }

    public void printMaze(){
        for(int x = 0; x < mazeHeight; x++){
            for (int y = 0; y < mazeWidth; y++) {
                System.out.print(baseMaze[x][y] + " ");
            }
            System.out.print("\n");
        }
    }

    private void createGraph(){
        //create nodes for start and end
        list.add(start);
        list.add(end);
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
                        Node node = new Node(i,j);
                        list.add(node);
                        currentState[i][j] = 'O';
                    }


                }
                                          //if no chekc 4 adjasent square if at least 3 blank make node\
                                          // store in array list of nodes
            }
        }
        int s = list.size();
        System.out.println(s);
        graph = new Graph(s);   // find length of array list and create graph with that many nodes
    }



    private Node findStart(){
        for (int i=0; i < mazeHeight; i++)
            for (int j = 0; j < mazeWidth; j++)
                if (baseMaze[i][j] == 'P') {
                    start = new Node(i, j);
                    //System.out.printf("start at (%d,%d)\n", i, j);
                }
        return start;
    }

    private Node findEnd(){
        for (int i = 0; i < mazeHeight; i++)
            for (int j = 0; j < mazeWidth; j++)
                if (baseMaze[i][j] == '*') {
                    end = new Node(i, j);
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
            for (int j = 0; j < mazeWidth; j++){
                assignTo[i][j] = assignFrom[i][j];
            }
    }

}
