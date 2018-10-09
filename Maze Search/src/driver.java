import java.io.*;
import java.util.ArrayList;
/* This class is the main driver for our assignment 1, using various search algorithms on static mazes
 * of various dimension and attributes.
 */

public class driver {

    public static void main(String[] args) throws IOException {

        Maze mediumMaze = readMazeIn("medium maze.txt");  // names can be changed as needed, but will be
        Maze largeMaze = readMazeIn("large maze.txt");    // read in from static files
        Maze openMaze = readMazeIn("open maze.txt");

        mediumMaze.printMaze();
        Search medSearch = new Search(mediumMaze);
        //largeMaze.printMaze();
        //Search largeSearch = new Search(largeMaze);
        openMaze.printMaze();
        Search openSearch = new Search(openMaze);
        //largeMaze.printMaze();
        //openMaze.printMaze();



    }

    /* a method to read in a maze of a given name, assuming the maze file exists
    * in the structure of the project.
    *
    */
    private static Maze readMazeIn(String mazeName) throws IOException {
        ArrayList<String> maze = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(mazeName));
        try {
            String line = br.readLine();
            while (line != null) {
                maze.add(line);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        char [][] newMaze = new char[maze.size()][maze.get(0).length()];
        for(int i = 0; i < maze.size(); i++) {
            newMaze[i]=maze.get(i).toCharArray();
        }
        Maze charMaze = new Maze(newMaze);
        return charMaze;


    }
}