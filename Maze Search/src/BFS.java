import java.util.*;

public class BFS {

    Queue<Object> queue = new PriorityQueue<Object>();

    Maze maze;
    int lastOptionCount = numOptions(maze.start.getXCoord(),maze.start.getYCoord());
    int parentDist =0;
    Node lastNode;

    public BFS(Maze mazeIn){   // take in Object Maze

        maze = mazeIn;



    }

    public void recurBFS(int x, int y){

        if(maze.start.getYCoord()== y && maze.start.getXCoord()==x){  // Start state check
            //Start state
        }
        else if(maze.end.getYCoord()== y && maze.end.getXCoord()==x){  // Goal state check
            //Goal state
        }
        else if(maze.currentState[x][y] == '.'){     //already visited

            // check distance and compare
            //     if shorter distance then update minPathLink
            //    else igonr
        }
        else{  //not yet visited
            boolean [] count = options(x,y);

            if(numOptions(x,y) != 1 && numOptions(x,y)!= lastOptionCount) {  // if number of options change

                if(count[0]== true){
                    Node temp = new Node(x,(y+1),lastNode, maze.end);
                    queue.add(temp);
                }
                if(count[1]== true){
                    Node temp = new Node((x+1),y,lastNode, maze.end);
                    queue.add(temp);
                }
                if(count[2]== true){
                    Node temp = new Node(x,(y-1),lastNode, maze.end);
                    queue.add(temp);
                }
                if(count[3]== true){
                    Node temp = new Node((x-1),y,lastNode, maze.end);
                    queue.add(temp);
                }
            }
            // check if intersecton if yes
            //    add to tree new node...
            else{    // if no increment parentDist
                maze.currentState[x][y]='.';
                parentDist++;

            }
        }
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
