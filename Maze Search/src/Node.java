public class Node implements Comparable {

    private int xCoord = 0;
    private int yCoord = 0;
    private int minDistance = Integer.MAX_VALUE;
    private Node minPathLink = null;
    private int endDistance = 0;
    private int parentDist = 0;  // dist to parent node
    private int num; //


    public Node (int inX, int inY, int num) {
        xCoord = inX;
        yCoord = inY;
        this.num = num;


    }

    @Override
    public int compareTo(Object o) {
        if(o.getClass() == this.getClass()) {
            if (((Node) o).getMinDistance() < this.getMinDistance()) return 1; // if that node is smaller
            else return 0; // if this node is smaller
        }
        else return -1;
    }

    public void setEndDistance(int endX, int endY){
        endDistance = Math.abs(xCoord-endX) + Math.abs(yCoord-endY);
    }

    public int getNum() {
        return num;
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
