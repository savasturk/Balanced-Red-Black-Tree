/**
 * Created by asus on 9.12.2017.
 */
public class Node <Key , Value, depth_counter>{

    public static final char RED   = 'R';
    public static final char BLACK = 'B';


    public int Depth_counter;
    public Key Key;
    public Node leftChild;
    public Node rightChild;
    public char Color;
    public Value Value;



    public Node(Key key, Value value,int depth_counter){
        this.Depth_counter= depth_counter;
        this.Value= value;
        this.Color=RED;
        this.Key= key;
        leftChild= null;
        rightChild=null;
    }
    public void setData(Key key, Value value){
        this.Key= key;
        this.Value= value;
    }
    public void setColor(char c){
            Color = c;

    }
    public void setDepth_counter(int count){
        Depth_counter=count;
    }
    public void setLeftChild(Node node){
        leftChild= node;
    }
    public void setRightChild(Node node){
        rightChild= node;
    }
    public Key getKey(){
        return Key;
    }
    public Value getValue(){
        return Value;
    }
    public char getColor(){
        return Color;
    }
    public Node getLeftChild(){
        return leftChild;
    }
    public Node getRightChild(){
        return rightChild;
    }
    public int getDepth_counter(){return Depth_counter;}
}
