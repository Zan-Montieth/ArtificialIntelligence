public class Maze {

    //Node start = findStart();
    //Node end = findEnd();
    char[][] baseMaze;
    char[][] currentState;
    private int mazeWidth;
    private int mazeLength;

    public Maze(String textMaze, int inMazeWidth) {
        mazeWidth = inMazeWidth - 1;
        char[] input =  textMaze.toCharArray();

        int y = 0;
        while(((y + 1)* (mazeWidth)) < textMaze.length() - 1){

            for (int x = 0; x < mazeWidth; x++) {
                baseMaze[y][x] = input[(y * x) + x + 1];
            }
            y++;
        }
        mazeLength = y;
    }

    public void printMaze(){
        for(int y = 0; y < mazeLength; y++){
            for (int x = 0; x < mazeWidth; x++) {
                System.out.print(baseMaze[x][y] + " ");
            }
            System.out.println();
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
