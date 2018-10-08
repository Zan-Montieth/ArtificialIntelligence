public class Node {

    private int xCoord = 0;
    private int yCoord = 0;
    private int minDistance = Integer.MAX_VALUE;
    private Node minPathLink = null;
    private int endDistance = 0;
    private int parentDist = 0;  // dist to parent node


    public Node (int inX, int inY) {
        xCoord = inX;
        yCoord = inY;


    }


    public int getX(){
        return xCoord;
    }

    public int getY(){
        return yCoord;
    }
    public int getMinDistance(){
        if(minPathLink== null){
            return minDistance;
        }
        else{
            return minPathLink.getMinDistance()+minDistance;
        }

    }
}
