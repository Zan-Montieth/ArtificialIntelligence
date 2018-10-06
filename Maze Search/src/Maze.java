public class Maze {

    //Node start = findStart();
    //Node end = findEnd();
    char[][] baseMaze;
    char[][] currentState;
    private int mazeWidth;

    public Maze(String textMaze, int inMazeWidth) {
        mazeWidth = inMazeWidth;
        for(int x = 0; x < inMazeWidth - 1; x++){
            //baseMaze[x][0] =
            //baseMaze = textMaze;
        }
        //currentState = textMaze;
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
