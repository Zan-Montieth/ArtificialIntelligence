import java.util.PriorityQueue;

public class Search {

    Maze maze;
    PriorityQueue<Node> queue;


    public void Search(Maze currentMaze) {
        maze = currentMaze;
        runBFS(maze);
        maze.reset();
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

    private Node traverse(Maze inMaze, int startX, int startY, int endX, int endY) {
        Node found;
        if (inMaze.hashpull(endX,endY) != null) found = inMaze.hashpull(endX,endY);
        else {
            if (inMaze.getSpot(endX+1,endY) == ' ') {
                found = traverse(inMaze, endX, endY, endX + 1, endY);
            }
            if (inMaze.getSpot(endX-1,endY) == ' ') {
                found = traverse(inMaze, endX, endY, endX - 1, endY);
            }
            if (inMaze.getSpot(endX,endY+1) == ' ') {
                found = traverse(inMaze, endX, endY, endX, endY+1);
            }
            else{
                found = traverse(inMaze, endX, endY, endX, endY-1);
            }
        }
        return found;

    }

}
