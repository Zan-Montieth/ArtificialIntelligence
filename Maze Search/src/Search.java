import java.util.PriorityQueue;

public class Search {

    Maze maze;
    PriorityQueue<Node> queue;


    public void Search(Maze currentMaze) {
        maze = currentMaze;
        runBFS(maze);
        runDPS(maze);
        runGBFS(maze);
        runAS(maze);
    }

    private void runBFS(Maze maze) {
        int x = maze.getStart().getX();
        int y = maze.getStart().getY();

    }

    private void runDPS(Maze maze) {

    }

    private void runGBFS(Maze maze) {

    }

    private void runAS(Maze maze) {

    }

    private Node traverse(Maze inMaze, int x, int y) {
        Node found;
        if (inMaze.hashpull(x, y) !=null) {
            found = inMaze.hashpull(x, y);  // if node found

        }
        else {          //if node not found keep walking
            inMaze.currentState[x][y]= '.';
            if(inMaze.currentState[x][y+1]==' '){
                found = traverse(inMaze,x,(y+1));

            }
            if(inMaze.currentState[x+1][y]==' '){
                found = traverse(inMaze,x+1,y);
            }
            if(inMaze.currentState[x][y-1]==' '){
                found = traverse(inMaze,x,(y-1));
            }
            else{
                found = traverse(inMaze,x-1,y);
            }
        }
        return(found);
    }

}
