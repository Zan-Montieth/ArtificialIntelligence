import java.util.*;

public class BFS {

    Queue<Node> queue = new PriorityQueue<Node>();

    Maze maze;
    int lastOptionCount = numOptions(maze.start.getXCoord(),maze.start.getYCoord());
    int parentDist =0;
    Node temp;
    Node start;
    Node end;

    public BFS(Maze mazeIn){   // take in Object Maze

        maze = mazeIn;
        end = new Node(maze.end.getXCoord(),maze.end.getYCoord(),null, null);

        searchBFS(maze.start.getXCoord(),maze.start.getYCoord());

    }

    public Node searchBFS(int x, int y) {
        // add start to queue
        Node start = new Node(x,y,null,null); // need last node and final node?

        queue.add(start);
        boolean[] options = options(x,y);
        int count = numOptions(x,y);   // track number of options

        while(queue.isEmpty() != true){

            temp = queue.poll();

            int[] next = new int[3];                    // next[0] t/f if node [1] x cord [2] y cord

            if(options[0]=true){                                           //up
                next = recurBFS(x,(y+1),count);
                if(next[0]==3){             // check for goal state
                    Node goal = new Node(next[1],next[2], temp,end);
                    return(goal);           // return Goal
                }
                else if (next[0]==1){        // if return is node
                    Node up = new Node(next[1],next[2], temp,end);// make new node
                    maze.currentState[next[1]][next[2]]= 'O';     // nodes represented by O
                    queue.add(up);    // add to queue
                }
            }
            if(options[1]=true){                                           //right
                next = recurBFS((x+1),y, count);
                if(next[0]==3){             // check for goal state
                    Node goal = new Node(next[1],next[2], temp,end);
                    return(goal);           // return Goal
                }
                else if (next[0]==1){        // if return is node
                    Node right= new Node(next[1],next[2], temp,end);// make new node
                    maze.currentState[next[1]][next[2]]= 'O';     // nodes represented by O
                    queue.add(right);    // add to queue
                }
            }
            if(options[2]=true){                                           //down
                next = recurBFS(x,(y-1), count);
                if(next[0]==3){             // check for goal state
                    Node goal = new Node(next[1],next[2], temp,end);
                    return(goal);           // return Goal
                }
                else if (next[0]==1){        // if return is node
                    Node down = new Node(next[1],next[2], temp,end);// make new node
                    maze.currentState[next[1]][next[2]]= 'O';     // nodes represented by O
                    queue.add(down);    // add to queue
                }
            }
            if(options[3]=true){                                           //left
                next = recurBFS((x-1),y, count);
                if(next[0]==3){             // check for goal state
                    Node goal = new Node(next[1],next[2], temp,end);
                    return(goal);           // return Goal
                }
                else if (next[0]==1){        // if return is node
                    Node left = new Node(next[1],next[2], temp,end);// make new node
                    maze.currentState[next[1]][next[2]]= 'O';     // nodes represented by O
                    queue.add(left);    // add to queue
                }
            }


        }
        System.out.println("end not found return null");
        return(null);
    }

    public int[] recurBFS(int inX, int inY, int count){  // find next node
        //ie check number of options

        int x = inX;
        int y = inY;
        int prevOption = count; // number of previous options
        int options = numOptions(x,y);
        boolean[] dir = options(x,y);
        int[] temp = new int[3];
        temp[1]= x;
        temp[2]= y;

        if(maze.end.getYCoord()== y && maze.end.getXCoord()==x){  // Goal state check
            System.out.println("Goal reached!"); //Goal state
            temp[0]= 3;

            return(temp); // return 3 in temp[0]
        }
        switch(options){        // number of potential routes
            case 0:             // dead end
                temp[0]=0;

                maze.currentState[x][y] = '.';
                return(temp);

            case 1:             // one way to go, no new node
                if(dir[0]== true){  // up
                    recurBFS(x,(y+1),1);
                }
                else if(dir[1]==true){  // Right
                    recurBFS((x+1),y,1);
                }
                else if(dir[2]==true){
                    recurBFS(x,(y-1),1);
                }
                else if(dir[3]==true){
                    recurBFS((x-1),y,1);
                }

                break;

            case 2:             // two ways to go only make node if different numOptions
                if(options == count){    // number of options different from last location
                    if(dir[0]== true){  // up
                        recurBFS(x,(y+1),2);
                    }
                    else if(dir[1]==true){  // Right
                        recurBFS((x+1),y,2);
                    }
                    else if(dir[2]==true){
                        recurBFS(x,(y-1),2);
                    }
                    else if(dir[3]==true){
                        recurBFS((x-1),y,2);
                    }
                }
                else{   // make new node
                    temp[0]=1;
                    return(temp);

                }
                break;
            case 3:             // three ways to go, make node
                temp[0]=1;
                return(temp);

        }

        System.out.println("issue with Options");
        return(null);
    }

    public boolean[] options(int x, int y){  // read like clock 0 = 12
        boolean[] count= new boolean[3];

        if(maze.currentState[x+1][y] == ' '){ // right
            count[1]= true;
        }
        if(maze.currentState[x][y+1] == ' '){  // up
            count[0]=true;
        }
        if(maze.currentState[x-1][y] == ' '){ // left
            count[3]=true;
        }
        if(maze.currentState[x][y-1] == ' '){  // down
            count[2]= true;
        }

        return count;
    }

    public int numOptions(int x, int y){  // read like clock 0 = 12
        int count= 0;

        if(maze.currentState[x+1][y] == ' '){ // right
            count++;
        }
        if(maze.currentState[x][y+1] == ' '){  // up
            count++;
        }
        if(maze.currentState[x-1][y] == ' '){ // left
            count++;
        }
        if(maze.currentState[x][y-1] == ' '){  // down
            count++;
        }

        return count;
    }

}
