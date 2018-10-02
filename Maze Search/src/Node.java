public class Node {

    private int xCoord = 0;
    private int yCoord = 0;
    private int minDistance = Integer.MAX_VALUE;
    private Node minPathLink = null;
    private int endDistance = 0;

    public Node (int inX, int inY, Node lastNode, Node finalNode) {
        xCoord = inX;
        yCoord = inY;


    }


    public int getXCoord(){
        return xCoord;
    }

    public int getYCoord(){
        return yCoord;
    }
    public int getMinDistance(){
        return minDistance;
    }
}
