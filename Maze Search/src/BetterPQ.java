public class BetterPQ {

    int end;
    int front;
    private Node BPqueue[];

    public BetterPQ(){
        BPqueue = new Node[12];
        front = 0;
        end = -1;
    }


    public void enqueu(Node i, int j){
        if((end+1)>= BPqueue.length){

            BPqueue = new Node [BPqueue.length*2];
            //System.out.println("The queue is full!");
        }
        for(int u =front;BPqueue[u].getMinDistance()<i.getMinDistance();u++){

        }
        end++;
        BPqueue[end]= i;
        //System.out.println("enqueued "+i);
    }

    public Node dequeue(){
        if(!empty()){
            int temp=front;
            Node o= BPqueue[front];

            for(temp=0;temp!=end;temp++){
                if(temp+1<=BPqueue.length){

                    BPqueue[temp]=BPqueue[temp+1];
                }
            }
            end--;
            return o;
        }
        else{
            return null;
        }
    }
    public boolean empty(){
        if(end==-1){
            return true;
        }
        else{
            return false;
        }
    }

    public Node peek(){
        Node p= BPqueue[front];
        return p;
    }

    public int returnFront(){
        return end;
    }

}
