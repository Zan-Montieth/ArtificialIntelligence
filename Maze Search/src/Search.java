import java.util.Iterator;
import java.util.PriorityQueue;
import Algs4.*;

public class Search {

    Maze maze;
    PriorityQueue<Node> queue = new PriorityQueue<Node>();
    PriorityQueue<Node> GFSqueue = new PriorityQueue<Node>();

    Stack<Node> stack = new Stack<Node>();
    MinPQ<Node> AS = new MinPQ<Node>();

    public Search(Maze currentMaze) {
        maze = currentMaze;
        runBFS(maze);
        maze.reset();

        runDFS(maze);
        maze.reset();

        //runGBFS(maze);
        maze.reset();

        runAS(maze);
        //System.out.println(maze.start.getMinDistance());
    }





    private void runBFS(Maze maze) {
        int x = maze.getStart().getX();
        int y = maze.getStart().getY();
        int frontierNodes  = 0;
        int completedNodes = 0;
        queue.add(maze.getStart());
        //System.out.println(queue.contains(maze.getStart()));
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            completedNodes++;
            if(top == maze.getEnd()) {
                maze.printMaze();
                break;
            }
            maze.currentState[x][y] = '.';
            if (isDownNode(maze,x,y)) {
                Node temp = traverse(maze,x+1,y,top,1);
                if (temp != null && !queue.contains(temp)) {
                    queue.add(temp);
                    frontierNodes++;
                }
            }
            if (isUpNode(maze,x,y)) {
                Node temp = traverse(maze,x-1,y,top,1);
                if (temp != null && !queue.contains(temp)) {
                    queue.add(temp);
                    frontierNodes++;
                }
            }
            if (isRightNode(maze,x,y)) {
                Node temp = traverse(maze,x,y+1,top,1);
                if (temp != null && !queue.contains(temp)) {
                    queue.add(temp);
                    frontierNodes++;
                }
            }
            if (isLeftNode(maze,x,y)) {
                Node temp = traverse(maze,x,y-1,top,1);
                if (temp != null && !queue.contains(temp)) {
                    queue.add(temp);
                    frontierNodes++;
                }
            }
            //maze.printMaze();
            x = queue.peek().getX();
            y = queue.peek().getY();
            //System.out.printf("Next node is %d,%d\n",x,y);
        }
        //maze.printMaze();
        //int steps = findSteps(maze);
        System.out.printf("Number of frontier nodes = %d\nNumber of completed nodes = %d"
                ,frontierNodes-completedNodes, completedNodes);
    }

    private void runDFS(Maze maze) {
        int x = maze.getStart().getX();
        int y = maze.getStart().getY();
        int frontierNodes  = 0;
        int completedNodes = 0;
        stack.push(maze.getStart());
        //System.out.println(queue.contains(maze.getStart()));
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            completedNodes++;
            if(top == maze.getEnd()) {
                maze.printMaze();
                break;
            }
            maze.currentState[x][y] = '.';
            if (isUpNode(maze,x,y)) {
                Node temp = traverse(maze,x-1,y,top,1);
                if (temp != null && !stackContains(stack,temp)) {
                    stack.push(temp);
                    frontierNodes++;
                }
            }
            if (isDownNode(maze,x,y)) {
                Node temp = traverse(maze,x+1,y,top,1);
                if (temp != null && !stackContains(stack, temp)) {
                    stack.push(temp);
                    frontierNodes++;
                }
            }
            if (isRightNode(maze,x,y)) {
                Node temp = traverse(maze,x,y+1,top,1);
                if (temp != null && !stackContains(stack,temp)) {
                    stack.push(temp);
                    frontierNodes++;
                }
            }
            if (isLeftNode(maze,x,y)) {
                Node temp = traverse(maze,x,y-1,top,1);
                if (temp != null && !stackContains(stack,temp)) {
                    stack.push(temp);
                    frontierNodes++;
                }            }
            //maze.printMaze();
            x = stack.peek().getX();
            y = stack.peek().getY();
            //System.out.printf("Next node is %d,%d\n",x,y);
        }
        //maze.printMaze();
        System.out.printf("Number of frontier nodes = %d\nNumber of completed nodes = %d",frontierNodes-completedNodes, completedNodes);
    }

    private void runGBFS(Maze maze) {
        int x = maze.getStart().getX();
        int y = maze.getStart().getY();
        Node temp;
        GFSqueue.add(maze.getStart());
        Node closest = maze.getStart();
        while(!queue.isEmpty()) {
            if(queue.peek() == maze.getEnd()) {
                maze.printMaze();
                break;
            }
            maze.currentState[x][y] = '.';
            if (isDownNode(maze, x, y)) {
                temp = traverse(maze, x + 1, y, GFSqueue.peek(), 1);
                if (temp.getMinDistance() < closest.getMinDistance()) {
                    closest = temp;
                }
            }
            if (isUpNode(maze, x, y)) {
                temp = traverse(maze, x - 1, y, GFSqueue.peek(), 1);
                if (temp.getMinDistance() < closest.getMinDistance()) {
                    closest = temp;
                }
            }
            if (isRightNode(maze, x, y)) {
                temp = traverse(maze, x, y + 1, GFSqueue.peek(), 1);
                if (temp.getMinDistance() < closest.getMinDistance()) {
                    closest = temp;
                }
            }
            if (isLeftNode(maze, x, y)) {
                temp = traverse(maze, x, y - 1, GFSqueue.peek(), 1);
                if (temp.getMinDistance() < closest.getMinDistance()) {
                    closest = temp;
                }
            }
            GFSqueue.add(closest);
            x = GFSqueue.peek().getX();
            y = GFSqueue.peek().getY();
        }
        maze.printMaze();
    }

    private void runAS(Maze maze) {


        AS.insert(maze.start);
        while(!AS.isEmpty()) {

            Node temp = AS.delMin();                    //temp is where we are
            System.out.println("min dist" + temp.getMinDistance());
            int x = temp.getX();
            int y = temp.getY();
            System.out.println(x + "," + y);
            if (temp == maze.end) {// Goal check
                System.out.println("Goal reached");
                maze.printMaze();
                break;
            }
            //int manh =0;
            maze.currentState[x][y] = '.';
            if (isUpNode(maze, x, y)) {           //0 update weightplus as path length + manhattan dist
                Node check = traverse(maze, x - 1, y, temp, 0);
            }
            maze.printMaze();
            if (isUpNode(maze,x,y)) {           //0 update weightplus as path length + manhattan dist
                Node check = traverse(maze,x-1,y,temp,0);
                //manh = manhattan(temp,maze.end);
                check(check);
            }
            if (isRightNode(maze,x,y)){         //1
                //manh = manhattan(temp,maze.end);
                Node check = traverse(maze,x,y+1,temp,0);
                check(check);
            }
            if (isDownNode(maze,x,y)) {         //2
                //manh = manhattan(temp,maze.end);
                Node check = traverse(maze,x+1,y,temp,0);
                check(check);
            }
            if (isLeftNode(maze,x,y)) {         //3
                // manh = manhattan(temp,maze.end);
                Node check = traverse(maze,x,y-1,temp,0);
                check(check);
            }


        }

    }

    private void check(Node check){
        if(check!= null){
            //System.out.println("Right potato");
            int t = check.getMinDistance();
            //System.out.println(t);
            check.addManh(maze);
            System.out.println("AS is "+ check.getMinDistance());
            AS.insert(check);
            check.removeManh(maze);
            System.out.print("min dist "+check.getMinDistance());
        }

    }


    private Boolean stackContains(Stack<Node> stack, Node node) {
        Iterator<Node> iter = stack.iterator();
        while (iter.hasNext()) {
            if (iter.next() == node) return true;
        }
        return false;
    }

    private Node traverse(Maze inMaze, int x, int y, Node base, int weight) { // weight should be 1 bc starting at node +1
        Node found;
        weight++;
        System.out.println("weight is "+ weight);
        if (inMaze.hashpull(x, y) !=null) {
            System.out.println("found node at "+x+", "+y);
            found = inMaze.hashpull(x, y);  // if node found
            //Node temp = inMaze.hashpull(x,y);
            //int baseNum = (base.getX()*100)+base.getY();
            //int endNode = inMaze.hashpull(x,y).getNum();
            //int startNode = inMaze.hashpull(base.getX(), base.getY()).getNum();
            //System.out.println(endNode);
            //System.out.println(startNode);
            //Edge edge = new Edge(endNode, startNode, weight);
            //inMaze.graph.addEdge(edge);
            found.checkMinDistance(weight,base);
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
        return(Math.abs(temp.getX()-end.getX())+Math.abs(temp.getY()-end.getY()));
    }
}
