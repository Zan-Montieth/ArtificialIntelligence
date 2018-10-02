import java.io.*;

public class driver {

    public static void main(String[] args) throws IOException {

        String mediumMaze = readMazeIn("medium maze.txt");
        String largeMaze = readMazeIn("large maze.txt");
        String openMaze = readMazeIn("open maze.txt");

        //System.out.print(mediumMaze);
        //System.out.print(largeMaze);
        //System.out.print(openMaze);

    }

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
