import Algs4.Stack;

public class DFS {

    Stack<Object> stack = new Algs4.Stack<Object>();
    Maze maze;

    public DFS(Maze inMaze){
        maze = inMaze;

    }

    public void recurDFS(int x, int y){
        if(maze.start.getY()== y && maze.start.getX()==x){   // Check Goal state
            // need to return the min path?
        }
        else if(maze.currentState[x][y] == '.'){     //already visited

            // check distance and compare
            //     if shorter distance then update minPathLink
            //    else igonr
        }
        else{
            //not yet visited
            // check if intersecton if yes
            //    add to tree new node...
            // if no add to parent dist
        }
    }




}
