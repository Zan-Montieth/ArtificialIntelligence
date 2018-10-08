import java.util.PriorityQueue;
import Algs4.*;

public class Search {

    Maze maze;
    PriorityQueue<Node> queue;



    public void Search(Maze currentMaze) {
        maze = currentMaze;
        runBFS(maze);
        maze.reset();

        runDPS(maze);
        maze.reset();

        runGBFS(maze);
        maze.reset();

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

    private Node traverse(Maze inMaze, int x, int y, Node base) {
        Node found;
        weight++;
        if (inMaze.hashpull(x, y) !=null) {
            found = inMaze.hashpull(x, y);  // if node found
            Node temp = inMaze.hashpull(x,y);
            int baseNum = (base.getX()*100)+base.getY();
            Edge edge = new Edge((x*100+y),baseNum, weight);
        }
        else {          //if node not found keep walking
            inMaze.currentState[x][y]= '.';
            if(inMaze.currentState[x][y+1]==' '){
                found = traverse(inMaze,x,(y+1), base);

            }
            if(inMaze.currentState[x+1][y]==' '){
                found = traverse(inMaze,x+1,y, base);
            }
            if(inMaze.currentState[x][y-1]==' '){
                found = traverse(inMaze,x,(y-1), base);
            }
            else{
                found = traverse(inMaze,x-1,y, base);
            }
        }
        return(found);
    }

}
