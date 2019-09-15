import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class CUS1151_Rettko_HW1 {

   public static List alternate(List list1, List list2) { 
      List result = new ArrayList(); 
      Iterator i1 = list1.iterator(); 
      Iterator i2 = list2.iterator(); //To do 
      boolean l1 = i1.hasNext();
      boolean l2 = i2.hasNext();
      while(l1 || l2) {
         if(l1) {
            result.add(i1.next());
            l1 = i1.hasNext();
         }
         if(l2) {
            result.add(i2.next());
            l2 = i2.hasNext();
         }
      }
      return result;
   }
   
   public static void main(String[] args) {
        ArrayList<Object> one = new ArrayList<Object>();
           one.add(1);
           one.add(2);
           one.add(3);
           one.add(4);
           one.add(5);
        ArrayList<Object> two = new ArrayList<Object>();
           two.add(6);
           two.add(7);
           two.add(8);
           two.add(9);
           two.add(10);
           two.add(11);
           two.add(12);
        System.out.print("List One: ");
        for (Object i : one) {
         System.out.print(i + " ");
        }
        System.out.print("\nList Two: ");
        for (Object j : two) {
         System.out.print(j + " ");
        }
        System.out.print("\nAlternating List: ");
        for (Object a : alternate(one, two)) {
         System.out.print(a + " ");
        }
   }
}