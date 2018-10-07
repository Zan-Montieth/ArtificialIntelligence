import java.util.PriorityQueue;
import java.util.Queue;

public class GFS {

    Maze mazeGFS;
    Maze solved;
    Queue<Object> queue = new PriorityQueue<Object>();

    public GFS(Maze inMaze){
        mazeGFS = inMaze;
    }

    public Maze computeGFS(Maze inMaze){
        //TODO create a list of all points in the maze and their distance to the finish using manhattan distance
        //manhattan distance in only moving on the straight lines no diagonals

            //TODO start at the end state
            //TODO recursively from the end travel DFS to create the distance function
                //doing DFS because visiting every node BFS and DFS have same time complexity but DFS has a smaller space complexity


        //TODO take choice that gets us closest to the goal and then remove all options that are larger


        return solved;
    }

    public Queue<Node> createDistanceList (){
        Queue<Node> distances = new PriorityQueue<Node>();


        return distances;
    }
}
