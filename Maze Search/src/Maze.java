import java.util.ArrayList;
import Algs4.Graph;
public class Maze {

    Node start;
    Node end;
    char[][] baseMaze;
    char[][] currentState;
    private int mazeWidth;
    private int mazeHeight;


    public Maze(char[][] textMaze) {
        baseMaze=textMaze;
        currentState = textMaze;
        mazeWidth=textMaze[0].length;
        mazeHeight=textMaze.length;
        start = findStart();
        end = findEnd();

    }

    public void printMaze(){
        for(int x = 0; x < mazeHeight; x++){
            for (int y = 0; y < mazeWidth; y++) {
                System.out.print(baseMaze[x][y] + " ");
            }
            System.out.print("\n");
        }
    }

    private Node findStart(){
        for (int i=0; i < mazeHeight; i++)
            for (int j = 0; j < mazeWidth; j++)
                if (baseMaze[i][j] == 'P') {
                    start = new Node(i, j, null, null);
                    //System.out.printf("start at (%d,%d)\n", i, j);
                }
        return start;
    }

    private Node findEnd(){
        for (int i = 0; i < mazeHeight; i++)
            for (int j = 0; j < mazeWidth; j++)
                if (baseMaze[i][j] == '*') {
                    end = new Node(i, j, null, null);
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
