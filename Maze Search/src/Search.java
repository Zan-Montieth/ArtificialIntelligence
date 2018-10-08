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

    /*private Node traverse(Maze inMaze, int startX, int startY, int endX, int endY) {
        Node found;
        if (inMaze.isNode(endX,endY)) found = inMaze.getNode(endX,endY);
        else {
            if ();
        }

    }*/

}
