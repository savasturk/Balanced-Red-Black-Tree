/**
 * Created by asus on 10.12.2017.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MergeTrees mgtree = new MergeTrees();
        mgtree.FullArray(mgtree.arr);
        int total_number=0;

       Scanner scanner =new Scanner(System.in);
       while (true) {
           System.out.println("1- For Insert Element");
           System.out.println("2- For Search Operation");
           String input_key = "";
           int input_value = 0;
           int number = scanner.nextInt();
           try {
               if (number == 1) {
                   while (true) {
                       System.out.println("Please enter key(like 'Mehmet') for insert: ");
                       try {
                           input_key = scanner.next();
                           break;
                       } catch (Exception e) {
                           System.out.println("Please enter valid Key!! ");
                           continue;
                       }
                   }
                   while (true) {
                       System.out.println("Please enter value(like '5') for insert: ");
                       try {
                           input_value = scanner.nextInt();
                           break;
                       } catch (Exception e) {
                           System.out.println("Please enter valid Value!! ");
                           continue;
                       }
                   }
                   mgtree.insert_Element(input_key, input_value);
                 //  int COunt=mgtree.ListLeaves(mgtree.root);
                  // mgtree.displayTree();
                   mgtree.number=0;
                   mgtree.counter2=0;
                   mgtree.total=0;
                   mgtree.COUNT=0;
                   mgtree.maxValue=0;
                   mgtree.FullArray(mgtree.arr);
                   mgtree.Call(mgtree.root);
                   mgtree.CheckBalanced(mgtree.arr);
                  // mgtree.displayTree();
                   total_number++;
               }
              // mgtree.displayTree();

               if (number == 2) {
                   System.out.println("Please enter search key: ");
                   String enter_key=scanner.next();
                  mgtree.Find(enter_key);
                  int COunt=mgtree.ListLeaves(mgtree.root);
                    mgtree.ListParent(COunt);

                   break;
                   //I will complete!!!!!!!!!!!
               }
           } catch (NumberFormatException e) {
               System.out.println("Please enter valid input number");
           }
       }

    }
}
