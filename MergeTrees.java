import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by asus on 10.12.2017.
 */
public class MergeTrees<Key, Value> {
    public static final char RED= 'R';
    public static final char BLACK= 'B';
    public Node root;
    int count=0;
    int counter=0;
    int count2=0;
    public int height=0;
    public int return_height=0;
    public int [] arr = new int[1000000];
    public void FullArray(int [] array){
        for (int i=0;i<1000000;i++){
            array[i]=10000;
        }
        arr=array;

    }

    public MergeTrees() {root=null;}
    public Node TransationLeft(Node for_left){
        Node child1=for_left.getRightChild().getLeftChild();
        Node child2=for_left.getRightChild();
        child2.setLeftChild(for_left);
        for_left.setRightChild(child1);
        return child2;
    }
    public Node TransationRight(Node for_right){
        Node pale1=for_right.getLeftChild().getRightChild();
        Node pale2=for_right.getLeftChild();
        pale2.setRightChild(for_right);
        for_right.setLeftChild(pale1);
        return pale2;
    }
    public Node PUT(Node node, Key key, Value value){
        if (node==null){
            Node newnode= new Node(key,value,1);
            return newnode;
        }
        else {
            int number_one=(Integer) node.getValue();
            int number_two=(Integer)value;
            if (number_two>=number_one){
                node.setRightChild(PUT(node.getRightChild(),key,value));
            }
            else {
                node.setLeftChild(PUT(node.getLeftChild(),key,value));
            }
            if (node.getLeftChild()==null || node.getLeftChild().Color==BLACK ){
                if (node.getRightChild()!=null&&node.getRightChild().getRightChild()!=null){
                    if (node.getRightChild().Color==RED && node.getRightChild().getRightChild().Color== RED){
                        //4.

                        node.getRightChild().setColor(BLACK);
                        node.setColor(RED);
                        node=TransationLeft(node);
                    }
                }
            }
            if (node.getRightChild()==null || node.getRightChild().Color==BLACK){
                if (node.getLeftChild()!=null && node.getLeftChild().getLeftChild()!=null){
                    if (node.getLeftChild().Color==RED && node.getLeftChild().getLeftChild().Color==RED){
                        //1



                        node.getLeftChild().setColor(BLACK);
                        node.setColor(RED);
                        node=TransationRight(node);
                    }
                }
            }
            if (node.getRightChild()==null || node.getRightChild().Color==BLACK){
                if (node.getLeftChild()!=null&&node.getLeftChild().getRightChild()!=null){
                    if (node.getLeftChild().getRightChild().Color==RED && node.getLeftChild().Color==RED){
                        //2.




                        node.getLeftChild().getRightChild().setColor(BLACK);
                        node.setColor(RED);
                        node.setLeftChild(TransationLeft(node.getLeftChild()));
                        node=TransationRight(node);
                    }
                }
            }
            if (node.getLeftChild()==null ||node.getLeftChild().Color==BLACK){
                if ( node.getRightChild()!=null&&node.getRightChild().getLeftChild()!=null ){
                    if (node.getRightChild().getLeftChild().Color==RED && node.getRightChild().Color==RED){
                        //3.


                        node.getRightChild().getLeftChild().setColor(BLACK);
                        node.setColor(RED);
                        node.setRightChild(TransationRight(node.getRightChild()));
                        node=TransationLeft(node);
                    }
                }
            }
            else {
                if (node.getLeftChild()!=null&&node.getRightChild()!=null && node.getRightChild().getRightChild()!=null){
                    if (node.getLeftChild().Color==RED&&node.getRightChild().Color==RED&& node.getRightChild().getRightChild().Color==RED){
                        node.getRightChild().setColor(BLACK);
                        node.getLeftChild().setColor(BLACK);
                        if (node!=root){
                            node.setColor(RED);
                        }

                    }
                }
                if (node.getLeftChild()!=null && node.getRightChild()!=null && node.getRightChild().getLeftChild()!=null){
                    if (node.getLeftChild().Color==RED && node.getRightChild().Color==RED && node.getRightChild().getLeftChild().Color==RED){
                        node.getLeftChild().setColor(BLACK);
                        if (node!=root){
                            node.setColor(RED);
                        }
                        node.getRightChild().setColor(BLACK);
                    }
                }
                if (node.getRightChild()!=null&& node.getLeftChild()!=null&& node.getLeftChild().getLeftChild()!=null){
                    if (node.getLeftChild().getLeftChild().Color==RED && node.getRightChild().Color==RED&& node.getLeftChild().Color==RED){
                        if (node!=root){
                            node.setColor(RED);
                        }
                        node.getRightChild().setColor(BLACK);
                        node.getLeftChild().setColor(BLACK);
                    }
                }
                if (node.getRightChild()!=null&& node.getLeftChild()!=null && node.getLeftChild().getRightChild()!=null){
                    if (node.getLeftChild().getRightChild().Color==RED&& node.getRightChild().Color==RED&& node.getLeftChild().Color==RED){
                        if (node!=root){
                            node.setColor(RED);
                        }
                        node.getRightChild().setColor(BLACK);
                        node.getLeftChild().setColor(BLACK);
                    }
                }
            }


        }
        return node;
    }
    public void insert_Element(Key key, Value value){
        root=PUT(root,key,value);
        root.setColor(BLACK);
    }
     public    int total=0;
    int max_node=0;
    int control_number=-2;
int check_balanced=-5;
public int enough_count=0;
    public int CheckBalanced(int [] temp){
        Arrays.sort(temp);
        int total_element=total;
        int min=temp[0];
        int max = temp[total_element-1];
        if (max-min<=1){
            check_balanced=-1;
            return -1;
        }
        else {
            System.out.println(temp[0]);
           Node parent2= SearchParentElement(max_node);//2
            System.out.println((int)parent2.Value);
            Node parent3=SearchParentElement((int)parent2.Value);
            Node parent=SearchParentElement((int)parent3.Value);

            if (!parent.equals(root)){
                final Node temp_parent=parent;
               final Node parent_parent=SearchParentElement((Integer) parent.Value);
               final Node set_node=setUnbalancedTree(parent,number);
               SetTree(root,temp_parent,parent_parent,set_node);
                /*counter2=0;
                total=0;
                COUNT=0;
                maxValue=0;
                FullArray(arr);
                CheckBalanced(arr);*/
              /*  if (check_balanced!=-1){
                    counter2=0;
                    total=0;
                    COUNT=0;
                    minValue=1000000000;
                    enough_count++;

                    Call(root);
                    CheckBalanced(arr);
                    if (enough_count>4){
                        check_balanced=-1;
                    }
                }*/
            }
            else {
                root= setUnbalancedTree(parent,number);
                /*counter2=0;
                total=0;
                COUNT=0;
                maxValue=0;
                enough_count++;
                if (enough_count>4){
                    check_balanced=-1;
                }
                FullArray(arr);
                Call(root);
                CheckBalanced(arr);*/


              /*  if (check_balanced!=-1){
                    counter2=0;
                    total=0;
                    COUNT=0;
                    maxValue=0;
                    enough_count++;

                    Call(root);
                    CheckBalanced(arr);
                    if (enough_count>4){
                        check_balanced=-1;
                    }
                }*/



            }
        }
        resetArray();
        return min;


    }
    public void resetArray(){
        for (int j=0;j<1000000;j++){
            arr[j]=10000;
        }
    }
public Node my_parent;
    public String enter_input="";

    public Node Search(String input) {
    if (root == null)
        return null;
    else {
        if (root.leftChild.Key.toString().equals(input) || root.rightChild.Key.toString().equals(input)) {
            my_parent = root;


        }
        if (root.leftChild != null) {
            Search(root.leftChild.Key.toString());

        }
        if (root.rightChild != null) {
            Search(root.rightChild.Key.toString());

        }
        return my_parent;
    }
}
public void Find(String enter){
        enter_input=enter;

}
//public int temp_value=0;
    public Node setUnbalancedTree(Node for_left,int Key) {
      //  while ( for_left!=null){

           // if (findHeight(for_left.rightChild.rightChild)>=findHeight(for_left.rightChild.leftChild)) {
                if (for_left != null && for_left.rightChild != null && for_left.rightChild.rightChild != null) {
                    // Right Right case.
            /*
  z                                y
 /  \                            /   \
T1   y     Left Rotate(z)       z      x
    /  \   - - - - - - - ->    / \    / \
   T2   x                     T1  T2 T3  T4
       / \
     T3  T4

             */
                    final Node temp_for_left = for_left;
                    final Node child2 = for_left.getRightChild();
                    for_left.setRightChild(null);
                    final Node child3 = for_left;
                    final Node child4 = child2.leftChild;
                    child2.setLeftChild(null);
                    child2.setLeftChild(child3);
                    child2.leftChild.setRightChild(child4);
                    child2.leftChild.setColor(child2.Color);

                    if (temp_for_left.equals(root)) child2.setColor(BLACK);
                    else {
                        child2.setColor(child2.leftChild.Color);
                    }

                    return child2;
                }
          //  } else {
                if (for_left != null && for_left.rightChild != null && for_left.rightChild.leftChild != null) {
                    final Node temp_for_left = for_left;
// Right Left case.
            /*

   z                            z                            x
  / \                          / \                          /  \
T1   y   Right Rotate (y)    T1   x      Left Rotate(z)   z      y
    / \  - - - - - - - - ->     /  \   - - - - - - - ->  / \    / \
   x   T4                      T2   y                  T1  T2  T3  T4
  / \                              /  \
T2   T3                           T3   T4
             */

                    final Node child1 = for_left.leftChild;
                    final Node child2 = for_left.rightChild.leftChild.leftChild;
                    final Node child3 = for_left.rightChild.leftChild.rightChild;
                    final Node child4 = for_left.rightChild.rightChild;
                    final Node child5 = for_left.rightChild.leftChild;
                    child5.setLeftChild(null);
                    child5.setRightChild(null);
                    final Node child6 = for_left.rightChild;
                    child6.setLeftChild(null);
                    child6.setRightChild(null);
                    final Node child7 = for_left;
                    child7.setLeftChild(null);
                    child7.setRightChild(null);
                    child5.setLeftChild(child7);
                    child5.setRightChild(child6);
                    child5.leftChild.setLeftChild(child1);
                    child5.leftChild.setRightChild(child2);
                    child5.rightChild.setLeftChild(child3);
                    child5.rightChild.setRightChild(child4);
                    child5.leftChild.setColor(child5.Color);
                    if (temp_for_left.equals(root)) child5.setColor(BLACK);

                    else {
                        child5.setColor(child5.leftChild.Color);
                    }

                    return child5;

                }
          //  }

//if (findHeight(for_left.leftChild.leftChild)>=findHeight(for_left.leftChild.rightChild))
          //  {

          //  } else {
                if (for_left != null && for_left.leftChild != null && for_left.leftChild.rightChild != null) {
                    //Left right case.
            /*

     z                               z                           x
    / \                            /   \                        /  \
   y   T4  Left Rotate (y)        x    T4  Right Rotate(z)    y      z
  / \      - - - - - - - - ->    /  \      - - - - - - - ->  / \    / \
T1   x                          y    T3                    T1  T2 T3  T4
    / \                        / \
  T2   T3                    T1   T2

             */
                    final Node temp_for_left = for_left;

                    final Node child1 = for_left.rightChild;
                    final Node child2 = for_left.leftChild.leftChild;
                    final Node child3 = for_left.leftChild.rightChild.leftChild;
                    final Node child4 = for_left.leftChild.rightChild.rightChild;
                    final Node child5 = for_left.leftChild.rightChild;
                    child5.setLeftChild(null);//x
                    child5.setRightChild(null);
                    final Node child6 = for_left.leftChild;
                    child6.setLeftChild(null);//y
                    child6.setRightChild(null);
                    final Node child7 = for_left;
                    child7.setLeftChild(null);//z
                    child7.setRightChild(null);
                    child5.setLeftChild(child6);
                    child5.setRightChild(child7);
                    child5.leftChild.setLeftChild(child2);
                    child5.leftChild.setRightChild(child3);
                    child5.rightChild.setLeftChild(child4);
                    child5.rightChild.setRightChild(child1);
                    child5.rightChild.setColor(child5.Color);
                    if (temp_for_left.equals(root)) child5.setColor(BLACK);
                    else {
                        child5.setColor(child5.rightChild.Color);
                    }
                    return child5;

                }
        if (for_left != null && for_left.leftChild != null && for_left.leftChild.leftChild != null) {

            // Left left case.
            /*
         z                                      y
        / \                                   /   \
       y   T4      Right Rotate (z)          x      z
      / \          - - - - - - - - ->      /  \    /  \
     x   T3                               T1  T2  T3  T4
    / \
  T1   T2


             */
            final Node temp_for_left = for_left;
            final Node child1 = for_left.leftChild;
            for_left.setLeftChild(null);
            final Node child2 = for_left;
            final Node child3 = child1.rightChild;
            child1.setRightChild(child2);
            child1.rightChild.setLeftChild(child3);
            child1.rightChild.setColor(child1.Color);
            if (temp_for_left.equals(root)) child1.setColor(BLACK);
            else {
                child1.setColor(child1.rightChild.Color);
            }

            return child1;
        }
          //  }

        return for_left;

}
    public void SetTree(Node root,Node parent,Node grand_parent,Node for_set_node){
        if (root==null)
            return;
        else {
            if (root.equals(grand_parent)&&root.leftChild.equals(parent))
            {
                root.setLeftChild(null);
                root.setLeftChild(for_set_node);

            }
            if (root.equals(grand_parent)&&root.rightChild.equals(parent)){
                root.setRightChild(null);
                root.setRightChild(for_set_node);
            }
            if (root.leftChild!=null){
                SetTree(root.leftChild,parent,grand_parent,for_set_node);

            }
            if (root.rightChild!=null){
                SetTree(root.leftChild,parent,grand_parent,for_set_node);


            }

        }
    }
    public void ListParent(int count){
        Node temp1=root;
        Node temp2=root;


        while (temp1!=null&&(temp1.leftChild!=null || temp1.rightChild!=null)) {

            if ((temp1.rightChild!=null&&((int) temp1.rightChild.Value == count))|| ( temp1.leftChild!=null&& (int)temp1.leftChild.Value == count))


            {
                System.out.println("Parent Key: " + temp1.Key + "--> Parent Color: " + temp1.Color);
                break;
            }
            if ((Integer) temp1.Value >= count)
            {
                temp1=temp1.leftChild;
            }
           else if ((Integer) temp1.Value < count){
                temp1=temp1.rightChild;
            }
        }

        while (temp2!=null&&(temp2.leftChild!=null || temp2.rightChild!=null)){

            if ((temp2.rightChild!=null&&temp2.rightChild.rightChild!=null&&((int) temp2.rightChild.rightChild.Value == count)) || (temp2.leftChild!=null&&temp2.leftChild.leftChild!=null&&((int) temp2.leftChild.leftChild.Value == count))

                    || (temp2.leftChild!=null&&temp2.leftChild.rightChild!=null&&(int) temp2.leftChild.rightChild.Value == count)|| (temp2.rightChild!=null&&temp2.rightChild.leftChild!=null&&(int) temp2.rightChild.leftChild.Value == count)
                    )
            {
                System.out.println("GrandParent Key: "+temp2.Key+"--> GrandParent Color: "+temp2.Color);

            }
            if ((temp2.rightChild!=null&&temp2.rightChild.rightChild!=null&&((int) temp2.rightChild.rightChild.Value == count)) ||(temp2.rightChild!=null&&temp2.rightChild.leftChild!=null&&((int) temp2.rightChild.leftChild.Value == count))){
                System.out.println("Uncle Key: "+temp2.leftChild.Key+ "--> "+"Uncle Color: "+temp2.leftChild.Color);
                break;

            }
            if ((temp2!=null&&(temp2.leftChild!=null&&temp2.leftChild.leftChild!=null&&((int) temp2.leftChild.leftChild.Value == count))||(temp2.leftChild!=null&&temp2.leftChild.rightChild!=null&&((int) temp2.leftChild.rightChild.Value == count)))){
                System.out.println("Uncle Key: "+temp2.rightChild.Key+ "--> "+"Uncle Color: "+temp2.rightChild.Color);
                break;
            }
            if ((int) temp2.Value >= count)
            {
                temp2=temp2.leftChild;
            }
           else if ((int) temp2.Value < count){
                temp2=temp2.rightChild;
            }

        }
    }
    int number=0;
int counter2=0;
int COUNT=0;
int maxValue=0;
    public void Call(Node root){
        if (root==null)
            return ;
        else {
            if (root.leftChild==null&&root.rightChild==null){
               // System.out.println("Leaf: "+root.Key+" "+COUNT);
                arr[counter2]= COUNT;
                total+=1;
                counter2++;
                if (COUNT>maxValue){
                    maxValue=COUNT;
                    max_node=((int) root.Value);
                }
                return;
            }
            if (root.leftChild!=null){
                COUNT++;
                Call(root.leftChild);
                COUNT-=1;

            }
            if (root.rightChild!=null){
                COUNT++;
                Call(root.rightChild);
                COUNT-=1;

            }



        }

    }
    public int ListLeaves(Node root){
        boolean flag=false;
        if (root==null)
            return number;
        else {
                if (root.leftChild==null&&root.rightChild==null)
                {
                   // System.out.println(root.Value+" Depth: "+count);
                    arr[counter]= (int) root.Value;
                    counter++;
                    if (root.Key.toString().equals(enter_input)){
                        System.out.println("Key: " + enter_input);
                        System.out.println("Value: " + root.Value.toString());
                        flag=true;
                        number= ((int) root.Value);

                        final int temp_value=(Integer) root.Value;
                        System.out.println("Color: " + root.Color);
                        return number;


                    }

            }
            if (root.leftChild!=null)
            {
                if (root.Key.toString().equals(enter_input)){
                    System.out.println("Key: " + enter_input);
                    System.out.println("Value: " + root.Value.toString());
                    flag=true;
                    number= ((int) root.Value);

                    System.out.println("Color: " + root.Color);
                    return number;

                }
                    ListLeaves(root.leftChild);


            }
            if (root.rightChild!=null)
            {
                if (root.Key.toString().equals(enter_input)){
                    System.out.println("Key: " + enter_input);
                    System.out.println("Value: " + root.Value.toString());
                    flag=true;
                    number= ((int ) root.Value);

                    System.out.println("Color: " + root.Color);
                    return number;

                }
                ListLeaves(root.rightChild);


            }
            if (flag==true){
                return number;
            }
            else {
                return number;
            }

    }

    }
   /* public void displayTree()
    {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int emptyLeaf = 32;
        boolean isRowEmpty = false;
        System.out.println("****......................................................****");
        while(isRowEmpty==false)
        {

            Stack localStack = new Stack();
            isRowEmpty = true;
            for(int j=0; j<emptyLeaf; j++)
                System.out.print(' ');
            while(globalStack.isEmpty()==false)
            {
                Node temp = (Node) globalStack.pop();
                if(temp != null)
                {
                    System.out.print(temp.Value+" "+temp.Color);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null ||temp.rightChild != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j<emptyLeaf*2-2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            emptyLeaf /= 2;
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() );
        }
        System.out.println("****......................................................****");
    }*/
    public Node SearchParentElement(int Key){
if (root==null){
    return null;
}
        Node current = root;
        while (current.leftChild!=null|| current.rightChild!=null){

            if ((current.rightChild!=null&&((int)current.rightChild.Value==Key)|| (current.leftChild!=null&&(Integer)current.leftChild.Value==Key))){

                System.out.println("Found this element in tree!!");
                System.out.println(Key+"in parent: "+current.Value);
                return current;
            }
             if((Integer)current.Value>=Key){
                current=current.leftChild;
            }
            else if ((int)current.Value<Key)
                {
                current= current.rightChild;
            }

        }
        return null;
    }


    //*************************
    public int findHeight(Node node){
    int counter=0;
        Node temp=root;
        System.out.println(temp.Value);
        while (temp!=null&&node !=null&&((int) temp.Value!=(int)node.Value)){
            if ((int) temp.Value>=(int)node.Value){
                temp=temp.leftChild;
                counter++;
            }
            else {
                temp=temp.rightChild;
                counter++;
            }


        }
        return counter;

}
    //***********************


    //*************************
    // Bunları birlikte düşün!
    public  Node SearchNode=null;
    public void SearchElement(String String_Value){
        if (root==null)
            return;
        else {
            if (root.Value.equals(String_Value))
            {
                SearchNode=root;
            }
            if (root.leftChild!=null){
                ListLeaves(root.leftChild);

            }
            if (root.rightChild!=null){
                ListLeaves(root.rightChild);

            }

        }
    }
    //***********************


}
