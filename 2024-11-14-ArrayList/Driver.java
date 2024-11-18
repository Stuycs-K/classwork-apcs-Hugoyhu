import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
  public static void main (String[] args) {
    ArrayList<String> a1 = ArrayListPractice.createRandomArray(0);
    ArrayList<String> a2 = ArrayListPractice.createRandomArray(1);
    ArrayList<String> a3 = ArrayListPractice.createRandomArray(20);

    System.out.println(a1);
    ArrayListPractice.replaceEmpty(a1);
    System.out.println(a1);
    System.out.println(ArrayListPractice.makeReversedList(a1));

    System.out.println(a2);
    ArrayListPractice.replaceEmpty(a2);
    System.out.println(a2);
    System.out.println(ArrayListPractice.makeReversedList(a2));

    System.out.println(a3);
    ArrayListPractice.replaceEmpty(a3);
    System.out.println(a3);
    System.out.println(ArrayListPractice.makeReversedList(a3));

    ArrayList<String> t1 = new ArrayList<String>(Arrays.asList("1","3","5"));
    ArrayList<String> t2 = new ArrayList<String>(Arrays.asList("2","4","6","8","10"));

    System.out.println(ArrayListPractice.mixLists(t1, t2));

  }
}
