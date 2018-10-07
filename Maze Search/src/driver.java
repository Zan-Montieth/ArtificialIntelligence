import java.io.*;

/* This class is the main driver for our assignment 1, using various search algorithms on static mazes
 * of various dimension and attributes.
 */

public class driver {

    public static void main(String[] args) throws IOException {

        Maze mediumMaze = readMazeIn("medium maze.txt");  // names can be changed as needed, but will be
        Maze largeMaze = readMazeIn("large maze.txt");    // read in from static files
        Maze openMaze = readMazeIn("open maze.txt");

        mediumMaze.printMaze();

        //System.out.print(mediumMaze);
        //System.out.print(largeMaze);
        //System.out.print(openMaze);

    }

    /* a method to read in a maze of a given name, assuming the maze file exists
    * in the structure of the project.
    *
     */
    private static Maze readMazeIn(String mazeName) throws IOException {
        String maze;
        int mazeWidth;
        BufferedReader br = new BufferedReader(new FileReader(mazeName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            mazeWidth = line.length();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            maze = sb.toString();
        } finally {
            br.close();
        }
        Maze charMaze = new Maze(maze, mazeWidth);
        return charMaze;


    }
}