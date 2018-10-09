import java.util.Comparator;
import java.util.PriorityQueue;
import Algs4.*;

public class Search {

    Maze maze;
    PriorityQueue<Node> queue = new PriorityQueue<Node>();
    Stack<Node> stack = new Stack<Node>();
    PriorityQueue<Node> AS = new PriorityQueue<Node>();

    public Search(Maze currentMaze) {


        maze = currentMaze;
        runBFS(maze);
        maze.reset();

        runDFS(maze);
        maze.reset();

        runGBFS(maze);
        maze.reset();

        runAS(maze);
    }

     public int compare(Node s1, Node s2) {
        if (s1.getMinDistance() < s2.getMinDistance())
            return 1;
        else if (s1.getMinDistance() > s2.getMinDistance())
            return -1;
        return 0;
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
            if (isDownNode(maze,x,y)) {
                Node temp = traverse(maze,x+1,y,queue.peek(),1);
                if (temp != null) queue.add(temp);
            }
            if (isUpNode(maze,x,y)) {
                Node temp = traverse(maze,x-1,y,queue.peek(),1);
                if (temp != null) queue.add(temp);
            }
            if (isRightNode(maze,x,y)) {
                Node temp = traverse(maze,x,y+1,queue.peek(),1);
                if (temp != null) queue.add(temp);
            }
            if (isLeftNode(maze,x,y)) {
                Node temp = traverse(maze,x,y-1,queue.peek(),1);
                if (temp != null) queue.add(temp);            }
            //maze.printMaze();
            queue.remove(queue.peek());
            x = queue.peek().getX();
            y = queue.peek().getY();

        }
        //maze.printMaze();

    }

    private void runDFS(Maze maze) {
        stack.push(maze.start);    // put start on the stack
        int x = maze.getStart().getX();
        int y = maze.getStart().getY();

        //while(!stack.isEmpty()) { //while stack not empty



        //}
    }

    private void runGBFS(Maze maze) {

    }

    private void runAS(Maze maze) {


        AS.add(maze.start);
        while(!AS.isEmpty()){
            Node temp = AS.poll();
            int x = temp.getX();
            int y = temp.getY();
            if(temp == maze.end){// Goal check
                maze.printMaze();
                break;
            }
            int manh =0;
            maze.currentState[x][y] = '.';
            if (isUpNode(maze,x,y)) {           //0 update weightplus as path length + manhattan dist
                Node check = traverse(maze,x,y+1,temp,1);
                manh = manhattan(temp,maze.end);
                if(temp!= null){
                    int t = temp.getMinDistance();
                    //AS.add(temp,(manh+t));                                Panic!!!!!!
                }
            }
            if (isRightNode(maze,x,y)){         //1
                manh = manhattan(temp,maze.end);
                Node check = traverse(maze,x+1,y,temp,1);
                if(temp!= null){
                    int t = temp.getMinDistance();
                    //AS.add(temp,(manh+t));                                Panic!!!!!!
                }
            }
            if (isDownNode(maze,x,y)) {         //2
                manh = manhattan(temp,maze.end);
                Node check = traverse(maze,x,y-1,temp,1);
                if(temp!= null){
                    int t = temp.getMinDistance();
                    //AS.add(temp,(manh+t));                                Panic!!!!!!
                }
            }
            if (isLeftNode(maze,x,y)) {         //3
                manh = manhattan(temp,maze.end);
                Node check = traverse(maze,x-1,y,temp,1);
                if(temp!= null){
                    int t = temp.getMinDistance();
                    //AS.add(temp,(manh+t));                                Panic!!!!!!
                }
            }


        }

    }

    private Node traverse(Maze inMaze, int x, int y, Node base, int weight) { // weight should be 1 bc starting at node +1
        Node found;
        weight++;
        if (inMaze.hashpull(x, y) !=null) {
            found = inMaze.hashpull(x, y);  // if node found
            //Node temp = inMaze.hashpull(x,y);
            //int baseNum = (base.getX()*100)+base.getY();
            //int endNode = inMaze.hashpull(x,y).getNum();
            //int startNode = inMaze.hashpull(base.getX(), base.getY()).getNum();
            //System.out.println(endNode);
            //System.out.println(startNode);
            //Edge edge = new Edge(endNode, startNode, weight);
            //inMaze.graph.addEdge(edge);
            found.chekcMinDistance(weight,base);
        }
        else {          //if node not found keep walking
            /* Need to add in check that it isnt finding the base node
             * as it's next node in the path.
             */
            inMaze.currentState[x][y]= '.';
            //inMaze.printMaze();
            if(isRightNode(inMaze,x,y)){
                found = traverse(inMaze,x,(y+1), base, weight);
            }
            else if(isDownNode(inMaze,x,y)){
                found = traverse(inMaze,(x+1),y, base, weight);
            }
            else if(isLeftNode(inMaze,x,y)){
                found = traverse(inMaze,x,(y-1), base, weight);
            }
            else if (isUpNode(inMaze,x,y)){
                found = traverse(inMaze,(x-1),y, base, weight);
            }
            else found=null;
        }

        return(found);
    }

    private Boolean isUpNode(Maze inMaze, int x,int y) {
        return (inMaze.currentState[x-1][y]==' ' || inMaze.currentState[x-1][y]=='O'|| inMaze.currentState[x-1][y]=='*');
    }

    private Boolean isDownNode(Maze inMaze, int x,int y) {
        return (inMaze.currentState[x+1][y]==' ' || inMaze.currentState[x+1][y]=='O'|| inMaze.currentState[x+1][y]=='*');
    }

    private Boolean isLeftNode(Maze inMaze, int x,int y) {
        return (inMaze.currentState[x][y-1]==' ' || inMaze.currentState[x][y-1]=='O'|| inMaze.currentState[x][y-1]=='*');
    }

    private Boolean isRightNode(Maze inMaze, int x,int y) {
        return (inMaze.currentState[x][y+1]==' ' || inMaze.currentState[x][y+1]=='O' || inMaze.currentState[x][y+1]=='*');
    }
    private int manhattan(Node temp, Node end){
        return(Math.abs(temp.getX()-end.getX())+Math.abs(temp.getY()-temp.getY()));
    }
}
