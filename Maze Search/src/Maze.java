import java.util.ArrayList;
public class Maze {

//    Node start = findStart();
//    Node end = findEnd();
    char[][] baseMaze;
    char[][] currentState;
    private int mazeWidth;
    private int mazeHeight;

    public Maze(char[][] textMaze) {
        baseMaze=textMaze;
        currentState = textMaze;
        mazeWidth=textMaze[0].length;
        mazeHeight=textMaze.length;
    }

    public void printMaze(){
        for(int x = 0; x < mazeHeight; x++){
            for (int y = 0; y < mazeWidth; y++) {
                System.out.print(baseMaze[x][y] + " ");
            }
            System.out.print("\n");
        }
    }
/*
    private Node findStart(){
        for (int i=0; i<baseMaze.length; i++)
            for (int j = 0; j < baseMaze.length; j++)
                if (baseMaze[i][j] == 'P') start = new Node(i, j, null, null);
        return start;
    }

    private Node findEnd(){
        for (int i=0; i<baseMaze.length; i++)
            for (int j = 0; j < baseMaze.length; j++)
                if (baseMaze[i][j] == '*') end = new Node(i, j, null, null);
        return end;
    }
*/
}
