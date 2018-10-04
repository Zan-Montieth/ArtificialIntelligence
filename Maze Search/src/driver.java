import java.io.*;

/* This clas is the main driver for our assignment 1, using various search algorithms on static mazes
 * of various dimension and attributes.
 */

public class driver {

    public static void main(String[] args) throws IOException {

        String mediumMaze = readMazeIn("medium maze.txt");  // names can be changed as needed, but will be
        String largeMaze = readMazeIn("large maze.txt");    // read in from static files
        String openMaze = readMazeIn("open maze.txt");

        //System.out.print(mediumMaze);
        //System.out.print(largeMaze);
        //System.out.print(openMaze);

    }

    /* a method to read in a maze of a given name, assuming the maze file exists
    * in the structure of the project.
    *
     */
    private static String readMazeIn(String mazeName) throws IOException {
        String maze;
        BufferedReader br = new BufferedReader(new FileReader(mazeName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            maze = sb.toString();
        } finally {
            br.close();
        }
        return maze;


    }
}
//Zan can push now from his surface