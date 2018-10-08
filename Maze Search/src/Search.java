import java.util.PriorityQueue;
import Algs4.*;

public class Search {

    Maze maze;
    PriorityQueue<Node> queue = new PriorityQueue<Node>();



    public Search(Maze currentMaze) {
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
        //int y = 6;
        //int x = 1;
        queue.add(maze.getStart());
        //System.out.println(queue.contains(maze.getStart()));
        while (!queue.isEmpty()) {
            if(queue.peek() == maze.getEnd()) {
                maze.printMaze();
                break;
            }
            maze.currentState[x][y] = '.';
            if (maze.getSpot(x+1,y) == ' ' || maze.getSpot(x+1,y) == 'O') {
                Node temp = traverse(maze,x+1,y,queue.peek(),1);
                if (temp != null) queue.add(temp);
            }
            if (maze.getSpot(x-1,y) == ' '|| maze.getSpot(x-1,y) == 'O') {
                Node temp = traverse(maze,x-1,y,queue.peek(),1);
                if (temp != null) queue.add(temp);
            }
            if (maze.getSpot(x,y+1) == ' '|| maze.getSpot(x,y+1) == 'O') {
                Node temp = traverse(maze,x,y+1,queue.peek(),1);
                if (temp != null) queue.add(temp);
            }
            if (maze.getSpot(x,y-1) == ' '|| maze.getSpot(x,y-1) == 'O') {
                Node temp = traverse(maze,x,y-1,queue.peek(),1);
                if (temp != null) queue.add(temp);            }
            //maze.printMaze();
            queue.remove(queue.peek());
            x = queue.peek().getX();
            y = queue.peek().getY();

        }
        //maze.printMaze();

    }

    private void runDPS(Maze maze) {

    }

    private void runGBFS(Maze maze) {

    }

    private void runAS(Maze maze) {

    }

    private Node traverse(Maze inMaze, int x, int y, Node base, double weight) {
        Node found;
        weight++;
        if (inMaze.hashpull(x, y) !=null) {
            found = inMaze.hashpull(x, y);  // if node found
            //Node temp = inMaze.hashpull(x,y);
            //int baseNum = (base.getX()*100)+base.getY();
            int endNode = inMaze.hashpull(x,y).getNum();
            int startNode = inMaze.hashpull(base.getX(), base.getY()).getNum();
            //System.out.println(endNode);
            //System.out.println(startNode);
            Edge edge = new Edge(endNode, startNode, weight);
            inMaze.graph.addEdge(edge);
        }
        else {          //if node not found keep walking
            /* Need to add in check that it isnt finding the base node
             * as it's next node in the path.
             */
            inMaze.currentState[x][y]= '.';
            //inMaze.printMaze();
            if(inMaze.currentState[x][y+1]==' ' || inMaze.currentState[x][y+1]=='O' || inMaze.currentState[x][y+1]=='*'){
                found = traverse(inMaze,x,(y+1), base, weight);
            }
            else if(inMaze.currentState[x+1][y]==' ' || inMaze.currentState[x+1][y]=='O'|| inMaze.currentState[x+1][y]=='*'){
                found = traverse(inMaze,(x+1),y, base, weight);
            }
            else if(inMaze.currentState[x][y-1]==' ' || inMaze.currentState[x][y-1]=='O'|| inMaze.currentState[x][y-1]=='*'){
                found = traverse(inMaze,x,(y-1), base, weight);
            }
            else if (inMaze.currentState[x-1][y]==' ' || inMaze.currentState[x-1][y]=='O'|| inMaze.currentState[x-1][y]=='*'){
                found = traverse(inMaze,(x-1),y, base, weight);
            }
            else found=null;
        }

        return(found);
    }

}
